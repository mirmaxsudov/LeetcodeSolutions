package qrCode;

import com.google.zxing.*;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.datamatrix.DataMatrixWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;

import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;

import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.IIOImage;
import javax.imageio.stream.ImageOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.EnumMap;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.zip.Deflater;

public class DataMatrixGenerator {
    static int id = 1;
    static List<String> list = List.of(
            "инатегра-1-30.000.csv",
            "инатегра-2-30.000.csv",
            "инатегра-3-20.000.csv",
            "инатегра-4-21.000.csv"
    );
    static List<String> dev = List.of(
            "data.csv",
            "инатегра-1-30.000.csv"
    );

    public static void main(String[] args) throws Exception {
        System.out.println(System.currentTimeMillis());
        generateDataMatrix(dev, 1.5);
        System.out.println(System.currentTimeMillis());
    }

    static class GeneratedImage {
        final String fileName;
        final byte[] data;

        GeneratedImage(String fileName, byte[] data) {
            this.fileName = fileName;
            this.data = data;
        }
    }

    public static void generateDataMatrix(List<String> csvPaths, double sizeCm) throws Exception {
        int dpi = 300;
        int cmToPx = (int) (dpi / 2.54);
        int imageSize = Math.max((int) (sizeCm * cmToPx), 100);
        int matrixSize = imageSize - 30;

        int threads = Runtime.getRuntime().availableProcessors();
        ExecutorService exec = Executors.newFixedThreadPool(threads);
        CompletionService<GeneratedImage> cs = new ExecutorCompletionService<>(exec);
        AtomicInteger idGen = new AtomicInteger(1);
        int tasks = 0;

        for (String path : csvPaths) {
            try (BufferedReader r = Files.newBufferedReader(Paths.get(path))) {
                String line;
                while ((line = r.readLine()) != null) {
                    String data = line.trim();
                    if (!data.isEmpty()) {
                        cs.submit(() -> createImage(data, idGen.getAndIncrement(), imageSize, matrixSize));
                        tasks++;
                    }
                }
            }
        }

        // Use Commons Compress ZipArchiveOutputStream
        try (ZipArchiveOutputStream zipOut = new ZipArchiveOutputStream(
                new FileOutputStream("datamatrix_images.zip"))) {

            zipOut.setMethod(ZipArchiveOutputStream.DEFLATED);
            zipOut.setLevel(Deflater.BEST_SPEED);

            for (int i = 0; i < tasks; i++) {
                Future<GeneratedImage> f = cs.take();
                GeneratedImage img = f.get();

                ZipArchiveEntry entry = new ZipArchiveEntry(img.fileName);
                zipOut.putArchiveEntry(entry);
                zipOut.write(img.data);
                zipOut.closeArchiveEntry();
            }
            zipOut.finish();
        }

        exec.shutdown();
        System.out.println("✅ Done: " + tasks + " images in datamatrix_images.zip");
    }

    private static GeneratedImage createImage(
            String data, int id, int imageSize, int matrixSize) throws IOException {

        Map<EncodeHintType, Object> hints = new EnumMap<>(EncodeHintType.class);
        hints.put(EncodeHintType.MARGIN, 0);
        BitMatrix bm = new DataMatrixWriter()
                .encode(data, BarcodeFormat.DATA_MATRIX, matrixSize, matrixSize, hints);

        // 2) Render to BufferedImage
        BufferedImage dm = MatrixToImageWriter.toBufferedImage(bm);

        // 3) Compose on canvas
        BufferedImage canvas = new BufferedImage(imageSize, imageSize, BufferedImage.TYPE_BYTE_BINARY);
        Graphics2D g = canvas.createGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, imageSize, imageSize);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 14));
        g.drawString("ID:" + id, 10, 18);
        int x = (imageSize - bm.getWidth()) / 2;
        g.drawImage(dm, x, 22, null);
        g.dispose();

        // 4) Write PNG to byte[] with max compression
        ByteArrayOutputStream baos = new ByteArrayOutputStream(2048);
        try (ImageOutputStream ios = ImageIO.createImageOutputStream(baos)) {
            ImageWriter w = ImageIO.getImageWritersByFormatName("png").next();
            w.setOutput(ios);
            ImageWriteParam p = w.getDefaultWriteParam();
            if (p.canWriteCompressed()) {
                p.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
                p.setCompressionQuality(0.0f);
            }
            w.write(null, new IIOImage(canvas, null, null), p);
            w.dispose();
        }

        return new GeneratedImage(String.format("img_%03d.png", id), baos.toByteArray());
    }
}