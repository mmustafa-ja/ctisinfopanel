/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StudentIsA;

import CourseAndStudent.Student;
import StudentHasA.CourseInfoForStudent;

/**
 *
 * @author hp
 */
public class GraduateStudent extends Student {

    private String theory;
    private int year;

    public GraduateStudent(String id, String name, String surname, String yearOfAdmission, String theory, String year) {
        super(id, name, surname, yearOfAdmission);
        this.theory = theory;
        this.year = Integer.parseInt(year);
    }
    
    public GraduateStudent(String id, String name, String surname,String gpa, String yearOfAdmission, String theory, String year) {
        super(id, name, surname,gpa, yearOfAdmission);
        this.theory = theory;
        this.year = Integer.parseInt(year);
    }   

    @Override
    public String toString() {
        String str= "Graduate "+super.toString()+ 
                "Theory=" + theory + 
                "\nYear="+year+"\nCourses:\n";
        for(CourseInfoForStudent c:studentCourses){
            str+=c.toString();
        }
        return str;
    }
    
    @Override
    public void calcGPA() {
        double sumPoints=0,totalPoints=0;
        for(CourseInfoForStudent c:studentCourses){
            sumPoints+=c.points();
            totalPoints+=c.getCredit()*4;
        }
        gpa= (sumPoints/totalPoints)*4;
    }

    /**
     *
     * @return
     */
    @Override
    public String writeToFile() {
        String str = this.id + "*" + this.name + "*" + this.surname + "*" + this.gpa + "*" + this.yearOfAdmission
                + "*graduate*" + this.theory + "*"+this.year +"*"+ this.studentCourses.size() + System.lineSeparator();
        if (!studentCourses.isEmpty()) {
            for (CourseInfoForStudent c : studentCourses) {
                str += c.getCode() + "*" +c.getCredit()+"*"+ c.getGrade() + System.lineSeparator();
            }
        }
        return str;
    }
  
    
}
