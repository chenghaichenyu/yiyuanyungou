package com.chenyu.yiyuangou.controller.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.chenyu.R;
import com.chenyu.core.controller.BasicFrg;
import com.chenyu.yiyuangou.controller.adapter.TestAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * Created by ChenYu on 2016/1/1.
 * 功能：“首页”的标签页
 */
public class HomeFrg extends BasicFrg {

    private List<String> data;

    @Bind(R.id.recyclerview)
    RecyclerView recyclerView;

    public HomeFrg(){
        super(R.layout.frg_home);
    }

    @Override
    public void initView(View view) {

        data = new ArrayList<String>();
        data.add("AAAA");
        data.add("BBBB");
        data.add("CCCC");
        data.add("DDDD");
        data.add("EEEE");
        data.add("FFFF");
        data.add("GGGG");
        data.add("HHHH");
        data.add("IIII");
        data.add("JJJJ");
        data.add("LLLL");
        TestAdapter adapter = new TestAdapter(data);
//        adapter.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                TipUtils.showTip("AAAAAA");
//            }
//        });
        recyclerView.setAdapter(adapter);
        LinearLayoutManager manager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
//        recyclerView.setLayoutManager(manager);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL));
    }

}
