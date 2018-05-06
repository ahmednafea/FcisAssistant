package FcisAssistant;
import java.util.Map;
import java.util.Vector;

public class InstructorCourse extends Course {
    protected Vector<String> Studentlist;
    protected Vector<GPA> GradesPercentage;
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
               if(s.Code.equals(this.Code)){
                   s.CourseGrade.setGPA();
                   switch (s.CourseGrade.GPA) {
                       case "A":
                           GradesPercentage.elementAt(0).Count++;
                           break;
                       case "A-":
                           GradesPercentage.elementAt(1).Count++;
                           break;
                       case "B+":
                           GradesPercentage.elementAt(2).Count++;
                           break;
                       case "B":
                           GradesPercentage.elementAt(3).Count++;
                           break;
                       case "B-":
                           GradesPercentage.elementAt(4).Count++;
                           break;
                       case "C+":
                           GradesPercentage.elementAt(5).Count++;
                           break;
                       case "C":
                           GradesPercentage.elementAt(6).Count++;
                           break;
                       case "C-":
                           GradesPercentage.elementAt(7).Count++;
                           break;
                       case "D+":
                           GradesPercentage.elementAt(8).Count++;
                           break;
                       case "F":
                           GradesPercentage.elementAt(9).Count++;
                           break;
                   }
               }
           }

       }
   }
}
