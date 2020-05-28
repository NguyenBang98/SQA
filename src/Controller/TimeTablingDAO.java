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
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TimeTablingDAO {

    private static Connection conn;

    public TimeTablingDAO() {
        if (conn == null) {
            try {
                Class.forName(Utils.Parameters.dbClass);
                conn = DriverManager.getConnection(Utils.Parameters.dbUrl, Utils.Parameters.userName, Utils.Parameters.password);
            } catch (ClassNotFoundException | SQLException e) {
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
        } catch (SQLException e) {
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
        } catch (SQLException e) {
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
        } catch (SQLException e) {
        }
        return result;
    }

    public Group[] listGroup() {
        Group[] result = null;
        String sql = "SELECT * FROM groups_subject";
        GroupDAO dao;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.last()) {
                result = new Group[rs.getRow()];
                rs.beforeFirst();
            }
            int count = 0;
            while (rs.next()) {
                dao = new GroupDAO();
                result[count] = new Group(rs.getInt(1), dao.searchroomID(rs.getInt(3)), dao.searchSubjectID(rs.getString(2)), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                count++;
            }
        } catch (Exception e) {
        }
        return result;
    }
    
    public Group[] searchGroupBySubjectID(String key){
        Group[] result = null;
        String sql = "SELECT * FROM groups_subject WHERE SubjectID = ?";
        GroupDAO dao;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, key);
            ResultSet rs = ps.executeQuery();
            if (rs.last()) {
                result = new Group[rs.getRow()];
                rs.beforeFirst();
            }
            int count = 0;
            while(rs.next()){
                dao = new GroupDAO();
                result[count] = new Group(rs.getInt(1), dao.searchroomID(rs.getInt(3)), dao.searchSubjectID(rs.getString(2)), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                count++;
            }
        } catch (SQLException e) {
        }
        return result;
    }

//    public ArrayList<Group> searchGroupBySubjectID1(String key) {
//        ArrayList<Group> result = new ArrayList<>();
//        String sql = "SELECT * FROM groups_subject WHERE SubjectID LIKE ?";
//        try {
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setString(1, key);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                GroupDAO dao = new GroupDAO();
//                Group group = new Group();
//                group.setGroupID(rs.getInt(1));
//                group.setSubject(dao.searchSubjectID(rs.getString(3)));
//                group.setRoom(dao.searchroomID(rs.getInt(2)));
//                result.add(group);
//            }
//        } catch (SQLException e) {
//        }
//        return result;
//    }

    public ArrayList<GroupLab> listGroupLab(String key) {
        ArrayList<GroupLab> result = new ArrayList<GroupLab>();
        String sql = "SELECT * FROM grouplab WHERE SubjectID = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, key);
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
                grouplab.setWeek(rs.getString("week"));
                result.add(grouplab);
            }
        } catch (SQLException e) {
        }
        return result;
    }

    public ArrayList<GroupLab> searchGroupLab() {
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
                grouplab.setWeek(rs.getString("week"));
                result.add(grouplab);
            }
        } catch (SQLException e) {
        }
        return result;
    }

}
