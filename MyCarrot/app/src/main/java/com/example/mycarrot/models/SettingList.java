package com.example.mycarrot.models;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.Image;

import com.example.mycarrot.R;

import java.io.Serializable;
import java.util.ArrayList;

public class SettingList implements Serializable {

    private Drawable icon;
    private String title;

    public SettingList(Drawable icon, String title) {
        this.icon = icon;
        this.title = title;
    }

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "SettingList{" +
                "icon='" + icon + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    public static ArrayList<SettingList> getSettingData() {

        ArrayList<SettingList> lists = new ArrayList<>();


        lists.add(new SettingList(Resources.getSystem().getDrawable(R.drawable.ic_baseline_location_on_24), "내 동네 설정"));
        lists.add(new SettingList(Resources.getSystem().getDrawable(R.drawable.ic_baseline_zoom_out_map_24), "동네 인증하기"));
        lists.add(new SettingList(Resources.getSystem().getDrawable(R.drawable.ic_baseline_sell_24), "키워드 알린"));
        lists.add(new SettingList(Resources.getSystem().getDrawable(R.drawable.ic_baseline_grid_on_24), "모아보기"));
        lists.add(new SettingList(Resources.getSystem().getDrawable(R.drawable.ic_baseline_create_24), "동네생활 글"));
        lists.add(new SettingList(Resources.getSystem().getDrawable(R.drawable.ic_baseline_chat_24), "동네생활 댓글"));
        lists.add(new SettingList(Resources.getSystem().getDrawable(R.drawable.ic_baseline_star_border_24), "동네생활 주제 목록"));
        lists.add(new SettingList(Resources.getSystem().getDrawable(R.drawable.ic_baseline_storefront_24), "비즈프로필 관리"));
        lists.add(new SettingList(Resources.getSystem().getDrawable(R.drawable.ic_baseline_notifications_24), "지역광고"));

        return lists;
    }

}
