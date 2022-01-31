package Chapter_07;

public class Biz_07_08_OneRec {
    private int student_id; // 8. 학번 추가
    private String name;
    private int kor;
    private int eng;
    private int mat;

    public Biz_07_08_OneRec(int student_id, String name, int kor, int eng, int mat) {
        this.student_id = student_id;
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.mat = mat;
    }

    public int student_id() {
        return this.student_id;
    }

    public String name() {
        return this.name;
    }

    public int kor() {
        return this.kor;
    }

    public int eng() {
        return this.eng;
    }

    public int mat() {
        return this.mat;
    }

    public int sum() {
        return this.kor + this.eng + this.mat;
    }

    public double ave() {
        return this.sum() / 3.0;
    }
}