package br.com.barcadero.commons.security;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestEncryptor {
	private String key 			= "Bar12345Bar12345"; // 128 bit key
    private String initVector 	= "RandomInitVector"; // 16 bytes IV
	@Test
    public void testEncrypt() {
		assertEquals("Criptografia nao confere", "9MU7vSBqfzPnj7iWvvfsEw==", HandleEncrypt.encrypt(key, initVector, "Hello World"));
	}
	
	@Test
	public void testDecrypt() {
		assertEquals("Descriptografia nao confere", "Hello World", HandleEncrypt.decrypt(key, initVector,"9MU7vSBqfzPnj7iWvvfsEw=="));
	}

}
