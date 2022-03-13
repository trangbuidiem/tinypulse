package trangbui.selenium.common;

import org.apache.commons.lang3.StringUtils;

import java.util.Random;

public class MyStringUtils {
    //Default Constructor
    private MyStringUtils() {}

    /**
     * Repeat * num times.
     * @param num
     * @return * num times, *******
     */
    public static String asterisk(int num) {
        return StringUtils.repeat("*", num);
    }

    public static String asterisk() {
        return StringUtils.repeat("*", Constants.TITLE_BOX_WIDTH);
    }

    public static String dash() {
        return StringUtils.repeat("-", Constants.TITLE_BOX_WIDTH);
    }


    public static String centerTitleWith$(String title, int size, String padStr) {

        return StringUtils.center(StringUtils.center(title, Constants.TITLE_TEXT_WIDTH, ' '), size, padStr);
    }

    public static String centerTitleWith$(String title) {
        return centerTitleWith$(title, Constants.TITLE_BOX_WIDTH, "$");
    }

    public static String centerTitleWithDash(String title) {
        return centerTitleWith$(title, Constants.TITLE_BOX_WIDTH, "=");
    }

    public static String randomEmail(Integer targetStringLength) {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        Random random = new Random();

        return  random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

}
