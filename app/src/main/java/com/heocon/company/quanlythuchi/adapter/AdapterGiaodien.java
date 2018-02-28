package com.heocon.company.quanlythuchi.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.heocon.company.quanlythuchi.fragment.CaidatFragment;
import com.heocon.company.quanlythuchi.fragment.ThongkeFragment;
import com.heocon.company.quanlythuchi.fragment.ThuchiFragment;

public class AdapterGiaodien extends FragmentPagerAdapter {
    private String matk;

    public AdapterGiaodien(FragmentManager fm, String matk) {
        super(fm);
        this.matk = matk;
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return new ThuchiFragment(matk);
            case 1:
                return new ThongkeFragment(matk);
            case 2:
                return new CaidatFragment(matk);
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
