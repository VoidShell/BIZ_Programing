package Chapter_08;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Main {


    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        System.out.println(simpleDateFormat.format(calendar.getTime()));

        String testString = "SKT,LGU+,경기도 광주시청";
        String replaceString = testString.replaceAll("[㈜]|[+]|[\"]", "");
        String[] testStrings = replaceString.split("[,]|[-]|[(]|[)]|[/]");
        for (int i = 0; i < testStrings.length; i++) {
            System.out.println(testStrings[i].trim());
            if (testStrings[i].trim().matches("^[가-힣\\s]*$")) {
                if (testStrings[i].startsWith("경")) {
                    System.out.println(123);
                    System.out.println(testStrings[i].trim());
                }
            }
        }

        String dateString = "20150720";
        System.out.println(dateString.substring(0, 4));

    }
}