package Interview.cryptography;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import java.util.Base64;

public class CipherDemo {

    public static void main(String[] args) throws Exception {
        // 1. Generate AES Secret Key
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256);
        SecretKey secretKey = keyGen.generateKey();

        // 2. Create an Initialization Vector (IV) for CBC mode
        byte[] iv = new byte[16];
        IvParameterSpec ivSpec = new IvParameterSpec(iv);

        // 3. Initialize the Cipher for Encryption (AES/CBC/PKCS5Padding)
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivSpec);

        // 4. Encrypt the Plain Text
        String plainText = "Hello, World!";
        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());

        // 5. Encode the encrypted bytes to Base64 (for readable output)
        String encryptedText = Base64.getEncoder().encodeToString(encryptedBytes);
        System.out.println("Encrypted Text: " + encryptedText);

        // 6. Initialize the Cipher for Decryption
        cipher.init(Cipher.DECRYPT_MODE, secretKey, ivSpec);

        // 7. Decrypt the Cipher Text
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        String decryptedText = new String(decryptedBytes);
        System.out.println("Decrypted Text: " + decryptedText);
    }
}
