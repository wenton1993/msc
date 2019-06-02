package com.wt.myspringcloud.common.util;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/**
 * @author 文通
 * @since 2019/5/22
 */
public class FileCompressionUtils {

    /**
     * 压缩
     *
     * @param filePathList 文件路径
     * @param zipFilePath  压缩文件路径
     * @throws IOException
     */
    public static void compressToZip(List<String> filePathList, String zipFilePath) throws IOException {
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(zipFilePath)))) {
            for (String filePath : filePathList) {
                try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(filePath))) {
                    zipOutputStream.putNextEntry(new ZipEntry(Paths.get(filePath).getFileName().toString()));
                    int i;
                    while ((i = inputStream.read()) != -1) {
                        zipOutputStream.write(i);
                    }
                }
            }
        }
    }

    /**
     * 解压 fileName.zip 到文件文件夹 fileName
     *
     * @param zipFilePath zip 文件路径
     */
    public static void extractFormZip(String zipFilePath) throws IOException {
        String directory = zipFilePath.substring(0, zipFilePath.lastIndexOf("."));
        if (Files.notExists(Paths.get(directory))) {
            Files.createDirectory(Paths.get(directory));
        }
        ZipFile zipFile = new ZipFile(zipFilePath);
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        while (entries.hasMoreElements()) {
            ZipEntry entry = entries.nextElement();
            try (BufferedInputStream inputStream = new BufferedInputStream(zipFile.getInputStream(entry));
                 BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(Paths.get(directory, entry.getName()).toString()))) {
                int i;
                while ((i = inputStream.read()) != -1) {
                    outputStream.write(i);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        extractFormZip("D:\\wento\\Desktop\\bank\\test\\wt-test.zip");
    }
}
