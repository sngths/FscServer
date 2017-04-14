package com.tianxing.pojo.assignemnt;

/**
 * Created by tianxing on 16/9/12.
 * 上传的图片信息
 */
public class Image extends FileUploaded{



    private String thumbnailUrl ;

    private Integer height ;
    private Integer width;

    private Integer thumbnailHeight ;
    private Integer thumbnailWidth;





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

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }


}
