package com.example.ptut.padc_simplehabit_one.database.daos;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.example.ptut.padc_simplehabit_one.database.daos.base.BaseDao;
import com.example.ptut.padc_simplehabit_one.datas.entities.SessionVO;

import java.util.List;

@Dao
public interface SessionDao extends BaseDao<SessionVO> {
    @Query("SELECT * FROM sessions")
    LiveData<List<SessionVO>> loadAllSessions();

    @Query("DELETE FROM sessions")
    void deleteAllSessions();

    @Query("SELECT * FROM sessions where `session-id`=:id")
    List<SessionVO> loadCategoryWithSession(String id);
}
