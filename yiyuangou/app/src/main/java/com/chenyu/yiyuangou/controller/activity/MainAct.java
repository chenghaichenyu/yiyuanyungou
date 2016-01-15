package com.chenyu.yiyuangou.controller.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;
import com.chenyu.R;
import com.chenyu.core.Utils.ResUtils;
import com.chenyu.core.controller.BasicAct;
import com.chenyu.yiyuangou.controller.fragment.AllGoodFrg;
import com.chenyu.yiyuangou.controller.fragment.HomeFrg;
import com.chenyu.yiyuangou.controller.fragment.LatestAnnouncementFrg;
import com.chenyu.yiyuangou.controller.fragment.PersonalCenterFrg;
import com.chenyu.yiyuangou.controller.fragment.ShoppingCartFrg;

import butterknife.Bind;

/**
 * Created by ChenYu
 * 功能：主界面，实现了底部导航栏的点击监听和手势滑动事件
 */
public class MainAct extends BasicAct {

    private Class[] tabFragmentArray = {HomeFrg.class, AllGoodFrg.class,LatestAnnouncementFrg.class,
            ShoppingCartFrg.class, PersonalCenterFrg.class};

    private int[] tabStringArray = {R.string.act_main_tab_string_home,R.string.act_main_tab_string_all_good, R.string.act_main_tab_string_latest_announcement,R.string.act_main_tab_string_shopping_cart, R.string.act_main_tab_string_personal_center};
    private int[] tabImageNoramlArray = {
            R.drawable.home_normal,R.drawable.all_good_normal,R.drawable.latest_announcement_normal,
            R.drawable.shopping_cart_normal,R.drawable.personal_center_normal};
    private int[] tabImageSelectedArray = {
            R.drawable.home_selected,R.drawable.all_good_selected,R.drawable.latest_announcement_selected,
            R.drawable.shopping_cart_selected,R.drawable.personal_center_selected};

    @Bind (R.id.act_main_tab_host)
    FragmentTabHost fragmentTabHost;
    @Bind(R.id.act_main_view_pager)
    ViewPager viewPager;

    private LayoutInflater layoutInflater;
    private Fragment[] fragments;

    public MainAct(){
        super(R.layout.act_main, R.string.act_main_title,false,TOOLBAR_TYPE_NO_TOOLBAR);
    }

    public static void startActivity(Context context){
        Intent intent = new Intent(context,MainAct.class);
        context.startActivity(intent);
    }


    @Override
    public void initView() {
        layoutInflater = LayoutInflater.from(this);
        fragmentTabHost.setup(this,getSupportFragmentManager(),R.id.act_main_view_pager);

        int count = tabStringArray.length;
        for(int i = 0;i < count;i++){
            TabHost.TabSpec tabSpec ;
            if(i == 0){
                //生成一个tab标签，i=0是默认选中的
                tabSpec = fragmentTabHost.newTabSpec(getString(tabStringArray[i])).setIndicator(getTabItemView(i,tabImageSelectedArray[i], tabStringArray[i]));
            }else{
                tabSpec = fragmentTabHost.newTabSpec(getString(tabStringArray[i])).setIndicator(getTabItemView(i,tabImageNoramlArray[i],tabStringArray[i]));

            }

            //去除分割线
            fragmentTabHost.getTabWidget().setDividerDrawable(null);
            //给tabspec添加fragment
            fragmentTabHost.addTab(tabSpec,tabFragmentArray[i],null);
            //给fragmentTabHost添加点击事件
            fragmentTabHost.getTabWidget().getChildTabViewAt(i).setOnClickListener(new TabOnClickListener(fragmentTabHost,i));
        }

        /**
         * 当点击Tab时，用ViewPager对fragment进行切换，否则fragment将会叠加
         */
        fragmentTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                int position = fragmentTabHost.getCurrentTab();
                viewPager.setCurrentItem(position);
            }
        });

        HomeFrg homeFrg = new HomeFrg();
        AllGoodFrg allGoodFrg = new AllGoodFrg();
        LatestAnnouncementFrg latestAnnouncementFrg = new LatestAnnouncementFrg();
        ShoppingCartFrg shoppingCartFrg = new ShoppingCartFrg();
        PersonalCenterFrg personalCenterFrg = new PersonalCenterFrg();
        fragments = new Fragment[]{homeFrg,allGoodFrg,latestAnnouncementFrg,shoppingCartFrg,personalCenterFrg};

        fragmentTabHost.setCurrentTab(0);
        viewPager.setOffscreenPageLimit(4);
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
        viewPager.setOnPageChangeListener(new ViewPagerListener());

    }


    /**
     * 设置每个Tab的上面的文字和图片
     * @param position 表示是第几个Tab
     * @param imageResId Tab上的图片资源ID
     * @param stringResId Tab上的文字资源ID
     * @return
     */
    public View getTabItemView(int position,int imageResId,int stringResId){
        View view = layoutInflater.inflate(R.layout.item_main_menu_tab,null);
        ImageView imageView = (ImageView)view.findViewById(R.id.act_main_tab_item_image);
        TextView text = (TextView)view.findViewById(R.id.act_main_tab_item_text);
        imageView.setImageResource(imageResId);
        text.setText(ResUtils.getString(stringResId));
        //初始化“首页”标签为选中状态
        if(position == 0){
            text.setTextColor(ResUtils.getColor(R.color.tab_text_selected));
        }
        return view;
    }


    /**
     * FragmentTabHost的点击事件
     */
    class TabOnClickListener implements View.OnClickListener{

        private FragmentTabHost fragmentTabHost;
        private int index;
        public TabOnClickListener(FragmentTabHost fragmentTabHost,int index){
            this.fragmentTabHost = fragmentTabHost;
            this.index = index;
        }

        @Override
        public void onClick(View v) {
            for(int i = 0 ; i < fragmentTabHost.getTabWidget().getTabCount();i++){
                View view = fragmentTabHost.getTabWidget().getChildAt(i);
                ImageView imageView = (ImageView)view.findViewById(R.id.act_main_tab_item_image);
                TextView textView = (TextView)view.findViewById(R.id.act_main_tab_item_text);
                if(i == index){
                    imageView.setImageResource(tabImageSelectedArray[i]);
                    textView.setTextColor(ResUtils.getColor(R.color.tab_text_selected));
                }else{
                    imageView.setImageResource(tabImageNoramlArray[i]);
                    textView.setTextColor(ResUtils.getColor(R.color.tab_text_normal));
                }
                fragmentTabHost.setCurrentTab(index);
            }
        }
    }

    /**
     * ViewPager适配器
     * 继承自PagerAdapter，将页面信息持续的保存在fragment manager中，方便用户返回该页面
     */
    class ViewPagerAdapter extends FragmentPagerAdapter{
        public ViewPagerAdapter(android.support.v4.app.FragmentManager fragmentManager){
            super(fragmentManager);
        }
        @Override
        public Fragment getItem(int position) {
            return fragments[position];
        }

        @Override
        public int getCount() {
            return fragments.length;
        }
    }

    /**
     * ViewPager的监听事件
     * 当前选择页面发生变化时的回调接口
     */
    class ViewPagerListener implements ViewPager.OnPageChangeListener{
        @Override
        public void onPageSelected(int position) {
            for(int i = 0;i < fragmentTabHost.getTabWidget().getTabCount();i ++){
                View view = fragmentTabHost.getTabWidget().getChildAt(i);
                ImageView image = (ImageView)view.findViewById(R.id.act_main_tab_item_image);
                TextView text = (TextView)view.findViewById(R.id.act_main_tab_item_text);
                if(i == position){
                    image.setImageResource(tabImageSelectedArray[i]);
                    text.setTextColor(ResUtils.getColor(R.color.tab_text_selected));
                }else{
                    image.setImageResource(tabImageNoramlArray[i]);
                    text.setTextColor(ResUtils.getColor(R.color.tab_text_normal));
                }
            }
            fragmentTabHost.setCurrentTab(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }
    }
}

