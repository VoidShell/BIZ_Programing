package Chapter_04;

public class k27_Biz_04_12_SinGraph {
    public static void main(String[] args) {
        double k27_fSin;
        // 1도 단위로 출력하는 for 문
        for (int k27_i = 0; k27_i < 360; k27_i++) {
            // 3.141592 / 180 = 1라디안
            // Math.sin에서 sin 함수를 사용하기 위한 공식
            // 인수로 Radian을 받기 때문에 라디안을 계산한다.
            // (파이 * 각도) / 180이 입력 공식
            // 1도가 몇 라디안인지 계산
            // for문이 360도, 즉 호도법으로 주기를 고려하고 있기 때문에
            // 1도가 몇라디안인지 계산하고 이를 Math.sin의 인수로 넣어준다.
            k27_fSin = Math.sin(k27_i * Math.PI / 180);
            k27_fSin = Math.sin(Math.toRadians(k27_i));
            // Math.sin의 반환값 fSin의 값 출력
            System.out.printf("%d sin ==> %f\n", k27_i, k27_fSin);
        }

        // 1도 단위로 출력하는 for문
        for (int k27_i = 0; k27_i < 360; k27_i++) {
            // 3.141592 / 180 = 1도는 몇 라디안인지
            // Math.sin에서 sin 함수를 사용하기 위한 공식
            // 파라미터가 Radian이다
            // (파이 * 각도) / 180이 입력 공식
            // 1도가 몇 라디안인지 계산
            // k27_fSin = Math.sin(k27_i * Math.PI / 180);
            // 1도가 몇 라디안인지 계산해주는 함수. Math.toRadians()
            k27_fSin = Math.sin(Math.toRadians(k27_i));

            // Sin의 범위 -1 ~ 1
            // 여기에 1.0을 더하면 절편이동하여 0 ~ 2가 된다.
            // 여기에 50을 곱하면 0 ~ 100까지 표현 가능하다. (보다 거대한 그래프로 효현 가능)
            // k27_iSpace 변수는 위에서 표현했던 k27_fSin 변수를 정수형 범위에서 거대하게 확장한다.
            int k27_iSpace = (int) ((1.0 - k27_fSin) * 50);
            // 이중 for문으로
            // 첫 번째 for문 행: 360줄까지를 출력 (360도니까 sin의 주기인 2파이를 모두 출력한다.
            // 두 번째 for문 열: sin 함수의 파동을 표현
            // fSin이 원본이고 여기에 iSpace로 범위 확장하여 표현
            for (int k27_j = 0; k27_j < k27_iSpace; k27_j++) {
                // k27_j < k27_iSpace 조건으로 띄어쓰기가 k27_iSpace 만큼 된다.
                // fSin은 첫 번째 for문에 의해 유동적인 값이라 k27_fSin -> k27_iSpace 역시 유동적으로 값 변화
                System.out.printf(" ");
            }
            // 각 행마다 k27_fSin, k27_iSpace 값 출력 됨.
            System.out.printf("*[%f][%d]\n", k27_fSin, k27_iSpace);
        }
    }
}
