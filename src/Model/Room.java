package Model;

public class Room {

    private String roomID;
    private static final int MAX_CAPACITY = 60;

    public Room(String roomID) {
        this.roomID = roomID;
    }

    public Room() {
        
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

}
