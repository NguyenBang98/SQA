package Model;

import java.time.LocalDateTime;

public class GroupLab {
    
    private int groupID;
    private int team;
    private RoomLab roomLab;
    private Subject subject;
    private String day;
    private String hour;
    private String week;

    public GroupLab( int groupID, int team, RoomLab roomLab, Subject subject, String day, String hour, String week) {
        this.groupID = groupID;
        this.team = team;
        this.roomLab = roomLab;
        this.subject = subject;
        this.day = day;
        this.hour = hour;
        this.week = week;
    }

    public GroupLab() {
    }

    public int getGroupID() {
        return groupID;
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }

    public int getTeam() {
        return team;
    }

    public void setTeam(int team) {
        this.team = team;
    }

    public RoomLab getRoomLab() {
        return roomLab;
    }

    public void setRoomLab(RoomLab roomLab) {
        this.roomLab = roomLab;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
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

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof GroupLab) {
            GroupLab lab2 = (GroupLab) obj;
            if (this.getGroupID() == lab2.getGroupID()
                    && this.getSubject().equals(lab2.getSubject())
                    && this.getRoomLab().equals(lab2.getRoomLab())
                    && this.getTeam() == lab2.getTeam()
                    && this.getDay().equals(lab2.getDay())
                    && this.getHour().equals(lab2.getHour())
                    && this.getWeek().equals(lab2.getWeek())) {
                return true;
            }
        }
        return false;
    }

}
