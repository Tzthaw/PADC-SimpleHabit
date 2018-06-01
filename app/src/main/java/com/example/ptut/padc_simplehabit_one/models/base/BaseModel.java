package com.example.ptut.padc_simplehabit_one.models.base;

import com.example.ptut.padc_simplehabit_one.events.SeriesEvent;
import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;
import de.greenrobot.event.ThreadMode;

public abstract class BaseModel {



    public BaseModel() {
        EventBus eventBus = EventBus.getDefault();
        if (!eventBus.isRegistered(this)) {
            eventBus.register(this);
        }
    }



    @Subscribe(threadMode = ThreadMode.BackgroundThread)
    public void onEvent(SeriesEvent.ErrorEvent event) {

    }
}
