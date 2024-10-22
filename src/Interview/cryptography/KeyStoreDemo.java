package Interview.cryptography;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.Key;
import java.security.KeyStore;

/**
 * Demonstrates how to create, store, load, and manage keys using Java KeyStore.
 * Java KeyStore (JKS) is a repository for storing cryptographic keys, certificates, and private keys securely.
 */
public class KeyStoreDemo {

    /**
     * Creates a new KeyStore, generates a secret key, and stores it in the KeyStore.
     */
    public static void createNewKeyStore() {
        try {
            // Create an instance of KeyStore of default type (usually JKS)
            KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());

            // Password to protect the KeyStore itself
            char[] pwdArray = "password".toCharArray();

            // Load an empty KeyStore (null input stream means a new, empty KeyStore)
            ks.load(null, pwdArray);

            // AES (Advanced Encryption Standard) key generation with a key size of 256 bits
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(256);

            // Generate a SecretKey using the AES algorithm
            SecretKey secretKey = keyGenerator.generateKey();

            // Wrap the generated secret key into a KeyStore.SecretKeyEntry
            KeyStore.SecretKeyEntry secretKeyEntry = new KeyStore.SecretKeyEntry(secretKey);

            // Protection parameter to protect the entry (using the same password)
            KeyStore.ProtectionParameter password = new KeyStore.PasswordProtection(pwdArray);

            // Store the secret key in the KeyStore with an alias "login-key"
            ks.setEntry("login-key", secretKeyEntry, password);

            // Store the KeyStore to a file named "demo.jks", using the password to protect it
            try (FileOutputStream fos = new FileOutputStream("demo.jks")) {
                ks.store(fos, pwdArray);
            }

            System.out.println("New KeyStore created and stored as 'demo.jks'.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Loads an existing KeyStore and retrieves a stored key by its alias.
     *
     * @return the retrieved key, or null if the key is not found
     */
    public static Key loadKeyStore() {
        try {
            // Load the existing KeyStore file "demo.jks"
            KeyStore ks = KeyStore.getInstance("JKS");
            char[] pwdArray = "password".toCharArray();

            // Load the KeyStore from the file using the password
            try (FileInputStream fis = new FileInputStream("demo.jks")) {
                ks.load(fis, pwdArray);
            }

            // Retrieve the key using the alias "login-key" and the password
            Key key = ks.getKey("login-key", pwdArray);

            // Print the key object (toString method of SecretKey doesn't show the actual key)
            System.out.println("Loaded key: " + key);
            return key;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Compares two keys for authorization purposes.
     *
     * @param serverKey   the key retrieved from the KeyStore
     * @param consumerKey the key to be compared (usually provided by a consumer or client)
     * @return true if the keys match, false otherwise
     */
    public static boolean isAuthorized(Key serverKey, Key consumerKey) {
        return serverKey != null && serverKey.equals(consumerKey);
    }

    public static void main(String[] args) {
        // Step 1: Create and store a new KeyStore
        createNewKeyStore();

        // Step 2: Load the key from the KeyStore
        Key loginKey = loadKeyStore();

        // Step 3: Example comparison for authorization (using null for demonstration)
        boolean isAuthorized = isAuthorized(loginKey, null);
        System.out.println("Authorization result: " + isAuthorized);
    }
}