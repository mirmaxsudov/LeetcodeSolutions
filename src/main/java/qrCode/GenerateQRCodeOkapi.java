package qrCode;


import uk.org.okapibarcode.backend.DataMatrix;
import uk.org.okapibarcode.output.Java2DRenderer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class GenerateQRCodeOkapi {
    public static void main(String[] args) throws IOException {
        String csvPath = "data.csv";
        int dpi = 300;
        int pxSize = (int) (1.5 / 2.54 * dpi);
        int paddingTop = 20;

        BufferedReader reader = new BufferedReader(new FileReader(csvPath));
        ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream("images_okapi.zip"));

        String line;
        int id = 1;

        while ((line = reader.readLine()) != null && !line.isEmpty()) {
            String data = line.trim();

            DataMatrix dm = new DataMatrix();
            dm.setContent(data);

            BufferedImage image = new BufferedImage(pxSize, pxSize, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d = image.createGraphics();
            g2d.setColor(Color.WHITE);
            g2d.fillRect(0, 0, pxSize, pxSize);

            g2d.setColor(Color.BLACK);
            g2d.setFont(new Font("Arial", Font.BOLD, 14));
            g2d.drawString(String.valueOf(id), 10, 15);

            g2d.translate(10, paddingTop); // shift down
            Java2DRenderer renderer = new Java2DRenderer(g2d, 4, uk.org.okapibarcode.graphics.Color.BLACK, uk.org.okapibarcode.graphics.Color.WHITE);
            renderer.render(dm);

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(image, "png", baos);
            baos.close();

            ZipEntry entry = new ZipEntry("id_" + id + ".png");
            zipOut.putNextEntry(entry);
            zipOut.write(baos.toByteArray());
            zipOut.closeEntry();

            id++;
        }

        zipOut.close();
        reader.close();
        System.out.println("✅ Done generating " + (id - 1) + " images.");
    }
}