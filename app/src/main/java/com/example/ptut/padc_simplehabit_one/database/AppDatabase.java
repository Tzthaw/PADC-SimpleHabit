package com.example.ptut.padc_simplehabit_one.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.ptut.padc_simplehabit_one.database.daos.CategoryDao;
import com.example.ptut.padc_simplehabit_one.database.daos.CurrentProgramDao;
import com.example.ptut.padc_simplehabit_one.database.daos.ProgramDao;
import com.example.ptut.padc_simplehabit_one.database.daos.SessionDao;
import com.example.ptut.padc_simplehabit_one.database.daos.TopicDao;
import com.example.ptut.padc_simplehabit_one.datas.entities.CategoriesProgramVO;
import com.example.ptut.padc_simplehabit_one.datas.entities.CurrentProgramVO;
import com.example.ptut.padc_simplehabit_one.datas.entities.ProgramVO;
import com.example.ptut.padc_simplehabit_one.datas.entities.SessionVO;
import com.example.ptut.padc_simplehabit_one.datas.entities.TopicVO;
import com.example.ptut.padc_simplehabit_one.shared.Constant;

@Database(entities = {CurrentProgramVO.class, CategoriesProgramVO.class, ProgramVO.class,
        SessionVO.class, TopicVO.class},version = 1,exportSchema = false)
public abstract class AppDatabase  extends RoomDatabase{

    private static AppDatabase appDatabase;

    public abstract CurrentProgramDao currentProgramDao();
    public abstract SessionDao sessionDao();
    public abstract CategoryDao categoryDao();
    public abstract ProgramDao programDao();
    public abstract TopicDao topicDao();

    public static AppDatabase getInMemoryDatabase(Context context){
        if(appDatabase==null){
            appDatabase= Room.databaseBuilder(context,AppDatabase.class, Constant.DB_NAME)
                    .allowMainThreadQueries()
                    .build();
        }
        return appDatabase;
    }

    public static void destroyInMemoryDatabase(){
        appDatabase=null;
    }
}
