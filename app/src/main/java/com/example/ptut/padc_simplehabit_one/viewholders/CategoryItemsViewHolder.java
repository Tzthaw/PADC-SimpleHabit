package com.example.ptut.padc_simplehabit_one.viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ptut.padc_simplehabit_one.datas.entities.ProgramVO;
import com.example.ptut.padc_simplehabit_one.R;
import com.example.ptut.padc_simplehabit_one.controllers.ItemClickListener;
import com.example.ptut.padc_simplehabit_one.viewholders.base.BaseViewHolder;
import com.example.ptut.padc_simplehabit_one.shared.UtilsGeneral;

import butterknife.BindView;

public class CategoryItemsViewHolder extends BaseViewHolder<ProgramVO>{
    @BindView(R.id.meditation_card_title)
    TextView mediCardTitle;
    @BindView(R.id.meditation_image)
    ImageView mediImage;
    @BindView(R.id.meditation_time)
    TextView mediTime;


    ProgramVO programVO;
    ItemClickListener clickListener;

    public CategoryItemsViewHolder(View itemView,ItemClickListener clickListener) {
        super(itemView);
        this.clickListener=clickListener;
    }

    @Override
    public void bind(ProgramVO data) {
        programVO =data;
        UtilsGeneral.LoadImageWithGlide(mediImage,itemView.getContext(),data.getImage());
        mediCardTitle.setText(data.getTitle());
        mediTime.setText(""+data.getAvgLength());
    }

    @Override
    public void onClick(View v) {
        clickListener.onCategoryItemClick(programVO,mediImage);
    }
}
