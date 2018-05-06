package FcisAssistant;
import android.view.View;

import com.abamed.fcisassistant.InstructorFragments.InstructorProfile;

import java.util.Vector;
import java.util.zip.Inflater;

public class Student extends Person {
    protected int CreditHours;
    protected int RCreditHours;
    protected String AcademicYear;
    protected String Department;
    protected Vector<StudentCourse> Courselist;
    protected float CumulativeGpa;
    protected int TotalCreditHours;
    protected int RTotalCreditHours;
    public Student(){}


    public Student(String id ,String name,String gender,String email,String password ,String academicYear,String department,int rTotalCreditHours){
        ID=id;
        Name=name;
        Gender=gender;
        Email=email;
        Password=password;
        CreditHours=0;
        RCreditHours=21;
        AcademicYear=academicYear;
        Department=department;
        TotalCreditHours=144;
        RTotalCreditHours=rTotalCreditHours;

    }
    public void InsertCourse(StudentCourse c) {
    Courselist.add(c);
    CreditHours+=c.CreditHours;
    RCreditHours-=c.CreditHours;
    RTotalCreditHours-=c.CreditHours;
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
    public String getAcademicYear() {
        return AcademicYear;
    }

    public void setAcademicYear(String academicYear) {
        AcademicYear = academicYear;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    public float getCumulativeGpa() {
        return CumulativeGpa;
    }

    public void setCumulativeGpa(float cumulativeGpa) {
        CumulativeGpa = cumulativeGpa;
    }

    public int getTotalCreditHours() {
        return TotalCreditHours;
    }

    public void setTotalCreditHours(int totalCreditHours) {
        TotalCreditHours = totalCreditHours;
    }

    public int getRTotalCreditHours() {
        return RTotalCreditHours;
    }

    public void setRTotalCreditHours(int RTotalCreditHours) {
        this.RTotalCreditHours = RTotalCreditHours;
    }

    public void SetCumulativeGpa(){
    float total=0;
        for (StudentCourse s:Courselist){
            total+=s.GetWeight();
        }
        total/=CreditHours;
        CumulativeGpa +=total;
        CumulativeGpa /=(TotalCreditHours-RTotalCreditHours);
    }
    public float GetFinalgrade(){
        float total=0;
        for (StudentCourse s:Courselist){
            total+=s.CourseGrade.TotalGrade;
        }
        return total;
    }
    public float GetFinalGpa(){
        float total=0;
        for (StudentCourse s:Courselist){
            total+=s.GetWeight();
        }
        total/=CreditHours;
        return total;
    }

}
