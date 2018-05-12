package FcisAssistant;
import java.util.ArrayList;
import java.util.Vector;

public class Instructor extends Person{
    protected int NoofEvaluators;
    protected float TotalEvaluation;
    protected ArrayList<InstructorCourse> Courselist;
    protected String OfficeHours;

    public Instructor() {
        ID="No ID";
        Name="NoName";
        Gender="No Gender";
        OfficeHours="Not Yet";
        Email="Not Found";
        Password="Not Found";

    }

    public ArrayList<InstructorCourse> getCourselist() {
        return Courselist;
    }

    public void setCourselist(ArrayList<InstructorCourse> courselist) {
        Courselist = courselist;
    }

    public void InsertCourse(InstructorCourse c) {
        Courselist.add(c);
     }
    public String getOfficeHours() {
        return OfficeHours;
    }

    public void setOfficeHours(String officeHours) {
        OfficeHours = officeHours;
    }

    public int getNoofEvaluators() {
        return NoofEvaluators;
    }

    public void setNoofEvaluators(int noofEvaluators) {
        NoofEvaluators = noofEvaluators;
    }

    public float getTotalEvaluation() {
        return TotalEvaluation;
    }

    public void setTotalEvaluation(float totalEvaluation) {
        TotalEvaluation = totalEvaluation;
    }

    public void Evaluate(float E){
        NoofEvaluators++;
        TotalEvaluation+=E;
        TotalEvaluation/=NoofEvaluators;
        TotalEvaluation*=10;
    }
    @Override
    public void EditPassword(String password){
        setPassword(password);
    }
    @Override
    public void EditEmail(String email){
        setEmail(email);
    }
}
