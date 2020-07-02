package SystemClassesAndMain;

import CourseAndStudent.Course;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CourseSys {

    private static HashSet<Course> courses = new HashSet();
    private static final String COURSE_FILENAME = "courses.txt";

    public static void readCoursesFromFile() {
        File file = new File(COURSE_FILENAME);
        Scanner sc = null;
        if (file.exists()) {
            try {
                sc = new Scanner(file);
                while (sc.hasNext()) {
                    String coursecode, coursecredit, name;
                    String[] line = sc.nextLine().split("/");
                    coursecode = line[0];
                    coursecredit = line[2];
                    name = line[1];
                    Course course = new Course(coursecode, coursecredit, name);
                    courses.add(course);
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(CourseSys.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            System.out.println("File does not exist");
        }
    }

    public static String displaycourses() {
        String res = "";

        for (Course cr : courses) {
            res += cr.toString() + "\n";
        }
        return res;
    }

    public static HashSet<Course> getCourses() {
        return courses;
    }

    public static String[] getCourse() {
        String[] getcourses = new String[courses.size()];
        int i = 0;
        TreeSet<Course> ts=new TreeSet<>();
        ts.addAll(courses);
        for (Course cr : ts) {
            getcourses[i] = String.valueOf(cr.getCourseCode());
            i++;
        }
        return getcourses;
    }

    public static int getCourseCredit(int code) {
        for (Course c : courses) {
            if (c.getCourseCode() == code) {
                return c.getCredit();
            }
        }
        return 0;
    }

}