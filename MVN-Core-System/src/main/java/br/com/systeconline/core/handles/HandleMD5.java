package br.com.systeconline.core.handles;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HandleMD5 {
	
	public static final String MD5_ALGORITHM = "MD5";
	public static String toMD5(final String valor) { 
		MessageDigest mDigest; 
		try { 
			//Instanciamos o nosso HASH MD5, poderíamos usar outro como //SHA, por exemplo, mas optamos por MD5. 
			mDigest = MessageDigest.getInstance(MD5_ALGORITHM); 
			//Convert a String valor para um array de bytes em MD5 
			byte[] valorMD5 = mDigest.digest(valor.getBytes("UTF-8")); 
			//Convertemos os bytes para hexadecimal, assim podemos salvar 
			//no banco para posterior comparação se senhas 
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
		
		
			
		
	
}
