package Chapter_07;

public class Biz_07_05_ClassArray {
    public static void main(String[] args) {
        int iPerson = 5;    //이 값을 주는 만큼 저장소 생성
        Biz_07_05_OneRec[] inData = new Biz_07_05_OneRec[iPerson];    //클래스형태의 배열이 생성

        for (int i = 0; i < iPerson; i++) {
            String name = String.format("홍길%02d", i);
            int kor = (int) (Math.random() * 100);
            int eng = (int) (Math.random() * 100);
            int mat = (int) (Math.random() * 100);
            inData[i] = new Biz_07_05_OneRec(name, kor, eng, mat);
        }

        for (int i = 0; i < iPerson; i++) {
            System.out.printf("번호:%d, 이름:%3s, 국어:%3d, 영어:%3d, 수학:%3d, 총점:%3d, 평균:%f\n",
                    i, inData[i].name(), inData[i].kor(), inData[i].eng(), inData[i].mat(), inData[i].sum(), inData[i].ave());
        }
    }
}
