package entity.info;

/**
 * Created by tianxing on 16/9/8.
 * 群组信息
 */
public class GroupInfo {

    private String roomID;
    private String roomName;//房间标题

    public String getRoomID() {
        return roomID;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }
}
