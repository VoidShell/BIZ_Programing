package Chapter_08;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class k27_Biz_08_06_02_SelectDate {
    public static final String STOCK_DATE = "20150112";
    public static final String STOCK_CODE = "A005930";
    public static final int DATE_FIELD_NUM = 1;
    public static final int CODE_FIELD_NUM = 2;
    public static final int CLOSING_PRICE_FIELD_NUM = 3;
    public static final int COMPARE_STOCK_DATE = 2015;

    public static int selectStock(String field, String selectFieldName, BufferedWriter bw, String line) throws IOException {
        if (field.equals(selectFieldName)) {
            writeFile(bw, line);
            return 1;
        }
        return 0;
    }

    public static void writeFile(BufferedWriter bw, String line) throws IOException {
        bw.write(line);
        bw.newLine();
    }

    public static void main(String[] args) throws IOException, ParseException {

        SimpleDateFormat sdfYMD = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdfMS = new SimpleDateFormat("SSS");
        SimpleDateFormat sdfHMS = new SimpleDateFormat("HH:mm:ss");

        File f = new File("THTSKS010H00.dat");
        BufferedReader br = new BufferedReader(new FileReader(f));

        File f1 = new File("StockDailyPrice_SelectDate.csv");
        BufferedWriter bw1 = new BufferedWriter(new FileWriter(f1));

        String readtxt;

        int cnt = 0;
        int wcnt = 0;

        Calendar startTime = Calendar.getInstance();
        System.out.printf("Program Start\n");
        System.out.println(sdfYMD.format(startTime.getTime()));
        System.out.printf("\n");

        while ((readtxt = br.readLine()) != null) {
            StringBuffer s = new StringBuffer();
            String[] field = readtxt.split("%_%");

            if (field.length > 2 && field[2].replace("^", "").trim().substring(0, 1).equals("A")) {
                s.append(field[0].replace("^", "").trim());
                for (int j = 1; j < field.length; j++) {
                    s.append("," + field[j].replace("^", "").trim());
                }
                String[] refineField = s.toString().split(",");
                wcnt += selectStock(refineField[DATE_FIELD_NUM], STOCK_DATE, bw1, s.toString());
            }
            cnt++;
        }

        br.close();
        bw1.close();

        System.out.printf("Program End [%d] [%d] records\n", cnt, wcnt);
        Calendar endTime = Calendar.getInstance();
        System.out.println(sdfYMD.format(endTime.getTime()));
        System.out.printf("\n");

        long time = endTime.getTimeInMillis() - startTime.getTimeInMillis();
        Date procTime = sdfMS.parse(String.valueOf(time));

        System.out.printf("Processing Time: %s\n", sdfHMS.format(procTime));
    }
}
