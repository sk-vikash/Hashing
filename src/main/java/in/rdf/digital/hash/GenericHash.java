package in.rdf.digital.hash;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class GenericHash {

  private static final String SHA1 = "SHA-1";
  private static final String SHA256 = "SHA-256";
  private static final String SHA512 = "SHA-512";
  private static final String MD5 = "MD5";
  private static final String samplePassword = "Password$$124&&";


  public static void getMD5() throws NoSuchAlgorithmException {
    MessageDigest messageDigest = MessageDigest.getInstance(MD5);
    final byte[] hashbytes = messageDigest.digest(samplePassword.getBytes(StandardCharsets.UTF_8));
    //System.out.println("getMD5().hashbytes = " + hashbytes);
    StringBuilder sb = new StringBuilder();
    for (byte b : hashbytes) {
      sb.append(String.format("%02x", b));
    }
    System.out.println("################ Hash in MD5 : "+sb.toString());
  }

  public static void getCommonCodesHash() {
    String getCommonCodesHash = DigestUtils.sha256Hex(samplePassword);
    System.out.println("####### Hash in Common Codes : "+getCommonCodesHash);
  }

  public static void getHashSHA1() throws NoSuchAlgorithmException {
    final MessageDigest digest = MessageDigest.getInstance(SHA1);
    final byte[] hashbytes = digest.digest(samplePassword.getBytes(StandardCharsets.UTF_8));
    StringBuilder sb = new StringBuilder();
    for (byte b : hashbytes) {
      sb.append(String.format("%02x", b));
    }
    System.out.println("############### Hash in SHA1 : "+sb.toString());
  }


  public static void getHashSHA256() throws NoSuchAlgorithmException {
    final MessageDigest digest = MessageDigest.getInstance(SHA256);
    final byte[] hashbytes = digest.digest(samplePassword.getBytes(StandardCharsets.UTF_8));
    StringBuilder sb = new StringBuilder();
    for (byte b : hashbytes) {
      sb.append(String.format("%02x", b));
    }
    System.out.println("############# Hash in SHA256 : "+ sb.toString());
  }

  public static void getHashSHA512() throws NoSuchAlgorithmException {
    final MessageDigest digest = MessageDigest.getInstance(SHA512);
    final byte[] hashbytes = digest.digest(samplePassword.getBytes(StandardCharsets.UTF_8));
    StringBuilder sb = new StringBuilder();
    for (byte b : hashbytes) {
      sb.append(String.format("%02x", b));
    }
    System.out.println("############# Hash in SHA512 : "+sb.toString());
  }


  public static void getBCryptPasswordEncoder(){
    //This comes from spring-boot-starter-security
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    String encode = bCryptPasswordEncoder.encode(samplePassword);
    System.out.println("############# Encode in BCrypt : "+encode);
  }
}


