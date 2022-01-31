package Chapter_03;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class k27_Biz_03_04_Date {
    public static void main(String[] args) {
        // #2-8. 현재 날짜, 시간 찍기
        // Calendar 클래스는 날짜와 시간에 관한 정보를 표현한다.
        // Calendar 클래스는 추상 클래스로 객체를 직접 생성할 수 없지만 getInstance() 메서드를 이용하여 시스템의 날짜와 시간 정보를 받아와
        // 이를 바탕으로 k27_calt 인스턴스를 생성한다.
        // SimpleDateFormat 클래스는 "YYYY/MM/dd HH:mm:ss"와 같은 패턴을 생성자로 받아 k27_sdf 인스턴스를 생성한다.
        // SimpleDateFormat 클래스의 인스턴스는 format 메서드를 호출해서 인수로 k27_calt.get()을 받는다.
        // k27_calt는 getTime() 메소드를 호출하여 Date 형으로 k27_sdf.format의 인수로 들어가 해당 포맷 형태를 출력한다.
        Calendar k27_calt = Calendar.getInstance();
        SimpleDateFormat k27_sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        System.out.printf("***********************************************************************\n");
        System.out.printf("최종실행시간: %s\n", k27_sdf.format(k27_calt.getTime()));
        System.out.printf("***********************************************************************\n");
    }
}
