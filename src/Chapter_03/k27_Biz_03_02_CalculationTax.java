package Chapter_03;

public class k27_Biz_03_02_CalculationTax {
    public static int k27_taxcal(int k27_val, int k27_rate) {
        // 소수점이 붙으면 올림을해서 물건에 대한 세금 가격을 변환하는 메서드
        // 세전 물건 가격과 세율을 파라미터로 정의한다.
        int k27_ret;
        // k27 세전 물건값과 세금을 각각 double로 형 변환 해준다 곱해준 것을 100.0으로 나눠준 것이랑
        // 같은식으로 그냥 형 변환 없이 100으로 나눠준과 비교를 한다
        // 전자는 소수점이 나올 수 있고 후자는 정수형으로 떨어지는데 비교 케이스에서
        if (((double) k27_val * (double) k27_rate / 100.0) == k27_val * k27_rate / 100)
            // 같을 경우 그냥 세금 계산
            k27_ret = k27_val * k27_rate / 100;
        else
            // 다를 경우 세금 계산 + 1 (소수점이 있다고 보는 경우)
            k27_ret = k27_val * k27_rate / 100 + 1;
        // 물건에 대한 세금을 리턴
        return k27_ret;
    }

    public static void main(String[] args) {
        // #2-1. 단순 세금 계산
        // 세전 물건 가격값
        int k27_val = 271;
        // 세율 3퍼센트
        int k27_rate = 3;
        // 위에서 정의한 k27_taxcal 메서드드로 세전 물건 가격값이랑 세율을 인수로 넣는다.
        int k27_tax = k27_taxcal(k27_val, k27_rate);

        System.out.printf("****************************************************\n");
        System.out.printf("*                  단순 세금 계산                  *\n");
        // 100.0으로 나눴기 때문에 소수점이 나올 수 있다. 실제 세금 계산 출력
        System.out.printf("실제 세금 계산: %f원\n", k27_val * k27_rate / 100.0);
        // 계산된 결과값들 출력.
        System.out.printf("세전가격: %d원,    세금: %d원,     세포함가격: %d원\n", k27_val, k27_tax, k27_val + k27_tax);
        System.out.printf("****************************************************\n");


        // #2-2. 소비자가 중심 세금계산
        // 소비자가격 초기화
        int k27_custom = 280;
        // 세율 3% -> 3%는 0.03 -> k27_taxrate/100.0 초기화
        int k27_taxrate = 3;
        // 세금, 세전가격,
        int k27_taxval, k27_netval;
        // 세전 가격 계산 = (소비자가격 / (1 + 세율 / 100.0)) 이를 int형으로 변환. -> 소수점 떨어짐.
        k27_netval = (int) (k27_custom / (1 + k27_taxrate / 100.0));
        // 세금 가격 계산 = 소비자 가격 - 세전 가격
        k27_taxval = k27_custom - k27_netval;
        System.out.printf("****************************************************\n");
        System.out.printf("*              소비자가 중심 세금계산              *\n");
        // 소비자 가격, 세전 가격, 세금 출력
        System.out.printf("소비자가격: %d원,    세전가격: %d원,     세금: %d원\n", k27_custom, k27_netval, k27_taxval);
        System.out.printf("****************************************************\n");
    }
}