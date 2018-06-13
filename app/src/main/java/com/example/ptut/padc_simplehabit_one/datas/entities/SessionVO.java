package com.example.ptut.padc_simplehabit_one.datas.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "sessions")
public class SessionVO {

    @PrimaryKey
    @SerializedName("session-id")
    @NonNull
    @ColumnInfo(name = "session-id")
    String sessionId;

    @ColumnInfo(name = "title")
    String title;

    @ColumnInfo(name = "length-in-seconds")
    int LengthTime;

    @ColumnInfo(name = "file-path")
    String filePath;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLengthTime() {
        return LengthTime;
    }

    public void setLengthTime(int lengthTime) {
        LengthTime = lengthTime;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
