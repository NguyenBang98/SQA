package Controller;

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
                room.setRoomID(rs.getString("RoomID"));
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
                roomLab.setRoomID(rs.getString("RoomID"));
                roomLab.setNameRoom(rs.getString("NameRoom"));
                result.add(roomLab);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
