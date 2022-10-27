package com.example.geek_for_less.patterns.singleton;

public enum SingletonEnum {
    ENCRYPTOR {
        String doEncryption(String message) {
            System.out.println("Encrypt");
            return String.format("this message was encrypted %s", message);
        }

        String doEncryptionNew(String message) {
            System.out.println("Encrypt");
            return String.format("this message was encrypted %s", message);
        }
    }
}
