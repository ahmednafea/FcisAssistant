package FcisAssistant;
import java.util.ArrayList;
import java.util.Vector;

public class TeacherAssistant extends Person {
    protected int CreditHours;
    protected int RCreditHours;
    protected String Department;
    protected int NoofEvaluators;
    protected ArrayList<TACourse> Courselist;
    protected float TotalEvaluation;

    public TeacherAssistant() {
        ID=null;
        Name=null;
        Gender=null;
        Email=null;
        Password=null;
        Department=null;
        CreditHours=0;
        RCreditHours=25;
        NoofEvaluators=0;
        TotalEvaluation=0;
    }

    public ArrayList<TACourse> getCourselist() {
        return Courselist;
    }

    public void setCourselist(ArrayList<TACourse> courselist) {
        Courselist = courselist;
    }

    public void InsertCourse(TACourse c) {
        Courselist.add(c);
        CreditHours+=c.CreditHours;
        RCreditHours-=c.CreditHours;
    }
    public int getCreditHours() {
        return CreditHours;
    }

    public void setCreditHours(int creditHours) {
        CreditHours = creditHours;
    }

    public int getRCreditHours() {
        return RCreditHours;
    }

    public void setRCreditHours(int RCreditHours) {
        this.RCreditHours = RCreditHours;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
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
