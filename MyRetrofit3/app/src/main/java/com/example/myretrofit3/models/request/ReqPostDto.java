package com.example.myretrofit3.models.request;

/**
 *      title: 'foo',
 *     body: 'bar',
 *     userId: 1,
 *
 *     A(모바일 - 액티비티) --> 객체를 생성해서 서비스 로직의 매개변수에 전달하는 코들 사용
 *     객체를 생성해서 보내야 한다.
 */


public class ReqPostDto {
    public String title;
    public  String body;
    public Integer userId;

    public ReqPostDto(String title, String body, Integer userId) {
        this.title = title;
        this.body = body;
        this.userId = userId;
    }
}
