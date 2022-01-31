package Chapter_04;

public class k27_Biz_04_03_Searching {
    public static void main(String[] args) {
        // 계산 결과가 저장 될 k27_iVal 변수 선언
        int k27_iVal;
        // for문을 300회 실행
        for (int k27_i = 0; k27_i < 300; k27_i++) {
            // for문의 증가 변수 k27_i에 5를 곱하고 k27_iVal 저장한다.
            // 5의 배수가 저장된다.
            k27_iVal = 5 * k27_i;

            // k27_iVal이 0보다 크거나 같고 10보다 작을 때
            if (0 <= k27_iVal && k27_iVal < 10) {
                // "일 k27_iVal" 출력한다.
                System.out.printf("일 %d\n", k27_iVal);
                // k27_iVal이 10보다 크거나 같고 100보다 작을 때
            } else if (10 <= k27_iVal && k27_iVal < 100) {
                // "십 27_iVal" 출력한다.
                System.out.printf("십 %d\n", k27_iVal);
                // k27_iVal이 100보다 크거나 같고 1000보다 작을 때
            } else if (100 <= k27_iVal && k27_iVal < 1000) {
                // "백 27_iVal" 출력한다.
                System.out.printf("백 %d\n", k27_iVal);
                // 그외 조건 은 "천 27_iVal"을 출력한다.
            } else {
                System.out.printf("천 %d\n", k27_iVal);
            }
        }
    }
}
