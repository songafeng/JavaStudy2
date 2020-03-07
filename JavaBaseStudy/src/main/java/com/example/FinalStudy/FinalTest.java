package com.example.FinalStudy;


/*
用来修饰数据，包括成员变量和局部变量，该变量只能被赋值一次且它的值无法被改变。对于成员变量来讲，我们必须在声明时或者构造方法中对它赋值；
*/

class Value {
    int v;
    public Value(int v) {
        this.v = v;
    }
}

public class FinalTest {

    final int f1 = 1;
    final int f2;
    public FinalTest() {
        f2 = 2;
    }

    public static void main(String[] args) {
        final int value1 = 1;
        // value1 = 4;
        final double value2;
        value2 = 2.0;
        final Value value3 = new Value(1);
        value3.v = 4;
    }

/*    修饰方法参数
    那么使用final修饰表示我们只会给它赋值一次且不会改变变量的值。
    */
    public void finalFunc(final int i, final Value value) {
        // i = 5; 不能改变i的值
        // v = new Value(); 不能改变v的值
        value.v = 5; // 可以改变引用对象的值
    }
}