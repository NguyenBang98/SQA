package Model;

import java.time.*;

public class Group {

    private int groupID;
    private Room room;
    private Subject subject;
    private String day;
    private String hour1;
    private String hour2;

    public Group() {
    }

    public Group(int groupID, Room room, Subject subject, String day, String hour1, String hour2) {
        this.groupID = groupID;
        this.room = room;
        this.subject = subject;
        this.day = day;
        this.hour1 = hour1;
        this.hour2 = hour2;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public int getGroupID() {
        return groupID;
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getHour1() {
        return hour1;
    }

    public void setHour1(String hour1) {
        this.hour1 = hour1;
    }

    public String getHour2() {
        return hour2;
    }

    public void setHour2(String hour2) {
        this.hour2 = hour2;
    }
    
    
}
