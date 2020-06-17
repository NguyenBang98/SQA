package Controller;

import Model.GroupLab;
import Model.RoomLab;
import Model.Subject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GroupLabDAO {

    Connection conn;

    public GroupLabDAO() {
        if (conn == null) {
            try {
                Class.forName(Utils.Parameters.dbClass);
                conn = DriverManager.getConnection(Utils.Parameters.dbUrl, Utils.Parameters.userName, Utils.Parameters.password);
            } catch (ClassNotFoundException | SQLException e) {
            }
        }
    }

    public void deleteGroupLab(int team, int GroupID) {
        String sql = "DELETE FROM grouplab WHERE team = ? AND codelab = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, team);
            ps.setInt(2, GroupID);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }
    
    public void updateGroupLab(){
        
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
    
    public Subject searchSubject(String key) {
        Subject result = new Subject();
        String sql = "SELECT * FROM subject WHERE Name = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, key);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                result.setSubjectID(rs.getString("SubjectID"));
                result.setName(rs.getString("Name"));
                result.setCredits(rs.getInt("Credit"));
            }
        } catch (SQLException e) {
        }
        return result;
    }
    
    public Subject searchSubjectID(String key) {
        Subject result = new Subject();
        String sql = "SELECT * FROM subject WHERE SubjectID = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, key);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result.setSubjectID(rs.getString("SubjectID"));
                result.setName(rs.getString("Name"));
                result.setCredits(rs.getInt("Credit"));
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
                grouplab.setRoomLab(searchroomLabID(rs.getInt("RoomLabID")));
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
                grouplab.setRoomLab(searchroomLabID(rs.getInt("RoomLabID")));
                grouplab.setDay(rs.getString("Days"));
                grouplab.setHour(rs.getString("hour1"));
                grouplab.setWeek(rs.getString("week"));
                result.add(grouplab);
            }
        } catch (SQLException e) {
        }
        return result;
    }

    public void saveGroupLab(GroupLab lab) {
        String sql = "INSERT INTO group(team, GroupID, SubjectID, RoomLabID, Days, hour1, week) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, lab.getTeam());
            ps.setInt(2, lab.getGroupID());
            ps.setString(3, lab.getSubject().getSubjectID());
            ps.setInt(4, lab.getRoomLab().getRoomLabID());
            ps.setString(5, lab.getDay());
            ps.setString(6, lab.getHour());
            ps.setString(7, lab.getWeek());
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public RoomLab searchroomLab(String key) {
        RoomLab result = new RoomLab();
        String sql = "SELECT * FROM roomlab WHERE NameRoomLab = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + key + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result.setRoomLabID(rs.getInt("RoomLabID"));
                result.setNameRoomLab(rs.getString("NameRoomLab"));
            }
        } catch (SQLException e) {
        }
        return result;
    }

    public RoomLab searchroomLabID(int key) {
        RoomLab result = new RoomLab();
        String sql = "SELECT * FROM roomlab WHERE RoomLabID = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, key);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result.setRoomLabID(rs.getInt("RoomLabID"));
                result.setNameRoomLab(rs.getString("NameRoomLab"));
            }
        } catch (SQLException e) {
        }
        return result;
    }

}