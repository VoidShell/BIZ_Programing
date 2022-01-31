package Chapter_04;

import java.text.DecimalFormat;

public class k27_Biz_04_14_Blanking {
    public static void main(String[] args) {
        // 칸 맞추기 실험을 위해 한글 String 변수와 숫자 혼종
        // 영문 숫자는 한 글자당 1byte, 한글은 2byte (한글은 멀티바이트 문자)
        // 영문 숫자는 한칸, 한글은 한 문자당 두 칸을 차지한다.
        String k27_item = "사과";
        int k27_unit_price = 5000;
        int k27_num = 500;
        int k27_total = 0;

        // DecimalFormat으로 1000단위 컴마 패턴 적용
        DecimalFormat k27_df = new DecimalFormat("###,###,###,###,###");

        // 헤더 찍기
        // 생각한 것과 출력한 것을 같게 출력하기 위해서 고정폭 폰트(monospacing font)를 사용한다.
        // 고정폭 폰트는 말 그대로 모든 문자의 폭이 일정한 것으로 숫자 영문(소문자, 대문자) 1길이
        // 한글은 2길이를 차지한다.
        // 하지만 IDE에서 고정폭 폰트라고 알려진 폰트중에서 대부분은 한글을 지원하지 않아
        // 한글 폰트중에서 고정폭 폰트를 사용해야 하며 굴림체, 돋움체, 바탕체, 궁서체가 고정폭 길이를 지원한다.
        // 한국에서 만들어진 IDE용 고정폭 폰트인 D2 Coding 폰트 역시 고정폭 길이를 지원한다.
        // 그래서 여기서는 D2 Coding 폰트를 사용한다.
        // 고정폭 길이 확인을 위한 테스트 코드이다.
        // 영문은 대소문자 8글자, 한글은 4글자인데 모두 같은 길이로 출력되어야 한다.
        System.out.println("ABCDEFGH");
        System.out.println("abcdefgh");
        System.out.println("12345678");
        System.out.println("가나다라");
        System.out.printf("====================================================\n");
        // 서식 지정사에서에서 .을 기준으로 왼쪽은 차지하는 칸수, 오른쪽은 소수점 몇자리까지 표현할지.
        // 품목은 20칸, 그 뒤로는 8칸씩
        // 소수점 자료가 없어서 .뒤에 숫자는 제거하였다.
        System.out.printf("%20.20s%8s%8s%8s\n", "품목", "단가", "수량", "합계");
        System.out.printf("====================================================\n");

        // 품목은 위와 동일하게 한글이니 10칸을 동일하게 적용
        // 숫자의 경우 한글보다 2칸을 더해야 동일하게 출력이 되는데 어떤 원리에 의한 것인지
        // 더 확인할 필요가 있다. 현재까지는 관련 자료를 못 찾음.
        System.out.printf("%20s%10s%10s%10s\n", k27_item, k27_df.format(k27_unit_price),
                k27_df.format(k27_num), k27_df.format(k27_unit_price * k27_num));
        System.out.printf("====================================================\n");
    }
}
