package Chapter_04;

public class k27_Biz_04_13_Pyramid {
    public static void main(String[] args) {
        // 별을 피라미드로 찍기 위해 행열에 대한 변수 설정
        // 행열 출력을 위한 2중 for문에서 행과 열의 숫자를 초기에 설정한다
        // 초기 행 k27_m = 20 (줄)
        // 초기 열 k27_n = 1 (칸)
        // 이 숫자들은 마지막 계산에 의해 늘거나 줄어든다.
        int k27_n, k27_m;
        k27_m = 20;
        k27_n = 1;

        // do - while 조건에 해당하는 부분을 반복한다. k27_m >= 0 조건 만족할 때 무한 반복
        // 첫 번째 for 구문은 띄어쓰기(빈공간)를 찍는다.
        do {
            for (int i = 0; i < k27_m; i++) {
                System.out.print(" ");
            }
            // 두 번째 for 구문은 별을 찍는다.
            for (int i = 0; i < k27_n; i++) {
                System.out.print("*");
            }
            System.out.print("\n");
            // 루프를 반복할 때마다 m(띄어쓰기)는 줄어들고
            // n(별)은 2씩 증가.
            k27_m = k27_m - 1;
            k27_n = k27_n + 2;
        // k27_m이 만족할때 계속 Loop 실행한다.
        } while (k27_m >= 0);
    }
}
