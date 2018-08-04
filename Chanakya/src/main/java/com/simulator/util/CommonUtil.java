package com.simulator.util;

import com.google.gson.Gson;

public class CommonUtil {

	private CommonUtil() {
		// private constructor
	}

	public static String toJson(Object obj) {
		Gson gson = new Gson();
		return gson.toJson(obj);
	}
	
	public static <T> T fromJson(String input, Class<T> clas) {
		Gson gson = new Gson();
		return (T) gson.fromJson(input, clas);
	}

	public static String encrypt(String input) {
		AES aes;
		String encrypted = input;
		try {
			aes = new AES("chanakya@simultr");
			encrypted = aes.encryptText(input);
		} catch (Exception e) {
			LogManager.errorLog.error("Error in encryption:" + e.getMessage(), e);
		}
		return encrypted;
	}

	public static String decrypt(String input) {
		AES aes;
		String decrypted = input;
		try {
			aes = new AES("chanakya@simultr");
			decrypted = aes.decryptText(input);
		} catch (Exception e) {
			LogManager.errorLog.error("Error in decryption:" + e.getMessage(), e);
		}
		return decrypted;
	}
}
