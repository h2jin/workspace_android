package com.example.movie_1.interfaces;

// 1. 인터페이스 선언하기
// 1-1. 추상 메서드를 선언한다. (구분해야 할 부분이나 데이터를 전달해야할 경우, 매개 변수를 만들어준다.)
// 2. 호출자에 가서 멤버변수 선언한다.(interface)
// 2-1. 필요한 곳에서 OnChangeToolbarType 속해있는 추상메서드를 호출하면 된다.
// 호출자 --> MOVIE Fragment, INFO Fragment
public interface OnChangeToolbarType {
    // 확장성 있게, 유지보수 편하게 생각을 해 본다.
    void onSetupType(String title);
    // Fragment --> 메서드 호출(IF(MOVIE), IF(INFO) ) .. 값만 던지면 됨.
    // mainActivity --> 콜백 받음
}
