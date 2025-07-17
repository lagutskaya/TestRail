package utils;

import java.util.Random;

public class RandomStringGenerator {

    public static String generateRandomString() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(3);

        for (int i = 0; i < 3; i++) {
            char c = (char) (random.nextInt(26) + 'a');
            sb.append(c);
        }

        return sb.toString();
    }
}
