package Controller;

import Model.Group;
import Model.GroupLab;
import Model.Room;
import Model.RoomLab;
import Model.Subject;
import java.sql.*;
import java.util.ArrayList;

public class GroupDAO {

    private Connection con;

    public GroupDAO() {
        if (con == null) {
            try {
                Class.forName(Utils.Parameters.dbClass);
                con = DriverManager.getConnection(Utils.Parameters.dbUrl, Utils.Parameters.userName, Utils.Parameters.password);
            } catch (ClassNotFoundException | SQLException e) {
            }
        }
    }

    public void saveGroup(Group group) {
        String sql = "INSERT INTO groups_subject(GroupID, SubjectID, RoomID, Days, hour1, hour2) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, group.getGroupID());
            ps.setString(2, group.getSubject().getSubjectID());
            ps.setInt(3, group.getRoom().getRoomID());
            ps.setString(4, group.getDay());
            ps.setString(5, group.getHour1());
            ps.setString(6, group.getHour2());
        } catch (SQLException e) {
        }
    }

    public void saveGroupLab(GroupLab lab) {
        String sql = "INSERT INTO group(team, GroupID, SubjectID, RoomLabID, Days, hour1) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, lab.getTeam());
            ps.setInt(2, lab.getGroupID());
            ps.setString(3, lab.getSubject().getSubjectID());
            ps.setInt(4, lab.getRoomLab().getRoomID());
            ps.setString(5, lab.getDay());
            ps.setString(6, lab.getHour());
            
        } catch (SQLException e) {
        }
    }

    public ArrayList<Group> listGroup() {
        ArrayList<Group> result = new ArrayList<Group>();
        String sql = "SELECT * FROM groups_subject";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Group group = new Group();
                group.setGroupID(rs.getInt("GroupID"));
                String subjectID = rs.getString("SubjectID");
                group.setSubject(searchSubject(subjectID));
                String roomID = rs.getString("RoomID");
                group.setRoom(searchroom(roomID));

                result.add(group);
            }
        } catch (SQLException e) {
        }
        return result;
    }

    public Subject searchSubject(String key) {
        Subject result = new Subject();
        String sql = "SELECT * FROM subject WHERE Name = ?";
        Connection conn = null;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, "%" + key + "%");
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
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + key + "%");
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

    public Room searchroom(String key) {
        Room result = new Room();
        String sql = "SELECT * FROM room WHERE NameRoom = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + key + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result.setRoomID(rs.getInt("RoomID"));
                result.setNameRoom(rs.getString("NameRoom"));
            }
        } catch (SQLException e) {
        }
        return result;
    }
    
    public RoomLab searchroomLab(String key) {
        RoomLab result = new RoomLab();
        String sql = "SELECT * FROM roomlab WHERE NameRoom = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + key + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                result.setRoomID(rs.getInt("RoomLabID"));
                result.setNameRoom(rs.getString("NameRoom"));
            }
        } catch (SQLException e) {
        }
        return result;
    }

}
