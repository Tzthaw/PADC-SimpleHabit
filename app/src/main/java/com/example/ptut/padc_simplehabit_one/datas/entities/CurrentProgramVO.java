package com.example.ptut.padc_simplehabit_one.datas.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;

@Entity(tableName = "currentProgram", indices = {@Index(value = {"current-session-id"},
        unique = true)},
        foreignKeys = @ForeignKey(entity = SessionVO.class,
                parentColumns = "session-id", childColumns = "current-session-id"))
public class CurrentProgramVO implements HomeScreenVO {
    @PrimaryKey
    @SerializedName("program-id")
    @ColumnInfo(name = "program-id")
    @NonNull
    String programId;

    @ColumnInfo(name = "title")
    String title;

    @ColumnInfo(name = "current_period")
    String currentPeriod;

    @ColumnInfo(name = "background")
    String Background;

    @Ignore
    @ColumnInfo(name = "average-lengths")
    int[] avgLength;

    @ColumnInfo(name = "description")
    String description;

    @ColumnInfo(name = "current-session-id")
    String currentSessionId;

    @Ignore
    @ColumnInfo(name = "sessions")
    public List<SessionVO> sessions;


    public String getCurrentSessionId() {
        return currentSessionId;
    }

    public void setCurrentSessionId(String currentSessionId) {
        this.currentSessionId = currentSessionId;
    }

    public List<SessionVO> getSessions() {
        return sessions;
    }

    public void setSessions(List<SessionVO> sessions) {
        this.sessions = sessions;
    }

    public String getProgramId() {
        return programId;
    }

    public void setProgramId(String programId) {
        this.programId = programId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCurrentPeriod() {
        return currentPeriod;
    }

    public void setCurrentPeriod(String currentPeriod) {
        this.currentPeriod = currentPeriod;
    }

    public String getBackground() {
        return Background + "www.oho.com/sites/default/files/styles/large_photo__960w_/public/insights/rocket-night.jpg?itok=i0kFPmO_";
    }

    public void setBackground(String background) {
        Background = background;
    }

    public int[] getAvgLength() {
        return avgLength;
    }

    public void setAvgLength(int[] avgLength) {
        this.avgLength = avgLength;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "CurrentProgramVO{" +
                "programId='" + programId + '\'' +
                ", title='" + title + '\'' +
                ", currentPeriod='" + currentPeriod + '\'' +
                ", Background='" + Background + '\'' +
                ", avgLength=" + Arrays.toString(avgLength) +
                ", description='" + description + '\'' +
                ", currentSessionId='" + currentSessionId + '\'' +
                ", sessions=" + sessions +
                '}';
    }
}
