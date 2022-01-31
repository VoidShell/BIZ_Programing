package Chapter_05;

import java.util.Calendar;

public class k27_Biz_05_02_Calendar {
    public static void main(String[] args) {
        // Calendar 객체 k27_calendar 생성
        Calendar k27_calendar = Calendar.getInstance();
        // 2020년 1월 1일 설정.
        k27_calendar.set(2020, 0, 1);

        // weeks k27_weeks 배열에 요일 String을 저장한다.
        String[] k27_weeks = {"일", "월", "화", "수", "목", "금", "토"};
        // 12월까지 달력을 출력해야하기 때문에 이중 for문으로
        // 1차 for문에는 월 길이, 2차 for문에는 일자 길이를 입력한다.
        for (int k27_i = 1; k27_i < 13; k27_i++) {
            // 월 표시가 k27_i 변수에 의해 바뀐다.
            System.out.printf("\n         %d월         \n", k27_i);
            System.out.printf("=====================\n");
            // 요일의 표시, 요일 순서는 Calendar.요일 상수로 번호를 불러온다.
            System.out.printf(" %s%2s%2s%2s%2s%2s%2s\n",
                    k27_weeks[Calendar.SUNDAY - 1], k27_weeks[Calendar.MONDAY - 1], k27_weeks[Calendar.TUESDAY - 1],
                    k27_weeks[Calendar.WEDNESDAY - 1], k27_weeks[Calendar.THURSDAY - 1],
                    k27_weeks[Calendar.FRIDAY - 1], k27_weeks[Calendar.SATURDAY - 1]);
            // getActualMaximum(Calendar.DAY_OF_MONTH) 메소드로 현재 월의 마지막 날짜를 구하여 리턴한다.
            // 해당 길이만큼 for문이 반복한다.
            for (int k27_j = 1; k27_j < k27_calendar.getActualMaximum(Calendar.DAY_OF_MONTH) + 1; k27_j++) {
                // 현재 날짜가 1일이라면
                if (k27_calendar.get(Calendar.DATE) == 1) {
                    // k27_calendar.get(Calendar.DAY_OF_WEEK)은 현재 요일 순번을 반환한다.
                    // 해당 요일 직전까지 반복하여 공백을 넣어준다.
                    for (int k27_k = 1; k27_k < k27_calendar.get(Calendar.DAY_OF_WEEK); k27_k++) {
                        System.out.printf(" %2s", "  ");
                    }
                    // 해당 루프가 직전까지 끝나고 해당 일을 정확한 요일 위치에 써준다.
                    System.out.printf(" %2d", k27_calendar.get(Calendar.DATE));
                    // 현재 날짜가 토요일이라면 개행을 해준다.
                    if (k27_calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
                        System.out.printf("\n");
                    }
                }
                // 날짜를 출력해주고 Calendar의 실제 날짜를 더해준다.
                k27_calendar.add(Calendar.DATE, 1);
                // 더해준 날짜만큼 다시 출력을 해준다.
                System.out.printf(" %2d", k27_calendar.get(Calendar.DATE));
                // 만약 요일이 토요일이라면 개행을 해준다.
                if (k27_calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
                    System.out.printf("\n");
                }
                // 현재 날짜가 해당 월의 getActualMaximum(Calendar.DAY_OF_MONTH)(최대날짜)에 도달하면 개행하고 루프를 멈춘다.
                if (k27_calendar.get(Calendar.DATE) == k27_calendar.getActualMaximum(Calendar.DAY_OF_MONTH)) {
                    System.out.printf("\n");
                    // 날짜를 더해주지 않으면 루프가 멈추기 전 날짜에 있기 때문에 날짜를 하루 더해준다.
                    k27_calendar.add(Calendar.DATE, 1);
                    break;
                }
            }
        }
    }
}
