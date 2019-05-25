package com.wt.myspringcloud.common.util;

import org.apache.commons.io.IOUtils;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class FileEncryptDecryptTools {
	private static final String ALGORITHM = "DESede";

	/**
	 * <pre>
	 * 将文件压缩并加密
	 * 如将/share_ibps/file/CARD_NO.txt下文件加密到/share_ibps/file/CARD_NO.zip，参数传递方式为
	 * fileAllNameZip = /share_ibps/file/CARD_NO.zip
	 * fileName = CARD_NO.txt
	 * fileAllName = /share_ibps/file/CARD_NO.txt
	 * key为24位随机字符串，如：132e8a57b4g6139d3a5de9g4
	 * 
	 * <pre>
	 * @param fileAllNameZip 加密后的文件完整路径
	 * @param fileName 待加密文件名
	 * @param fileAllName 待加密文件完整路径
	 * @param key 加秘秘钥 
	 * @throws IOException
	 * @author CAO_Z
	 * @throws InvalidKeyException 
	 * @throws NoSuchAlgorithmException 
	 * @throws NoSuchPaddingException
	 * @sinece 2018-2-27 下午1:20:57
	 */
	public static void generateEncryptedFile(String fileAllName, String fileName, String fileAllNameZip, String key)
			throws IOException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException {
		// 将生成文件压缩并加密。
		OutputStream out = null;
		FileOutputStream fos = null;
		FileInputStream fis = null;
		try {
			fos = new FileOutputStream(fileAllNameZip);
			out = alipayUploadOuputStream(key, fos, fileName);
			fis = new FileInputStream(fileAllName);
			IOUtils.copy(fis, out);
		} catch (FileNotFoundException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		} catch (InvalidKeyException e) {
			throw e;
		} catch (NoSuchAlgorithmException e) {
			throw e;
		} catch (NoSuchPaddingException e) {
			throw e;
		} finally {
			if (null != fis) {
				try {
					fis.close();
				} catch (IOException e) {
				}
			}
			if (null != out) {
				try {
					out.close();
				} catch (IOException e) {
				}
			}
			if (null != fos) {
				try {
					fos.close();
				} catch (IOException e) {
				}
			}
		}
	}

	private static OutputStream alipayUploadOuputStream(String threeDesKey, OutputStream fileOuputStream,
			String zipEntryName) throws IOException, InvalidKeyException, NoSuchAlgorithmException,
			NoSuchPaddingException {
		// 设置流以加密模式输出
		OutputStream encryptOutPutStream = encryptMode(threeDesKey, fileOuputStream);
		// 设置流以压缩模式输出
		ZipOutputStream zipOutPutStream = new ZipOutputStream(encryptOutPutStream);
		zipOutPutStream.putNextEntry(new ZipEntry(zipEntryName));
		return zipOutPutStream;

	}

	/**
	 * <pre>
	 * 该方法对一个加密的Zip文件进行解密输出。
	 * 如将/share_ibps/file/CARD_NO.zip下文件解密到/share_ibps/file/CARD_NO.txt，参数传递方式为
	 * fileAllNameZip = /share_ibps/file/CARD_NO.zip
	 * fileAllName = /share_ibps/file/CARD_NO.txt
	 * key为24位随机字符串，如：132e8a57b4g6139d3a5de9g4
	 * 
	 * <pre>
	 * @param fileAllNameZip
	 *            待解密的压缩文件完整路径
	 * @param fileAllNameTxt
	 *            解密后的文件完整路径
	 * @param key
	 * @throws IOException
	 * @author CAO_Z
	 * @throws NoSuchAlgorithmException 
	 * @throws NoSuchPaddingException 
	 * @throws InvalidKeyException
	 * @sinece 2018-2-27 下午1:20:24
	 */
	public static void decryptEncryptedFile(String fileAllNameZip, String fileAllNameTxt, String key)
			throws IOException, InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException {
		// 对一个加密的Zip文件进行解密输出。
		InputStream in = null;
		FileOutputStream fos = null;
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(fileAllNameZip);
			in = alipayDownloadInputStream(key, fis);
			fos = new FileOutputStream(new File(fileAllNameTxt));
			IOUtils.copy(in, fos);
		} catch (FileNotFoundException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		} finally {
			if (null != fos) {
				try {
					fos.close();
				} catch (IOException e) {
				}
			}
			if (null != in) {
				try {
					in.close();
				} catch (IOException e) {
				}
			}
			if (null != fis) {
				try {
					fis.close();
				} catch (IOException e) {
				}
			}
		}
	}

	private static InputStream alipayDownloadInputStream(String threeDesKey, InputStream fileInputStream)
			throws IOException, InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException {
		InputStream decryptInputStream = decryptMode(threeDesKey, fileInputStream);
		// 设置流以解密模式输出
		ZipInputStream zipIn = new ZipInputStream(decryptInputStream);
		if (zipIn.getNextEntry() == null) {
			return null;
		}
		return zipIn;
	}

	/**
	 * 设置数据流为加密模式
	 * 
	 * @param secretKey
	 * @param outputStream
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeyException
	 * @throws NoSuchPaddingException
	 */
	public static CipherOutputStream encryptMode(SecretKey secretKey, OutputStream outputStream)
			throws NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException {
		// 加密
		try {
			Cipher c1 = Cipher.getInstance(ALGORITHM);
			c1.init(Cipher.ENCRYPT_MODE, secretKey);
			return new CipherOutputStream(outputStream, c1);
		} catch (InvalidKeyException e) {
			throw e;
		} catch (NoSuchAlgorithmException e) {
			throw e;
		} catch (NoSuchPaddingException e) {
			throw e;
		}
	}

	/**
	 * 设置数据流为加密模式
	 * 
	 * @param des3Key
	 * @param outputStream
	 * @return
	 * @throws NoSuchPaddingException
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeyException
	 */
	public static CipherOutputStream encryptMode(String des3Key, OutputStream outputStream) throws InvalidKeyException,
			NoSuchAlgorithmException, NoSuchPaddingException {
		// 生成密钥
		SecretKey secretKey = new SecretKeySpec(des3Key.getBytes(), ALGORITHM);
		return encryptMode(secretKey, outputStream);

	}

	/**
	 * 设置数据流为解密模式
	 * 
	 * @param des3Key
	 * @param inputStream
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws InvalidKeyException
	 * @throws Exception
	 */
	public static CipherInputStream decryptMode(String des3Key, InputStream inputStream) throws InvalidKeyException,
			NoSuchPaddingException, NoSuchAlgorithmException {
		// 生成密钥
		SecretKey deskey = new SecretKeySpec(des3Key.getBytes(), ALGORITHM); // 解密
		return decryptMode(deskey, inputStream);
	}

	/**
	 * 设置数据流为解密模式
	 * 
	 * @param secretKey
	 * @param inputStream
	 * @return
	 * @throws NoSuchPaddingException
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeyException
	 * @throws Exception
	 */
	public static CipherInputStream decryptMode(SecretKey secretKey, InputStream inputStream)
			throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException {
		try {
			Cipher c1 = Cipher.getInstance(ALGORITHM);
			c1.init(Cipher.DECRYPT_MODE, secretKey);
			return new CipherInputStream(inputStream, c1);
		} catch (NoSuchAlgorithmException e) {
			throw e;
		} catch (NoSuchPaddingException e) {
			throw e;
		} catch (InvalidKeyException e) {
			throw e;
		}
	}

	public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IOException {
		FileEncryptDecryptTools.generateEncryptedFile("D:\\wento\\Desktop\\bank\\zip-2019052301.txt", "zip-2019052301.txt", "D:\\wento\\Desktop\\bank\\RES_zip-2019052301.zip", "123456789012345678901234");
	}

}
