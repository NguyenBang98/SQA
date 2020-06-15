package Controller;

import Model.Group;
import Model.GroupLab;
import Model.Room;
import Model.RoomLab;
import Model.Subject;
import java.sql.*;
import java.util.ArrayList;

public class GroupDAO {

    Connection con;

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
    
    public ArrayList<Subject> listSubject() {
        ArrayList<Subject> result = new ArrayList<Subject>();
        String sql = "SELECT * FROM subject";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
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
            PreparedStatement ps = con.prepareStatement(sql);
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
    
    public Group[] listGroup() {
        Group[] result = null;
        String sql = "SELECT * FROM groups_subject";
        GroupDAO dao;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
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
    
    public Group[] searchGroupBySubjectID(String key) {
        Group[] result = null;
        String sql = "SELECT * FROM groups_subject WHERE SubjectID = ?";
        GroupDAO dao;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, key);
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
        } catch (SQLException e) {
        }
        return result;
    }
    
    public Group searchGroupBySubjectIDAndGroupID(String key1, int key2) throws SQLException {
        Group result = null;
        String sql = "SELECT * FROM groups_subject WHERE SubjectID = ? AND GroupID = ?";
        GroupDAO dao = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, key1);
            ps.setInt(2, key2);
            ResultSet rs = ps.executeQuery();
            if (rs.last()) {
                result = new Group();
                rs.beforeFirst();
            }
            int count = 0;
            while (rs.next()) {
                dao = new GroupDAO();
                result = new Group(rs.getInt(1), dao.searchroomID(rs.getInt(3)), dao.searchSubjectID(rs.getString(2)), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
                count++;
            }
        } catch (SQLException e) {
        }
        return result;
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

//   

    public void deleteGroup(int GroupID, String SubjectID) {
        String sql = "DELETE FROM groups_subject WHERE GroupID = ? AND SubjectID = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, GroupID);
            ps.setString(2, SubjectID);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }

    public void updateGroup(Group group) {
        String sql = "UPDATE groups_subject SET RoomID = ?, Days = ?, hour1 = ?, hour2 = ? WHERE GroupID = ? AND SubjectID = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, group.getRoom().getRoomID());
            ps.setString(2, group.getDay());
            ps.setString(3, group.getHour1());
            ps.setString(4, group.getHour2());
            ps.setInt(5, group.getGroupID());
            ps.setString(6, group.getSubject().getSubjectID());
            
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }


}
