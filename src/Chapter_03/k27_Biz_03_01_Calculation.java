package Chapter_03;

public class k27_Biz_03_01_Calculation {
    public static void main(String[] args) {
        // #1. 연산후대입
        // 연산을 위한 int k27_ii 변수 선언
        int k27_ii;
        // k27_ii 변수에 1 + 2 의 연산결과 대입.
        k27_ii = 1 + 2;
        // 변수에 저장된 연산 결과 #1-1에 출력: 3
        System.out.printf("#1-1 : %d\n", k27_ii);
        // k27_ii 변수에 1 + 2 * 3 연산 결과 대입. 곱셉이 우선순위로 계산된다.
        k27_ii = 1 + 2 * 3;
        // 변수에 저장된 연산 결과 #1-2에 출력: 7
        System.out.printf("#1-2 : %d\n", k27_ii);


        // #2. 누적하기, 합 구하기
        // k27_sum 변수 대입
        int k27_sum;
        // 누적 변수는 Loop 바깥에서 초기화
        k27_sum = 0;

        // k27_sum 변수에 for문의 증감변수 k27_i이 값이 +
        // ++로 증가 for문이기 때문에 1을 100번 대입
        for (int k27_i = 1; k27_i < 101; k27_i++) {
            k27_sum = k27_sum + k27_i;
        }
        // Loop 결과로 계산된 k27_sum 합계 출력
        System.out.printf("#2 : %d\n", k27_sum);
        // k27_sum을 100으로 나눈 평균값 출력
        System.out.printf("#2-2 : %d\n", k27_sum / 100);

        // int 타입 배열 선언 및 1, 2, 3, 4, 5로 초기화
        int[] k27_v = {1, 2, 3, 4, 5};
        // k27_vSum 배열합 변수 선언
        int k27_vSum;
        // k27_vSum 배열합 변수 0으로 초기화
        k27_vSum = 0;

        // for문을 5회로 설정. 배열의 길이 5
        for (int k27_i = 0; k27_i < 5; k27_i++) {
            // k27_vSum 변수에 배열의 각요소가 for문 돌때마다 더해짐.
            k27_vSum = k27_vSum + k27_v[k27_i];
        }
        // 배열의 합이 더해진 k27_vSum 변수 선언
        System.out.printf("#2-3 : %d\n", k27_vSum);


        // #3. 정수형 변수의 나눗셈은 정수범위에서 버림처리
        // 나눗셈 결과 저장을 위한 임시 int형 변수
        // 목을 계산할 때. int 형이라 소수점 출력 안 된다.
        k27_ii = 1000 / 3;
        System.out.printf("#3-1 : %d\n", k27_ii);
        // 나머지를 계산할 때. 이때는 제대로 출력
        k27_ii = 1000 % 3;
        System.out.printf("#3-2 : %d\n", k27_ii);
        // 나머지 연산의 응용
        for (int k27_i = 0; k27_i < 20; k27_i++) {
            System.out.printf("#3-3 : %d  ", k27_i);
            // k27_i에 1더해주는 건 1부터 처리하는 것처럼 보이려고
            // 20까지 루프를 반복해주니 나머지가 0일 경우는 다섯번 마다 나온다. 네번 출력
            if (((k27_i + 1) % 5) == 0) {
                System.out.printf("\n");
            }
        }


        // #4. 원하는 자릿수 반올림, 버림 처리 */
        k27_ii = 12345;
        // 10으로 나누면 10원 이하가 버림되고 다시 10을 곱하면 원본이 됨.
        int k27_j = (k27_ii / 10) * 10;
        System.out.printf("#4-1 : %d\n", k27_j);

        k27_ii = 12345;
        // 5를 더해서 반올림의 효과를 만든다. 버림되고 다시 10을 곱하면 올림효과 완성.
        k27_j = ((k27_ii + 5) / 10) * 10;
        System.out.printf("#4-2 : %d\n", k27_j);
        // 맨 끝짜리가 4라 올림 효과가 없어지고 내림이 되어버린다. 결과적으로 반올림.
        k27_ii = 12344;
        k27_j = ((k27_ii + 5) / 10) * 10;
        System.out.printf("#4-2 : %d\n", k27_j);


        // #5. 소수점 이하에서는 어떻게 할까?
        // 이 값은 2.8이다.
        int k27_MyVal = 14 / 5;
        // 그냥 넣으면 버림, 0.5를 더한 다음 정수형 형변환 하면 반올림 처리됨. #4번 문제와 같은 원리.
        System.out.printf("#5-1 : %d\n", k27_MyVal);

        // 연산 결과를 저장하는 double 형 k27_MyValF 변수 선언.
        double k27_MyValF;

        // 이 값은 정수끼리 연산이라 정수로 결과 나옴.
        k27_MyValF = 14 / 5;
        System.out.printf("#5-2 : %f\n", k27_MyValF);

        // 한 개라도 실수면 실수 값이 나온다
        k27_MyValF = 14.0 / 5;
        System.out.printf("#5-3 : %f\n", k27_MyValF);

        // 실수 상태에서 0.5를 더하면 그냥 덧셈이 될 뿐 다른 처리는 되지 않는다
        k27_MyValF = (14.0) / 5 + 0.5;
        System.out.printf("#5-4 : %f\n", k27_MyValF);

        // 실수 상황에서 0.5를 더하고 이를 정수형으로 바꾸면 반올림 효과가 있다.
        // 교안에서 %d라고 되어있지만 에러난다.
        k27_MyValF = ((14.0) / 5 + 0.5);
        System.out.printf("#5-5 : %f\n", k27_MyValF);
    }
}
