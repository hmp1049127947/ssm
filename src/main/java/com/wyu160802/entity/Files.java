package com.wyu160802.entity;

import java.io.Serializable;

/**
 * @author 黄明潘
 * @date 2019/10/5-16:12
 */
public class Files implements Serializable {
    private Integer id;
    private String fileName;
    private String fileTitle;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileTitle() {
        return fileTitle;
    }

    public void setFileTitle(String fileTitle) {
        this.fileTitle = fileTitle;
    }

    @Override
    public String toString() {
        return "Files{" +
                "id=" + id +
                ", fileName='" + fileName + '\'' +
                ", fileTitle='" + fileTitle + '\'' +
                '}';
    }
}
