package com.example.ptut.padc_simplehabit_one.database.dbentities;

import android.arch.persistence.room.Relation;

import com.example.ptut.padc_simplehabit_one.datas.entities.CurrentProgramVO;
import com.example.ptut.padc_simplehabit_one.datas.entities.SessionVO;

import java.util.List;

public class CurrentWithSession extends CurrentProgramVO{
    @Relation(entity = SessionVO.class,parentColumn = "current-session-id", entityColumn = "session-id")
    List<SessionVO> sessionVOList;

    public List<SessionVO> getSessionVOList() {
        return sessionVOList;
    }

    public void setSessionVOList(List<SessionVO> sessionVOList) {
        this.sessionVOList = sessionVOList;
    }

    @Override
    public String toString() {
        return "CurrentWithSession{" +
                "sessionVOList=" + sessionVOList +
                '}';
    }
}
