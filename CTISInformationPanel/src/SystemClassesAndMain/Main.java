package SystemClassesAndMain;

import GUI.UndergraduateStudentFrame;

public class Main {

    public static void main(String[] args) {
        CourseSys.readCoursesFromFile();
        StudentSys.readFromFile();
        UndergraduateStudentFrame usf=new UndergraduateStudentFrame();
        usf.setVisible(true);
    }

}
