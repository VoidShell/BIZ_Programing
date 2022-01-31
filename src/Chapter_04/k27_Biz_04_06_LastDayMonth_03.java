package Chapter_04;

public class k27_Biz_04_06_LastDayMonth_03 {
    public static void main(String[] args) {
        // 2중 for문을 구성하여 달력의 행렬을 구성한다.
        // 첫 번째 for문(행)으로 최대 월인 1 ~ 12월까지 회수를 반복 실행되게 한다. (1월 ~ 12월)
        // 두 번째 for문(열)으로 최대 일수인 1 ~ 31일까지 반복 실행되게 한다. (1일 ~ 31일)
        for (int k27_i = 1; k27_i < 13; k27_i++) {
            // 첫 번째 for문(행)에서 k27_i 증가로 1 ~ 12월까지 출력.
            System.out.printf(" %d월 ==>", k27_i);
            // 두 번째 for문(열)에서 k27_j 31까지 증가시켜서 31번 반복.
            for (int k27_j = 1; k27_j < 32; k27_j++) {
                // if ||(or)로 4, 6, 9, 11월을 30일 조건으로 묶는다.
                if (k27_i == 4 || k27_i == 6 || k27_i == 9 || k27_i == 11) {
                    // k27_j를 30전까지 검출 컴마와 함께 출력
                    if (k27_j != 30) {
                        System.out.printf("%d, ", k27_j);
                    } else {
                        // k27_j를 30이 되면 출력 이후 개행(\n)
                        System.out.printf("%d\n", k27_j);
                        // 그리고 break로 두 번째 for문 종료
                        break;
                    }
                    // if ||(or)로 1, 3, 5, 7, 8, 10, 12월까지 모아서 31일 조건으로 묶는다.
                } else if (k27_i == 1 || k27_i == 3 || k27_i == 5 || k27_i == 7 || k27_i == 8 || k27_i == 10
                        || k27_i == 12) {
                    if (k27_j != 31) {
                        // k27_j를 31전까지 검출 컴마와 함께 출력
                        System.out.printf("%d, ", k27_j);
                    } else {
                        // k27_j를 31이 되면 출력 이후 개행(\n)
                        System.out.printf("%d\n", k27_j);
                        // 그리고 break로 두 번째 for문 종료
                        break;
                    }
                    // 28일만 있는 2월은 따로 분류한다.
                } else {
                    // 남은 2월은 28일 까지만 있다.
                    if (k27_j != 28) {
                        // 계속 증가하는 k27_j가 28전까지 k27_j를 컴마와 함께 출력
                        System.out.printf("%d, ", k27_j);
                    } else {
                        // k27_j가 28일때 "%d\n"출력. 마지막 날이기때문에 개행을 한다
                        System.out.printf("%d\n", k27_j);
                        // 이후 break 하고 LOOP으로 이동하여 이중 for문 계속 수행한다.
                        break;
                    }
                }
            }
        }
    }
}
