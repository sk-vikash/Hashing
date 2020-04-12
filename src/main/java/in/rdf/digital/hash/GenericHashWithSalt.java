package in.rdf.digital.hash;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import org.springframework.security.crypto.bcrypt.BCrypt;


public class GenericHashWithSalt {

  private static final String SHA1 = "SHA-1";
  private static final String SHA256 = "SHA-256";
  private static final String SHA512 = "SHA-512";
  private static final String MD5 = "MD5";
  private static final String samplePassword = "Password$$124&&";
  private static final String SECURE_RANDOM_SALT_PROVIDER = "SUN";
  private static final String SECURE_RANDOM_SALT_ALGORITHM = "SHA1PRNG";



  public static void getMD5WithSalt() throws NoSuchAlgorithmException, NoSuchProviderException {
    MessageDigest messageDigest = MessageDigest.getInstance(MD5);
    byte[] salt = getSalt();
    messageDigest.update(salt);

    final byte[] hashedPasswordWithSalt = messageDigest.digest(samplePassword.getBytes(StandardCharsets.UTF_8));
    StringBuilder sb = new StringBuilder();
    for (byte b : hashedPasswordWithSalt) {
      sb.append(String.format("%02x", b));
    }
    System.out.println("################ Hash with salt in MD5 : "+sb.toString());
  }


  public static void getHashSHA1WithSalt() throws NoSuchAlgorithmException, NoSuchProviderException {
    final MessageDigest digest = MessageDigest.getInstance(SHA1);
    byte[] salt = getSalt();
    digest.update(salt);

    final byte[] hashbytes = digest.digest(samplePassword.getBytes(StandardCharsets.UTF_8));
    StringBuilder sb = new StringBuilder();
    for (byte b : hashbytes) {
      sb.append(String.format("%02x", b));
    }
    System.out.println("############### Hash with salt in SHA1 : "+sb.toString());
  }


  public static void getHashSHA256WithSalt()
      throws NoSuchAlgorithmException, NoSuchProviderException {
    final MessageDigest digest = MessageDigest.getInstance(SHA256);

    byte[] salt = getSalt();
    digest.update(salt);

    final byte[] hashbytes = digest.digest(samplePassword.getBytes(StandardCharsets.UTF_8));
    StringBuilder sb = new StringBuilder();
    for (byte b : hashbytes) {
      sb.append(String.format("%02x", b));
    }
    System.out.println("############# Hash with salt in SHA256 : "+ sb.toString());
  }

  public static void getHashSHA512WithSalt()
      throws NoSuchAlgorithmException, NoSuchProviderException {
    final MessageDigest digest = MessageDigest.getInstance(SHA512);

    byte[] salt = getSalt();
    digest.update(salt);

    final byte[] hashbytes = digest.digest(samplePassword.getBytes(StandardCharsets.UTF_8));
    StringBuilder sb = new StringBuilder();
    for (byte b : hashbytes) {
      sb.append(String.format("%02x", b));
    }
    System.out.println("############# Hash with salt in SHA512 : "+sb.toString());
  }

  public static void getBCryptWithSalt(){
    String generatedSecuredPasswordHash = BCrypt.hashpw(samplePassword, BCrypt.gensalt(12));
    System.out.println("############# Hash with salt in Bcrypt : "+generatedSecuredPasswordHash);

    boolean matched = BCrypt.checkpw(samplePassword, generatedSecuredPasswordHash);
    System.out.println(matched);
  }

  public static void getPBKDF2WithHmacSHA1WithSalt()
      throws NoSuchProviderException, NoSuchAlgorithmException, InvalidKeySpecException {
    int iteration = 1000;
    byte[] salt = getSalt();
    PBEKeySpec spec = new PBEKeySpec(samplePassword.toCharArray(), salt, iteration, 64 * 8);
    SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
    final byte[] hash = skf.generateSecret(spec).getEncoded();

    StringBuilder sb = new StringBuilder();
    for (byte b : hash) {
      sb.append(String.format("%02x", b));
    }
    System.out.println("# Hash with salt in PBKDF2WithHmacSHA1 : "+sb.toString());


    boolean matched = validatePassword(samplePassword, sb.toString(), salt, iteration);
    System.out.println(matched);
    System.out.println();
  }

  private static byte[] getSalt() throws NoSuchAlgorithmException, NoSuchProviderException {
    //Always use a SecureRandom generator
    SecureRandom sr = SecureRandom.getInstance(SECURE_RANDOM_SALT_ALGORITHM, SECURE_RANDOM_SALT_PROVIDER);
    //Create array for salt
    byte[] salt = new byte[16];
    //Get a random salt
    sr.nextBytes(salt);
    StringBuilder sb = new StringBuilder();
    for (byte b : salt) {
      sb.append(String.format("%02x", b));
    }
    System.out.println("sb.toString() = " + sb.toString());
    return salt;
  }

  private static boolean validatePassword(String originalPassword, String storedPassword, byte[] salt, int iteration)
      throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchProviderException {

    byte[] hash = fromHex(storedPassword);

    PBEKeySpec spec = new PBEKeySpec(originalPassword.toCharArray(), salt, iteration, hash.length * 8);
    SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
    byte[] testHash = skf.generateSecret(spec).getEncoded();

    int diff = hash.length ^ testHash.length;
    for(int i = 0; i < hash.length && i < testHash.length; i++)
    {
      diff |= hash[i] ^ testHash[i];
    }
    return diff == 0;
  }

  private static byte[] fromHex(String hex) throws NoSuchAlgorithmException
  {
    byte[] bytes = new byte[hex.length() / 2];
    for(int i = 0; i<bytes.length ;i++)
    {
      bytes[i] = (byte)Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
    }
    return bytes;
  }
}


