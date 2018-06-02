package com.example.ptut.padc_simplehabit_one.models;

import android.content.Context;

import com.example.ptut.padc_simplehabit_one.dataAgent.SeriesDataAgentImpl;
import com.example.ptut.padc_simplehabit_one.datas.entities.CategoriesProgramVO;
import com.example.ptut.padc_simplehabit_one.datas.entities.CurrentProgramVO;
import com.example.ptut.padc_simplehabit_one.datas.entities.HomeScreenVO;
import com.example.ptut.padc_simplehabit_one.datas.entities.ProgramVO;
import com.example.ptut.padc_simplehabit_one.events.SeriesEvent;
import com.example.ptut.padc_simplehabit_one.models.base.BaseModel;
import com.example.ptut.padc_simplehabit_one.shared.Constant;

import java.util.ArrayList;
import java.util.List;

import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;
import de.greenrobot.event.ThreadMode;

public class CurrentProgramModel extends BaseModel {

    private String access_token= Constant.access_token;
    private int page=Constant.page;

    private static CurrentProgramModel currentProgramModel;
     Context context;
    private SeriesDataAgentImpl seriesDataAgentImpl;

    private List<HomeScreenVO> homeScreenVOS=new ArrayList<>();
    private List<CategoriesProgramVO> categoryList;
    private CurrentProgramVO currentProgramVO;

    private String errorMsg;

    private CurrentProgramModel(Context context) {
      this.context=context;
      seriesDataAgentImpl=SeriesDataAgentImpl.getInstance();
    }

    public static CurrentProgramModel getInstance(Context context){
        if(currentProgramModel==null){
            currentProgramModel=new CurrentProgramModel(context);
        }
        return currentProgramModel;
    }

    public void loadCurrentProgramData(){
        seriesDataAgentImpl.getCurrentProgram(access_token,page);

    }

    public CurrentProgramVO loadCurrentData(){
        return currentProgramVO;
    }

    public ProgramVO loadProgramData(String programId){
       for(CategoriesProgramVO vo:categoryList){
        for(ProgramVO voprogram:vo.getPrograms()){
            if(voprogram.getProgramId().equalsIgnoreCase(programId)){
                return voprogram;
            }
        }
       }
        return null;
    }

    @Subscribe(threadMode = ThreadMode.BackgroundThread)
    public void onCurrentProgramEvent(SeriesEvent.CurrentProgramEvent event){
        currentProgramVO=new CurrentProgramVO();
        if(seriesDataAgentImpl==null){
            seriesDataAgentImpl=SeriesDataAgentImpl.getInstance();
        }
        currentProgramVO=event.getCurrentProgramVO();
        if(currentProgramVO!=null){
            homeScreenVOS.add(currentProgramVO);
            seriesDataAgentImpl.getCategoriesPrograms(access_token,page);
        }else
            EventBus.getDefault().post(new SeriesEvent.ErrorEvent("currentVO null object"));

    }
    @Subscribe(threadMode = ThreadMode.BackgroundThread)
    public void OnCategoriesEvent(SeriesEvent.CategoriesProgramEvent event){
        if(seriesDataAgentImpl==null){
            seriesDataAgentImpl=SeriesDataAgentImpl.getInstance();
        }
        categoryList=event.getCategoriesProgramVOS();
        if (categoryList!=null){
            homeScreenVOS.addAll(categoryList);
            seriesDataAgentImpl.getTopicsData(access_token,page);
        }else
            EventBus.getDefault().post(new SeriesEvent.ErrorEvent("topicVO null object"));

    }


    @Subscribe(threadMode = ThreadMode.BackgroundThread)
    public void onTopicItemEvent(SeriesEvent.AllTopicsEvent event){
        if(event.getTopicsItems()!=null){
            homeScreenVOS.addAll(event.getTopicsItems());
            EventBus.getDefault().post(new SeriesEvent.HomeScreenEvent(homeScreenVOS));
        }else{
            EventBus.getDefault().post(new SeriesEvent.ErrorEvent("currentVO null object"));
        }

    }

    public CurrentProgramVO getCurrentProgramData(){
        for(HomeScreenVO homeScreenVO:homeScreenVOS){
            if(homeScreenVO instanceof  CurrentProgramVO){
              return (CurrentProgramVO) homeScreenVO;
            }
        }
        return null;
    }


}
