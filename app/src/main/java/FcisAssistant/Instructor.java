package FcisAssistant;
import java.util.Vector;

public class Instructor extends Person{
    protected int NoofEvaluators;
    protected float TotalEvaluation;
    protected int Image;
    protected Vector<InstructorCourse> Courselist;
    protected String OfficeHours;

    public Instructor() {
        ID=null;
        Name=null;
        Gender=null;
        OfficeHours=null;
        Email=null;
        Password=null;
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

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        this.Image = image;
    }
    public void Evaluate(float E){
        NoofEvaluators++;
        TotalEvaluation+=E;
        TotalEvaluation/=NoofEvaluators;
        TotalEvaluation*=10;
    }
}
