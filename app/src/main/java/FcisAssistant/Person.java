package FcisAssistant;

import android.view.View;

import java.util.Vector;

public abstract class Person  {
    protected String ID;
    protected String Name;
    protected String Gender;
    protected String Email;

    protected String Password;
    public Person(){
        ID=null;
        Name=null;
        Gender=null;
        Email=null;
        Password=null;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }


}
