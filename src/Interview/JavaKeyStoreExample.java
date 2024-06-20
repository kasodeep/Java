package Interview;

import javax.crypto.KeyGenerator;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.Key;
import java.security.KeyStore;

/*
 * It is used to manage keys and certificates in Java.
 * It can store and manage Symmetric Keys(Secret Keys), Asymmetric Keys(Public & Private Keys).
 * */
public class JavaKeyStoreExample {

    public static void createNewKeyStore() {
        try {
            KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
            char[] pwdArray = "password".toCharArray();
            ks.load(null, pwdArray); // null denotes it starts as an empty keystore.

            // AES-> Advanced Encryption Standard.
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(256);

            KeyStore.SecretKeyEntry secret = new KeyStore.SecretKeyEntry(keyGenerator.generateKey());
            KeyStore.ProtectionParameter password = new KeyStore.PasswordProtection(pwdArray);

            ks.setEntry("login-key", secret, password);
            ks.store(new FileOutputStream("demo.jks"), pwdArray);

            System.out.println(ks);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static Key loadKeyStore() {
        try {
            KeyStore ks = KeyStore.getInstance("JKS");
            char[] pwdArray = "password".toCharArray();

            ks.load(new FileInputStream("demo.jks"), pwdArray);
            System.out.println(ks.getKey("login-key", pwdArray));
            return ks.getKey("login-key", pwdArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean isAuthorized(Key serverKey, Key consumerKey) {
        return serverKey.equals(consumerKey);
    }

    public static void main(String[] args) {
        // Initialize new key-store;
        createNewKeyStore();

        // Load key;
        Key loginKey = loadKeyStore();
        boolean isAuthorized = isAuthorized(loginKey, null);
    }
}
