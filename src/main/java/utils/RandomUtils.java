package utils;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomUtils {
    public static long randomInt = (long) (Math.random() * 1000000000);

    public static String randomString(int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }
}