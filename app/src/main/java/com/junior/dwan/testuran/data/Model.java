package com.junior.dwan.testuran.data;

import android.util.Log;

import java.util.Date;

/**
 * Created by Might on 28.12.2016.
 */

public class Model {
    private enum FileType {image, pdf, movie, music, doc, none}
    private String filename;
    private boolean isFolder;
    private Date modDate;
    private FileType mFileType = FileType.image;
    private boolean isOrange;
    private boolean isBlue;

    public Model(String filename, boolean isFolder, Date modDate, boolean isOrange, boolean isBlue, String fileType) {
        this.filename = filename;
        this.isFolder = isFolder;
        this.modDate = modDate;
        this.isOrange = isOrange;
        this.isBlue = isBlue;
        this.mFileType = FileType.valueOf(fileType);
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public boolean isFolder() {
        return isFolder;
    }

    public void setFolder(boolean folder) {
        isFolder = folder;
    }

    public Date getModDate() {
        return modDate;
    }

    public void setModDate(Date modDate) {
        this.modDate = modDate;
    }

    public boolean isOrange() {
        return isOrange;
    }

    public void setOrange(boolean orange) {
        isOrange = orange;
    }

    public boolean isBlue() {
        return isBlue;
    }

    public void setBlue(boolean blue) {
        isBlue = blue;
    }

    public String checkFileType(){
        Log.i("TAG","file type = "+ mFileType.name()+" "+mFileType.ordinal()+" ");
        return mFileType.name();
    }
}
