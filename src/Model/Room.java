package Model;

public class Room {

    private String roomID;
    private String nameRoom;
    private static final int MAX_CAPACITY = 60;

    public Room(String roomID, String nameRoom) {
        this.roomID = roomID;
        this.nameRoom = nameRoom;
    }

    public Room() {
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public String getNameRoom() {
        return nameRoom;
    }

    public void setNameRoom(String nameRoom) {
        this.nameRoom = nameRoom;
    }

}
