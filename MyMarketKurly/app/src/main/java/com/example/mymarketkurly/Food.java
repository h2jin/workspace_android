package com.example.mymarketkurly;

import android.widget.ImageView;

import java.util.ArrayList;

public class Food {

    String imageUrl;
    String company;
    String name;
    String amount;
    String price;

    public Food(String imageUrl, String company, String name, String amount ,String price) {
        this.imageUrl = imageUrl;
        this.company = company;
        this.name = name;
        this.amount = amount;
        this.price = price;
    }

    public static ArrayList<Food> getFoodList() {
        ArrayList<Food> foodList = new ArrayList<>();
        foodList.add(new Food("https://search.pstatic.net/common/?src=http%3A%2F%2Fblogfiles.naver.net%2FMjAyMTAxMjhfMjEy%2FMDAxNjExODAxOTQyNzUx.9_5M2mqE6vTpt5Fg22ZyV6VmlzSBlv8_JVKEPWWj3sYg.OhJA_37px8pIVLK4X47hPZ3eeeW39it_gJkWCHDsXwsg.JPEG.jdr21035%2FIMG_5559.jpg&type=a340", "[연세우유 x 마켓컬리]", "전용목장우유" ,"900ml", "1970"));
        foodList.add(new Food("https://search.pstatic.net/common/?src=http%3A%2F%2Fshop1.phinf.naver.net%2F20211014_61%2F1634177453234u9mPe_JPEG%2F35313351933716649_684116837.jpg&type=a340", "[KF365]", "DOLE 실속 바나나" ,"1kg", "2980"));
        foodList.add(new Food("http://static.megamart.com/product/editor/8809/8809216//_DSC0978-copy.jpg", "[다향오리]", "훈제오리" ,"150g", "2980"));
        foodList.add(new Food("https://www.fnnews.com/resource/media/image/2021/06/01/202106011044205462_l.jpg", "[Kurly's]", "국산콩 두부" ,"300g", "1900"));
        foodList.add(new Food("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTfZjQiYhr0SQL5PxL4PE885jBblbDZyTtpzw&usqp=CAU", "[KF365]", "김구원 선생 국내산 무농약 콩나물" ,"300g", "900"));
        foodList.add(new Food("https://static.coupangcdn.com/image/vendor_inventory/ebf4/f6f506b0d240faf82899ef0a5a33c93f96ea2a75dd2264aede3c7e22b482.jpg", "[남향푸드또띠아]", "간편 간식 브리또" ,"13종", "3200"));
        foodList.add(new Food("https://www.shinailbo.co.kr/news/photo/201905/1163495_434258_937.jpg", "[하림]", "냉장 닭가슴살" ,"4종", "1700"));
        foodList.add(new Food("https://img-cf.kurly.com/shop/data/goodsview/20211224/gv30000261825_1.jpg", "[폴 바셋]", "바리스타 돌체라떼" ,"330ml", "2900"));

        return foodList;
    }


}
