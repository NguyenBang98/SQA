package Model;

public class RoomLab {

    private String roomID;
    private String nameRoom;

    public RoomLab(String roomID, String nameRoom) {
        this.roomID = roomID;
        this.nameRoom = nameRoom;
    }

    public RoomLab() {
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
