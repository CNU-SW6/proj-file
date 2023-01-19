package cnu.swabeimage.utils;

public class RandomUtil {
    public static String lowerAlpa(int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < count ; i++) {
            char ch = (char) ((Math.random() * 26) + 97);
            sb.append(ch);
        }
        return sb.toString();
    }
}
