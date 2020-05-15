package Model;

public class Room {

    private int roomID;
    private String nameRoom;

    public Room(int roomID, String nameRoom) {
        this.roomID = roomID;
        this.nameRoom = nameRoom;
    }

    public Room() {
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

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Room) {
            Room r = (Room) obj;
            if (this.getRoomID() == r.getRoomID()
                    && this.getNameRoom().equals(r.getNameRoom())) {
                return true;
            }
        }
        return false;
    }

}
