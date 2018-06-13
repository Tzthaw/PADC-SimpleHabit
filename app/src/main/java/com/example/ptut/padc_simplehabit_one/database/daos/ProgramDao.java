package com.example.ptut.padc_simplehabit_one.database.daos;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.example.ptut.padc_simplehabit_one.database.daos.base.BaseDao;
import com.example.ptut.padc_simplehabit_one.datas.entities.ProgramVO;

import java.util.List;

@Dao
public interface ProgramDao extends BaseDao<ProgramVO> {

    @Query("SELECT * FROM programs")
    LiveData<List<ProgramVO>> getAllPrograms();

    @Query("DELETE FROM programs")
    void deleteAll();

}
