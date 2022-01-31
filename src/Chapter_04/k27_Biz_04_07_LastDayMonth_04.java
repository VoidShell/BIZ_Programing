package Chapter_04;

public class k27_Biz_04_07_LastDayMonth_04 {
    public static void main(String[] args) {
        // 2중 for문을 구성하여 달력의 행렬을 구성한다.
        // 첫 번째 for문(행)으로 최대 월인 1 ~ 12월까지 회수를 반복 실행되게 한다. (1월 ~ 12월)
        // 두 번째 for문(열)으로 최대 일수인 1 ~ 31일까지 반복 실행되게 한다. (1일 ~ 31일)
        for (int k27_i = 1; k27_i < 13; k27_i++) {
            System.out.printf(" %d월 =>", k27_i);
            // 두번 째 for문(열)으로 최대 일수인 1 ~ 31일까지 반복 실행되게 한다. (1월 ~ 31일)
            LOOP: for (int k27_j = 1; k27_j < 32; k27_j++) {
                // switch 문에서 k27_i을 case문을 통해 월로 판별한다.
                switch (k27_i) {
                    case 4:
                    case 6:
                    case 9:
                    case 11: // 4, 6, 9, 11월은 30일 공통이기 때문에 묶는다.
                        if (k27_j != 30) {
                            // 계속 증가하는 k27_j가 30전까지 k27_j를 컴마와 함께 출력
                            System.out.printf("%d, ", k27_j);
                        } else {
                            // 계속 증가하는 k27_j가 30이 되면 개행과 출력하고 개행한다(\n)
                            System.out.printf("%d\n", k27_j);
                            // 이후 break 하고 LOOP으로 이동하여 이중 for문 계속 수행한다.
                            break LOOP;
                        }
                        // 스위치 문 종료. 한번 case에 걸리면 다른 case로는 이동하지 않는다. (중복 조건 없음)
                        break;
                    case 1:
                    case 3:
                    case 5:
                    case 7:
                    case 8:
                    case 10:
                    case 12:
                        // 1, 3, 5, 7, 8, 10, 11월은 31일까지이기 때문에 공통으로 묶는다.
                        if (k27_j != 31) {
                            System.out.printf("%d, ", k27_j);
                            // 계속 증가하는 k27_j가 31전까지 k27_j를 컴마와 함께 출력
                        } else {
                            System.out.printf("%d\n", k27_j);
                            // 계속 증가하는 k27_j가 31이 되면 개행과 출력하고 개행한다(\n)
                            // 이후 break 하고 LOOP으로 이동하여 이중 for문 계속 수행한다.
                            break LOOP;
                        }
                        // 스위치 문 종료. 한번 case에 걸리면 다른 case로는 이동하지 않는다. (중복 조건 없음)
                        break;
                    case 2: // 28일만 있는 2월은 따로 분류한다.
                        if (k27_j != 28) {
                            // 계속 증가하는 k27_j가 28전까지 k27_j를 컴마와 함께 출력
                            System.out.printf("%d, ", k27_j);
                        } else {
                            // 계속 증가하는 k27_j가 31이 되면 개행과 출력하고 개행한다(\n)
                            System.out.printf("%d\n", k27_j);
                            // 이후 break 하고 LOOP으로 이동하여 이중 for문 계속 수행한다.
                            break LOOP;
                        }
                        // 스위치 문 종료. 한번 case에 걸리면 다른 case로는 이동하지 않는다. (중복 조건 없음)
                        break;
                }
            }
        }
    }
}