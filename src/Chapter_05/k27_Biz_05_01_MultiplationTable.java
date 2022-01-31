package Chapter_05;

public class k27_Biz_05_01_MultiplationTable {
    public static void main(String[] args) {
        int k27_danNum = 1;
        for (int k27_i = k27_danNum; k27_i < k27_danNum + 1; k27_i++) {
            // 구구단을 3단 단위로 출력하기 위해 3개 배치
            // 해당 for문은 단순 반복만을 위한 for문이다.
            System.out.printf("***************\t***************\t***************\n");
            System.out.printf(" 구구단 %d 단\t 구구단 %d 단\t 구구단 %d 단\n", k27_danNum, k27_danNum + 1, k27_danNum + 2);
            System.out.printf("***************\t***************\t***************\n");
            // 탭으로 구분된 항목에서 첫 번째 이중 for문의 변수가 1, 2, 3단을 출력한다.
            // 두 번째 이중 for문은 각 각 단수별로 1부터 9까지 순차적으로 곱해준다.
            for (int k27_j = 1; k27_j < 10; k27_j++) {
                System.out.printf(" %d * %d = %2d\t\t %d * %d = %2d\t\t %d * %d = %2d\n",
                        k27_danNum, k27_j, k27_danNum * k27_j, k27_danNum + 1, k27_j,
                        (k27_danNum + 1) * k27_j, k27_danNum + 2, k27_j, (k27_danNum + 2) * k27_j);
            }
            // 한번에 3단씩 출력되기 때문에 3을 더해준다.
            k27_danNum = k27_danNum + 3;
            // 7, 8, 9 마지막 Loop때 danNum은 7이고 마지막 +3이 더해지면 10이 되고 Loop가 종료된다.
            if (k27_danNum > 7) {
                break;
            }
        }
    }
}