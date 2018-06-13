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

@Entity(tableName = "categoriesPrograms",indices = {@Index("category-program-id")},
        foreignKeys = @ForeignKey(entity = ProgramVO.class,
        parentColumns = "program-id",
        childColumns = "category-program-id",
        onDelete = CASCADE))
public class CategoriesProgramVO implements HomeScreenVO {

    @PrimaryKey
    @NonNull
    @SerializedName("category-id")
    @ColumnInfo(name = "category-id")
    String categoryVoId;

    @ColumnInfo(name = "title")
    String title;

    @ColumnInfo(name = "category-program-id")
    String categoryProgramId;

    @Ignore
    @ColumnInfo(name = "programs")
    List<ProgramVO> programs;

    public String getCategoryProgramId() {
        return categoryProgramId;
    }

    public void setCategoryProgramId(String categoryProgramId) {
        this.categoryProgramId = categoryProgramId;
    }

    public List<ProgramVO> getPrograms() {
        return programs;
    }

    public void setPrograms(List<ProgramVO> programs) {
        this.programs = programs;
    }

    public String getCategoryVoId() {
        return categoryVoId;
    }

    public void setCategoryVoId(String categoryVoId) {
        this.categoryVoId = categoryVoId;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}


