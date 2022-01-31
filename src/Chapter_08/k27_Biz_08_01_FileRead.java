package Chapter_08;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class k27_Biz_08_01_FileRead {
    public static void main(String[] args) {
        try {
            // aaa.txt 파일 객체 생성
            File f = new File("aaa.txt ");
            // FileWriter 생성자에 f 인스턴스 인수로 넣어줌.
            FileWriter fw = new FileWriter(f);
            // fw 인스턴스의 write 메서드로 인수에 해당하는 내용 파일에 쓰기.
            fw.write("안녕 파일\n");
            // 추가적으로 계속 쓸 수 있다.
            fw.write("hello 헬로\n");
            // 파일 객체 닫아줌
            fw.close();
            // FileReader 인스턴스 fr 생성. 역시 생성자에 f 인스턴스를 넣는다.
            FileReader fr = new FileReader(f);

            // int 형 변수 n에 -1 대입
            int n = -1;
            // char형 배열 ch 선언
            char[] ch;
            // while(true)로 무한반복
            while (true) {
                // ch배열 100길이로 선언(버퍼값)
                ch = new char[100];
                // fr 인스턴스의 read 메서드에 해당 배열을 넣고 그곳에 담아 읽어온다.
                // 내용이 없으면 -1을 반환한다.
                n = fr.read(ch);
                if (n == -1)
                    // -1을 반환하고 루프 종료
                    break;
                // ch 배열의 모든 내용을 출력한다.
                for (int i = 0; i < n; i++) {
                    System.out.printf("%c", ch[i]);
                }
            }
            // fr인스턴스를 닫는다
            fr.close();
            System.out.printf("\nFILE READ END");
            // 에러가 날 경우 에러처리
        } catch (Exception e) {
            System.out.printf("나 에러[%s]\n", e);
        }
    }
}