package com.tribe7.mvptest.main.ui;

import android.os.Build;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.tribe7.mvptest.R;
import com.tribe7.mvptest.advert.ui.AdvertFragment;
import com.tribe7.mvptest.article.ui.ArticleFragment;
import com.tribe7.mvptest.base.BaseActivity;
import com.tribe7.mvptest.base.BaseFragment;
import com.tribe7.mvptest.find.ui.FindFragment;
import com.tribe7.mvptest.main.presenter.MainPresenter;
import com.tribe7.mvptest.main.presenter.MainPresenterImpl;
import com.tribe7.mvptest.main.view.MainView;
import com.tribe7.mvptest.mine.ui.MineFragment;

/**
 * Created by admin on 2016/8/9.
 */

public class MainActivity extends BaseActivity implements MainView{
    private BaseFragment[] fragments;
    private AdvertFragment advertfragment;
    private ArticleFragment articlefragment;
    private FindFragment findfragment;
    private MineFragment minefragment;
    private ImageView[] imagebuttons;
    private TextView[] textviews;

    private int index=0;
    private int currentTabIndex=1;// 当前fragment的index

    private static BaseFragment curFragment;

    private MainPresenterImpl mMainPresenter;

    @Override
    public void initView() {
        setContentView(R.layout.activity_main);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

        }
        setContentView(R.layout.activity_main);
    }

    @Override
    public void initData() {
        mMainPresenter = new MainPresenter(this);

        advertfragment = new AdvertFragment();
        articlefragment = new ArticleFragment();
        findfragment = new FindFragment();
        minefragment = new MineFragment();
        fragments = new BaseFragment[] {advertfragment, articlefragment, findfragment, minefragment };
        imagebuttons = new ImageView[4];
        imagebuttons[0] = (ImageView) findViewById(R.id.ib_weixin);
        imagebuttons[1] = (ImageView) findViewById(R.id.ib_contact_list);
        imagebuttons[2] = (ImageView) findViewById(R.id.ib_find);
        imagebuttons[3] = (ImageView) findViewById(R.id.ib_profile);

        imagebuttons[0].setSelected(true);
        textviews = new TextView[4];
        textviews[0] = (TextView) findViewById(R.id.tv_weixin);
        textviews[1] = (TextView) findViewById(R.id.tv_contact_list);
        textviews[2] = (TextView) findViewById(R.id.tv_find);
        textviews[3] = (TextView) findViewById(R.id.tv_profile);
        textviews[0].setTextColor(0xFF45C01A);

        switch2Advert();
    }

    @Override
    public void setListener() {

    }

    public void onTabClicked(View view) {
        mMainPresenter.switchNavigation(view.getId());
    }

    @Override
    public void switch2Advert() {
        index = 0;
        switchTab();
    }

    @Override
    public void switch2Article() {
        index = 1;
        switchTab();
    }

    @Override
    public void switch2Find() {
        index = 2;
        switchTab();
    }

    @Override
    public void switch2Mine() {
        index = 3;
        switchTab();
    }

    private void switchTab(){
        if (currentTabIndex != index) {
            FragmentTransaction trx = getSupportFragmentManager().beginTransaction();
            trx.hide(fragments[currentTabIndex]);
            if (!fragments[index].isAdded()) {
                trx.add(R.id.fragment_container, fragments[index]);
            }
            trx.show(fragments[index]).commit();
            curFragment = fragments[index];
        }
        imagebuttons[currentTabIndex].setSelected(false);
        // 把当前tab设为选中状态
        imagebuttons[index].setSelected(true);
        textviews[currentTabIndex].setTextColor(0xFF999999);
        textviews[index].setTextColor(0xFF45C01A);
        currentTabIndex = index;
    }
}
