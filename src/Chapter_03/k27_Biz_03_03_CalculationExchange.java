package Chapter_03;

import java.text.DecimalFormat;

public class k27_Biz_03_03_CalculationExchange {
    public static void main(String[] args) {
        // #2-3. 수수료 없이 계산
        // 자신 금액 초기화
        int k27_MyWon = 1000000;
        // 달러 환율 초기화
        double k27_MoneyEx = 1238.21;
        // 환전 수수료 -> 0.3%
        double k27_commission = 0.003;
        // 자신 금액을 달러 환율로 나누고 int 형 변환을 해주면 소수점이 떨어지면서 달러로 변환된다.
        // 소수점 떨구는 건 잔돈을 빼는 과정
        int k27_usd = (int) (k27_MyWon / k27_MoneyEx);
        // 위에서 변환한 k27_usd(달러금액)에 환율을 곱하고 이를 k27_MyWon(자신금액)에서 뺀다.
        // 그러면 잔돈이 남는다.
        int k27_remain = (int) (k27_MyWon - k27_usd * k27_MoneyEx);
        System.out.printf("*******************************************************************************\n");
        System.out.printf("*                               수수료없이 계산                               *\n");
        // 계산된 결과값들 출력.
        System.out.printf("총 한화환전금액: %d원 => 미화 : %d달러, 잔돈: %d원\n", k27_MyWon, k27_usd, k27_remain);
        System.out.printf("*******************************************************************************\n");


        // #2-4. 수수료 포함 환전 계산(1)
        // k27_commision은 1달러당 수수료
        // 달러 환율에 환전 수수료를 곱하면 1달러당 수수료(k27_ComperOne)가 나온다.
        double k27_ComPerOne = k27_MoneyEx * k27_commission;
        // 전체 수수료는 변환할 달러(k27_usd)에 1달러당 수수료(k27_ComPerOne)를 곱한 값이다.
        double k27_totalcom = k27_usd * k27_ComPerOne;
        // 전체 수수료, 달러, 1달러당 수수료 출력
        System.out.printf("*******************************************************************************\n");
        System.out.printf("*                                 수수료 계산                                 *\n");
        // 계산된 결과값들 출력.
        System.out.printf("총 수수료: %f원 => 미화 : %d달러, 달러당 수수료: %f원\n", k27_totalcom, k27_usd, k27_ComPerOne);
        System.out.printf("*******************************************************************************\n");


        // #2-5. 수수료 포함 환전 계산(2)
        // 올림 총 수수료 변수 선언
        int k27_i_totalcom;
        // 총 수수료를 int형 변환해서 소수점을 떼고 다시 double을 붙여서 원래 값과 비교한다.
        // 서로 결과가 다르면 int형변환한 총 수수료(k27_totalcom)에 1을 더하고 올림 총수수료(k27_i_totalcom)에 대입한다.
        if (k27_totalcom != (double) ((int) k27_totalcom))
            // 은행은 절대 덜받지 않는다. 조금이라도 있으면 올려받는다!
            k27_i_totalcom = (int) k27_totalcom + 1;
        else
            // 그렇지 않으면 올림 총 수수료에 그냥 int형변환하고 그대로 대입한다. (소수점이 없었다.)
            k27_i_totalcom = (int) k27_totalcom;
        System.out.printf("*******************************************************************************\n");
        System.out.printf("*                               수수료 적용환전                               *\n");
        // 계산된 결과값들 출력.
        System.out.printf("총 수수료: %d원 => 미화 : %d달러, 달러당 수수료: %f원\n",
                k27_i_totalcom, k27_usd, k27_ComPerOne);
        // 잔돈(k27_remain)은 보유금액에서 달러(k27_USD) * 환율(k27_MoneyEX) 곱해서 환전한 금액을 빼고
        // 거기에서 최종적으로 계산된 수수료(은행기준버림)까지 빼주면 잔돈이 계산된다
        // int형이 전체 적용되지만 실제로 적용 되는 부분은 k27_usd * k27_MoneyEx 부분이다.
        k27_remain = (int) (k27_MyWon - k27_usd * k27_MoneyEx - k27_i_totalcom);
        System.out.printf("총 한화환전금액: %d원 => 미화 : %d달러, 수수료청구: %d 잔돈: %d원\n",
                k27_MyWon, k27_usd, k27_i_totalcom, k27_remain);
        System.out.printf("*******************************************************************************\n");


        // #2-6. 수수료 포함 환전 계산(3)
        // 달러 환율에 1달러당 환전 수수료를 곱하고 이를 자신 금액으로 나눈다. 이를 int형으로 형변환 하고 달러(k27_usd)에 대입
        // 실수형 계산 (1달러 + 1달러 환전수수료) 이 금액을 전체금액으로 나누어 환전해야 정확
        k27_usd = (int) (k27_MyWon / (k27_MoneyEx + k27_ComPerOne));
        // 달러(k27_usd)에1 1달러당 환전 수수료를 곱하고 환전 수수료(k27_totalcom)에 대입
        k27_totalcom = k27_usd * k27_ComPerOne;
        // 환전 수수료를 int형으로 변환하고 이를 다시 더블형으로 변환하면 소수점 내림이 된다.
        // 이게 기존 환전 수수료랑 다른지 체크.
        if (k27_totalcom != (double) ((int) k27_totalcom))
            // 다르면 환전 수수료에 소수점이 붙었다는 뜻으로 +1을 하고 올림 수수료에 대입
            // 은행은 절대 덜받지 않는다. 조금이라도 있으면 올려받는다!
            k27_i_totalcom = (int) k27_totalcom + 1;
        else
            // 그렇지 않으면 올림 총 수수료에 그냥 int형변환하고 그대로 대입한다. (소수점이 없었다.)
            k27_i_totalcom = (int) k27_totalcom;
        System.out.printf("*******************************************************************************\n");
        System.out.printf("*                           (정확한)수수료 적용환전                           *\n");
        System.out.printf("총 수수료: %d원 => 미화 : %d달러, 달러당 수수료: %f원\n",
                // 계산된 결과값들 출력.
                k27_i_totalcom, k27_usd, k27_ComPerOne);
        k27_remain = (int) (k27_MyWon - k27_usd * k27_MoneyEx - k27_i_totalcom);
        System.out.printf("총 한화환전금액: %d원 => 미화 : %d달러, 수수료청구: %d원, 잔돈: %d원\n",
                // 계산된 결과값들 출력.
                k27_MyWon, k27_usd, k27_i_totalcom, k27_remain);
        System.out.printf("*******************************************************************************\n");


        // #2-7. 콤마찍기
        // DecimalFormat 클래스를 이용하여 DecimalFormat으로 문자열을 지정 포맷으로 출력.
        // DecimalFormat 클래스는 format 메서드를 사용하여 특정 패턴으로 값을 포맷할 수 있다. (반환값 String)
        // 지정할 수 있는 패턴 형식은 '0'과' '#'를 사용한다.
        // DecimalFromat 형의 k27_df 인스턴스 생성. 해당 인스턴스는 생성자로 "###,###,###,###,###" 이 패턴을 받아 만들어졌음.
        // 해당 k27_df의 format 메서드 호출로 각 입력값들을 해당 포맷으로 String 형으로 출력한다.
        DecimalFormat k27_df = new DecimalFormat("###,###,###,###,###");

        System.out.printf("*******************************************************************************\n");
        System.out.printf("*                             콤마찍기, 날짜 적용                             *\n");
        // format 메서드로 각 데이터값을 인수로 넣고 String 형 반환이므로 서식 지정자로 %s를 사용한다.
        System.out.printf("총 수수료: %s원 => 미화 : %s달러, 달러당 수수료: %f원\n", k27_df.format(k27_i_totalcom),
                k27_df.format(k27_usd), k27_ComPerOne);
        // 잔돈(k27_remain)은 보유금액에서 달러(k27_USD) * 환율(k27_MoneyEX) 곱해서 환전한 금액을 빼고
        // 거기에서 최종적으로 계산된 수수료(은행기준버림)까지 빼주면 잔돈이 계산된다
        // int형이 전체 적용되지만 실제로 적용 되는 부분은 k27_usd * k27_MoneyEx 부분이다.
        k27_remain = (int) (k27_MyWon - k27_usd * k27_MoneyEx - k27_i_totalcom);
        System.out.printf("총 한화환전금액: %s원 => 미화 : %s달러, 수수료청구: %s원 잔돈: %s원\n",
                k27_df.format(k27_MyWon), k27_df.format(k27_usd), k27_df.format(k27_i_totalcom), k27_df.format(k27_remain));
        System.out.printf("*******************************************************************************\n");
    }

}
