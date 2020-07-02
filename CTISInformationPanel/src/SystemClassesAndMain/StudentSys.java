package SystemClassesAndMain;

import java.util.LinkedHashSet;
import CourseAndStudent.Student;
import StudentHasA.CourseInfoForStudent;
import StudentIsA.GraduateStudent;
import StudentIsA.UndergraduateStudent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentSys {
     private static LinkedHashSet<Student> students=new LinkedHashSet<>();
     private static final String STUDENT_FILENAME="students.txt";

    public static LinkedHashSet<Student> getStudents() {
        return students;
    }
     
    public static String getStudentsWhoTakeGivenCourse(String code){
        String str="";
        for(Student s:students){
            for(CourseInfoForStudent c:s.getStudentCourses())
                if(c.getCode()==Integer.parseInt(code))
                    str+=s.toString();            
        }
        return str;
    }
    
    public static void addStudent(Student s){
        students.add(s);
    }
    
    public static void writeToFile(){
         try {
             PrintWriter file=new PrintWriter(STUDENT_FILENAME);
             String str="";
             for(Student s:students){
                 str+=s.writeToFile();
             }
             file.println(str);
             file.close();
         } catch (FileNotFoundException ex) {
             Logger.getLogger(StudentSys.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    public static Student searchStudent(int id){
        for(Student s:students){
            if(s.getId()==id)
                return s;
        }
        return null;
    }
    
    public static void readFromFile(){
        File file=new File(STUDENT_FILENAME);
        if(file.exists()){
            try {
                Scanner inp=new Scanner(file);
                while(inp.hasNext()){
                    String[] line=inp.nextLine().split("\\*");
                    String id,name,surname,gpa,yearOfAdmission,type;
                    id=line[0];
                    name=line[1];
                    surname=line[2];
                    gpa=line[3];
                    yearOfAdmission=line[4];
                    type=line[5];
                    if(type.equalsIgnoreCase("undergraduate")){
                        String semesterNum;
                        int numOfCourses;
                        semesterNum=line[6];
                        UndergraduateStudent u=new UndergraduateStudent(id, name, surname,gpa, yearOfAdmission,semesterNum);
                        numOfCourses=Integer.parseInt(line[7]);
                        for(int i=0;i<numOfCourses;i++){
                            String code,grade;
                            int credit;
                            String[] course=inp.nextLine().split("\\*");
                            code=course[0];
                            grade=course[1];
                            credit=CourseSys.getCourseCredit(Integer.parseInt(code));
                            CourseInfoForStudent c=new CourseInfoForStudent(code, grade);
                            c.setCredit(credit);
                            u.addCourse(c);
                        }
                        students.add(u);
                    }else{
                        String theory,year;
                        theory=line[6];
                        year=line[7];
                        GraduateStudent g=new GraduateStudent(id, name, surname,gpa, yearOfAdmission, theory, year);
                        int numOfCourses=Integer.parseInt(line[8]);
                        for(int i=0;i<numOfCourses;i++){
                            String[] course=inp.nextLine().split("\\*");
                            String code,grade;
                            int credit;
                            code=course[0];
                            grade=course[1];
                            credit=CourseSys.getCourseCredit(Integer.parseInt(code));
                            CourseInfoForStudent c=new CourseInfoForStudent(code, grade);
                            c.setCredit(credit);
                            g.addCourse(c);
                        }
                        students.add(g);
                    }
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(StudentSys.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public static String displayAll(){
        String str="";
        for(Student s:students){
            str+=s.toString()+"\n";
        }
        return str;
    }
}
