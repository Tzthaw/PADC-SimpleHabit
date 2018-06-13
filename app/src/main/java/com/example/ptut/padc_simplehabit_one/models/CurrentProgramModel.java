package com.example.ptut.padc_simplehabit_one.models;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.util.Log;

import com.example.ptut.padc_simplehabit_one.dataAgent.SeriesDataAgentImpl;
import com.example.ptut.padc_simplehabit_one.database.AppDatabase;
import com.example.ptut.padc_simplehabit_one.datas.entities.CategoriesProgramVO;
import com.example.ptut.padc_simplehabit_one.datas.entities.CurrentProgramVO;
import com.example.ptut.padc_simplehabit_one.datas.entities.ProgramVO;
import com.example.ptut.padc_simplehabit_one.datas.entities.SessionVO;
import com.example.ptut.padc_simplehabit_one.datas.entities.TopicVO;
import com.example.ptut.padc_simplehabit_one.events.SeriesEvent;
import com.example.ptut.padc_simplehabit_one.shared.Constant;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;
import de.greenrobot.event.ThreadMode;

public class CurrentProgramModel extends ViewModel {

    private String access_token = Constant.access_token;
    private int page = Constant.page;


    private SeriesDataAgentImpl seriesDataAgentImpl;


    AppDatabase appDatabase;
    public CurrentProgramModel() {
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }

        seriesDataAgentImpl = SeriesDataAgentImpl.getInstance();
        seriesDataAgentImpl.getCurrentProgram(access_token,page);

    }

    public void getCurrentProgram() {
        seriesDataAgentImpl.getCurrentProgram(access_token, page);
    }

    public void getCategories() {
        seriesDataAgentImpl.getCategoriesPrograms(access_token, page);
    }

    public void getTopics() {
        seriesDataAgentImpl.getTopicsData(access_token, page);
    }

    public LiveData<CurrentProgramVO> loadCurrentData(){
        Log.e("CurrentDb",appDatabase.currentProgramDao().getAllCurrent().toString());
        return appDatabase.currentProgramDao().getAllCurrent();
    }

    public void initDatabase(Context context) {

        appDatabase = AppDatabase.getInMemoryDatabase(context);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this);
        }
        AppDatabase.destroyInMemoryDatabase();
    }


    @Subscribe(threadMode = ThreadMode.BackgroundThread)
    public void onCurrentProgramEvent(SeriesEvent.CurrentProgramEvent event) {
        appDatabase.currentProgramDao().deleteAll();
        if (seriesDataAgentImpl == null) {
            seriesDataAgentImpl = SeriesDataAgentImpl.getInstance();
        }

        CurrentProgramVO currentProgramVO=event.getCurrentProgramVO();
        for(SessionVO sessionVO:event.getCurrentProgramVO().getSessions()){
            long sessionIds=appDatabase.sessionDao().insert(sessionVO);
            Log.e("Session Id",sessionIds+"");
            currentProgramVO.setCurrentSessionId(sessionVO.getSessionId());
            long currentIds=appDatabase.currentProgramDao().insert(currentProgramVO);
            Log.e("Current Id",currentIds+"");
        }

        seriesDataAgentImpl.getCategoriesPrograms(access_token,page);
    }

    @Subscribe(threadMode = ThreadMode.BackgroundThread)
    public void OnCategoriesEvent(SeriesEvent.CategoriesProgramEvent event) {
        appDatabase.categoryDao().deleteAllCateogryData();
        if (seriesDataAgentImpl == null) {
            seriesDataAgentImpl = SeriesDataAgentImpl.getInstance();
        }

        for(CategoriesProgramVO categoriesProgramVO:event.getCategoriesProgramVOS()){
            for(ProgramVO programVO:categoriesProgramVO.getPrograms()){
                for(SessionVO sessionVO:programVO.getSessions()){
                    long sessionCid=appDatabase.sessionDao().insert(sessionVO);
                    Log.e("sessionCid",sessionCid+"");
                    programVO.setProgramSessionId(sessionVO.getSessionId());
                }
                long programCid=appDatabase.programDao().insert(programVO);
                Log.e("programCid",programCid+"");
                categoriesProgramVO.setCategoryProgramId(programVO.getProgramVoId());
            }
            long categoryId=appDatabase.categoryDao().insert(categoriesProgramVO);
            Log.e("categoryId",categoryId+"");
        }

        seriesDataAgentImpl.getTopicsData(access_token, page);


    }


    @Subscribe(threadMode = ThreadMode.BackgroundThread)
    public void onTopicItemEvent(SeriesEvent.AllTopicsEvent event) {
        appDatabase.topicDao().deleteAllTopics();
        if (seriesDataAgentImpl == null) {
            seriesDataAgentImpl = SeriesDataAgentImpl.getInstance();
        }
        for(TopicVO topicVO:event.getTopicsItems()){
            long topicId=appDatabase.topicDao().insert(topicVO);
            Log.e("TopicID",topicId+"");
        }

    }


}
