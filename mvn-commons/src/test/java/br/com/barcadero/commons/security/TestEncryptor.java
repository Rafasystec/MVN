package br.com.barcadero.commons.security;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestEncryptor {
	public static void main(String[] args) {
		System.out.println(HandleEncrypt.encrypt("Hello World"));
	}
	
	@Test
    public void testEncrypt() {
		assertEquals("Criptografia nao confere", "aQCJE0l+N9vhzQal52nRVg==", HandleEncrypt.encrypt("Hello World"));
	}
	
	@Test
	public void testDecrypt() {
		assertEquals("Descriptografia nao confere", "Hello World", HandleEncrypt.decrypt("aQCJE0l+N9vhzQal52nRVg=="));
	}

}
