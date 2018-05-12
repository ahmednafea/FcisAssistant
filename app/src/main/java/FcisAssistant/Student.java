package FcisAssistant;
import android.view.View;

import com.abamed.fcisassistant.InstructorFragments.InstructorProfile;

import java.util.ArrayList;
import java.util.Vector;
import java.util.zip.Inflater;

public class Student extends Person {
    protected long CreditHours;
    protected long RCreditHours;
    protected String AcademicYear;
    protected String Department;
    protected ArrayList<StudentCourse> Courselist;
    protected float CumulativeGpa;
    protected long TotalCreditHours;
    protected long RTotalCreditHours;
    public Student(){
        ID="0";
        Name="No Name";
        Gender="No gender";
        Email="No Email";
        Password="No Password";
        CreditHours=0;
        RCreditHours=21;
        AcademicYear="None";
        Department="None";
        TotalCreditHours=144;
        RTotalCreditHours=0;
        Courselist=new ArrayList<>();
        InsertCourse(new StudentCourse());
    }


    public Student(String id ,String name,String gender,String email,String password ,String academicYear,String department,
                   int rTotalCreditHours){
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

    public ArrayList<StudentCourse> getCourselist() {
        return Courselist;
    }

    public void setCourselist(ArrayList<StudentCourse> courselist) {
        Courselist = courselist;
    }

    public long getCreditHours() {
        return CreditHours;
    }

    public void setCreditHours(long creditHours) {
        CreditHours = creditHours;
    }

    public long getRCreditHours() {
        return RCreditHours;
    }

    public void setRCreditHours(long RCreditHours) {
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

    public long getTotalCreditHours() {
        return TotalCreditHours;
    }

    public void setTotalCreditHours(long totalCreditHours) {
        TotalCreditHours = totalCreditHours;
    }

    public long getRTotalCreditHours() {
        return RTotalCreditHours;
    }

    public void setRTotalCreditHours(long RTotalCreditHours) {
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
    @Override
    public void EditPassword(String password){
        setPassword(password);
    }
    @Override
    public void EditEmail(String email){
        setEmail(email);
    }
}
