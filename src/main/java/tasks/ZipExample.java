package tasks;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipExample {
    public static void main(String[] args) {

        try {
            zipDirectory("C:\\Abdurahmon\\G19 face\\10-modul",
                    "C:\\Abdurahmon\\G19 face\\10-modul.zip");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void zipDirectory(String sourceDir, String outputZipFile) throws IOException {
        File dir = new File(sourceDir);
        if (!dir.exists() || !dir.isDirectory()) {
            throw new IllegalArgumentException("The provided path is not a valid directory.");
        }

        try (FileOutputStream fos = new FileOutputStream(outputZipFile);
             ZipOutputStream zos = new ZipOutputStream(fos)) {

            zipFilesRecursively(dir, dir.getName(), zos);
        }
    }

    private static void zipFilesRecursively(File fileToZip, String fileName, ZipOutputStream zos) throws IOException {
        if (fileToZip.isHidden()) {
            return;
        }

        if (fileToZip.isDirectory()) {
            if (fileName.endsWith("/")) {
                zos.putNextEntry(new ZipEntry(fileName));
                zos.closeEntry();
            } else {
                zos.putNextEntry(new ZipEntry(fileName + "/"));
                zos.closeEntry();
            }
            File[] children = fileToZip.listFiles();
            if (children != null) {
                for (File childFile : children) {
                    zipFilesRecursively(childFile, fileName + "/" + childFile.getName(), zos);
                }
            }
            return;
        }

        try (FileInputStream fis = new FileInputStream(fileToZip)) {
            ZipEntry zipEntry = new ZipEntry(fileName);
            zos.putNextEntry(zipEntry);
            byte[] bytes = new byte[1024];
            int length;
            while ((length = fis.read(bytes)) >= 0) {
                zos.write(bytes, 0, length);
            }
        }
    }
}
