package Chapter_07;

import java.util.ArrayList;

public class Biz_07_07_ArrayList_02 {
    public static void main(String[] args) {
        int iTestMAX=1000000;
        ArrayList iAL= new ArrayList();

        for(int i=0; i < iTestMAX;i++) {
            iAL.add((int) (Math.random() * 1000000));
        }
        for(int i=0; i < iAL.size(); i++) {
            System.out.printf(" ArrayList %d = %d\n", i, iAL.get(i));
        }

        System.out.printf("******************************\n");
        iAL.sort(null);

        for(int i=0; i < iAL.size(); i++)
            System.out.printf(" ArrayList %d = %d\n", i, iAL.get(i));
    }
}
