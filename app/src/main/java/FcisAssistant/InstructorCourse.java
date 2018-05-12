package FcisAssistant;
import java.util.ArrayList;
import java.util.Vector;

public class InstructorCourse extends Course {
    protected ArrayList<String> Studentlist;
    protected ArrayList<GPA> GradesPercentage;

    public InstructorCourse() {
        Studentlist.add("0");
        setTheGradesPercentage();
    }

    public ArrayList<String> getStudentlist() {
        return Studentlist;
    }

    public void setStudentlist(ArrayList<String> studentlist) {
        Studentlist = studentlist;
    }

    public ArrayList<GPA> getGradesPercentage() {
        return GradesPercentage;
    }

    public void setGradesPercentage(ArrayList<GPA> gradesPercentage) {
        GradesPercentage = gradesPercentage;
    }

    public void setTheGradesPercentage(){
       GradesPercentage.clear();
       GradesPercentage.add(new GPA("A",0));
       GradesPercentage.add(new GPA("A-",0));
       GradesPercentage.add(new GPA("B+",0));
       GradesPercentage.add(new GPA("B",0));
       GradesPercentage.add(new GPA("B-",0));
       GradesPercentage.add(new GPA("C+",0));
       GradesPercentage.add(new GPA("C",0));
       GradesPercentage.add(new GPA("C-",0));
       GradesPercentage.add(new GPA("D+",0));
       GradesPercentage.add(new GPA("F",0));
       for(String id:Studentlist) {
           Student student = FirebaseClass.GetStudentInfo(id);
           for (StudentCourse s:student.Courselist){
               if(s.code.equals(this.code)){
                   s.CourseGrade.setGPA();
                   switch (s.CourseGrade.GPA) {
                       case "A":
                           GradesPercentage.get(0).Count++;
                           break;
                       case "A-":
                           GradesPercentage.get(1).Count++;
                           break;
                       case "B+":
                           GradesPercentage.get(2).Count++;
                           break;
                       case "B":
                           GradesPercentage.get(3).Count++;
                           break;
                       case "B-":
                           GradesPercentage.get(4).Count++;
                           break;
                       case "C+":
                           GradesPercentage.get(5).Count++;
                           break;
                       case "C":
                           GradesPercentage.get(6).Count++;
                           break;
                       case "C-":
                           GradesPercentage.get(7).Count++;
                           break;
                       case "D+":
                           GradesPercentage.get(8).Count++;
                           break;
                       case "F":
                           GradesPercentage.get(9).Count++;
                           break;
                   }
               }
           }

       }
   }
}
