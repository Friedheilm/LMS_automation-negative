package by.bntu.lms.utils;

import java.security.SecureRandom;
import java.util.concurrent.ThreadLocalRandom;

public class Utils {
    static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    static SecureRandom rnd = new SecureRandom();

    public static int generateRandomNumber(int from, int to) {
        return ThreadLocalRandom.current().nextInt(from, to + 1);
    }

    public static String generateRandomString(int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }
}
