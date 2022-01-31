package Chapter_07;

public class Biz_07_09_OneRec {
    private int student_id; // 8. 학번 추가
    private String name;
    private int kor;
    private int eng;
    private int mat;

    public Biz_07_09_OneRec(int student_id, String name, int kor, int eng, int mat) {
        this.student_id = student_id;
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.mat = mat;
    }

    public Biz_07_09_OneRec(int kor, int eng, int mat) {
        this.kor = kor;
        this.eng = eng;
        this.mat = mat;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKor() {
        return kor;
    }

    public void setKor(int kor) {
        this.kor = kor;
    }

    public int getEng() {
        return eng;
    }

    public void setEng(int eng) {
        this.eng = eng;
    }

    public int getMat() {
        return mat;
    }

    public void setMat(int mat) {
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
