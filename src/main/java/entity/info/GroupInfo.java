package entity.info;

/**
 * Created by tianxing on 16/9/8.
 * 群组信息
 */
public class GroupInfo {
    private String roomName = "";
    private String roomTitle = "";//房间标题

    public String getRoomName() {
        return roomName;
    }

    public String getRoomTitle() {
        return roomTitle;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public void setRoomTitle(String roomTitle) {
        this.roomTitle = roomTitle;
    }
}
