package com.example.ptut.padc_simplehabit_one.datas.views;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ptut.padc_simplehabit_one.R;
import com.example.ptut.padc_simplehabit_one.controllers.EmptyClickListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EmptyLayout extends LinearLayout {

    @BindView(R.id.empty_text)
    TextView emptyText;
    Context context;
    EmptyClickListener onEmptyClickListener;

    public EmptyLayout(Context context) {
        super(context);
        this.context=context;
    }

    public EmptyLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
    }

    public EmptyLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context=context;
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this, this);
        emptyText.setText("No Data");
    }

    public void bindData(EmptyClickListener onEmptyClickListener) {
        this.onEmptyClickListener=onEmptyClickListener;

    }

    @OnClick
    public void onNewsClick(){
    }

}
