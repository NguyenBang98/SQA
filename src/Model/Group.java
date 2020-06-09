package Model;

import java.time.*;

public class Group {

    private int groupID;
    private Room room;
    private Subject subject;
    private String day;
    private String hour1;
    private String hour2;
    private String week;

    public Group() {
    }

    public Group(int groupID, Room room, Subject subject, String day, String hour1, String hour2, String week) {
        this.groupID = groupID;
        this.room = room;
        this.subject = subject;
        this.day = day;
        this.hour1 = hour1;
        this.hour2 = hour2;
        this.week = week;
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

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Group) {
            Group g2 = (Group) obj;
            if (this.getGroupID() == g2.getGroupID()
                    && this.getSubject().equals(g2.getSubject())
                    && this.getRoom().equals(g2.getRoom())
                    && this.getDay().equals(g2.getDay())
                    && this.getHour1().equals(g2.getHour1())
                    && this.getHour2().equals(g2.getHour2())
                    && this.getWeek().equals(g2.getWeek()))  {
                return true;
            }
            if(this.getGroupID() == g2.getGroupID()
                    && this.getSubject().equals(g2.getSubject())){
                return true;
            }
            if(this.getDay().equals(g2.getDay())
                    && this.getHour1().equals(g2.getHour1())
                    && this.getHour2().equals(g2.getHour2())){
                return true;
            }

        }
        return false;

    }
}
