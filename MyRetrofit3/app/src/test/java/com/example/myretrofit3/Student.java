package com.example.myretrofit3;

// Build 패턴
// this 키워드에 대한 충분한 이해 필요
public class Student {
    
    private String name;
    private int grade;

    // 1. 기본 생성자를 private 으로 정의한다.
    private Student() {}

    // 2. 내부 클래스를 생성한다. (보통 static (public, default, private 도 가능) - 내부 정적 클래스)
    // 내부클래스를 접근 제어 지시자를 무엇으로 하든 static이 붙으면 정적이다.
    // 내부 안에는 무조건 private으로 해야 함.
    public static class MyBuilder {
        // 2-1. out clas 멤버 변수를 한번 더 정의한다. (단, private으로)
        private String name;
        private int grade;
        
        // 2-2. setter 메서드를 만들어준다. (하지만 return 타입은 자기자신이다. --> this 키워드)
        public MyBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public MyBuilder setGrade(int grade) {
            this.grade = grade;
            return this;
        }

        // 3. 핵심
        // 리턴 타입을 out class로 반환하는 메서드를 만들어준다.
        public Student build() {
            Student student = new Student();
            student.name = name; //outer class의 멤버변수 = inner class의 멤버변수
            student.grade = grade;
            return student;
        }
    }

    public static void main(String[] args) {
        // 생성자에 매개변수를 넣어주는 경우, 생성할 때마다 모든 매개변수를 처리해줘야 하는데
        // 빌더 패턴의 경우 선택한 것들만 사용 가능하다.
        Student student1 = new MyBuilder().setName("홍길동").build();
        Student student2 = new MyBuilder().setGrade(1).build();
        Student student = new MyBuilder().setName("이순신").setGrade(3).build();
    }
    
    
}
