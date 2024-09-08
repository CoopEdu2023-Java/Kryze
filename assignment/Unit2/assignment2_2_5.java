import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.*;
import java.util.Base64;

public class assignment2_2_5 {
    public static void main(String[] args) throws Exception {
        interface Encryptable {
            String encrypt(String data) throws Exception;

            String decrypt(String encryptedData) throws Exception;
        }

        class AES implements Encryptable {
            private SecretKey secretKey;

            public AES() throws NoSuchAlgorithmException {
                KeyGenerator keyGen = KeyGenerator.getInstance("AES");
                keyGen.init(128);
                secretKey = keyGen.generateKey();
            }

            @Override
            public String encrypt(String data) throws Exception {
                Cipher cipher = Cipher.getInstance("AES");
                cipher.init(Cipher.ENCRYPT_MODE, secretKey);
                byte[] encryptedBytes = cipher.doFinal(data.getBytes());
                return Base64.getEncoder().encodeToString(encryptedBytes);
            }

            @Override
            public String decrypt(String encryptedData) throws Exception {
                Cipher cipher = Cipher.getInstance("AES");
                cipher.init(Cipher.DECRYPT_MODE, secretKey);
                byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedData));
                return new String(decryptedBytes);
            }
        }

        class RSA implements Encryptable {
            private PublicKey publicKey;
            private PrivateKey privateKey;

            public RSA() throws NoSuchAlgorithmException {
                KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
                keyGen.initialize(2048);
                KeyPair keyPair = keyGen.generateKeyPair();
                publicKey = keyPair.getPublic();
                privateKey = keyPair.getPrivate();
            }

            @Override
            public String encrypt(String data) throws Exception {
                Cipher cipher = Cipher.getInstance("RSA");
                cipher.init(Cipher.ENCRYPT_MODE, publicKey);
                byte[] encryptedBytes = cipher.doFinal(data.getBytes());
                return Base64.getEncoder().encodeToString(encryptedBytes);
            }

            @Override
            public String decrypt(String encryptedData) throws Exception {
                Cipher cipher = Cipher.getInstance("RSA");
                cipher.init(Cipher.DECRYPT_MODE, privateKey);
                byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedData));
                return new String(decryptedBytes);
            }
        }

        Encryptable aes = new AES();
        String aesEncrypted = aes.encrypt("Lizhen");
        System.out.println("AES Encrypted: " + aesEncrypted);
        String aesDecrypted = aes.decrypt(aesEncrypted);
        System.out.println("AES Decrypted: " + aesDecrypted);

        Encryptable rsa = new RSA();
        String rsaEncrypted = rsa.encrypt("Caitiancheng");
        System.out.println("RSA Encrypted: " + rsaEncrypted);
        String rsaDecrypted = rsa.decrypt(rsaEncrypted);
        System.out.println("RSA Decrypted: " + rsaDecrypted);
    }
}
