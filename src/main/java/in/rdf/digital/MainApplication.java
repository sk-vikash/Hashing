package in.rdf.digital;

import in.rdf.digital.hash.GenericHash;
import in.rdf.digital.hash.GenericHashWithSalt;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.spec.InvalidKeySpecException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApplication {
  public static void main(final String[] args)
      throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeySpecException {
    SpringApplication.run(MainApplication.class, args);
    System.out.println("###################################################################################");
    System.out.println("###################################################################################");
    System.out.println("###################################################################################");
    System.out.println("###################################################################################");
    GenericHash.getMD5();
    System.out.println();
    GenericHash.getHashSHA1();
    System.out.println();
    GenericHash.getHashSHA256();
    System.out.println();
    GenericHash.getCommonCodesHash();
    System.out.println();
    GenericHash.getHashSHA512();
    System.out.println();
    GenericHash.getBCryptPasswordEncoder();
    System.out.println();
    System.out.println("###################################################################################");
    System.out.println("###################################################################################");
    System.out.println("###################################################################################");
    System.out.println("###################################################################################");
    System.out.println();
    GenericHashWithSalt.getMD5WithSalt();
    System.out.println();
    GenericHashWithSalt.getHashSHA1WithSalt();
    System.out.println();
    GenericHashWithSalt.getHashSHA256WithSalt();
    System.out.println();
    GenericHashWithSalt.getHashSHA512WithSalt();
    System.out.println();
    GenericHashWithSalt.getBCryptWithSalt();
    System.out.println();
    GenericHashWithSalt.getPBKDF2WithHmacSHA1WithSalt();
    System.out.println("###################################################################################");
    System.out.println("###################################################################################");
    System.out.println("###################################################################################");
    System.out.println("###################################################################################");
  }
}
