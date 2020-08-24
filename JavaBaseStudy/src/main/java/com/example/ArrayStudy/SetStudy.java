package com.example.ArrayStudy;

import java.util.HashSet;
import java.util.Iterator;

public class SetStudy {
    public static void main(String[] args) {
        HashSet set = new HashSet();
        //分别向books集合中添加两个A对象，两个B对象，两个C对象
        set.add(new A());
        set.add(new A());

        set.add(new B());
        set.add(new B());

        set.add(new C());
        set.add(new C());
        System.out.println(set);
        System.out.println(set.size());
        for(Iterator iter = set.iterator(); iter.hasNext();){
            Object value =  iter.next();
            System.out.println(value);
        }
    }
}

//类A的equals方法总是返回true,但没有重写其hashCode()方法。不能保证当前对象是HashSet中的唯一对象
class A
{
    public boolean equals(Object obj)
    {
        return true;
    }
}

//类B的hashCode()方法总是返回1,但没有重写其equals()方法。不能保证当前对象是HashSet中的唯一对象
class B
{
    public int hashCode()
    {
        return 1;
    }
}

//类C的hashCode()方法总是返回2,且有重写其equals()方法
class C
{
    public int hashCode()
    {
        return 2;
    }
    public boolean equals(Object obj)
    {
        return true;
    }
}
