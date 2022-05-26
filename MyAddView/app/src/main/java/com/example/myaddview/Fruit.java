package com.example.myaddview;

import java.util.ArrayList;

public class Fruit {

    String imageUrl;
    String name;
    String price;
    String count;

    public Fruit (String imageUrl, String name, String price, String count) {
        this.imageUrl = imageUrl;
        this.name = name;
        this.price = price;
        this.count = count;
    }

//    샘플 데이터 만들어 보기
    public static ArrayList<Fruit> getFruits() {
        ArrayList<Fruit> list = new ArrayList<>();
        list.add(new Fruit("https://media.istockphoto.com/photos/watermelon-picture-id1327253468?b=1&k=20&m=1327253468&s=170667a&w=0&h=JPD2Xaet67_LJacMDetvHYnfn5gTPR7ZagkEKqWo7Q4=", "수박", "10000", "1"));
        list.add(new Fruit("https://cdn.pixabay.com/photo/2017/09/26/13/31/apple-2788616__340.jpg", "사과", "8000", "2"));
        list.add(new Fruit("https://cdn.pixabay.com/photo/2016/03/05/22/31/food-1239303__340.jpg", "메론", "15000", "3"));
        list.add(new Fruit("https://media.istockphoto.com/photos/strawberry-on-wooden-background-copy-space-picture-id911678646?b=1&k=20&m=911678646&s=170667a&w=0&h=T_OrGlYPVZZ2TBc-fHsLdRZtgahlXa1lEjca9u3SOZk=", "딸기", "20000", "4"));
        list.add(new Fruit("https://media.istockphoto.com/photos/single-peach-fruit-with-leaf-isolated-on-white-picture-id1137630158?b=1&k=20&m=1137630158&s=170667a&w=0&h=bYeS3vmGTtbYeCFd5NIHQNVoHSRs4PmPswuI2pnp6fE=", "복숭아", "9000", "5"));
        list.add(new Fruit("https://media.istockphoto.com/photos/fresh-red-grape-isolated-on-white-background-picture-id1008765228?b=1&k=20&m=1008765228&s=170667a&w=0&h=Hkc0w1EQmFXV3C322e36aEumtwX9CAjHyna6YKlpjPQ=", "포도", "7000", "10"));
        list.add(new Fruit("https://media.istockphoto.com/photos/tangerine-or-clementine-with-green-leaf-isolated-on-white-picture-id906390546?b=1&k=20&m=906390546&s=170667a&w=0&h=A22u96CUoOlcR5wj7WXPydZZ_mxYTgKiQrOQcjCB_iQ=", "오렌지", "5000", "15"));


        return list;
    }

}
