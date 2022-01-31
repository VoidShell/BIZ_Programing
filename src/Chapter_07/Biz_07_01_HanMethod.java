package Chapter_07;

import java.io.UnsupportedEncodingException;

public class Biz_07_01_HanMethod {
    public static String k27_HanBlankBackword(String k27_str, int k27_length) throws UnsupportedEncodingException {
        StringBuilder stringBuilder = new StringBuilder(k27_str);
        String outputString;

        int byteLength = k27_str.getBytes("euc-kr").length;

        if (byteLength < k27_length) {
            for (int i = 0; i < k27_length - byteLength; i++) {
                stringBuilder.append(" ");
            }
            outputString = stringBuilder.toString();
        } else {
            outputString = k27_str;
        }
        return outputString;
    }

    public static String k27_HanBlankForeword(String k27_str, int k27_length) throws UnsupportedEncodingException {
        StringBuilder stringBuilder = new StringBuilder();
        String outputString;

        int byteLength = k27_str.getBytes("euc-kr").length;

        if (byteLength < k27_length) {
            for (int i = 0; i < k27_length - byteLength; i++) {
                stringBuilder.append(" ");
            }
            outputString = stringBuilder.append(k27_str).toString();

        } else {
            outputString = k27_str;
        }
        return outputString;
    }

    public static int k27_HanCount(String k27_str) throws UnsupportedEncodingException {
        int hanFlag = 0;
        for (int i = 0; i < k27_str.length(); i++) {
            String inputString = k27_str.substring(i, i + 1);
            int byteLength = inputString.getBytes("euc-kr").length;

            if (byteLength == 2) {
                hanFlag++;
            }
        }
        return hanFlag;
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        System.out.printf("HanBlankForeword[%s]\n", k27_HanBlankForeword("한글abcd", 15));
        System.out.printf("HanBlankForeword[%s]\n", k27_HanBlankForeword("한글한글aa", 15));
        System.out.printf("HanBlankBackword[%s]\n", k27_HanBlankBackword("한글aa", 15));
        System.out.printf("HanBlankBackword[%s]\n", k27_HanBlankBackword("한글한글aa", 15));
        System.out.printf("한글은 [%d]개\n", k27_HanCount("한글한글aa"));
    }
}
