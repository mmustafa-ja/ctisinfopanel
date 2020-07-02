package CourseAndStudent;

public class Course implements Comparable<Course>{
    private int CourseCode;
    private int credit;
    private String CourseName;

    public Course(String CourseCode, String credit, String CourseName) {
        this.CourseCode = Integer.parseInt(CourseCode);
        this.credit = Integer.parseInt(credit);
        this.CourseName = CourseName;
    }

    @Override
    public String toString() {
        return "Course" + "\nCourseCode=" + CourseCode + "\ncredit=" + credit + 
                "\nCourseName=" + CourseName + "\n";
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.CourseCode;
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
        final Course other = (Course) obj;
        if (this.CourseCode != other.CourseCode) {
            return false;
        }
        return true;
    }

    public int getCredit() {
        return credit;
    }
    
    public int getCourseCode() {
        return CourseCode;
    }

    @Override
    public int compareTo(Course t) {
        return this.CourseCode-t.getCourseCode();
    }
}