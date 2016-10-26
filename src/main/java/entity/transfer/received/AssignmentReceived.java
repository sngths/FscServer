package entity.transfer.received;

/**
 * Created by tianxing on 16/10/26.
 * 从客户端收到的发布作业
 */
public class AssignmentReceived {

    private String title = "";

    private String content = "";
    private String image;


    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getImage() {
        return image;
    }
}
