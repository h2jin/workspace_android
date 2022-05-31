package com.example.myretrofit3;

public class UserInfo {

    // 빌더 패턴 연습

    private int id;
    private String name;
    private String pw;
    private String address;

    private UserInfo() {}

    public static class MyBuilder1 {
        private int id;
        private String name;
        private String pw;
        private String address;

        public MyBuilder1 setId(int id) {
            this.id = id;
            return this;
        }

        public  MyBuilder1 setName(String name) {
            this.name = name;
            return this;
        }

        public MyBuilder1 setPw(String pw) {
            this.pw = pw;
            return this;
        }

        public MyBuilder1 setAddress(String address) {
            this.address = address;
            return this;
        }

        public UserInfo build() {
            UserInfo userInfo = new UserInfo();
            userInfo.id = id;
            userInfo.name = name;
            userInfo.pw = pw;
            userInfo.address = address;
            return userInfo;
        }

    }

    public static void main(String[] args) {
        UserInfo userInfo1 = new MyBuilder1().setId(1).setName("홍길동").build();
        UserInfo userInfo2 = new MyBuilder1().setId(2).setName("가나다").setPw("asd123").build();
        UserInfo userInfo3 = new MyBuilder1().setId(3).setName("이순신").setPw("qwe123").setAddress("부산시 진구").build();
    }

}
