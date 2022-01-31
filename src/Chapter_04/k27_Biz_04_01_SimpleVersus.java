package Chapter_04;

public class k27_Biz_04_01_SimpleVersus {
    public static void main(String[] args) {
        // 정수형 변수 k27_iA, k27_iB 선언
        int k27_iA, k27_iB;
        // k27_iA는 0으로 초기화
        k27_iA = 0;
        // while을 통해 무한 반복(true)
        while (true) {
            // k27_iB 변수 0으로 초기화
            k27_iB = 0;
            // while을 통해 무한 반복(true)
            // while문을 두 번 중첩해서 썼기 때문에 이중 for문처럼 같은 기능을 하게 돼고
            // 행열의 형태로 출력이 가능하다.
            while (true) {
                // 매 루프마다 별을 출력
                System.out.printf("*");
                // 증감 변수인 k27_iA와 k27_iB가 같아질 때 break을 통해 루프를 탈출한다.
                if (k27_iA == k27_iB) {
                    break;
                }
                // 2차 while문의 증감 변수 k27_iB를 매 Loop 마다 1증가시킨다.
                k27_iB++;
            }
            // k27_iA와 k27_iB의 값이 같아지는 순간이 2차 while문이 정지할 때이다.
            // 이때 개행을 해주어 행렬의 형태로 출력되도록 한다.
            System.out.printf("\n");
            // 1차 while문이 실행 될 때 마다 k27_iA의 값이 1씩 증가
            k27_iA++;
            // k27_iA가 30이 되면 종료
            // 별이 30줄까지 출력된다.
            if (k27_iA == 30) {
                break;
            }
        }
    }
}
