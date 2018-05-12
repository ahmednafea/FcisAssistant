package FcisAssistant;
import java.util.ArrayList;

public class Course {
    protected String code;
    protected String Name;
    protected String InstructorofCourse;
    protected ArrayList<String> TAlist;
    protected long CreditHours;

    public Course(String code, String name, String instructorofCourse, ArrayList<String> TAlist, int creditHours) {
        this.code = code;
        Name = name;
        InstructorofCourse = instructorofCourse;
        this.TAlist = TAlist;
        CreditHours = creditHours;
    }

    public Course() {
        code ="nocodeyet";
        Name="noname";
        InstructorofCourse="notyet";
        CreditHours=0;
        TAlist=new ArrayList<>();
        TAlist.add("NoOne");
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getInstructorofCourse() {
        return InstructorofCourse;
    }

    public void setInstructorofCourse(String instructorId) {
        InstructorofCourse=instructorId;
    }

    public long getCreditHours() {
        return CreditHours;
    }

    public void setCreditHours(long creditHours) {
        CreditHours = creditHours;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }



}
