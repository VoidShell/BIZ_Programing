package Chapter_05_Receipt_03;

public class Main {
    public static void main(String[] args) {
        int c = 2200;
        // 부동 소수점 연산 발생: 소수점이 변수에 직접 나눠지는 경우
        System.out.println(c / 1.1);
        System.out.println(c / (11.0 / 10));

        // 부동 소수점 연산 미발생: 수식을 조작하여 소수점이 변수에 나눠지지 않게 함.
        System.out.println(c * 10 / 11.0);
        System.out.println(c / 11.0 * 10);

        String[] test = {"123", "455", "1234"};
        System.out.println(test.length);
    }
}