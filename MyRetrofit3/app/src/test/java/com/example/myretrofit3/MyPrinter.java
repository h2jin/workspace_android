package com.example.myretrofit3;

// 싱글톤 패턴
// 
public class MyPrinter {

    private static MyPrinter myPrinter;

    private MyPrinter() {
    }

    public static MyPrinter getInstance() {
        if (myPrinter == null) {
            myPrinter = new MyPrinter();
        }
        return myPrinter;
    }

    // 테스트 코드 작성
    public static void main(String[] args) {
       AClazz aClazz = new AClazz(); // 생성자 내부에 MyPrinter가 메모리에 올라감
        BClazz bClazz = new BClazz();

        // 래퍼런스 주소 비교 - 같은 객체이면 주소값이 같게 나올 것.

        MyPrinter myPrinterA = aClazz.myPrinter;
        MyPrinter myPrinterB = bClazz.myPrinter;

        // Object equals()
        System.out.println(myPrinterA.equals(myPrinterB)); // 결과값 true

    }
    
}

class AClazz {
    public MyPrinter myPrinter;

    public AClazz() {
        myPrinter = MyPrinter.getInstance();
    }
}

class BClazz {
    public MyPrinter myPrinter;

    public BClazz() {
        myPrinter = MyPrinter.getInstance();
    }
}
