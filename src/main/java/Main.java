import com.carbroker.Util.CryptWithMD5;
import com.carbroker.Util.GenerateRandomValue;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
 class CryptWithMD5 {
    private static MessageDigest md;

    public static String cryptWithMD5(String pass){
        try {
            md = MessageDigest.getInstance("MD5");
            byte[] passBytes = pass.getBytes();
            md.reset();
            byte[] digested = md.digest(passBytes);
            StringBuffer sb = new StringBuffer();
            for(int i=0;i<digested.length;i++){
                sb.append(Integer.toHexString(0xff & digested[i]));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(CryptWithMD5.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;


    }
}
public class Main {
    public static String generateRandomChars(String candidateChars, int length) {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(candidateChars.charAt(random.nextInt(candidateChars
                    .length())));
        }

        return sb.toString();
    }




    public  static  void  main(String [] args){
       GenerateRandomValue gen=new GenerateRandomValue();
       int n=gen.generate();
       System.out.println(n);
        System.out.println(generateRandomChars(
                "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890", 6));

String a="aaaa";
        System.out.println(CryptWithMD5.cryptWithMD5(a));
    }
}
