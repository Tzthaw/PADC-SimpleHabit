package com.example.ptut.padc_simplehabit_one.datas.entities;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "topics")
public class TopicVO implements HomeScreenVO {

    @PrimaryKey
    @SerializedName("topic-name")
    @ColumnInfo(name = "topic-name")
    @NonNull
    String topicName;
    @ColumnInfo(name = "topic-desc")
    String topicDesc;
    @ColumnInfo(name = "icon")
    String image;
    @ColumnInfo(name = "background")
    String backgroundImg;


    @NonNull
    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(@NonNull String topicName) {
        this.topicName = topicName;
    }

    public String getTopicDesc() {
        return topicDesc;
    }

    public void setTopicDesc(String topicDesc) {
        this.topicDesc = topicDesc;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getBackgroundImg() {
        return backgroundImg;
    }

    public void setBackgroundImg(String backgroundImg) {
        this.backgroundImg = backgroundImg;
    }
}
