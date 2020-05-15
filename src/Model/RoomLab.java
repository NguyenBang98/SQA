package Model;

public class RoomLab {

    private int roomLabID;
    private String nameRoomLab;

    public RoomLab(int roomLabID, String nameRoomLab) {
        this.roomLabID = roomLabID;
        this.nameRoomLab = nameRoomLab;
    }

    public RoomLab() {
    }

    public int getRoomLabID() {
        return roomLabID;
    }

    public void setRoomLabID(int roomLabID) {
        this.roomLabID = roomLabID;
    }

    public String getNameRoomLab() {
        return nameRoomLab;
    }

    public void setNameRoomLab(String nameRoomLab) {
        this.nameRoomLab = nameRoomLab;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof RoomLab){
            RoomLab lab = (RoomLab) obj;
            if(this.getRoomLabID() == lab.getRoomLabID() &&
                    this.getNameRoomLab().equals(lab.getNameRoomLab())){
                return true;
            } 
        }
        return false;
    }
}
