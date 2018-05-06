package FcisAssistant;

public class StudentCourse extends Course {
    protected Grade CourseGrade;
    protected GradeDistribution Max;


    public float GetWeight(){
        CourseGrade.SetWieght(CreditHours);
        return CourseGrade.Weight;
    }
}
