package model;

public class Predmet {
    private String day;
    private String start;
    private String end;
    private String zkratka;
    private String name;
    private String type;
    private String room;
    private String teacher;

    public Predmet() {
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getZkratka() {
        return zkratka;
    }

    public void setZkratka(String zkratka) {
        this.zkratka = zkratka;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public Predmet(String day, String start, String end, String zkratka, String name, String type, String room, String teacher) {
        this.day = day;
        this.start = start;
        this.end = end;
        this.zkratka = zkratka;
        this.name = name;
        this.type = type;
        this.room = room;
        this.teacher = teacher;
    }
}
