package com.example.ptut.padc_simplehabit_one.viewholders;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ptut.padc_simplehabit_one.R;
import com.example.ptut.padc_simplehabit_one.controllers.ItemClickListener;
import com.example.ptut.padc_simplehabit_one.datas.entities.CurrentProgramVO;
import com.example.ptut.padc_simplehabit_one.shared.UtilsGeneral;
import com.example.ptut.padc_simplehabit_one.viewholders.base.BaseViewHolder;

import butterknife.BindView;

public class CurrentViewHolder extends BaseViewHolder<CurrentProgramVO> {

    @BindView(R.id.start_title)
    TextView startTitle;
    @BindView(R.id.start_img)
    ImageView startImg;
    @BindView(R.id.start_desc)
    TextView startDesc;
    @BindView(R.id.start_time)
    TextView startTime;
    @BindView(R.id.start_add)
    TextView startAdd;
    @BindView(R.id.start_btn)
    Button startBtn;

    ItemClickListener clickListener;
    CurrentProgramVO currentProgramVO;

    public CurrentViewHolder(View itemView,ItemClickListener clickListener) {
        super(itemView);
        this.clickListener=clickListener;
    }


    @Override
    public void onClick(View v) {
        clickListener.onCurrentItemClick(currentProgramVO,startImg);
    }

    @Override
    public void bind(CurrentProgramVO data) {
        currentProgramVO=data;
        startTitle.setText(data.getTitle());
        UtilsGeneral.LoadImageWithGlide(startImg,itemView.getContext(),data.getBackground());
        startDesc.setText(data.getDescription());
        startTime.setText(""+data.getSessions().get(0).getLengthTime());
    }
}
