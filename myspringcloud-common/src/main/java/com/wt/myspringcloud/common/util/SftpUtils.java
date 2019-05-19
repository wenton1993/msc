package com.wt.myspringcloud.common.util;

import com.jcraft.jsch.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
        logger.info("downloading {} to {} successfully.", remoteFilePath, localFilePath);
        try (InputStream inputStream = this.channel.get(remoteFilePath);
             FileOutputStream fileOutputStream = new FileOutputStream(localFilePath)) {
            int c;
            while ((c = inputStream.read()) != -1) {
                fileOutputStream.write(c);
            }
            logger.info("download {} to {} successfully.", remoteFilePath, localFilePath);
        }
    }

    public static void main(String[] args) {
        SftpUtils sftpUtils = new SftpUtils("192.168.20.2", 20622, "hjb", "hjb");
        try {
            sftpUtils.connect();
            sftpUtils.download("/home/hjb/apps/bank/20190517/hjb_bos_transfer_20190517_result_FINI.txt", "D:\\wento\\Desktop");
        } catch (JSchException | SftpException | IOException e) {
            e.printStackTrace();
        } finally {
            sftpUtils.disconnect();
        }
    }

}
