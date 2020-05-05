package Model;

import java.time.LocalDateTime;

public class GroupLab {

    private int groupID;
    private int team;
    private RoomLab roomLab;
    private Subject subject;
    private LocalDateTime day;

    public GroupLab(int groupID, int team, RoomLab roomLab, Subject subject, LocalDateTime day) {
        this.groupID = groupID;
        this.team = team;
        this.roomLab = roomLab;
        this.subject = subject;
        this.day = day;
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

    public LocalDateTime getDay() {
        return day;
    }

    public void setDay(LocalDateTime day) {
        this.day = day;
    }

}
