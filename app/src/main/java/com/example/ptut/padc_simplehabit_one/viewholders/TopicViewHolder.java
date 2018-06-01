package com.example.ptut.padc_simplehabit_one.viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ptut.padc_simplehabit_one.datas.entities.TopicVO;
import com.example.ptut.padc_simplehabit_one.R;
import com.example.ptut.padc_simplehabit_one.viewholders.base.BaseViewHolder;
import com.example.ptut.padc_simplehabit_one.shared.UtilsGeneral;

import butterknife.BindView;

public class TopicViewHolder extends BaseViewHolder<TopicVO> {

    @BindView(R.id.topic_item_bg)
    ImageView topicItemBgImg;
    @BindView(R.id.topic_item_icon)
    ImageView topicItemIcon;
    @BindView(R.id.topic_item_title)
    TextView topicItemTitle;
    @BindView(R.id.topic_item_discuss)
    TextView topicItemDiscuss;
    TopicVO topicItem;


    public TopicViewHolder(View itemView) {
        super(itemView);

    }

    @Override
    public void bind(TopicVO data) {
        topicItem = data;
//        UtilsGeneral.LoadImageWithGlide(topicItemBgImg, itemView.getContext(), data.getBackgroundImg());
        UtilsGeneral.LoadImageWithGlide(topicItemIcon, itemView.getContext(), data.getImage());
        topicItemTitle.setText(data.getTopicName());
        topicItemDiscuss.setText(data.getTopicDesc());
    }

    @Override
    public void onClick(View v) {
    }
}
