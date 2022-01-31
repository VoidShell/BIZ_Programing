package Chapter_07;

import Chapter_05_Receipt_02.k27_Biz_05_Receipt_02_All;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.w3c.dom.ls.LSOutput;

import javax.naming.PartialResultException;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;

public class Biz_07_10_SortCutArrayList {
    // 클래스의 ArrayList p31
    static ArrayList<Biz_07_08_OneRec> ArrayOneRec = new ArrayList<Biz_07_08_OneRec>();

    static int sumkor = 0;
    static int sumeng = 0;
    static int summat = 0;
    static int sumsum = 0;
    static int sumave = 0;
    static final int iPerson = 200;

    // 데이터 만들기
    public static void dataset() {
        for (int i = 1; i < iPerson + 1; i++) {
            String name = String.format("홍길동%02d", i); // 이름만들기
            int kor = (int) (Math.random() * 100); // 국어점수만들기
            int eng = (int) (Math.random() * 100); // 영어점수만들기
            int mat = (int) (Math.random() * 100); // 수학점수만들기
            ArrayOneRec.add(new Biz_07_08_OneRec(i, name, kor, eng, mat));
            // 하나의 OneRec 클래스 생성 후 ArryaList에 집어넣었다.

        }
    }

/*    public static void dataSort() {
        Comparator<Biz_07_08_OneRec> bikyeokijun = new Comparator<Biz_07_08_OneRec>() {
            @Override
            public int compare(Biz_07_08_OneRec o1, Biz_07_08_OneRec o2) {
                return ;
            }
        };
        Collections.sort(ArrayOneRec, bikyeokijun);
    }*/

    // 헤더 인쇄
    public static void HeaderPrint(int i) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:hh");
        Calendar calendar = Calendar.getInstance();
        System.out.printf("\n                 성적 집계표                  \n");
        System.out.printf("%s %d%10s %20s\n", "PAGE", i + 1, "출력일자 : ", simpleDateFormat.format(calendar.getTime()));
        System.out.printf("============================================\n");
        System.out.printf("%2s %4s %2s %2s %2s %2s   %2s\n", "번호", "이름", "국어", "영어", "수학", "총점", "평균");
        System.out.printf("============================================\n");

    }

    // 내용 인쇄
    public static void ItemPrint(int i) {
        Biz_07_08_OneRec rec;

        rec = ArrayOneRec.get(i);
        System.out.printf("%4d %4s %3d %3d %3d  %3d  %6.2f\n", rec.student_id(), rec.name(), rec.kor(), rec.eng(),
                rec.mat(), rec.sum(), rec.ave());
    }

    // 꼬리 인쇄
    public static void TailPrint(ArrayList<Biz_07_09_OneRec> scoreCal, int flag) {
        int start = flag - 30;
        int kor30Sum = 0;
        int eng30Sum = 0;
        int mat30Sum = 0;
        int korAllSum = 0;
        int engAllSum = 0;
        int matAllSum = 0;

        for (int i = start; i < flag; i++) {
            kor30Sum = kor30Sum + scoreCal.get(i).kor();
            eng30Sum = eng30Sum + scoreCal.get(i).eng();
            mat30Sum = mat30Sum + scoreCal.get(i).mat();
        }

        for (int i = 0; i < flag; i++) {
            korAllSum = korAllSum + scoreCal.get(i).kor();
            engAllSum = engAllSum + scoreCal.get(i).eng();
            matAllSum = matAllSum + scoreCal.get(i).mat();
        }


        System.out.printf("============================================\n");
        System.out.printf("현재페이지\n");
        System.out.printf("%2s %4s %2s %2s %2s %2s   %2s\n", "합계", "   ",
                kor30Sum, eng30Sum, mat30Sum, kor30Sum + eng30Sum + mat30Sum, (kor30Sum + eng30Sum + mat30Sum) / 3);
        System.out.printf("%2s %4s %2s %2s %2s %2s   %2s\n", "평균", "   ",
                kor30Sum / 30, eng30Sum / 30, mat30Sum / 30, (kor30Sum + eng30Sum + mat30Sum) / 30, (kor30Sum + eng30Sum + mat30Sum) / 30 / 3);
        System.out.printf("============================================\n");
        System.out.printf("누적페이지\n");
        System.out.printf("%2s %4s %2s %2s %2s %2s   %2s\n", "합계", "   ",
                korAllSum, engAllSum, matAllSum, korAllSum + engAllSum + matAllSum, (korAllSum + engAllSum + matAllSum) / 3);
        System.out.printf("%2s %4s %2s %2s %2s %2s   %2s\n", "평균", "   ",
                korAllSum / flag, engAllSum / flag, matAllSum / flag, (korAllSum + engAllSum + matAllSum) / flag, (korAllSum + engAllSum + matAllSum) / flag / 3);
        System.out.printf("============================================\n");


    }

    public static void main(String[] args) {
        ArrayList<Biz_07_09_OneRec> ScoreCal = new ArrayList<>();
        dataset();

        int flag = 0;

        for (int i = 0; i < iPerson / 30 + 1; i++) {
            HeaderPrint(i);
            if (flag < iPerson - 30) {
                for (int j = flag; j < flag + 30; j++) {
                    ItemPrint(j);
                    ScoreCal.add(new Biz_07_09_OneRec(ArrayOneRec.get(j).kor(), ArrayOneRec.get(j).eng(), ArrayOneRec.get(j).mat()));
                }
                flag = flag + 30;
                TailPrint(ScoreCal, flag);
            } else {
                for (int j = flag; j < flag + iPerson % 30; j++) {
                    ItemPrint(j);
                    ScoreCal.add(new Biz_07_09_OneRec(ArrayOneRec.get(j).kor(), ArrayOneRec.get(j).eng(), ArrayOneRec.get(j).mat()));
                }
                TailPrint(ScoreCal, flag);
                break;
            }
        }
    }
}

