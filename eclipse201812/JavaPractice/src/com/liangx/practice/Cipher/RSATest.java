package com.liangx.practice.Cipher;

import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class RSATest {

	
	private static String src = "liangx";
	private static RSAPublicKey rsaPublicKey;
	private static RSAPrivateKey rsaPrivateKey;
	
	static {
		KeyPairGenerator keyPairGenerator;
		try {
			//生成公钥和私钥
			keyPairGenerator = KeyPairGenerator.getInstance("RSA");
			keyPairGenerator.initialize(512);
			KeyPair keyPair = keyPairGenerator.generateKeyPair();
			rsaPublicKey = (RSAPublicKey)keyPair.getPublic();
			rsaPrivateKey = (RSAPrivateKey)keyPair.getPrivate();
			System.out.println("public key: " + Base64.getEncoder().encode(rsaPublicKey.getEncoded()));
			System.out.println("private key: " + Base64.getEncoder().encode(rsaPrivateKey.getEncoded()));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
	
	//公钥加密，私钥解密
	public static void pubEn2PriDe() throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		
		//公钥加密
		X509EncodedKeySpec x509EncodeKeySpec = new X509EncodedKeySpec(rsaPublicKey.getEncoded());
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		PublicKey publicKey = keyFactory.generatePublic(x509EncodeKeySpec);
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);
		byte[] result = cipher.doFinal(src.getBytes());
		System.out.println("公钥加密，私钥解密。加密：" + Base64.getEncoder().encode(result));
		
		//私钥解密
		PKCS8EncodedKeySpec pkcs8EncodeKeySpec = new PKCS8EncodedKeySpec(rsaPrivateKey.getEncoded());
		keyFactory = KeyFactory.getInstance("RSA");
		PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodeKeySpec);
		cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.DECRYPT_MODE, privateKey);
		result = cipher.doFinal(result);
		System.out.println("公钥加密，私钥解密。解密：" + Base64.getEncoder().encode(result));

	}
	
	public static void main(String[] args) throws InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
		pubEn2PriDe();
		
		
	}

}
