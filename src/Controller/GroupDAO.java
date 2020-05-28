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
        String sql = "INSERT INTO groups_subject(GroupID, SubjectID, RoomID, Days, hour1, hour2, weeks) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, group.getGroupID());
            ps.setString(2, group.getSubject().getSubjectID());
            ps.setInt(3, group.getRoom().getRoomID());
            ps.setString(4, group.getDay());
            ps.setString(5, group.getHour1());
            ps.setString(6, group.getHour2());
            ps.setString(7, group.getWeek());
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public void saveGroupLab(GroupLab lab) {
        String sql = "INSERT INTO group(team, GroupID, SubjectID, RoomLabID, Days, hour1, week) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql);
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

    public Subject searchSubject(String key) {
        Subject result = new Subject();
        String sql = "SELECT * FROM subject WHERE Name = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
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
            PreparedStatement ps = con.prepareStatement(sql);
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

    public Room searchroom(String key) {
        Room result = new Room();
        String sql = "SELECT * FROM room WHERE NameRoom LIKE ?";

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

    public Room searchroomID(int key) {
        Room result = new Room();
        String sql = "SELECT * FROM room WHERE RoomID = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, key);
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
        String sql = "SELECT * FROM roomlab WHERE NameRoomLab = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
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
            PreparedStatement ps = con.prepareStatement(sql);
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

    public void deleteGroup(int GroupID) {
        String sql = "DELETE FROM groups_subject WHERE GroupID = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, GroupID);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public void deleteGroupLab(int team, int GroupID) {
        String sql = "DELETE FROM grouplab WHERE team = ? AND GroupID = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, team);
            ps.setInt(2, GroupID);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public void updateGroup(Group group) {
        String sql = "UPDATE groups_subject SET ";
    }

    public void updateGroupLab(GroupLab lab) {
        String sql = "UPDATE grouplab SET";
    }

}
