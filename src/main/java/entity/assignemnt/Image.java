package entity.assignemnt;

/**
 * Created by tianxing on 16/9/12.
 * 上传的图片信息
 */
public class Image {

    private String name = "";
    private String url = "";

    private String date;
    private String thumbnailUrl = "";

    private Integer height ;
    private Integer width;

    private Integer thumbnailHeight ;
    private Integer thumbnailWidth;

    private Long FileSize;


    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public void setThumbnailHeight(Integer thumbnailHeight) {
        this.thumbnailHeight = thumbnailHeight;
    }

    public void setThumbnailWidth(Integer thumbnailWidth) {
        this.thumbnailWidth = thumbnailWidth;
    }

    public void setFileSize(Long fileSize) {
        FileSize = fileSize;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getDate() {
        return date;
    }

    public Integer getHeight() {
        return height;
    }

    public Integer getThumbnailHeight() {
        return thumbnailHeight;
    }

    public Integer getThumbnailWidth() {
        return thumbnailWidth;
    }

    public Integer getWidth() {
        return width;
    }

    public Long getFileSize() {
        return FileSize;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }


}
