package com.example.ptut.padc_simplehabit_one.database.daos;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.example.ptut.padc_simplehabit_one.database.daos.base.BaseDao;
import com.example.ptut.padc_simplehabit_one.datas.entities.TopicVO;

import java.util.List;

@Dao
public interface TopicDao extends BaseDao<TopicVO> {

    @Query("SELECT * FROM topics")
    LiveData<List<TopicVO>> loadAllTopicData();

    @Query("DELETE FROM topics")
    void deleteAllTopics();
}
