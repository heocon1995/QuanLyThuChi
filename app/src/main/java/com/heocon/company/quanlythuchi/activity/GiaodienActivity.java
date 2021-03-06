package com.heocon.company.quanlythuchi.activity;

/**
 * Created by longdg on 12/12/2015.
 */

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;


import com.heocon.company.quanlythuchi.R;
import com.heocon.company.quanlythuchi.adapter.AdapterGiaodien;
import com.heocon.company.quanlythuchi.adapter.AdapterNavigation;


public class GiaodienActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TabLayout tablayout;
    private ViewPager viewPager;
    private AdapterGiaodien adapterGiaodich;
    private DrawerLayout drawerLayout;
    private LinearLayout layout;
    private String[] arr;
    private AdapterNavigation adapterNavigation;
    private ListView listView;
    private String matk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giaodien);
        setResult(0);
        matk = getIntent().getStringExtra("matk");
        setActionBar();
        setTablayout();
        setViewPager();
        addEventTab();
        setDrawer();
    }

    public void setActionBar() {
        toolbar = (Toolbar) findViewById(R.id.toolbarGiaodien);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Thu chi");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.menus_icon_3);
    }

    public void setTablayout() {
        tablayout = (TabLayout) findViewById(R.id.tablayout);
        tablayout.addTab(tablayout.newTab().setIcon(R.drawable.ic_expenditure));
        tablayout.addTab(tablayout.newTab().setIcon(R.drawable.ic_statistical));
        tablayout.addTab(tablayout.newTab().setIcon(R.drawable.ic_setting));
    }

    public void setViewPager() {
        viewPager = (ViewPager) findViewById(R.id.viewpagerGiaodien);
        adapterGiaodich = new AdapterGiaodien(getSupportFragmentManager(), matk);
        viewPager.setAdapter(adapterGiaodich);
    }

    public void addEventTab() {
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tablayout));
        tablayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        getSupportActionBar().setTitle("Thu chi");
                        tablayout.getTabAt(0).setIcon(R.drawable.ic_expenditure_2);
                        viewPager.setCurrentItem(0);
                        break;
                    case 1:
                        getSupportActionBar().setTitle("Thống kê");
                        tablayout.getTabAt(1).setIcon(R.drawable.ic_statistical_2);
                        viewPager.setCurrentItem(1);
                        break;
                    case 2:
                        getSupportActionBar().setTitle("Cài đặt");
                        tablayout.getTabAt(2).setIcon(R.drawable.ic_setting_2);
                        viewPager.setCurrentItem(2);
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        tablayout.getTabAt(0).setIcon(R.drawable.ic_expenditure);
                        break;
                    case 1:
                        tablayout.getTabAt(1).setIcon(R.drawable.ic_statistical);
                        break;
                    case 2:
                        tablayout.getTabAt(2).setIcon(R.drawable.ic_setting);
                        break;
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }

    public void setDrawer() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        layout = (LinearLayout) findViewById(R.id.layoutGiaodien);
        listView = (ListView) findViewById(R.id.lvDrawer);
        arr = getResources().getStringArray(R.array.navigation);
        adapterNavigation = new AdapterNavigation(this, R.layout.activity_navigation_item, arr);
        listView.setAdapter(adapterNavigation);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                addEvent(position);
                drawerLayout.closeDrawer(layout);
            }
        });
    }

    public void addEvent(int so) {
        switch (so) {
            case 0:
                Intent intent = new Intent(this, GiaodichActivity.class);
                intent.putExtra("matk", matk);
                startActivity(intent);
                break;
            case 1:
                Intent intent1 = new Intent(this, ThongtinActivity.class);
                intent1.putExtra("matk", matk);
                intent1.putExtra("dk", "xem");
                startActivity(intent1);
                break;
            case 2:
                viewPager.setCurrentItem(0);
                break;
            case 3:
                viewPager.setCurrentItem(1);
                break;
            case 4:
                viewPager.setCurrentItem(2);
                break;
            case 5:
                SharedPreferences share = getSharedPreferences("taikhoan", MODE_PRIVATE);
                SharedPreferences.Editor edit = share.edit();
                edit.clear();
                edit.commit();
                setResult(1);
                finish();
                break;
            case 6:
                finish();
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // getMenuInflater().inflate(R.menu.menu_giaodien, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            if (drawerLayout.isDrawerOpen(layout)) {
                drawerLayout.closeDrawer(layout);
            } else {
                drawerLayout.openDrawer(layout);
            }
        }
        return super.onOptionsItemSelected(item);
    }
}

