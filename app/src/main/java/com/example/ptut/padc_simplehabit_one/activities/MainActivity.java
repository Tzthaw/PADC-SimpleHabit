package com.example.ptut.padc_simplehabit_one.activities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.example.ptut.padc_simplehabit_one.R;
import com.example.ptut.padc_simplehabit_one.activities.base.BaseActivity;
import com.example.ptut.padc_simplehabit_one.controllers.EmptyClickListener;
import com.example.ptut.padc_simplehabit_one.controllers.ItemClickListener;
import com.example.ptut.padc_simplehabit_one.datas.entities.CurrentProgramVO;
import com.example.ptut.padc_simplehabit_one.datas.entities.ProgramVO;
import com.example.ptut.padc_simplehabit_one.fragments.FragmentOnGo;
import com.example.ptut.padc_simplehabit_one.fragments.FragmentSeries;
import com.example.ptut.padc_simplehabit_one.fragments.FragmentTeachers;
import com.example.ptut.padc_simplehabit_one.shared.Constant;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends BaseActivity implements ItemClickListener,EmptyClickListener {

    @BindView(R.id.bottom_navigation)
    BottomNavigationView bottomNavigationView;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.viewpager)
    ViewPager viewPager;
    @BindView(R.id.tabs)
    TabLayout tabLayout;

    ViewPagerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this, this);

        setSupportActionBar(toolbar);

        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        Objects.requireNonNull(tabLayout.getTabAt(1)).select();
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_meditate:
                        return true;
                    case R.id.action_me:
                        UserProfileActivity.getInstance(getApplicationContext());
                        return true;
                    case R.id.action_more:

                        return true;
                }
                return false;
            }
        });

    }

    private void setupViewPager(ViewPager viewPager) {

        adapter.addFragment(FragmentOnGo.newInstance(), "On The Go");
        adapter.addFragment(FragmentSeries.newInstance(), "SERIES");
        adapter.addFragment(FragmentTeachers.newInstance(), "TEACHERS");
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onEmptyClick() {
    }


    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onCategoryItemClick(ProgramVO programVO, ImageView imageView) {
        Intent intent=ActivityCategoryDetail.getInstance(this,programVO.getProgramId(), Constant.PROGRAM_ID);
        ActivityOptionsCompat options = ActivityOptionsCompat.
                makeSceneTransitionAnimation(this, imageView, "profile");
        startActivity(intent, options.toBundle());
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onCurrentItemClick( CurrentProgramVO currentProgramVO, ImageView imageView) {
        Intent intent=ActivityCategoryDetail.getInstance(this,currentProgramVO.getProgramId(),Constant.CURRENT_ID);
        ActivityOptionsCompat options = ActivityOptionsCompat.
                makeSceneTransitionAnimation(this, imageView, "profile");
        startActivity(intent, options.toBundle());
    }





}