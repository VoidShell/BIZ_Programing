package Chapter_05;

public class k27_Biz_05_01_MultiplationTable_2 {
    public static void main(String[] args) {
        int k27_danNum = 1;
        for (int k27_i = k27_danNum; k27_i < k27_danNum + 1; k27_i++) {
            // 구구단을 3단 단위로 출력하기 위해 3개 배치
            // 해당 for문은 단순 반복만을 위한 for문이다.
            System.out.printf("***************\t***************\t***************\n");
            System.out.printf(" 구구단 %d 단\t 구구단 %d 단\t 구구단 %d 단\n", k27_danNum, k27_danNum + 3, k27_danNum + 6);
            System.out.printf("***************\t***************\t***************\n");
            // 탭으로 구분된 항목에서 첫 번째 이중 for문의 변수가 1, 4, 7단을 출력한다.
            // 이를 위해 기존에 + 1 + 2가 아니라 + 3, + 6을 해준다.
            // 두 번째 이중 for문은 각 각 단수별로 1부터 9까지 순차적으로 곱해준다.
            for (int k27_j = 1; k27_j < 10; k27_j++) {
                System.out.printf(" %d * %d = %2d\t\t %d * %d = %2d\t\t %d * %d = %2d\n",
                        k27_danNum, k27_j, k27_danNum * k27_j, k27_danNum + 3, k27_j,
                        (k27_danNum + 3) * k27_j, k27_danNum + 6, k27_j, (k27_danNum + 6) * k27_j);
            }
            // 행이 바뀔때마다 k27_danNum이 1씩(단수) 증가해야하기 때문에 k27_danNum이다.
            k27_danNum = k27_danNum + 1;
            // k27_danNum이 3이상이면 break 종료한다.
            if (k27_danNum > 3) {
                break;
            }
        }
    }
}