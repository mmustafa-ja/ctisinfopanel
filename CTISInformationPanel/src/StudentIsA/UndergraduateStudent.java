/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StudentIsA;

import CourseAndStudent.Student;
import StudentHasA.CourseInfoForStudent;

public class UndergraduateStudent extends Student {

    private int SemesterNumber;

    public UndergraduateStudent(String id, String name, String surname, String yearOfAdmission, String SemesterNumber) {
        super(id, name, surname, yearOfAdmission);
        this.SemesterNumber = Integer.parseInt(SemesterNumber);
    }
    
    public UndergraduateStudent(String id, String name, String surname,String gpa, String yearOfAdmission, String SemesterNumber) {
        super(id, name, surname,gpa, yearOfAdmission);
        this.SemesterNumber = Integer.parseInt(SemesterNumber);
    }

    @Override
    public String toString() {
        String str= "Undergraduate "+super.toString()
                + "Semester Number=" + SemesterNumber + "\nCourses:\n";
        for(CourseInfoForStudent c:studentCourses){
            str+=c.toString();
        }
        return str;
    }

    @Override
    public void calcGPA() {
        double sumPoints = 0, totalPoints = 0;
        for (CourseInfoForStudent c : studentCourses) {
            sumPoints += c.points();
            totalPoints += c.getCredit() * 4;
        }
        gpa = (sumPoints / totalPoints) * 4;
    }

    @Override
    public String writeToFile() {
        String str = this.id + "*" + this.name + "*" + this.surname + "*" + this.gpa + "*" + this.yearOfAdmission
                + "*undergraduate*" + this.SemesterNumber + "*" + this.studentCourses.size() + System.lineSeparator();
        if (!studentCourses.isEmpty()) {
            for (CourseInfoForStudent c : studentCourses) {
                str += c.getCode() + "*"+ c.getGrade() + System.lineSeparator();
            }
        }
        return str;
    }
}
