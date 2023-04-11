package information;

public class Grade {
    private int kor;
    private int math;
    private int eng;
    private int science;
    private int society;
    private int history;
    public Grade(int kor, int math, int eng, int science, int society, int history) {
        this.kor = kor;
        this.math = math;
        this.eng = eng;
        this.society = society;
        this.science = science;
        this.history = history;
    }
    public int getKor() {
        return kor;
    }
    public int getMath() {
        return math;
    }
    public int getEng() {
        return eng;
    }
    public int getHistory() {
        return history;
    }
    public int getSociety() {
        return society;
    }
    public int getScience() {
        return science;
    }
    public double getAverage() {
        return Math.round((kor+math+eng+history+society+science)/6);
    }

    public void setKor(int kor) {
        this.kor = kor;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public void setEng(int eng) {
        this.eng = eng;
    }

    public void setScience(int science) {
        this.science = science;
    }

    public void setSociety(int society) {
        this.society = society;
    }

    public void setHistory(int history) {
        this.history = history;
    }
}
