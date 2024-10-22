package Interview.cryptography;

import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.Base64;

public class SigningExample {

    public static void main(String[] args) throws Exception {
        // Create a SecureRandom instance
        SecureRandom secureRandom = new SecureRandom();

        // Generate a DSA key pair
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("DSA");
        keyPairGenerator.initialize(1024, secureRandom);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        // The data to be signed
        String data = "This is a secret message";
        byte[] dataBytes = data.getBytes(StandardCharsets.UTF_8);

        // Initialize the Signature object for signing
        Signature signature = Signature.getInstance("SHA256withDSA");
        signature.initSign(keyPair.getPrivate(), secureRandom);

        // Sign the data
        signature.update(dataBytes);
        byte[] digitalSignature = signature.sign();

        // Print the signature in Base64 format
        String signedData = Base64.getEncoder().encodeToString(digitalSignature);
        System.out.println("Digital Signature: " + signedData);

        // Verify the signature
        Signature signatureVerify = Signature.getInstance("SHA256withDSA");
        signatureVerify.initVerify(keyPair.getPublic());
        signatureVerify.update(dataBytes);

        boolean isVerified = signatureVerify.verify(digitalSignature);
        System.out.println("Signature verified: " + isVerified);
    }
}
