package Chapter_08;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class k27_Biz_08_04_ReadStockData {
    public static void main(String[] args) throws IOException, ParseException {
        // SimpleDateFormat으로 출력 양식 설정
        SimpleDateFormat sdfYMD = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdfMS = new SimpleDateFormat("SSS");
        SimpleDateFormat sdfHMS = new SimpleDateFormat("HH:mm:ss");
        // THTSKS010H00.dat 파일 인스턴스 설정
        File f = new File("THTSKS010H00.dat");
        // BufferedReader 클래스 인스턴스 br 생성
        BufferedReader br = new BufferedReader(new FileReader(f));
        // 타임스탬프를 찍을 Calendar 인스턴스 startTime 생성
        // 원하는 지점마다 인스턴ㅅ를 생성해야 한다.
        Calendar startTime = Calendar.getInstance();
        System.out.printf("Program Start\n");
        // sdfYMD 양식으로 날짜 출력.
        System.out.println(sdfYMD.format(startTime.getTime()));
        System.out.printf("\n");

        String readtxt;
        int LineCnt = 0;
        int n = -1;
        StringBuffer s = new StringBuffer();
        while (true) {
            // 버퍼로 사용할 1000길이의 char 배열 선언.
            char[] ch = new char[1000];
            // br의 read메서드로 ch를 인수로 넣고 이에 대한 리턴값을 n에 반환.
            n = br.read(ch);
            // n이 01 이라면 루프 종료
            if (n == -1) break;
            // ch 배열의 길이만큼 루프 진행
            for (char c : ch) {
                // c가 개행이면
                if (c == '\n') {
                    // 표준출력으로 StringBuilder 인스턴스 s의 String을 출력한다
                    System.out.printf("%s\n", s.toString());
                    // 0에서 s 스트링 빌더의 길이만큼 삭제한다.
                    s.delete(0, s.length());
                    // c가 개행이 아니면
                } else {
                    // c를 append한다.
                    s.append(c);
                }
            }
            // LineCut의 flag를 1 증가
            LineCnt++;
        }

        // 파일에서 읽어온 메시지 출력
        System.out.printf("[%s]***\n", s.toString());
        br.close();
        // 타임 스탬프 출력
        System.out.printf("Program End\n");
        Calendar endTime = Calendar.getInstance();
        System.out.println(sdfYMD.format(endTime.getTime()));
        System.out.printf("\n");
        // 경과 시간 계산 출력
        long time = endTime.getTimeInMillis() - startTime.getTimeInMillis();
        Date procTime = sdfMS.parse(String.valueOf(time));

        System.out.printf("Processing Time: %s\n", sdfHMS.format(procTime));
    }
}
