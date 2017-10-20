package br.com.barcadero.module.sat.handle;
import java.io.File;
import java.io.FileInputStream;
import java.security.Key;
import java.security.KeyStore;
import java.security.MessageDigest;
import java.security.PrivateKey;
//import java.security.PublicKey;
import java.security.Signature;
import java.security.cert.Certificate;
import javax.crypto.Cipher;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class HandleSignatureSAT {
	
	private String fileName = "";
	private char[] password;
	public final String DIR_DEFAULT_CHV = "Export" + File.separator + "SSH" + File.separator + "CRIPT" + File.separator;
	private final String FILE_NAME_CHV  = "OS201411218326.pfx";
	
	
//	public static void main(String[] args) {
//		AssinaturaDigitalSAT assSat = new AssinaturaDigitalSAT(System.getProperty("user.dir").replace("SatMfe", "Nexgen"));
//		try {
//			System.out.println(assSat.criptografar("S3cr3l1f0rmatica"));
//			System.out.println(assSat.descriptografar(assSat.getCurrentPassWord()));
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//	}
	
	@Deprecated
	public HandleSignatureSAT(String fileName, String password) {
		
		this.fileName = fileName;
		this.password = password.toCharArray();
		
	}
	
	public HandleSignatureSAT() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Instancia padrao para assinar digitalmente
	 * @param fileName : Caminho completo onde se encontra o e-CNPJ exceto o nome pois eh posto aqui.
	 */
	public HandleSignatureSAT(String fileName){
		try {
			this.fileName = fileName + File.separator + DIR_DEFAULT_CHV + FILE_NAME_CHV;
			this.password = "S3cr3l1f0rmatica".toCharArray(); //Depois deve ser posto uma criptografia
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	/**
	 * Retorna a assinatura gerada
	 * @param cnpjDesenvolvedora : CNPJ da desenvolvedora do AC, incluindo os zeros a esquerda
	 * @param cnpjContribuinte   : CNPJ do contribuinte do AC, incluindo os zeros a esquerda
	 * @return
	 * @throws Exception
	 */
	public String assinar(String cnpjDesenvolvedora, String cnpjContribuinte) throws Exception{
		String value = "";
		try {
			value =  cnpjDesenvolvedora.replace("-", "").replace(".", "").replace("/", "");
			value += cnpjContribuinte.replace("-", "").replace(".", "").replace("/", "");
			return assinar(value);
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
	}
	
	/**
	 * Gera a assinutura
	 * @param value
	 * @return
	 * @throws Exception
	 */
	private String assinar(String value) throws Exception {
		
		Signature signature = Signature.getInstance("NONEwithRSA");
		signature.initSign(getPrivateKeyFromFile());
		signature.update(MessageDigest.getInstance("SHA-256").digest(value.getBytes()));
		
        return new String(new BASE64Encoder().encode(signature.sign()));
        
	}
	
	/**
	 * Criptografa um valor qualquer
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public String criptografar(String value) throws Exception {
		Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, getPrivateKeyFromFile());
    	return new String(new BASE64Encoder().encode(cipher.doFinal(MessageDigest.getInstance("SHA-256").digest(value.getBytes()))));
		
	}
	
	/**
	 * descriptografar baseado no Certificado
	 * @param value
	 * @return
	 * @throws Exception
	 */
	public String descriptografar(String value) throws Exception {
		Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
//		cipher.init(Cipher.DECRYPT_MODE, getPublicKeyFromFile());
		cipher.init(Cipher.DECRYPT_MODE, getPrivateKeyFromFile());
    	return new BASE64Decoder().decodeBuffer(new String(cipher.doFinal(MessageDigest.getInstance("SHA-256").digest(value.getBytes())))).toString();
//		return new String(cipher.doFinal(MessageDigest.getInstance("SHA-256").digest(value.getBytes())));
	
	}
	
	private PrivateKey getPrivateKeyFromFile() throws Exception {  
        
        Key key = getKey();
        
        if( key instanceof PrivateKey ) {
            return (PrivateKey) key;
        }
        return null;
        
    }
	
	
//	private PublicKey getPublicKeyFromFile() throws Exception {
//		
//		Certificate certificate = getCertificate();
//	    PublicKey publicKey = certificate.getPublicKey();
//	    
//	    return publicKey;
//	    
//	}
	
	private Key getKey() throws Exception {
		
		FileInputStream fis = null;
		
		try {
			
			KeyStore ksKeys = KeyStore.getInstance("PKCS12");
			fis = new FileInputStream(fileName);
			ksKeys.load(fis, password);
			String alias = "";
			
			if (ksKeys.aliases().hasMoreElements()) {
				
	            alias = (String) ksKeys.aliases().nextElement();
				if (!ksKeys.isKeyEntry(alias)) {
										
					throw new Exception("N�o existe chave particular no armaz�m designado.");
					
				}				
				return ksKeys.getKey(alias, password);
				
	        }
			throw new IllegalArgumentException("KeyStore n�o contem o alias");
			
		} catch (Exception e) {
			throw new IllegalArgumentException("Erro ao abrir KeyStore -  " + e.getMessage());
		} finally {
			if (fis != null) fis.close();
		}
		
	}
	
	private Certificate getCertificate() throws Exception {
		
		FileInputStream fis = null;
		
		try {
			
			KeyStore ksKeys = KeyStore.getInstance("PKCS12");
			fis = new FileInputStream(fileName);
			ksKeys.load(fis, password);
			String alias = "";
			
			if (ksKeys.aliases().hasMoreElements()) {
				
	            alias = (String) ksKeys.aliases().nextElement();
	            
	            if (!ksKeys.isKeyEntry(alias)) {
					
					throw new Exception("N�oo existe chave particular no armaz�m designado.");
					
				}
				return ksKeys.getCertificate(alias);
				
	        } 
			throw new IllegalArgumentException("KeyStore n�o contem o alias");
			
		} catch (Exception e) {
			throw new IllegalArgumentException("Erro ao abrir KeyStore -  " + e.getMessage());
		} finally {
			if (fis != null) fis.close();
		}
		
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public char[] getPassword() {
		return password;
	}

	public void setPassword(char[] password) {
		this.password = password;
	}
	
//	private String getCurrentPassWord() {
//		return "iQmk4f8kLSMCanDgJgvuHhO2ixayjIP00rq3LvETRQfXKCoBBbVHM8mKImLFKJTWnUgj0MtrSa/r" +
//			   "eAGqYsSSV+45Zj2IQA03uxXVZRrToN61wbA80wg719cvMM3sNa51e5AAvE5Q28OdWKc1on1Ol5Nn" +
//			   "fLZXnMTXqohBe+H+a2EY02qR/lzOkLDJ3lzwsHu+G5GLp1+t/nrum6ZAzubHu0lmCdr5WnUPe15M" +
//			   "y/HEaAVgHCTKymGxUvPr41c0sTn7uARnIfe+cD91fjU8ODW4tQkrmGnDrGTgRb/ydCTKxrbpk3Sq" +
//			   "F1kSStRME5ChBP2IZ4b6aTNnQeaYHrudETNx6A==";
//	}
	
}
