package Model;

import java.time.*;

public class Group {

    private int groupID;
    private Room room;
    private Subject subject;
    private LocalDateTime day;

    public Group() {
    }

    public Group(Room room, Subject subject, int groupID, LocalDateTime day) {
        this.room = room;
        this.subject = subject;
        this.groupID = groupID;
        this.day = day;
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

    public LocalDateTime getDay() {
        return day;
    }

    public void setDay(LocalDateTime day) {
        this.day = day;
    }

}
