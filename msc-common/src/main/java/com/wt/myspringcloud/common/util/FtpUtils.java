package com.wt.myspringcloud.common.util;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 常用方法
 * 1.FTPClient::retrieveFile 下载文件
 * 2.FTPClient::storeFile 上传文件
 */
public class FtpUtils {
    // 日志打印器
    private static Logger logger = LoggerFactory.getLogger(SftpUtils.class);
    // FTP客戶端
    private FTPClient ftpClient = new FTPClient();

    /**
     * 连接到服务器
     *
     * @param server   服务器地址
     * @param username 用户名
     * @param password 密码
     * @throws IOException 连接失败
     */
    public void login(String server, String username, String password) throws IOException {
        ftpClient.connect(server);
        ftpClient.login(username, password);
        if (!FTPReply.isPositiveCompletion(ftpClient.getReplyCode())) {
            throw new IOException("FTP server refused connection.");
        }
    }

    /**
     * 预与服务器断开连接
     *
     * @throws IOException 断开连接时发生异常
     */
    public void disconnect() throws IOException {
        if (ftpClient.isConnected()) {
            ftpClient.disconnect();
        }
    }

    /**
     * 下载文件
     *
     * @param remotePath 文件下载路径
     * @param localPath  文件保存路径
     * @throws IOException 下载失败
     */
    public void download(String remotePath, String localPath) throws IOException {
        // 打印文件下载和保存路径
        logger.info("Download from {} to {}.", remotePath, localPath);
        // 创建本地目录
        Path path = Paths.get(localPath);// 文件保存路径
        Path localDirectory = path.subpath(0, path.getNameCount() - 1);// 文件保存目录
        if (Files.notExists(localDirectory)) {
            Files.createDirectories(localDirectory);// 创建目录
        }
        // 下载
        try (OutputStream outputStream = new FileOutputStream(localPath)) {
            ftpClient.retrieveFile(remotePath, outputStream);// 下载文件
        }
    }

    /**
     * 上传文件
     *
     * @param localPath  本地文件路径
     * @param remotePath 上传文件路径
     * @throws IOException 上传失败
     */
    public void upload(String localPath, String remotePath) throws IOException {
        // 打印文件本地和上传路径
        logger.info("Upload from {} to {}.", remotePath, localPath);
        // 进入根目录
        Path path = Paths.get(remotePath);// 远程路径
        ftpClient.changeWorkingDirectory(path.getRoot().toString());// 进入根目录
        // 根据远程路径获取远程目录
        Path path1 = path.subpath(0, path.getNameCount() - 1);// 远程目录
        // 循环创建远程目录
        for (int i = 0; i < path.getNameCount(); i++) {
            String directory = path1.getName(i).toString();// 获取下一个目录元素
            boolean changeResult = ftpClient.changeWorkingDirectory(directory);// 尝试进入目录
            if (!changeResult) {
                // 进入目录失败
                ftpClient.mkd(directory);// 创建目录
                ftpClient.changeWorkingDirectory(directory);// 进入目录
            }
        }
        // 上传文件
        try (InputStream inputStream = new FileInputStream(localPath)) {
            ftpClient.storeFile(remotePath, inputStream);
        }
    }
}
