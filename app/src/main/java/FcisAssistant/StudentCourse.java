package FcisAssistant;

import java.util.ArrayList;

public class StudentCourse extends Course {
    protected Grade CourseGrade;
    public StudentCourse(Grade courseGrade, String code, String name, String instructorofCourse, ArrayList<String> TAlist1, int creditHours) {
        this.code = code;
        Name = name;
        InstructorofCourse = instructorofCourse;
        TAlist = TAlist1;
        CreditHours = creditHours;
        CourseGrade = courseGrade;

    }

    public Grade getCourseGrade() {
        return CourseGrade;
    }

    public void setCourseGrade(Grade courseGrade) {
        CourseGrade = courseGrade;
    }

    public StudentCourse() {
        code = "None";
        Name = "None";
        InstructorofCourse = "None";
        CreditHours = 0;
        CourseGrade = new Grade();
    }

    public float GetWeight(){
        CourseGrade.SetWieght(CreditHours);
        return CourseGrade.Weight;
    }
}
