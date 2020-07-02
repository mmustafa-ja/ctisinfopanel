package StudentHasA;
public class CourseInfoForStudent {
    private int code,credit;
    private String grade;

    public CourseInfoForStudent(String code, String grade) {
        this.code = Integer.parseInt(code);
        this.grade = grade;
    }
    
    public double points(){
        double points=0;
        switch (grade){
            case "A":
            case "A+":
                points=credit*4;
            break;
            case "A-":points=credit*3.7;
            break;
            case "B+":points=credit*3.3;
            break;
            case "B":points=credit*3;
            break;
            case "B-":points=credit*2.7;
            break;
            case "C+":points=credit*2.3;
            break;
            case "C":points=credit*2;
            break;
            case "C-":points=credit*1.7;
            break;
            case "D+":points=credit*1.3;
            break;
            case "D":points=credit*1;
            break;
            case "F":points=0;
            break;
        }
        return points;
    }

    public int getCode() {
        return code;
    }

    public int getCredit() {
        return credit;
    }

    public String getGrade() {
        return grade;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }
    
    @Override
    public String toString() {
        return "CTIS "+code+"\tGrade="+grade+"\n";
    }
    
    
}
