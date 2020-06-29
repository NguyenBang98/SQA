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

    public void deleteGroupLab(int team, int GroupID, String SubjectID) {
        String sql = "DELETE FROM grouplab WHERE team = ? AND GroupID = ? AND SubjectID = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, team);
            ps.setInt(2, GroupID);
            ps.setString(3, SubjectID);
            ps.executeUpdate();
        } catch (SQLException e) {
        }
    }
    
    public void updateGroupLab(GroupLab lab){
        String sql = "UPDATE groups_lab SET RoomLabID = ?, Days = ?, hour1 = ? WHERE GroupID = ? AND SubjectID = ? AND team = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, lab.getRoomLab().getRoomLabID());
            ps.setString(2, lab.getDay());
            ps.setString(3, lab.getHour());
            ps.setInt(6, lab.getTeam());
            ps.setInt(4, lab.getGroupID());
            ps.setString(5, lab.getSubject().getSubjectID());
            
            ps.executeUpdate();
        } catch (Exception e) {
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

    public GroupLab[] listGroupLab(String key) {
        GroupLab[] result = null;
        String sql = "SELECT * FROM grouplab WHERE SubjectID = ?";
        GroupLabDAO dao;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, key);
            ResultSet rs = ps.executeQuery();
            if (rs.last()) {
                result = new GroupLab[rs.getRow()];
                rs.beforeFirst();
            }
            int count = 0;
            while (rs.next()) {
                dao = new GroupLabDAO();
                result[count] = new GroupLab(rs.getInt("GroupID"), rs.getInt("team"),
                        dao.searchroomLabID(rs.getInt("RoomLabID")), dao.searchSubjectID(rs.getString("SubjectID")),
                        rs.getString("Days"), rs.getString("hour"), rs.getString("week"));
                count++;
            }
        } catch (Exception e) {
        }
        return result;
    }
    
    public GroupLab[] listGroupLabID(String key, int team, int id) {
        GroupLab[] result = null;
        String sql = "SELECT * FROM grouplab WHERE SubjectID = ? AND team = ? AND GroupID = ?";
        GroupLabDAO dao;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, key);
            ps.setInt(2, team);
            ps.setInt(3, id);
            ResultSet rs = ps.executeQuery();
            if (rs.last()) {
                result = new GroupLab[rs.getRow()];
                rs.beforeFirst();
            }
            int count = 0;
            while (rs.next()) {
                dao = new GroupLabDAO();
                result[count] = new GroupLab(rs.getInt("GroupID"), rs.getInt("team"),
                        dao.searchroomLabID(rs.getInt("RoomLabID")), dao.searchSubjectID(rs.getString("SubjectID")),
                        rs.getString("Days"), rs.getString("hour"), rs.getString("week"));
                count++;
            }
        } catch (Exception e) {
        }
        return result;
    }

    public GroupLab[] searchGroupLab() {
        GroupLab[] result = null;
        String sql = "SELECT * FROM grouplab";
        GroupLabDAO dao;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.last()) {
                result = new GroupLab[rs.getRow()];
                rs.beforeFirst();
            }
            int count = 0;
            while (rs.next()) {
                dao = new GroupLabDAO();
                result[count] = new GroupLab(rs.getInt("GroupID"), rs.getInt("team"),
                        dao.searchroomLabID(rs.getInt("RoomLabID")), dao.searchSubjectID(rs.getString("SubjectID")),
                        rs.getString("Days"), rs.getString("hour"), rs.getString("week"));
                count++;
            }
        } catch (Exception e) {
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
            ps.setString(1, key);
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
