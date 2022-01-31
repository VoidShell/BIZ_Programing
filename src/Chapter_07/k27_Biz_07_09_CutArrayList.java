package Chapter_07;

import java.text.SimpleDateFormat;
import java.util.*;

public class k27_Biz_07_09_CutArrayList {
    // OneRec 클래스형 ArayList 객체 ArraOneRec을 생성한다.
    // 전체 정보가 삽입된 ArrayList이다.
    // static으로 선언되어 다른 메서드에서 별도의 인자 호출 없이 해당 객체를 사용할 수 있다.
    static ArrayList<k27_Biz_07_09_OneRec> k27_ArrayOneRec = new ArrayList<>();
    static final int k27_iPerson = 2050;
    static final int k27_pageNum = 40;

    // 데이터 만들기
    // Math.random()으로 난수를 발생시키고 100을 곱해 랜덤 점수를 만든다.
    // ArrayOneRec에 add 메소드를 사용하여 OneRec클래스를 생성자로 인스턴스를 만들고 list에 담는다.
    public static void k27_dataset() {
        for (int i = 1; i < k27_iPerson + 1; i++) {
            String name = String.format("홍길%02d", i); // 이름만들기
            int kor = (int) (Math.random() * 100); // 국어점수만들기
            int eng = (int) (Math.random() * 100); // 영어점수만들기
            int mat = (int) (Math.random() * 100); // 수학점수만들기
            k27_ArrayOneRec.add(new k27_Biz_07_09_OneRec(i, name, kor, eng, mat));
            // 하나의 OneRec 클래스 생성 후 ArryaList에 집어넣었다.
        }
    }

    // 인수로 ArrayList<k27_Biz_07_09_OneRec>형 list 인스턴스과 인덱스를 받고
    // 해당 인덱스를 바탕으로 list 인스턴스에 static으로 선언된 ArrayOneRec의 요소값을 대입하는 메서드
    // 파라미터1: ArrayList<k27_Biz_07_09_OneRec> k27_list, 파라미터2: k27_j 인덱스
    public static void k27_listInsert(ArrayList<k27_Biz_07_09_OneRec> k27_list, int k27_j) {
        k27_list.add(new k27_Biz_07_09_OneRec(
                k27_ArrayOneRec.get(k27_j).student_id(), k27_ArrayOneRec.get(k27_j).name(), k27_ArrayOneRec.get(k27_j).kor(),
                k27_ArrayOneRec.get(k27_j).eng(), k27_ArrayOneRec.get(k27_j).mat()));
    }

    // 헤더 인쇄
    // 헤더 부분 SimpleDateFormat으로 날짜 출력
    public static void k27_HeaderPrint(int i) {
        SimpleDateFormat k27_simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:hh");
        Calendar k27_calendar = Calendar.getInstance();
        System.out.printf("\n                     성적집계표                     \n");
        System.out.printf("%s %3d        %13s%s\n", "PAGE:", i + 1, "출력일자 : ", k27_simpleDateFormat.format(k27_calendar.getTime()));
        System.out.printf("=====================================================\n");
        System.out.printf("%-3s %5s %5s %5s %5s %5s %5s\n", "번호", "이름", "국어", "영어", "수학", "총점", "평균");
        System.out.printf("=====================================================\n");

    }

    // 내용 인쇄 부분.
    // k27_ArrayOneRec에서 get 메서드로 불러온 요소값을 OneRec 클래스형 인스턴스에 대입한다.
    // 이제 해당 인스턴스로부터 명령어를 길게 치지 않고 메소드 필드 사용 가능하다.
    public static void k27_ItemPrint(int i) {
        k27_Biz_07_09_OneRec k27_rec;

        k27_rec = k27_ArrayOneRec.get(i);
        System.out.printf("%04d  %6s %6d %7d %7d %7d  %6.2f\n", k27_rec.student_id(), k27_rec.name(), k27_rec.kor(), k27_rec.eng(),
                k27_rec.mat(), k27_rec.sum(), k27_rec.ave());
    }

    // Stream -> Map 매핑 과정과 sum 메서드를 통해 list의 특정 요소 합을 구한다.
    // streamKorSum 메서드: 해당 list에서 OndeRec 클래스의 kor 필드들 합을 구한다.
    // 파라미터1: 합계를 구할 k27_list
    public static int k27_listKorSum(ArrayList<k27_Biz_07_09_OneRec> k27_list) {
        return k27_list.stream().mapToInt(k27_Biz_07_09_OneRec::kor).sum();
    }

    // Stream -> Map 매핑 과정과 sum 메서드를 통해 list의 특정 요소 합을 구한다.
    // streamEngSum 메서드: 해당 list에서 OndeRec 클래스의 eng 필드들 합을 구한다.
    // 파라미터1: 합계를 구할 k27_list
    public static int k27_listEngSum(ArrayList<k27_Biz_07_09_OneRec> k27_list) {
        return k27_list.stream().mapToInt(k27_Biz_07_09_OneRec::eng).sum();
    }

    // Stream -> Map 매핑 과정과 sum 메서드를 통해 list의 특정 요소 합을 구한다.
    // streamMatSum 메서드: 해당 list에서 OndeRec 클래스의 mat 필드들 합을 구한다.
    // 파라미터1: 합계를 구할 k27_list
    public static int k27_listMatSum(ArrayList<k27_Biz_07_09_OneRec> k27_list) {
        return k27_list.stream().mapToInt(k27_Biz_07_09_OneRec::mat).sum();
    }

    // k27_list 에서 해당 과목의 평균을 구하는 메서드
    // 파라미터1: 사이즈 길이를 반한활 k27_list, 파라미터2: 과목 점수 합계
    public static double k27_listSubAvg(ArrayList<k27_Biz_07_09_OneRec> k27_list, int k27_subSum) {
        return (double) k27_subSum / k27_list.size();
    }

    // 꼬리 인쇄
    public static void k27_TailPrint(ArrayList<k27_Biz_07_09_OneRec> allList, ArrayList<k27_Biz_07_09_OneRec> k27_pageList) {
        // Page 부분에서 list~Sum 메서드 이용해서 각 과목 합계 구하는 과정
        int k27_korPageSum = k27_listKorSum(k27_pageList);
        int k27_engPageSum = k27_listEngSum(k27_pageList);
        int k27_matPageSum = k27_listMatSum(k27_pageList);
        // Page 부분에서 listSubAvg 메서드 이용해서 각 과목 평균 구하는 과정
        double k27_korPageAvg = k27_listSubAvg(k27_pageList, k27_korPageSum);
        double k27_engPageAvg = k27_listSubAvg(k27_pageList, k27_engPageSum);
        double k27_matPageAvg = k27_listSubAvg(k27_pageList, k27_matPageSum);
        // 전체에서 list~Sum 메서드 이용해서 각 과목 전테 합계 구하는 과정
        int k27_korAllSum = k27_listKorSum(allList);
        int k27_engAllSum = k27_listEngSum(allList);
        int k27_matAllSum = k27_listMatSum(allList);
        // 전체에서 listSubAvg 메서드 이용해서 각 과목 전체 통계 구하는 과정
        double k27_korAllAvg = k27_listSubAvg(allList, k27_korAllSum);
        double k27_engAllAvg = k27_listSubAvg(allList, k27_engAllSum);
        double k27_matAllAvg = k27_listSubAvg(allList, k27_matAllSum);

        System.out.printf("=====================================================\n");
        System.out.printf("현재페이지\n");
        System.out.printf("합      계%11d%8d%8d%8d%8d\n",
                k27_korPageSum, k27_engPageSum, k27_matPageSum, k27_korPageSum + k27_engPageSum + k27_matPageSum, (k27_korPageSum + k27_engPageSum + k27_matPageSum) / 3);
        System.out.printf("평      균%11.2f%8.2f%8.2f%8.2f%8.2f\n",
                k27_korPageAvg, k27_engPageAvg, k27_matPageAvg, k27_korPageAvg + k27_engPageAvg + k27_matPageAvg, (k27_korPageAvg + k27_engPageAvg + k27_matPageAvg) / 3.0);
        System.out.printf("=====================================================\n");
        System.out.printf("누적페이지\n");
        System.out.printf("합      계%11d%8d%8d%8d%8d\n",
                k27_korAllSum, k27_engAllSum, k27_matAllSum, k27_korAllSum + k27_engAllSum + k27_matAllSum, (k27_korAllSum + k27_engAllSum + k27_matAllSum) / 3);
        System.out.printf("평      균%11.2f%8.2f%8.2f%8.2f%8.2f\n",
                k27_korAllAvg, k27_engAllAvg, k27_matAllAvg, k27_korAllAvg + k27_engAllAvg + k27_matAllAvg, (k27_korAllAvg + k27_engAllAvg + k27_matAllAvg) / 3.0);
        System.out.printf("=====================================================\n");
        // k27_pageList 리스트에서 clear 메서드를 사용해서 해당 인스턴스를 초기화 한다.
        // 해당 페이지가 끝나면 pageList를 초기화하여 인스턴스를 새로운 페이지로 재사용할 수 있게 한다.
        k27_pageList.clear();
    }

    public static void main(String[] args) {
        // k27_allList: 전체를 관리하는 리스트
        // k27_pageList: 페이지 단위를 관리하는 리스트
        ArrayList<k27_Biz_07_09_OneRec> k27_allList = new ArrayList<>();
        ArrayList<k27_Biz_07_09_OneRec> k27_pageList = new ArrayList<>();
        // [데이터 생성]
        k27_dataset();
        int k27_flag = 0;
        int lastPageNum = 0;

        // k27_iPerson이 k27_pageNum에 완전히 나눠지는지를 본다.
        // 나눠지지 않아서 나머지 페이지가 있으면 해당 부분에 대한 처리를 해준다
        // 그렇지 않으면 그런 처리를 빼고 일반 처리를 해준다.
        if (k27_iPerson % k27_pageNum != 0) {
            // for문에서 별개로 더해지는 k27_flag 변수
            // iPerson / pageNum + 1까지 범위를 주어 나머지를 제외한 목부분을 구해
            // 목 = 페이지 반복 회수를 설정한다.
            for (int k27_i = 0; k27_i < k27_iPerson / k27_pageNum + 1; k27_i++) {
                // [헤더 부분 인쇄]
                k27_HeaderPrint(k27_i);
                // 조건문에서는 pageNum의 단위가 걸치는 부분을 판별한다.
                // iPerson - flag가 pageNum보다 크거나 같으면 페이지 전체를 인쇄할 수 있는 조건이다.
                // 전체 페이지 인쇄 조건 분기문으로 걸린다.
                if (k27_iPerson - k27_flag >= k27_pageNum) {
                    // pageNum 단위로 for문을 반복한다. 항목이 pageNum 만큼 인쇄된다.
                    for (int k27_j = k27_flag; k27_j < k27_flag + k27_pageNum; k27_j++) {
                        // [내용 인쇄 부분]
                        k27_ItemPrint(k27_j);
                        k27_listInsert(k27_allList, k27_j);
                        // listInsert 메서드로 페이지 품목 정보를 담는 pageList에 데이터 삽입.
                        k27_listInsert(k27_pageList, k27_j);
                    }
                    // flag를 + pageNum만큼 증가시켜 다음 페이지로 넘어간다.
                    k27_flag = k27_flag + k27_pageNum;
                    // TailPrint 메서드에 k27_allList, pageList를 인수로 넣어서 연산 결과를 출력한다.
                    k27_TailPrint(k27_allList, k27_pageList);
                    // iPerson - flag가 pageNum보다 작으면 남아있는 부분이 한 페이지가 안 된다는 뜻이다.
                    // 이 경우 남아있는 부분만 출력해주는 분기문을 적용한다.
                } else {
                    // 시작 지점을 k27_flag - pageNum으로 설정한다. 이렇게 되면 위에서 다음 새 페이지로 넘기는 과정이 없어진다.
                    // 그리고 for문의 범위를 iPerson까지로 잡아서 남은 부분만큼만 프로그램이 작동할 수 있도록 한다.
                    for (int k27_j = k27_flag; k27_j < k27_iPerson; k27_j++) {
                        // [내용 인쇄 부분]
                        k27_ItemPrint(k27_j);
                        // listInsert 메서드로 전체 품목의 정보를 담는 allList에 데이터 삽입
                        k27_listInsert(k27_allList, k27_j);
                        // listInsert 메서드로 페이지 품목 정보를 담는 pageList에 데이터 삽입.
                        k27_listInsert(k27_pageList, k27_j);
                    }
                    // [테일 부분 인쇄] 인수로 allList와 pageList를 받는다.
                    k27_TailPrint(k27_allList, k27_pageList);
                }
            }
            // k27_iPerson이 k27_pageNum에 완전히 나눠지는 경우
            // 나머지 페이지가 없어서 일반 출력 부분에 대한 것만 고려한다.
        } else {
            // for문에서 별개로 더해지는 k27_flag 변수
            // iPerson / pageNum 까지 범위를 목부분을 구한다.
            // 목 = 페이지 반복 회수를 설정한다.
            // 나머지가 없기 때문에 나머지 고려없이 딱 해당 루프만 진행하면 된다.
            for (int k27_i = 0; k27_i < k27_iPerson / k27_pageNum; k27_i++) {
                // [헤더 부분 인쇄]
                k27_HeaderPrint(k27_i);
                // 조건문에서는 pageNum의 단위가 걸치는 부분을 판별한다.
                // iPerson - flag가 pageNum보다 크거나 같으면 페이지 전체를 인쇄할 수 있는 조건이다.
                // 전체 페이지 인쇄 조건 분기문으로 걸린다.
                // pageNum 단위로 for문을 반복한다. 항목이 pageNum 만큼 인쇄된다.
                for (int k27_j = k27_flag; k27_j < k27_flag + k27_pageNum; k27_j++) {
                    // [내용 인쇄 부분]
                    k27_ItemPrint(k27_j);
                    k27_listInsert(k27_allList, k27_j);
                    // listInsert 메서드로 페이지 품목 정보를 담는 pageList에 데이터 삽입.
                    k27_listInsert(k27_pageList, k27_j);
                }
                // flag를 + pageNum만큼 증가시켜 다음 페이지로 넘어간다.
                k27_flag = k27_flag + k27_pageNum;
                // TailPrint 메서드에 k27_allList, pageList를 인수로 넣어서 연산 결과를 출력한다.
                k27_TailPrint(k27_allList, k27_pageList);
                // iPerson - flag가 pageNum보다 작으면 남아있는 부분이 한 페이지가 안 된다는 뜻이다.
                // 이 경우 남아있는 부분만 출력해주는 분기문을 적용한다.
            }
        }
    }

    // 학생들 과목 정보를 만드는 OneRec 클래스 추가
    public static class k27_Biz_07_09_OneRec {
        // id, 이름, 국어, 영어, 수학,
        private int k27_student_id;
        private String k27_name;
        private int k27_kor;
        private int k27_eng;
        private int k27_mat;

        // 생성자에서 모든 필드에 대해서 선언
        public k27_Biz_07_09_OneRec(int k27_student_id, String name, int kor, int eng, int mat) {
            this.k27_student_id = k27_student_id;
            this.k27_name = name;
            this.k27_kor = kor;
            this.k27_eng = eng;
            this.k27_mat = mat;
        }

        // private 필드에 대해서 getter 설정
        public int student_id() {
            return this.k27_student_id;
        }

        public String name() {
            return this.k27_name;
        }

        public int kor() {
            return this.k27_kor;
        }

        public int eng() {
            return this.k27_eng;
        }

        public int mat() {
            return this.k27_mat;
        }

        // 합계를 구하는 sum 메서드 정의
        // kor, eng, mat 필드의 합계를 더해서 return 한다
        public int sum() {
            return this.k27_kor + this.k27_eng + this.k27_mat;
        }

        // 평균을 구하는 age 메서드 정의
        // sun() / 3.0 하여 double 형으로 return 한다.
        public double ave() {
            return this.sum() / 3.0;
        }
    }
}
