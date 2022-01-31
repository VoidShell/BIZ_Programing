package Chapter_04;

public class k27_Biz_04_02_NumberVersus {
    public static void main(String[] args) {
        // 계산 결과 저장을 위한 int 변수 선언
        int k27_iI;
        // 계산 결과 저장을 위한 double 변수 선언
        double k27_iD;

        // int 형 변수에 저장되기 때문에  목만 저장된다. (버림)
        k27_iI = 10 / 3;
        // 3.0으로 나눠주면 자동으로 형변화 일어나고 k27_iD가 double형 이기 때문에 double로 저장된다.
        k27_iD = 10 / 3.0;

        // k27_iI == k27_iD 만족하면 equal을 출력.
        if (k27_iI == k27_iD) {
            System.out.printf("equal\n");
            // 그렇지 않으면 Not equal 출력하고 k27_iI을 double 형 변환하여 출력.
        } else {
            // 서식지정자 %f는 double 출력.
            // 3.00000과 3.333333.. 은 같지 않다.
            System.out.printf("Not equal[%f][%f]\n", (double) k27_iI, k27_iD);
        }
        // k27_iD가 3.333333과 같으면 equal 출력
        if (k27_iD == 3.333333) {
            System.out.printf("equal\n");
            // 그렇지 않으면 Not equal 출력
        } else {
            // k27_iD = 10 / 3.0의 결과는 3.3333333333333333.....
            System.out.printf("Not equal[3.333333][%f]\n", k27_iD);
        }
        // k27_iD를 int로 형변환하고 다시 double에 저장
        // int로 형변환하면 소수점이 내림 된다.
        k27_iD = (int) k27_iD;
        // k27_iI == k27_iD 조건 만족하면 eqaul 출력
        // 소수점을 버렸기 때문에 같은 값이 돼서 equal 출력된다.
        if (k27_iI == k27_iD) {
            System.out.printf("equal\n");
            // 그렇지 않으면  k27_iD을 double로 형변환한 값과 k27_iD 출력.
        } else {
            System.out.printf("Not equal[%f][%f]", (double) k27_iI, k27_iD);
        }

        // 같은 값이지만 정수형 출력이 어떤 차이가 있는지 보여준다.
        System.out.printf("int로 인쇄[%d][%f]\n", k27_iI, k27_iD);
        // 같은 값이지만 실수형 출력이 어떤 차이가 있는지 보여준다.
        System.out.printf("double로 인쇄[%f][%f]\n", (double) k27_iI, k27_iD);
        // 정수형 변수를 double로 형변환 하면 어떻게 돼는지 실수형 변수와 비교하기 위한 출력을 한다

        // char형 k27_a 변수에 문자형 c를 초기화.
        char k27_a = 'c';

        // k27_a == 'b' 라면
        if (k27_a == 'b') {
            // k27_a와 b가 같다고 출력.
            System.out.printf("k27_a는 b이다\n");
        }
        // k27_a == 'c' 라면
        if (k27_a == 'c') {
            // k27_a와 c가 같다고 출력.(O)
            System.out.printf("k27_a는 c이다\n");
        }
        // k27_a == 'd' 라면
        if (k27_a == 'd') {
            // k27_a와 d가 같다고 출력.
            System.out.printf("k27_a는 d이다\n");
        }

        // String 변수 k27_aa에 문자열 abcd 초기화
        String k27_aa = "abcd";

        // k27_aa변수가 abcd와 같다면
        // 문자열의 비교는 equals 메서드 사용한다.
        if (k27_aa.equals("abcd")) {
            // k27_aa와 abcd가 같다고 출력(O)
            System.out.printf("k27_aa는 abcd이다\n");
            // k27_aa와 abcd가 다르다고 출력.
        } else {
            System.out.printf("k27_aa는 abcd이 아니다\n");
        }

        // boolean 변수 k27_bb에 true 초기화.
        boolean k27_bb = true;

        // '!!' 부정이면 다시 부정 두개가 붙어서 다시 true가 된다.
        // if(true)와 같아짐
        if (!!k27_bb) {
            // bb가 아니고 아니면 참이다 출력(O)
            System.out.printf("bb가 아니고 아니면 참이다\n");
        } else {
            // bb가 아니고 아니면 거짓이다 출력 안 됨.
            System.out.println("bb가 아니고 아니면 거짓이다\n");
        }
    }
}
