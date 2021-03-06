package br.com.barcadero.commons.security;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class HandleEncrypt {

	private static String key   = "h2R45X7x9r1X34WQ";
	private static String vetor = "123XTY789HIJ34UU";
	public static final String MD5_ALGORITHM = "MD5";
	
	public static String encrypt(String value) {
		return encrypt(getKey(), getVetor(), value);
	}
	
	public static String decrypt(String value) {
		return decrypt(getKey(), getVetor(), value);
	}
	
	private static String encrypt(String key, String initVector, String value) {
		try {
			IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
			SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

			byte[] encrypted = cipher.doFinal(value.getBytes());

			return Base64.encodeBase64String(encrypted);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return null;
	}

	private static String decrypt(String key, String initVector, String encrypted) {
		try {
			IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
			SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
			cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);

			byte[] original = cipher.doFinal(Base64.decodeBase64(encrypted));

			return new String(original);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return null;
	}
	
	public static String toMD5(final String valor) { 
		MessageDigest mDigest; 
		try { 
			mDigest = MessageDigest.getInstance(MD5_ALGORITHM);  
			byte[] valorMD5 = mDigest.digest(valor.getBytes("UTF-8"));  
			StringBuffer sb = new StringBuffer(); 
			for (byte b : valorMD5){ 
				sb.append(Integer.toHexString((b & 0xFF) | 0x100).substring(1,3)); 
			} 
			return sb.toString(); 
		} catch (NoSuchAlgorithmException e) { 
			// TODO Auto-generated catch block 
			e.printStackTrace(); return null; 
		} catch (UnsupportedEncodingException e) { 
			// TODO Auto-generated catch block 
			e.printStackTrace(); return null; 
		} 
	}

	public static void main(String[] args) {
		String key = "Bar12345Bar12345"; // 128 bit key
		String initVector = "RandomInitVector"; // 16 bytes IV

		System.out.println(decrypt(key, initVector,
				encrypt(key, initVector, "Hello World")));
	}

	public static String getKey() {
		return key;
	}

	public static void setKey(String key) {
		HandleEncrypt.key = key;
	}

	public static String getVetor() {
		return vetor;
	}

	public static void setVetor(String vetor) {
		HandleEncrypt.vetor = vetor;
	}

	
}
