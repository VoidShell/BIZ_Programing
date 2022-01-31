package Chapter_04;

public class k27_Biz_04_11_Spacing {
    public static void main(String[] args) {
        // 행렬 출력을 위한 이중 for문 설정
        // 첫 번째 for문 행
        // 두 번째 for문 열
        for (int k27_i = 0; k27_i < 10; k27_i++) {
            // 두 번째 for문의 마침 조건이 j < k27_i 반복 열의 반복회수가 점점 늘어남
            for (int k27_j = 0; k27_j < k27_i; k27_j++) {
                // 두 번째 for문의 반복 회수만큼 띄어쓰기가 결정 됨.
                System.out.printf(" ");
            }
            // 행 단위를 기록하는 첫 번째 for문에서 i를 출력한다.
            System.out.printf("%d\n", k27_i);
        }
    }
}