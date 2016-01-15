package com.chenyu.yiyuangou.controller.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chenyu.R;
import com.chenyu.core.controller.BasicAdapter;
import com.chenyu.core.controller.ViewHolder;
import com.chenyu.yiyuangou.model.bean.Address;

import java.util.List;

/**
 * Created by ChenYu on 2016/1/15.
 */
public class AddressAdapter extends BasicAdapter {

    List<Address> data;

    public AddressAdapter(List<Address> data){
        super(data, R.layout.item_act_address);
        this.data = data;
    }

    @Override
    public void bind(ViewHolder viewHolder, int position) {
        TextView name = viewHolder.getTextView(R.id.item_act_address_tv_name);
        TextView phone = viewHolder.getTextView(R.id.item_act_address_tv_phone);
        TextView detailAddress = viewHolder.getTextView(R.id.item_act_address_tv_detail);
        ImageView defaultView = viewHolder.getImageView(R.id.item_act_address_image);

        Address address = data.get(position);
        name.setText(address.getName());
        phone.setText(address.getPhone());
        detailAddress.setText(address.getDetailAddress());
        if (!address.isDefault()){
            //不是默认地址
            defaultView.setVisibility(View.GONE);
        }
    }
}
