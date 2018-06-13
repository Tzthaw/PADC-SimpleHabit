package com.example.ptut.padc_simplehabit_one.datas.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(tableName = "programs",indices = {@Index("program-session-id")},
        foreignKeys = @ForeignKey(entity = SessionVO.class,
                parentColumns = "session-id",
                childColumns = "program-session-id", onDelete = CASCADE))
public class ProgramVO {

    @PrimaryKey
    @ColumnInfo(name = "program-id")
    @SerializedName("program-id")
    @NonNull
    String programVoId;
    @ColumnInfo(name = "title")
    String title;
    @ColumnInfo(name = "image")
    String image;
    @Ignore
    @ColumnInfo(name = "average-lengths")
    int[] avgLength;
    @ColumnInfo(name = "description")
    String description;
    @ColumnInfo(name = "program-session-id")
    String programSessionId;
    @Ignore
    @ColumnInfo(name = "sessions")
    List<SessionVO> sessions;

    public String getProgramSessionId() {
        return programSessionId;
    }

    public void setProgramSessionId(String programSessionId) {
        this.programSessionId = programSessionId;
    }

    public List<SessionVO> getSessions() {
        return sessions;
    }

    public void setSessions(List<SessionVO> sessions) {
        this.sessions = sessions;
    }

    public String getProgramVoId() {
        return programVoId;
    }

    public void setProgramVoId(String programVoId) {
        this.programVoId = programVoId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image + "theultralinx.com/.image/c_limit%2Ccs_srgb%2Cfl_progressive%2Cq_auto:good%2Cw_620/MTI5MDI0MjY3MjM2MTg2NTkw/materialdesign7.jpg";
    }

    public void setImage(String image) {
        this.image = image;
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

}
