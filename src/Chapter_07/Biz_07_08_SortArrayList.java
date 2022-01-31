package Chapter_07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Biz_07_08_SortArrayList {
    // 클래스의 ArrayList p31
    static ArrayList<Biz_07_08_OneRec> ArrayOneRec = new ArrayList<Biz_07_08_OneRec>();

    static int sumkor = 0;
    static int sumeng = 0;
    static int summat = 0;
    static int sumsum = 0;
    static int sumave = 0;
    static final int iPerson = 20;

    // 데이터 만들기
    public static void dataset() {
        for (int i = 0; i < iPerson; i++) {
            String name = String.format("홍길동%02d", i); // 이름만들기
            int kor = (int) (Math.random() * 100); // 국어점수만들기
            int eng = (int) (Math.random() * 100); // 영어점수만들기
            int mat = (int) (Math.random() * 100); // 수학점수만들기
            ArrayOneRec.add(new Biz_07_08_OneRec(i, name, kor, eng, mat));
            // 하나의 OneRec 클래스 생성 후 ArryaList에 집어넣었다.

        }
    }

    public static void dataSort() {
        Comparator<Biz_07_08_OneRec> bikyeokijun = new Comparator<Biz_07_08_OneRec>() {
            @Override
            public int compare(Biz_07_08_OneRec o1, Biz_07_08_OneRec o2) {
                return 0;
            }
        };
        Collections.sort(ArrayOneRec, bikyeokijun);
    }

    // 헤더 인쇄
    public static void HeaderPrint() {
        System.out.printf("********************************************\n");
        System.out.printf("%2s %4s %2s %2s %2s %2s   %2s\n", "번호", "이름", "국어", "영어", "수학", "합계", "평균");
        System.out.printf("********************************************\n");

    }

    // 내용 인쇄
    public static void ItemPrint(int i) {
        Biz_07_08_OneRec rec;

        rec = ArrayOneRec.get(i);
        System.out.printf("%4d %4s %3d %3d %3d  %3d  %6.2f\n", rec.student_id(), rec.name(), rec.kor(), rec.eng(),
                rec.mat(), rec.sum(), rec.ave());
    }

    // 꼬리 인쇄
    public static void TailPrint() {

        sumkor = ArrayOneRec.stream().mapToInt(Biz_07_08_OneRec::kor).sum();
        sumeng = ArrayOneRec.stream().mapToInt(Biz_07_08_OneRec::eng).sum();
        summat = ArrayOneRec.stream().mapToInt(Biz_07_08_OneRec::mat).sum();
        sumave = (sumkor + sumeng + summat) / 3;

        System.out.printf("************************************************\n");
        System.out.printf("국어합계 %4d    국어평균: %6.2f\n", sumkor, sumkor / (double) ArrayOneRec.size());
        System.out.printf("영어합계 %4d    영어평균: %6.2f\n", sumeng, sumeng / (double) ArrayOneRec.size());
        System.out.printf("수학합계 %4d    수학평균: %6.2f\n", summat, summat / (double) ArrayOneRec.size());
        System.out.printf("************************************************\n");
        System.out.printf("반평균합계 %4d    반평균: %6.2f\n", sumave, (sumkor + sumeng + summat) / (double) ArrayOneRec.size() / 3);
    }

    public static void main(String[] args) {
        dataset();
        dataSort();
        HeaderPrint();
        for (int i = 0; i < ArrayOneRec.size(); i++) {
            ItemPrint(i);
        }
        TailPrint();
    }
}
