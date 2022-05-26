package com.example.recyclerview.models;

import java.io.Serializable;
import java.util.ArrayList;

public class Food implements Serializable {

//    Serializable -> 직렬화. 오브젝트 단위를 직렬화시켜서 Byte 단위 타입으로 바꿔주는 녀석.
//    받을 때는 역직렬화하여 Byte단위에서 다시 Object 단위로 받을 수 있음.


    private String thumbnail;
    private String title;
    private String subTitle;
    private String detail;

    public Food(String thumbnail, String title, String subTitle, String detail) {
        this.thumbnail = thumbnail;
        this.title = title;
        this.subTitle = subTitle;
        this.detail = detail;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public static ArrayList<com.example.recyclerview.models.Food> getSampleData() {
        ArrayList<com.example.recyclerview.models.Food> foods = new ArrayList<>();

        foods.add(new com.example.recyclerview.models.Food("https://cdn.pixabay.com/photo/2017/09/26/13/31/apple-2788616__340.jpg", "Food1", "SubTitle1", "detail"));
        foods.add(new com.example.recyclerview.models.Food("https://cdn.pixabay.com/photo/2017/09/26/13/31/apple-2788616__340.jpg", "Food2", "SubTitle1", "detail"));
        foods.add(new com.example.recyclerview.models.Food("https://cdn.pixabay.com/photo/2017/09/26/13/31/apple-2788616__340.jpg", "Food3", "SubTitle1", "detail"));
        foods.add(new com.example.recyclerview.models.Food("https://cdn.pixabay.com/photo/2017/09/26/13/31/apple-2788616__340.jpg", "Food4", "SubTitle1", "detail"));
        foods.add(new com.example.recyclerview.models.Food("https://cdn.pixabay.com/photo/2017/09/26/13/31/apple-2788616__340.jpg", "Food5", "SubTitle1", "detail"));
        foods.add(new com.example.recyclerview.models.Food("https://cdn.pixabay.com/photo/2017/09/26/13/31/apple-2788616__340.jpg", "Food6", "SubTitle1", "detail"));
        foods.add(new com.example.recyclerview.models.Food("https://cdn.pixabay.com/photo/2017/09/26/13/31/apple-2788616__340.jpg", "Food7", "SubTitle1", "detail"));
        foods.add(new com.example.recyclerview.models.Food("https://cdn.pixabay.com/photo/2017/09/26/13/31/apple-2788616__340.jpg", "Food8", "SubTitle1", "detail"));
        foods.add(new com.example.recyclerview.models.Food("https://cdn.pixabay.com/photo/2017/09/26/13/31/apple-2788616__340.jpg", "Food9", "SubTitle1", "detail"));
        foods.add(new com.example.recyclerview.models.Food("https://cdn.pixabay.com/photo/2017/09/26/13/31/apple-2788616__340.jpg", "Food10", "SubTitle1", "detail"));
        foods.add(new com.example.recyclerview.models.Food("https://cdn.pixabay.com/photo/2017/09/26/13/31/apple-2788616__340.jpg", "Food11", "SubTitle1", "detail"));
        foods.add(new com.example.recyclerview.models.Food("https://cdn.pixabay.com/photo/2017/09/26/13/31/apple-2788616__340.jpg", "Food12", "SubTitle1", "detail"));
        foods.add(new com.example.recyclerview.models.Food("https://cdn.pixabay.com/photo/2017/09/26/13/31/apple-2788616__340.jpg", "Food13", "SubTitle1", "detail"));
        foods.add(new com.example.recyclerview.models.Food("https://cdn.pixabay.com/photo/2017/09/26/13/31/apple-2788616__340.jpg", "Food14", "SubTitle1", "detail"));
        foods.add(new com.example.recyclerview.models.Food("https://cdn.pixabay.com/photo/2017/09/26/13/31/apple-2788616__340.jpg", "Food15", "SubTitle1", "detail"));
        foods.add(new com.example.recyclerview.models.Food("https://cdn.pixabay.com/photo/2017/09/26/13/31/apple-2788616__340.jpg", "Food16", "SubTitle1", "detail"));


        return foods;
    }
}

