package entity.transfer;

/**
 * Created by tianxing on 16/11/4.
 * 一条学生回复的老师评论
 */
public class Comment {


    private String replyID;//学生回复ID
    private int score;//分数
    private String content;//评语


    public String getReplyID() {
        return replyID;
    }

    public int getScore() {
        return score;
    }

    public String getContent() {
        return content;
    }
}
