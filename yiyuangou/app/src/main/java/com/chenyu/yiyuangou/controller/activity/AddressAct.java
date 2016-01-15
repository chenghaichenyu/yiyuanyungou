package com.chenyu.yiyuangou.controller.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.chenyu.R;
import com.chenyu.core.Utils.LogUtils;
import com.chenyu.core.controller.BasicAct;
import com.chenyu.yiyuangou.controller.adapter.AddressAdapter;
import com.chenyu.yiyuangou.model.bean.Address;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import butterknife.Bind;

/**
 * Created by ChenYu
 * 功能：地址管理页面
 */
public class AddressAct extends BasicAct{

    @Bind(R.id.act_address_recyclerview)
    RecyclerView recyclerView;
    /**
     * 收货地址是否为空
     */
    private boolean isAddressNull = true;
//    private boolean isRecyclerViewNull = true;
    public AddressAct(){
        super(R.layout.act_address,R.string.act_address_title);
    }

    public static void startActivity(Context context){
        Intent intent = new Intent(context,AddressAct.class);
        context.startActivity(intent);
    }

    @Override
    public void initView() {
        isAddressNull = false;
        if(isAddressNull){
            //收货地址为空
        }else{
            //收货地址不为空
            List<Address> addressList = new ArrayList<Address>();
            Address address = null;
            address = new Address();
            address.setName("张三");
            address.setPhone("12345678910");
            address.setDetailAddress("广东省 珠海市 香洲区 唐家湾镇 哈工大路1号经济资源开发港 博士楼");
            address.setIsDefault(true);
            addressList.add(address);

            address = new Address();
            address.setName("张三");
            address.setPhone("12345678910");
            address.setDetailAddress("广东省 珠海市 香洲区 唐家湾镇 哈工大路1号经济资源开发港 博士楼");
            address.setIsDefault(false);
            addressList.add(address);

            address = new Address();
            address.setName("张三");
            address.setPhone("12345678910");
            address.setDetailAddress("广东省 珠海市 香洲区 唐家湾镇 哈工大路1号经济资源开发港 博士楼");
            address.setIsDefault(false);
            addressList.add(address);

            address = new Address();
            address.setName("张三");
            address.setPhone("12345678910");
            address.setDetailAddress("广东省 珠海市 香洲区 唐家湾镇 哈工大路1号经济资源开发港 博士楼");
            address.setIsDefault(false);
            addressList.add(address);

            AddressAdapter adapter = new AddressAdapter(addressList);
            recyclerView.setAdapter(adapter);
//            LinearLayoutManager layoutManager = new LinearLayoutManager(AddressAct.this,LinearLayoutManager.VERTICAL,false);
            recyclerView.setLayoutManager(new MyLinearLayoutManager(AddressAct.this));
        }
    }

    class MyLinearLayoutManager extends LinearLayoutManager{

        public MyLinearLayoutManager(Context context){
            super(context);
        }

        @Override
        public void onMeasure(RecyclerView.Recycler recycler, RecyclerView.State state, int widthSpec, int heightSpec) {
            int[] mMeasuredDimension = new int[2];
            final int widthMode = View.MeasureSpec.getMode(widthSpec);
            final int heightMode = View.MeasureSpec.getMode(heightSpec);
            final int heightSize = View.MeasureSpec.getSize(heightSpec);
            int width = 0;
            int height = 0;
            LogUtils.d("state:" + state.toString());
            for (int i = 0; i < getItemCount(); i++) {
                try {
                    measureScrapChild(recycler, i, widthSpec,
                            View.MeasureSpec.makeMeasureSpec(i, View.MeasureSpec.UNSPECIFIED),
                            mMeasuredDimension);
                } catch (IndexOutOfBoundsException e) {
                    e.printStackTrace();
                }
                if (getOrientation() == HORIZONTAL) {
                    width = width + mMeasuredDimension[0];
                    if (i == 0) {
                        height = mMeasuredDimension[1];
                    }
                } else {
                    height = height + mMeasuredDimension[1];
                    if (i == 0) {
                        width = mMeasuredDimension[0];
                    }
                }
            }

            switch (widthMode) {
                case View.MeasureSpec.EXACTLY:
                case View.MeasureSpec.AT_MOST:
                case View.MeasureSpec.UNSPECIFIED:
            }

            switch (heightMode) {
                case View.MeasureSpec.EXACTLY:
                    height = heightSize;
                case View.MeasureSpec.AT_MOST:
                case View.MeasureSpec.UNSPECIFIED:
            }
            setMeasuredDimension(widthSpec, height);

        }

        private void measureScrapChild(RecyclerView.Recycler recycler, int position, int widthSpec, int heightSpec, int[] measuredDimension) {
            View view = recycler.getViewForPosition(position);

            if (view != null) {
                RecyclerView.LayoutParams p = (RecyclerView.LayoutParams) view.getLayoutParams();
                int childHeightSpec = ViewGroup.getChildMeasureSpec(heightSpec,
                        getPaddingTop() + getPaddingBottom(), p.height);
                view.measure(widthSpec, childHeightSpec);
                measuredDimension[0] = view.getMeasuredWidth() + p.leftMargin + p.rightMargin;
                measuredDimension[1] = view.getMeasuredHeight() + p.bottomMargin + p.topMargin;
                recycler.recycleView(view);
            }
        }


    }
}