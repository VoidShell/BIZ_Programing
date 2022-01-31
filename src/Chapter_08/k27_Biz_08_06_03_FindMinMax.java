package Chapter_08;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class k27_Biz_08_06_03_FindMinMax {
    public static final String STOCK_CODE = "A005930";
    public static final String STOCK_DATE = "20150112";
    public static final int DATE_FIELD_NUM = 1;
    public static final int CODE_FIELD_NUM = 2;
    public static final int CLOSING_PRICE_FIELD_NUM = 3;
    public static final int COMPARE_STOCK_DATE = 2015;

    public static class Stock {
        private String stockCode;
        private String stockDate;
        private int stockClosingPrice;

        public Stock(String stockCode, String stockDate, int stockClosingPrice) {
            this.stockCode = stockCode;
            this.stockDate = stockDate;
            this.stockClosingPrice = stockClosingPrice;
        }

        public String getStockCode() {
            return stockCode;
        }

        public void setStockCode(String stockCode) {
            this.stockCode = stockCode;
        }

        public String getStockDate() {
            return stockDate;
        }

        public void setStockDate(String stockDate) {
            this.stockDate = stockDate;
        }

        public int getStockClosingPrice() {
            return stockClosingPrice;
        }

        public void setStockClosingPrice(int stockClosingPrice) {
            this.stockClosingPrice = stockClosingPrice;
        }
    }

    public static int cutYearString(String dateField) {
        return Integer.parseInt(dateField.substring(0, 4));
    }

    public static int findMinStock(ArrayList<Stock> stockArrayList) {
        return stockArrayList.stream().mapToInt(Stock::getStockClosingPrice).min().orElse(0);
    }

    public static int findMaxStock(ArrayList<Stock> stockArrayList) {
        return stockArrayList.stream().mapToInt(Stock::getStockClosingPrice).max().orElse(0);
    }

    public static void addStockList(ArrayList<Stock> stockArrayList, String[] field) {
        if (field[CODE_FIELD_NUM].equals(STOCK_CODE) &&
                cutYearString(field[DATE_FIELD_NUM]) == COMPARE_STOCK_DATE) {
            stockArrayList.add
                    (new Stock(field[CODE_FIELD_NUM], field[DATE_FIELD_NUM], Integer.parseInt(field[CLOSING_PRICE_FIELD_NUM])));
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException, ParseException {
        SimpleDateFormat sdfYMD = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdfMS = new SimpleDateFormat("SSS");
        SimpleDateFormat sdfHMS = new SimpleDateFormat("HH:mm:ss");

        File f = new File("THTSKS010H00.dat");
        BufferedReader br = new BufferedReader(new FileReader(f));

        String readtxt;

        int cnt = 0;
        int wcnt = 0;

        Calendar startTime = Calendar.getInstance();
        System.out.printf("Program Start\n");
        System.out.println(sdfYMD.format(startTime.getTime()));
        System.out.printf("\n");

        ArrayList<Stock> stockArrayList = new ArrayList<>();

        while ((readtxt = br.readLine()) != null) {
            StringBuffer s = new StringBuffer();
            String[] field = readtxt.split("%_%");

            if (field.length > 2 && field[2].replace("^", "").trim().substring(0, 1).equals("A")) {
                s.append(field[0].replace("^", "").trim());
                for (int j = 1; j < field.length; j++) {
                    s.append("," + field[j].replace("^", "").trim());
                }
                String[] refineField = s.toString().split(",");
                addStockList(stockArrayList, refineField);
            }
            cnt++;
        }

        br.close();

        System.out.printf("%d년 %s 최대 종가: %d\n", COMPARE_STOCK_DATE, STOCK_CODE, findMaxStock(stockArrayList));
        System.out.printf("%d년 %s 최소 종가: %d\n", COMPARE_STOCK_DATE, STOCK_CODE, findMinStock(stockArrayList));
        System.out.printf("\n");

        System.out.printf("Program End [%d] [%d] records\n", cnt, wcnt);
        Calendar endTime = Calendar.getInstance();
        System.out.println(sdfYMD.format(endTime.getTime()));
        System.out.printf("\n");

        long time = endTime.getTimeInMillis() - startTime.getTimeInMillis();
        Date procTime = sdfMS.parse(String.valueOf(time));

        System.out.printf("Processing Time: %s\n", sdfHMS.format(procTime));
    }
}
