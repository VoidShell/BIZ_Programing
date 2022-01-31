package Chapter_04;

public class k27_Biz_04_10_KoreanNumber_02 {
    public static void main(String[] args) {
        // 예제용 int 형 숫자를 k27_iNumVal에 초기화
        // int k27_iNumVal = 1001034567;
        int k27_iNumVal = 0;
        // valueOf는 String 형으로 변환해주는 String 메서드.
        // 해당 메서드를 사용해서
        String k27_sNumVal = String.valueOf(k27_iNumVal);
        // String 최종 출력 변수 k27_Numvoice 빈칸으로 초기화
        String k27_sNumVoice = "";
        // k27_sNumVal을 출력하고 length 메서드를 사용해서 길이를 출력(숫자가 몇자리인지 알 수 있다.)
        System.out.printf("==> %s [%d자리]\n", k27_sNumVal, k27_sNumVal.length());
        // int형 변수 i, j를 선언한다.
        int k27_i, k27_j;
        // 일의 자리숫자를 한글로 읽는 문자들을 k27_units 배열에 초기화한다.
        String[] k27_units = {"영", "일", "이", "삼", "사", "오", "육", "칠", "팔", "구"};
        // 숫자의 단위를 읽는 한글 문자들을 k27_unitX 배열에 초기화한다.
        String[] k27_unitX = {"", "십", "백", "천", "만", "십", "백", "천", "억", "십"};
        // 자리수 문자의 순번을 가리키는 k27_i 변수를 0으로 초기화 한다.
        k27_i = 0;
        // k27_j 변수는 length()로 길이를 재어 자리수를 가리키는 역할을 한다.
        k27_j = k27_sNumVal.length() - 1;

        while (true) {
            if (k27_i >= k27_sNumVal.length()) {
                // 변수 k27_i가 k27_sNumVal의 길이보다 커지면 루프 멈춘다.
                break;
            }
            // 문자열[문자열] 형식으로 출력한다.
            // 문자열 부분: k27_sNumVal.substring으로 첫 문자를 뽑아내어 출력
            // [문자열] 부분: 해당 문자를 int형으로 파싱해서 k27_units 배열의 순번의 요소로 입력.
            // 해당 일의자리 숫자들 출력한다.
            System.out.printf("%s[%s]", k27_sNumVal.substring(k27_i, k27_i + 1),
                    // substring(i, i+1)은 해당 문자열을 한글자 단위로 자르는 것.
                    k27_units[Integer.parseInt(k27_sNumVal.substring(k27_i, k27_i + 1))]);
            // while 문으로 계속 만복이 되기 때문에 문장의 길이가 끝날때까지 모든 항에 대해서 문자열[문자열]을 출력한다.

            // k27_sNumVal.substring을 이용해 검사하는 과정에서 0인 문자를 판별한다.
            // sNumVal에서 뽑아온 한 글자가 '0'이면서
            if (k27_sNumVal.substring(k27_i, k27_i + 1).equals("0")) {
                // 추가 조건으로 해당 순번의 자리수가(unitX[j])'만' 또는 '억'과 과 일치하는 조건을 판별.
                if (k27_unitX[k27_j].equals("만") || k27_unitX[k27_j].equals("억")) {
                    // 두 조건을 만족하면 최종 출력되는 k27_sNumvoice에 unitX 배열의 j 인덱스 자리수 문자를 추가한다.
                    k27_sNumVoice = k27_sNumVoice + "" + k27_unitX[k27_j];
                    // 앞의 문자가 0일때 바로 자리수 문자를 붙여 '이백 만원'이런식으로 읽으 수 있도록 한다.
                } else {
                    // 그 외조건은 아무 조건도 처리 하지 않음
                }
                // sNumVal에서 뽑아온 한 글자가 '0'이 아니면
            } else {
                // 위의 조건이 아니면 자리수만이 아니라 일의자리숫자+자리수가 결합된 형태로 출력
                // k27_sNumvoice에 k27_units substring에 대응하는 한글자를 int로 변환하여 unit에서 해당 한자리 한글 문자를
                // 출력하고 대입
                // 그 뒤에는 한글 자리수 문자 대입
                k27_sNumVoice = k27_sNumVoice + k27_units[Integer.parseInt(k27_sNumVal.substring(k27_i, k27_i + 1))]
                        + k27_unitX[k27_j];
                // 이 때문에 0이 아니면서 만이나 억이 앞에 있지 않다면 계속 이 포맷으로 출력이 된다.
                // 그러다가 해당 조건에 걸리면 k27_units 배열은 안 들어가고 k27_unitX 한글 문자 자리수만 출력으로 들어간다.
            }
            k27_i++;
            // for문처럼 인덱스 번호를 증가시킨다.
            // 한자리 한글 문자 k27_units의 경우 ++ 구문을 사용한다.
            k27_j--;
            // 자리수 한글 문자 k27.UnitX의 경우 -- 구문을 사용해 배열의 끝 부분에서 작업을 진행한다.

            // k27_iNumVal가 억 이상이고 만 이하 단위가 없을 시
            // 위에서 자리수를 판별하는 알고리즘으로 검출할 경우 숫자가 계속 늘어날 수록 경우의 수가 많아진다.
            // 출력 표기만 없애버리는 식으로 진행한다.
            if (k27_sNumVoice.contains("억만")) {
                k27_sNumVoice = k27_sNumVoice.replace("억만", "억");
            }
            // 숫자 0일 경우 "영"을 직접 읽어주도록 표시
            // 정규 표현식사용하여 matches를 사용해 검출
            if (k27_sNumVal.matches("[0]")) {
                k27_sNumVoice = "영";
            }
        }
        // k41_sNumVal을 숫자와 [한글]형태로 표기해준다
        System.out.printf("\n%s[%s]\n", k27_sNumVal, k27_sNumVoice);
    }
}