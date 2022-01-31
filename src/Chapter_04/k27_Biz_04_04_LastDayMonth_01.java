package Chapter_04;

public class k27_Biz_04_04_LastDayMonth_01 {
    public static void main(String[] args) {
        // 2중 for문을 구성하여 달력의 행렬을 구성한다.
        // 첫 번째 for문(행)으로 최대 월인 1 ~ 12월까지 회수를 반복 실행되게 한다. (1월 ~ 12월)
        // 두 번째 for문(열)으로 최대 일수인 1 ~ 31일까지 반복 실행되게 한다. (1일 ~ 31일)
        for (int k27_i = 1; k27_i < 13; k27_i++) {
            // 첫 번째 for문(행)에서 k27_i 증가로 1 ~ 12월까지 출력.
            System.out.printf(" %d월 => ", k27_i);
            // 두 번째 for문(열)에서 k27_j 31까지 증가시켜서 31번 반복.
            for (int k27_j = 1; k27_j < 32; k27_j++) {
                // 1월일 때 날짜가 31이 아님을 처리
                if (k27_i == 1 && k27_j != 31) {
                    // k27_j가 30까지 증가하면서 k27_j를 컴마와 함께 출력.
                    System.out.printf("%d, ", k27_j);
                } else if (k27_i == 1 && k27_j == 31) {
                    // k27_j가 31이 되면 k27_j를 출력하고 개행함.
                    System.out.printf("%d", k27_j);
                    // 해당 월을 처리했으면 첫 번째 for문(열) 탈출
                    break;
                }
                // 2월일 때 날짜가 28이 아님을 처리
                if (k27_i == 2 && k27_j != 28) {
                    // k27_j가 27까지 증가하면서 k27_j를 컴마와 함께 출력.
                    System.out.printf("%d, ", k27_j);
                } else if (k27_i == 2 && k27_j == 28) {
                    // k27_j가 28이 되면 k27_j를 출력하고 개행함.
                    System.out.printf("%d", k27_j);
                    // 해당 월을 처리했으면 첫 번째 for문(열) 탈출
                    break;
                }

                // 3월일 때 날짜가 31이 아님을 처리
                if (k27_i == 3 && k27_j != 31) {
                    // k27_j가 30까지 증가하면서 k27_j를 컴마와 함께 출력.
                    System.out.printf("%d, ", k27_j);
                } else if (k27_i == 3 && k27_j == 31) {
                    // k27_j가 31이 되면 k27_j를 출력하고 개행함.
                    System.out.printf("%d", k27_j);
                    // 해당 월을 처리했으면 첫 번째 for문(열) 탈출
                    break;
                }

                // 4월일 때 날짜가 30이 아님을 처리
                if (k27_i == 4 && k27_j != 30) {
                    // k27_j가 29까지 증가하면서 k27_j를 컴마와 함께 출력.
                    System.out.printf("%d, ", k27_j);
                } else if (k27_i == 4 && k27_j == 30) {
                    // k27_j가 30이 되면 k27_j를 출력하고 개행함.
                    System.out.printf("%d", k27_j);
                    // 해당 월을 처리했으면 첫 번째 for문(열) 탈출
                    break;
                }

                // 5월일 때 날짜가 31이 아님을 처리
                if (k27_i == 5 && k27_j != 31) {
                    // k27_j가 30까지 증가하면서 k27_j를 컴마와 함께 출력.
                    System.out.printf("%d, ", k27_j);
                } else if (k27_i == 5 && k27_j == 31) {
                    // k27_j가 31이 되면 k27_j를 출력하고 개행함.
                    System.out.printf("%d", k27_j);
                    // 해당 월을 처리했으면 첫 번째 for문(열) 탈출
                    break;
                }

                // 6월일 때 날짜가 30이 아님을 처리
                if (k27_i == 6 && k27_j != 30) {
                    // k27_j가 29까지 증가하면서 k27_j를 컴마와 함께 출력.
                    System.out.printf("%d, ", k27_j);
                } else if (k27_i == 6 && k27_j == 30) {
                    // k27_j가 30이 되면 k27_j를 출력하고 개행함.
                    System.out.printf("%d", k27_j);
                    // 해당 월을 처리했으면 첫 번째 for문(열) 탈출
                    break;
                }

                // 7월일 때 날짜가 31이 아님을 처리
                if (k27_i == 7 && k27_j != 31) {
                    // k27_j가 30까지 증가하면서 k27_j를 컴마와 함께 출력.
                    System.out.printf("%d, ", k27_j);
                } else if (k27_i == 7 && k27_j == 31) {
                    // k27_j가 31이 되면 k27_j를 출력하고 개행함.
                    System.out.printf("%d", k27_j);
                    // 해당 월을 처리했으면 첫 번째 for문(열) 탈출
                    break;
                }

                // 8월일 때 날짜가 31이 아님을 처리
                if (k27_i == 8 && k27_j != 31) {
                    // k27_j가 30까지 증가하면서 k27_j를 컴마와 함께 출력.
                    System.out.printf("%d, ", k27_j);
                } else if (k27_i == 8 && k27_j == 31) {
                    // k27_j가 31이 되면 k27_j를 출력하고 개행함.
                    System.out.printf("%d", k27_j);
                    // 해당 월을 처리했으면 첫 번째 for문(열) 탈출
                    break;
                }

                // 9월일 때 날짜가 30이 아님을 처리
                if (k27_i == 9 && k27_j != 30) {
                    // k27_j가 29까지 증가하면서 k27_j를 컴마와 함께 출력.
                    System.out.printf("%d, ", k27_j);
                } else if (k27_i == 9 && k27_j == 30) {
                    // k27_j가 30이 되면 k27_j를 출력하고 개행함.
                    System.out.printf("%d", k27_j);
                    // 해당 월을 처리했으면 첫 번째 for문(열) 탈출
                    break;
                }

                // 10월일 때 날짜가 31이 아님을 처리
                if (k27_i == 10 && k27_j != 31) {
                    // k27_j가 30까지 증가하면서 k27_j를 컴마와 함께 출력.
                    System.out.printf("%d, ", k27_j);
                } else if (k27_i == 10 && k27_j == 31) {
                    // k27_j가 31이 되면 k27_j를 출력하고 개행함.
                    System.out.printf("%d", k27_j);
                    // 해당 월을 처리했으면 첫 번째 for문(열) 탈출
                    break;
                }

                // 11월일 때 날짜가 30이 아님을 처리
                if (k27_i == 11 && k27_j != 30) {
                    // k27_j가 29까지 증가하면서 k27_j를 컴마와 함께 출력.
                    System.out.printf("%d, ", k27_j);
                    // k27_j가 30이 되면 k27_j를 출력하고 개행함.
                } else if (k27_i == 11 && k27_j == 30) {
                    System.out.printf("%d", k27_j);
                    // 해당 월을 처리했으면 첫 번째 for문(열) 탈출
                    break;
                }

                // 12월일 때 날짜가 31이 아님을 처리
                if (k27_i == 12 && k27_j != 31) {
                    // k27_j가 30까지 증가하면서 k27_j를 컴마와 함께 출력.
                    System.out.printf("%d, ", k27_j);
                } else if (k27_i == 12 && k27_j == 31) {
                    // k27_j가 31이 되면 k27_j를 출력하고 개행함.
                    System.out.printf("%d", k27_j);
                    break;
                } // 마지막 "일"에 콤마를 빼기위해..

            }
            System.out.printf("\n");
        }
    }
}