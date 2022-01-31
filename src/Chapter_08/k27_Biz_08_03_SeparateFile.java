package Chapter_08;

import java.io.*;
import java.util.ArrayList;

public class k27_Biz_08_03_SeparateFile {
    // Wifi Field가 몇번인지 상수로 설정.
    public static final int WIFI_FIELD_NUM = 5;

    // 각 행 별로 통신사를 분류할 Telecom 클래스 정의
    public static class Telecom {
        private String field;
        private boolean skt;
        private boolean kt;
        private boolean lgu;

        // ArrayList에서 임시로 리스트를 생성할 목적으로 field 변수만 받는 생성자 정의
        public Telecom(String field) {
            this.field = field;
        }

        // private 필드에 대해 getter/setter 정의.
        public boolean isSkt() {
            return skt;
        }

        public void setSkt(boolean skt) {
            this.skt = skt;
        }

        public boolean isKt() {
            return kt;
        }

        public void setKt(boolean kt) {
            this.kt = kt;
        }

        public boolean isLgu() {
            return lgu;
        }

        public void setLgu(boolean lgu) {
            this.lgu = lgu;
        }

        // 통신사를 판별하는 메서드
        // 파라미터1: Telecom 형 ArrayList 리스트 인스턴스, 파라미터2: field[5](Wifi 필드 내용), 파라미터3: 작업 번호
        public static void selectTelecom(ArrayList<Telecom> telecoms, String field, int LineCut) {
            // replace 결과가 저장 될 String 변수 선언
            String replaceField;
            // [㈜]|[+]|["]과 같은 기준으로 해당 내용을 삭제하고 reaplceField에 저장.
            replaceField = field.replaceAll("[㈜]|[+]|[\"]", "");
            // [,]|[-]|[(]|[)]|[/]과 같은 중복 기준으로 spli을 해주고 이를 splitField 배열에 저장
            // 위 두 과정을 통해서 통신사별로 배열로 나뉘게 된다.
            String[] splitField = replaceField.split("[,]|[-]|[(]|[)]|[/]");

            // splifField 길이만큼 반복문 진행.
            for (int i = 0; i < splitField.length; i++) {
                // splitField의 첫 글자가 S나 s로 시작하면 SKT 통신사
                if (splitField[i].trim().startsWith("S") || splitField[i].trim().startsWith("s")) {
                    // telecoms 리스트 인스턴스의 LineCut에 해당하는 순번에 setter로 SKT를 true 설정.
                    telecoms.get(LineCut).setSkt(true);
                    // splitField의 첫 글자가 K나 케로 시작하면 KT 통신사
                } else if (splitField[i].trim().startsWith("K") || splitField[i].trim().startsWith("케")) {
                    // telecoms 리스트 인스턴스의 LineCut에 해당하는 순번에 setter로 KT를 true 설정.
                    telecoms.get(LineCut).setKt(true);
                    // splitField의 첫 글자가 L, U, 엘로 시작하면 LGU 통신사
                } else if (splitField[i].trim().startsWith("L") || splitField[i].trim().startsWith("U") || splitField[i].trim().startsWith("엘")) {
                    // telecoms 리스트 인스턴스의 LineCut에 해당하는 순번에 setter로 LGU를 true 설정.
                    telecoms.get(LineCut).setLgu(true);
                    // 그 외 통신사 구분
                    // splitField의 첫 글자가 띄어쓰기를 포함한 한글, 주, 그리고 공백이 아닐 경우
                    // 혹은, 문자 전체가 Break Space(\u00A0)가 아니거나 I로 시작하거나
                } else if (splitField[i].trim().matches("^[가-힣\\s]*$") && !splitField[i].trim().startsWith("주")
                        && !splitField[i].startsWith(" ") || splitField[i].matches("\\u00A0") || splitField[i].startsWith("I")) {
                    System.out.printf("알 수 없는 통신사[%d번째항목][%s]***\n", LineCut + 1, splitField[i].trim());
                    // 아래는 교안처럼 출력하기
                    //System.out.printf("알 수 없는 통신사[%d번째항목][%s]***\n", LineCut + 1, field);
                }
            }
        }
        // 파일 쓰기 메서드
        // 파라미터1: BufferWriter SKT 인스턴스, 파라미터2: BufferWriter KT 인스턴스, 파라미터3: BufferWriter LGU 인스턴스
        // 파라미터4: Telecom 형 ArrayList 리스트 인스턴스, 파라미터5: 전체 라인 field 배열, 파라미터6: 작업번호
        public static void writeFile(
                BufferedWriter sktBw, BufferedWriter ktBw, BufferedWriter lguBw, ArrayList<Telecom> telecoms, String[] field, int LineCut)
                throws IOException {

            // telecoms에서 LineCut 번호로 Telecom 클래스의 인스턴스를 호출하여 SKT 필드의 true 여부를 판별한다.
            if (telecoms.get(LineCut).isSkt()) {
                // 조건이 만족하면 field[5]에 SKT를 대입한다.
                field[5] = "SKT";
                // sktBw 인스턴스로 write를 하는데 writeLine 메서드의 반환값을 쓴다.
                sktBw.write(writeLine(field));
                // 개행한다.
                sktBw.newLine();
            }
            // telecoms에서 LineCut 번호로 Telecom 클래스의 인스턴스를 호출하여 KT 필드의 true 여부를 판별한다.
            if (telecoms.get(LineCut).isKt()) {
                // 조건이 만족하면 field[5]에 KT를 대입한다.
                field[5] = "KT";
                // ktBw 인스턴스로 write를 하는데 writeLine 메서드의 반환값을 쓴다.
                ktBw.write(writeLine(field));
                // 개행한다.
                ktBw.newLine();
            }
            // telecoms에서 LineCut 번호로 Telecom 클래스의 인스턴스를 호출하여 LGU 필드의 true 여부를 판별한다.
            if (telecoms.get(LineCut).isLgu()) {
                // 조건이 만족하면 field[5]에 LGU를 대입한다.
                field[5] = "LGU";
                // lguBw 인스턴스로 write를 하는데 writeLine 메서드의 반환값을 쓴다.
                lguBw.write(writeLine(field));
                // 개행한다.
                lguBw.newLine();
            }
        }
        // 배열로 구성된 행을 다시 하나의 String으로 조립하는 메서드
        public static String writeLine(String[] field) {
            StringBuilder stringBuilder = new StringBuilder();
            // field의 길이만큼 반복문 설정
            for (int i = 0; i < field.length; i++) {
                // 마지막 순서 직전까지는 field[i]를 붙이고 뒤에 탭을 붙인다.
                if (i < field.length - 1) {
                    stringBuilder.append(field[i]).append("\t");
                    // 마지막 순서일 경우에는 그냥 field[i]만 붙인다.
                } else {
                    stringBuilder.append(field[i]);
                }
            }
            // stringBuilder의 String을 리턴한다.
            return stringBuilder.toString();
        }

        public static void main(String[] args) throws IOException {
            // EUC-KR 방식을 불러올 수 있도록 StreamReader를 사용한다.
            // fis -> is -> br
            FileInputStream fis = new FileInputStream("전국무료와이파이표준데이터.txt");
            InputStreamReader is = new InputStreamReader(fis, "EUC-KR");
            BufferedReader br = new BufferedReader(is);

            // fos - osw -> bw
            BufferedWriter sktBw = new BufferedWriter(new OutputStreamWriter
                    (new FileOutputStream("전국무료와이파이표준데이터_SKT.txt")));
            BufferedWriter ktBw = new BufferedWriter(new OutputStreamWriter
                    (new FileOutputStream("전국무료와이파이표준데이터_KT.txt")));
            BufferedWriter lguBw = new BufferedWriter(new OutputStreamWriter
                    (new FileOutputStream("전국무료와이파이표준데이터_LGU.txt")));

            // 불러온 행을 저장하는 String 변수
            String readtxt;

            // readLine 메서드로 불러오는 줄이 없으면 빈 파일 메시지 출력.
            if ((readtxt = br.readLine()) == null) {
                System.out.printf("빈 파일입니다\n");
                return;
            }
            // BufferedWriter의 write 메서드를 통해 칼럼 이름 행을 write한다.
            sktBw.write(readtxt);
            sktBw.newLine();
            ktBw.write(readtxt);
            ktBw.newLine();
            lguBw.write(readtxt);
            lguBw.newLine();
            // 작업번호, 줄번호를 나타내는 LineCut 변수 선언.
            int LineCut = 0;

            ArrayList<Telecom> telecoms = new ArrayList<>();
            // readLine 메서드로 한줄씩 불러와 readtxt에 대입하고 해당 결과가 null이 아닌지 체크한다.
            // null이 아닐 경우 계속 루프를 돌면서 아래 내용을 처리한다.
            while ((readtxt = br.readLine()) != null) {
                // readtxt를 탭으로 분리하여 field 배열에 저장
                String[] field = readtxt.split("\t");
                // telecoms 리스트 인스턴스에 Telecom 생성자로 wifi 필드를 추가
                telecoms.add(new Telecom(field[WIFI_FIELD_NUM]));
                // selecTelecom 메서드로 통신사를 구분하고 리스트 인스턴스에 기록.
                selectTelecom(telecoms, field[WIFI_FIELD_NUM], LineCut);
                // writeFile 메서드로 분류된 통신사를 각 파일에 기록한다.
                writeFile(sktBw, ktBw, lguBw, telecoms, field, LineCut);
                LineCut++;
            }
            // 사용이 끝난 reader, write 인스턴스 close로 닫아준다.
            br.close();
            sktBw.close();
            ktBw.close();
            lguBw.close();
        }
    }
}