package com.chenyu.yiyuangou.controller.adapter;

import android.support.v7.widget.CardView;
import android.view.View;

import com.chenyu.R;
import com.chenyu.core.Utils.LogUtils;
import com.chenyu.core.controller.BasicAdapter;
import com.chenyu.core.controller.ViewHolder;

import java.util.List;

/**
 * Created by Chenyu on 2016/1/4.
 */
public class TestAdapter extends BasicAdapter {

    public TestAdapter(List<?> data){
        super(data, R.layout.item_test);
    }

    @Override
    public void bind(ViewHolder viewHolder, final int position) {

        if(position % 2 !=0){
            viewHolder.getImageView(R.id.test_imageview).setImageResource(R.mipmap.ic_launcher);
        }else{
            viewHolder.getImageView(R.id.test_imageview).setImageResource(R.drawable.shopping_cart_selected);
        }

//        viewHolder.getTextView(R.id.test_textview).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                TipUtils.showTip("TextView");
//            }
//        });
//        viewHolder.getImageView(R.id.test_iamgeview).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                TipUtils.showTip("imageView");
//            }
//        });

        CardView cardView =  viewHolder.get(R.id.cardview);
        if(!cardView.hasOnClickListeners()){
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    LogUtils.d("good");
                    LogUtils.d("position:"+position);

                }
            });
        }
    }
}
