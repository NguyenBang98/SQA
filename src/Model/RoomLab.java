package Model;

public class RoomLab {

    private int roomID;
    private String nameRoom;

    public RoomLab(int roomID, String nameRoom) {
        this.roomID = roomID;
        this.nameRoom = nameRoom;
    }

    public RoomLab() {
    }

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public String getNameRoom() {
        return nameRoom;
    }

    public void setNameRoom(String nameRoom) {
        this.nameRoom = nameRoom;
    }

}
