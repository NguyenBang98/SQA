package Model;

import java.time.LocalDateTime;

public class GroupLab {

    private int groupID;
    private int team;
    private RoomLab roomLab;
    private Subject subject;
    private String day;
    private String hour1;
    private String hour2;

    public GroupLab(int groupID, int team, RoomLab roomLab, Subject subject, String day, String hour1, String hour2) {
        this.groupID = groupID;
        this.team = team;
        this.roomLab = roomLab;
        this.subject = subject;
        this.day = day;
        this.hour1 = hour1;
        this.hour2 = hour2;
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
