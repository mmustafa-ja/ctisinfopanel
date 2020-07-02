package CourseAndStudent;

import Interface.WriteInterface;
import java.util.ArrayList;
import StudentHasA.CourseInfoForStudent;
public abstract class Student implements WriteInterface{
    protected int id;
    protected String name,surname,yearOfAdmission;
    protected double gpa;
    protected ArrayList<CourseInfoForStudent> studentCourses;
    
    public Student(String id, String name, String surname, String yearOfAdmission) {
        this.id = Integer.parseInt(id);
        this.name = name;
        this.surname=surname;
        this.yearOfAdmission=yearOfAdmission;
        studentCourses=new ArrayList<>();
    }
    
    public Student(String id, String name, String surname, String gpa, String yearOfAdmission) {
       this(id,name,surname,yearOfAdmission);
       this.gpa=Double.parseDouble(gpa);
    }

    public abstract void calcGPA();
    
    @Override
    public String toString() {
//        return "Student" + "\nID=" + id + "\nName=" + name + "\nSurname="+surname+
//                "\nCgpa=" + gpa + "\nYear of Admission="+yearOfAdmission+"\n";
            return String.format("Student\nID=%d\nName=%s\nSurname=%s\nGPA=%.2f\n"
                    + "Year of Admission=%s\n",id,name,surname,gpa,yearOfAdmission);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }    
    
    public boolean addCourse(CourseInfoForStudent course){
        
        if(isCourseTaken(course.getCode()))
            return false;
        studentCourses.add(course);
        return true;
    }
    
    public boolean isCourseTaken(int code){
        for(CourseInfoForStudent s:studentCourses){
            if(s.getCode()==code)
                return true;
        }
        return false;
    }

    public ArrayList<CourseInfoForStudent> getStudentCourses() {
        return studentCourses;
    }

    public int getId() {
        return id;
    }

    public double getGpa() {
        return gpa;
    }
}
