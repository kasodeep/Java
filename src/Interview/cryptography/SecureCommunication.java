package Interview.cryptography;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import java.security.*;
import java.util.Base64;

public class SecureCommunication {

    private static final String RSA = "RSA";
    private static final String AES = "AES";
    private static final String SIGN_ALGO = "SHA256withRSA";
    private static final String KEYSTORE_TYPE = "PKCS12";
    private static final int AES_KEY_SIZE = 256;
    private static final int RSA_KEY_SIZE = 2048;
    private static final int GCM_TAG_LENGTH = 128;
    private static final int GCM_IV_LENGTH = 12;

    // Step 1: Generate RSA KeyPair
    public static KeyPair generateRSAKeyPair() throws NoSuchAlgorithmException {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance(RSA);
        keyGen.initialize(RSA_KEY_SIZE);
        return keyGen.generateKeyPair();
    }

    // Step 2: Generate AES SecretKey
    public static SecretKey generateAESKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGen = KeyGenerator.getInstance(AES);
        keyGen.init(AES_KEY_SIZE);
        return keyGen.generateKey();
    }

    // Step 3: Encrypt using AES
    public static byte[] encryptAES(String message, SecretKey aesKey, byte[] iv) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        GCMParameterSpec gcmSpec = new GCMParameterSpec(GCM_TAG_LENGTH, iv);

        cipher.init(Cipher.ENCRYPT_MODE, aesKey, gcmSpec);
        return cipher.doFinal(message.getBytes());
    }

    // Step 4: Decrypt using AES
    public static String decryptAES(byte[] cipherText, SecretKey aesKey, byte[] iv) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        GCMParameterSpec gcmSpec = new GCMParameterSpec(GCM_TAG_LENGTH, iv);

        cipher.init(Cipher.DECRYPT_MODE, aesKey, gcmSpec);
        return new String(cipher.doFinal(cipherText));
    }

    // Step 5: Sign data using RSA
    public static byte[] signData(byte[] data, PrivateKey privateKey) throws Exception {
        Signature signature = Signature.getInstance(SIGN_ALGO);
        signature.initSign(privateKey);
        signature.update(data);
        return signature.sign();
    }

    // Step 6: Verify the signature using RSA
    public static boolean verifySignature(byte[] data, byte[] signature, PublicKey publicKey) throws Exception {
        Signature sig = Signature.getInstance(SIGN_ALGO);
        sig.initVerify(publicKey);
        sig.update(data);
        return sig.verify(signature);
    }

    public static void main(String[] args) throws Exception {
        // Alice and Bob communication simulation

        // Generate RSA key pair
        KeyPair rsaKeyPair = generateRSAKeyPair();

        // Generate AES secret key for message encryption
        SecretKey aesKey = generateAESKey();

        // Original message
        String originalMessage = "Hello Bob, this is a secret message.";

        // Generate IV (Initialization Vector) for AES
        SecureRandom random = new SecureRandom();
        byte[] iv = new byte[GCM_IV_LENGTH];
        random.nextBytes(iv);

        // Encrypt message using AES
        byte[] encryptedMessage = encryptAES(originalMessage, aesKey, iv);
        System.out.println("Encrypted message: " + Base64.getEncoder().encodeToString(encryptedMessage));

        // Sign the encrypted message using RSA private key
        byte[] signature = signData(encryptedMessage, rsaKeyPair.getPrivate());
        System.out.println("Signature: " + Base64.getEncoder().encodeToString(signature));

        // Verify the signature using RSA public key
        boolean isSignatureValid = verifySignature(encryptedMessage, signature, rsaKeyPair.getPublic());
        System.out.println("Signature valid: " + isSignatureValid);

        // Decrypt the message using AES
        String decryptedMessage = decryptAES(encryptedMessage, aesKey, iv);
        System.out.println("Decrypted message: " + decryptedMessage);
    }
}
