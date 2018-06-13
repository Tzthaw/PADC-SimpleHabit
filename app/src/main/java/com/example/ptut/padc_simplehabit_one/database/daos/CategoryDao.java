package com.example.ptut.padc_simplehabit_one.database.daos;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.example.ptut.padc_simplehabit_one.database.daos.base.BaseDao;
import com.example.ptut.padc_simplehabit_one.datas.entities.CategoriesProgramVO;

import java.util.List;

@Dao
public interface CategoryDao extends BaseDao<CategoriesProgramVO> {


    @Query("SELECT * FROM categoriesPrograms")
    LiveData<List<CategoriesProgramVO>> loadAllCategory();

    @Query("DELETE FROM categoriesPrograms")
    void deleteAllCateogryData();


}

