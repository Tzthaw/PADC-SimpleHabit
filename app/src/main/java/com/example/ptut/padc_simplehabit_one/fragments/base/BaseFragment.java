package com.example.ptut.padc_simplehabit_one.fragments.base;

import android.arch.lifecycle.LifecycleOwner;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.example.ptut.padc_simplehabit_one.events.SeriesEvent;
import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;
import de.greenrobot.event.ThreadMode;

/**
 * Created by aung on 6/13/17.
 */

public abstract class BaseFragment extends Fragment implements LifecycleOwner {


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            readArguments(bundle);
        }

        if (savedInstanceState != null) {
            readArguments(savedInstanceState);
        }
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    protected void readArguments(Bundle bundle) {

    }

    @Subscribe(threadMode = ThreadMode.BackgroundThread)
    public void onEvent(SeriesEvent.ErrorEvent event) {

    }
}
