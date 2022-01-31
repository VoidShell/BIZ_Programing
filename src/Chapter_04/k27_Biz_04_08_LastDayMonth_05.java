package Chapter_04;

public class k27_Biz_04_08_LastDayMonth_05 {
    public static void main(String[] args) {
        // 달력 각 월의 마지막 일은 비정형 데이터이다. 비정형 비교를 위해서는 그냥 값을 다 넣는 방식들이 좋다.
        // k27_iLMD 배열에 1월 ~ 12월까지 각 마지막일을 초기화한다.
        int[] k27_iLMD = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // 2중 for문을 구성하여 달력의 행렬을 구성한다.
        // 첫 번째 for문(행)으로 k27_iLMD배열의 길이만큼 회수를 반복 실행되게 한다. (1월 ~ 12월)
        // 두 번째 for문(열)으로 최대 일수인 1 ~ 31일까지 반복 실행되게 한다. (1일 ~ 31일)
        for (int k27_i = 0; k27_i < k27_iLMD.length; k27_i++) {
            // 첫 번째 for문에서는 몇 월인지를 출력한다.
            // 행: k27_i가 0부터 시작하기 때문에 출력 형식에서 k27_i + 1을 한다.
            System.out.printf(" %d월 => ", k27_i + 1);
            for (int k27_j = 1; k27_j < 32; k27_j++) {
                // 열: k27_j는 1부터 시작하고 31까지 반복하고 k27_j를 일자로 출력한다.
                System.out.printf("%d", k27_j);
                // 각월의 마지막 일을 k27_iLMD 배열에 저장해놓았기 때문에 마지막 판별을 하는 구문
                if (k27_iLMD[k27_i] == k27_j) {
                    // 마지막 판별이 true이면 break으로 반복문 탈출한다.
                    break;
                }
                // 마지막 판별 구문 이후에 컴마를 사용해서 마지막 날짜 이후에 컴마가 출력 안 되게 한다.
                System.out.printf(", ");
            }
            // 두 번째 for문(열)이 끝나면 개행을 해서 월을 구분한다.
            System.out.printf("\n");
        }
    }
}
