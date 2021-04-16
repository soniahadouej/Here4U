package tn.g3.spring.entity;
import java.util.Random;


public class OfferCodeGenerator {
	private static final String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public static String generateCodeOffer () {
        Random rand = new Random();
        int size = rand.nextInt(10) + 5;
        char[] chars = new char[size];
        for (int i = 0; i < size; i++) chars[i] = characters.charAt(rand.nextInt(characters.length()));
        return new String(chars);
    }
    

}
