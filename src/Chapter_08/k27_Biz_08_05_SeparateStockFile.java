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

public class k27_Biz_08_05_SeparateStockFile {
    public static void main(String[] args) throws IOException, ParseException {
        // SimpleDateFormat 양식 설정
        SimpleDateFormat sdfYMD = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdfMS = new SimpleDateFormat("SSS");
        SimpleDateFormat sdfHMS = new SimpleDateFormat("HH:mm:ss");

        // File 인스턴스로 "THTSKS010H00.dat" 생성.
        File f = new File("THTSKS010H00.dat");
        // BufferedReadr 인스턴스 br 생성.
        BufferedReader br = new BufferedReader(new FileReader(f));
        // File 인스턴스로 "StockDailyPrice.csv" 생성.
        File f1 = new File("StockDailyPrice.csv");
        // BufferedWriter 인스턴스 bw 생성.
        BufferedWriter bw1 = new BufferedWriter(new FileWriter(f1));

        String readtxt;

        int cnt = 0;
        int wcnt = 0;

        Calendar startTime = Calendar.getInstance();
        System.out.printf("Program Start\n");
        System.out.println(sdfYMD.format(startTime.getTime()));
        System.out.printf("\n");
        // readLine 메서드를 통해 한줄씩 내용을 불러오고 이를 readtxt에 저장한다.
        // readtxt의 null을 체크해서 아닐 경우 계속 반복한다.
        while ((readtxt = br.readLine()) != null) {
            StringBuffer s = new StringBuffer();
            // %_% 단위로 readtxt를 split 한다
            String[] field = readtxt.split("%_%");
            // 첫 필드는 뒤에있는 ^ 기호만 떼어내고 append한다.
            if (field.length > 2 && field[2].replace("^", "").trim().substring(0, 1).equals("A")) {
                s.append(field[0].replace("^", "").trim());
                // 두 번째 필드는 좌우에 있는 ^ 기호를 떼어내고 append한다.
                for (int j = 1; j < field.length; j++) {
                    s.append("," + field[j].replace("^", "").trim());
                }
                // StringBuffer로 완성된 String을 write한다.
                bw1.write(s.toString());
                bw1.newLine();
                wcnt++;
            }
            cnt++;
        }

        br.close();
        bw1.close();
        // Calendar로 타임스탬프 출력
        System.out.printf("Program End [%d] [%d] records\n", cnt, wcnt);
        Calendar endTime = Calendar.getInstance();
        System.out.println(sdfYMD.format(endTime.getTime()));
        System.out.printf("\n");
        // 시간차이 계산해서 경과 시간 측정 출력
        long time = endTime.getTimeInMillis() - startTime.getTimeInMillis();
        Date procTime = sdfMS.parse(String.valueOf(time));

        System.out.printf("Processing Time: %s\n", sdfHMS.format(procTime));
    }
}
