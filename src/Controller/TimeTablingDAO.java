package Controller;

import Model.Group;
import Model.GroupLab;
import Model.Room;
import Model.RoomLab;
import Model.Subject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TimeTablingDAO {

    private static Connection conn;

    public TimeTablingDAO() {
        if (conn == null) {
            try {
                Class.forName(Utils.Parameters.dbClass);
                conn = DriverManager.getConnection(Utils.Parameters.dbUrl, Utils.Parameters.userName, Utils.Parameters.password);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<Subject> listSubject() {
        ArrayList<Subject> result = new ArrayList<Subject>();
        String sql = "SELECT * FROM subject";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Subject subject = new Subject();
                subject.setSubjectID(rs.getString("SubjectID"));
                subject.setName(rs.getString("Name"));
                subject.setCredits(rs.getInt("Credit"));
                result.add(subject);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public ArrayList<Room> listRoom() {
        ArrayList<Room> result = new ArrayList<Room>();
        String sql = "SELECT * FROM room";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Room room = new Room();
                room.setRoomID(rs.getInt("RoomID"));
                room.setNameRoom(rs.getString("NameRoom"));
                result.add(room);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public ArrayList<RoomLab> listRoomLab() {
        ArrayList<RoomLab> result = new ArrayList<RoomLab>();
        String sql = "SELECT * FROM roomlab";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                RoomLab roomLab = new RoomLab();
                roomLab.setRoomLabID(rs.getInt("RoomLabID"));
                roomLab.setNameRoomLab(rs.getString("NameRoomLab"));
                result.add(roomLab);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public ArrayList<Group> listGroup() {
        ArrayList<Group> result = new ArrayList<Group>();
        String sql = "SELECT * FROM groups_subject";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Group group = new Group();
                GroupDAO dao = new GroupDAO();
                group.setGroupID(rs.getInt("GroupID"));
                group.setSubject(dao.searchSubjectID(rs.getString("SubjectID")));
                group.setRoom(dao.searchroomID(rs.getInt("RoomID")));
                group.setDay(rs.getString("Days"));
                group.setHour1(rs.getString("hour1"));
                group.setHour2(rs.getString("hour2"));
                result.add(group);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public ArrayList<GroupLab> listGroupLab() {
        ArrayList<GroupLab> result = new ArrayList<GroupLab>();
        String sql = "SELECT * FROM grouplab";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                GroupLab grouplab = new GroupLab();
                GroupDAO dao = new GroupDAO();
                grouplab.setTeam(rs.getInt("team"));
                grouplab.setGroupID(rs.getInt("GroupID"));
                grouplab.setSubject(dao.searchSubjectID(rs.getString("SubjectID")));
                grouplab.setRoomLab(dao.searchroomLabID(rs.getInt("RoomLabID")));
                grouplab.setDay(rs.getString("Days"));
                grouplab.setHour(rs.getString("hour1"));
                result.add(grouplab);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
