package Chapter_08;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class k27_Biz_08_02_FileReadWrite {
    public static void FileWrite() throws IOException {
        // File 클래스형 f 파일 인스턴스 생성. "aaa.txt" 라는 파일 이름을 생성자에서 설정한다.
        File f = new File("aaa.txt ");
        // BufferedWriter 클래스형 bw 인스턴스 생성. new FileWriter(f) 부분을 생성자에서 받는다.
        BufferedWriter bw = new BufferedWriter(new FileWriter(f));

        // BufferWriter의 인스턴스 bw로 쓰기를 한다.
        bw.write("안녕 파일 ");
        // newLine() 메서드는 개행을 의미한다.
        bw.newLine();
        bw.write("hello 헬로");
        bw.newLine();
        // 인스턴스 bw를 닫아준다.
        bw.close();
    }

    public static void FileRead() throws IOException {
        // File 클래스형 f 파일 인스턴스 생성. "aaa.txt" 라는 파일 이름을 생성자에서 설정한다.
        File f = new File("aaa.txt ");
        // BuffereReader 클래스형 bw 인스턴스 생성. new FileReader(f) 부분을 생성자에서 받는다.
        BufferedReader br = new BufferedReader(new FileReader(f));

        // 한줄씩 읽어올 String을 담을 변수 설정한다.
        String readtxt;
        // br 인스턴스의 readLin() 메서드로 한줄씩 불러온 결과를 readtxt에 저장한다.
        // readtxt가 null이 아닐때까지 while 루프를 반복한다.
        // 내용이 없을때까지 계속 반복한다.
        while ((readtxt = br.readLine()) != null) {
            System.out.printf("%s\n", readtxt);
        }
        // 인스턴스 br을 닫아준다.
        br.close();
    }

    public static void main(String[] args) throws IOException {
        // 정의한 메서드를 실행한다.
        FileWrite();
        FileRead();
    }
}

