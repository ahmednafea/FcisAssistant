package com.abamed.fcisassistant;

public class Tableclass {
   private String Name;
    private String Groupe;
    private String Lecturer;
    private String Time;
    private String Day;

    public Tableclass(String name, String groupe, String lecturer, String time, String day) {
        Name = name;
        Groupe = groupe;
        Lecturer = lecturer;
        Time = time;
        Day = day;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getGroupe() {
        return Groupe;
    }

    public void setGroupe(String groupe) {
        Groupe = groupe;
    }

    public String getLecturer() {
        return Lecturer;
    }

    public void setLecturer(String lecturer) {
        Lecturer = lecturer;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getDay() {
        return Day;
    }

    public void setDay(String day) {
        Day = day;
    }
}
