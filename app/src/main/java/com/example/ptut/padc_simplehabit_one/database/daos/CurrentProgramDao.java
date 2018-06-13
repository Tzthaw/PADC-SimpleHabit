package com.example.ptut.padc_simplehabit_one.database.daos;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Transaction;

import com.example.ptut.padc_simplehabit_one.database.daos.base.BaseDao;
import com.example.ptut.padc_simplehabit_one.database.dbentities.CurrentWithSession;
import com.example.ptut.padc_simplehabit_one.datas.entities.CurrentProgramVO;

@Dao
public interface  CurrentProgramDao extends BaseDao<CurrentProgramVO>{


    @Query("SELECT * FROM currentProgram")
    LiveData<CurrentProgramVO> getAllCurrent();

    @Query("DELETE FROM currentProgram")
    void deleteAll();

    @Transaction
    @Query("SELECT * FROM currentProgram INNER JOIN sessions ON `current-session-id`=`session-id`")
    LiveData<CurrentWithSession> getCurrentWithSession();
}


