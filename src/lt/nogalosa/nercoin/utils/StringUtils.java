package lt.nogalosa.nercoin.utils;

import lt.nogalosa.nercoin.hash.NerHash;

import java.util.Random;

public class StringUtils {
    private static Random random;

    static {
        random = new Random();
    }

    public static String generateRandomString() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 30;
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();

        return generatedString;
    }

    public static String generateRandomHash() {
        NerHash nerHash = new NerHash(generateRandomString());
        return nerHash.hash();
    }
}
