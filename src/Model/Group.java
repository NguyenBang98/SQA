package Model;

import java.time.*;

public class Group {

    private int groupID;
    private Room room;
    private Subject subject;
    private String day;
    private String hour;

    public Group() {
    }

    public Group(int groupID, Room room, Subject subject, String day, String hour) {
        this.groupID = groupID;
        this.room = room;
        this.subject = subject;
        this.day = day;
        this.hour = hour;
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

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }
}
