package com.wt.myspringcloud.common.util;

import com.jcraft.jsch.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/**
 * @author 文通
 * @since 2019/5/19
 */
public class SftpUtils {

    private static Logger logger = LoggerFactory.getLogger(SftpUtils.class);

    private String host;
    private int port;
    private String username;
    private String password;

    private Session session;
    private ChannelSftp channel;

    public SftpUtils(String host, int port, String username, String password) {
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
    }

    public void connect() throws JSchException {
        JSch jsch = new JSch();
        session = jsch.getSession(this.username, this.host, this.port);
        session.setPassword(this.password);
        Properties config = new Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config);
        session.connect();
        channel = (ChannelSftp) session.openChannel("sftp");
        channel.connect();
    }

    public void disconnect() {
        if (channel != null) {
            channel.disconnect();
        }
        if (session != null) {
            session.disconnect();
        }
    }

    public void download(String remoteFilePath, String localDirectory) throws SftpException, IOException {
        String fileName = Paths.get(remoteFilePath).getFileName().toString();
        String localFilePath = Paths.get(localDirectory, fileName).toString();
        logger.info("Download {} to {}.", remoteFilePath, localFilePath);
        if (Files.notExists(Paths.get(localDirectory))) {
            Files.createDirectories(Paths.get(localDirectory));
        }
        try (BufferedInputStream inputStream = new BufferedInputStream(this.channel.get(remoteFilePath));
             BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(localFilePath))) {
            int c;
            while ((c = inputStream.read()) != -1) {
                outputStream.write(c);
            }
            logger.info("Download {} to {} successfully.", remoteFilePath, localFilePath);
        }
    }

    public void upload(String localFilePath, String remoteDirectory) throws SftpException, IOException {
        Path remoteDirectoryPath = Paths.get(remoteDirectory);
        this.channel.cd("/");
        for (int i = 0; i < remoteDirectoryPath.getNameCount(); i++) {
            try {
                this.channel.cd(remoteDirectoryPath.getName(i).toString());
            } catch (SftpException e) {
                this.channel.mkdir(remoteDirectoryPath.getName(i).toString());
                this.channel.cd(remoteDirectoryPath.getName(i).toString());
            }
        }
        this.channel.put(localFilePath, remoteDirectory);
        this.channel.cd(remoteDirectory);
    }

    public static void main(String[] args) {
        SftpUtils sftpUtils = new SftpUtils("192.168.20.2", 20622, "hjb", "hjb");
        try {
            sftpUtils.connect();
            // sftpUtils.download("/home/hjb/apps/bank/20190517/hjb_bos_transfer_20190517_result_FINI.txt", "D:\\wento\\Desktop\\test3\\1\\2\\3");
            sftpUtils.upload("D:\\wento\\Desktop\\test.zip", "/home/hjb/apps/bank/test/1/2/3");
        } catch (JSchException | SftpException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sftpUtils.disconnect();
        }
    }



}
