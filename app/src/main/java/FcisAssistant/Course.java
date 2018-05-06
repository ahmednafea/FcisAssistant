package FcisAssistant;
import java.util.Vector;

public class Course {
    protected String Code;
    protected String Name;
    protected String InstructorofCourse;
    protected Vector<String> TAlist;
    protected int CreditHours;
    protected int image;

    public Course() {
        Code=null;
        Name=null;
        InstructorofCourse=null;
        CreditHours=0;
        image=0;
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

    public int getCreditHours() {
        return CreditHours;
    }

    public void setCreditHours(int creditHours) {
        CreditHours = creditHours;
    }


    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

}
