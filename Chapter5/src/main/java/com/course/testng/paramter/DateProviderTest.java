package com.course.testng.paramter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;


public class DateProviderTest {


    @Test(dataProvider = "date")
    public void testDateProvider(String name,int age) {
        System.out.println("name =" + name + ";  age =" + age);
    }

    //标记一个方法是用来给其他测试方法提供数据的方法。要求该方法必须返回是object[][]
    @DataProvider(name="date")  //把@DataProvider方法里的数据传入@Test方法中使用
    public Object[][] providerDate(){
        Object[][] o = new Object[][] {
                {"zhangsan",10},
                {"lisi",20},
                {"wangwu",30}
        };
        return o;
    }


    @Test(dataProvider = "methodData")
    public void test1(String name,int age) {
        System.out.println("test111方法 name=" + name + ";  age=" +age);
    }

    @Test(dataProvider = "methodData")
    public void test2(String name,int age) {
        System.out.println("test222方法 name=" + name + ";  age=" +age);
    }

    //通过不同方法名给不同测试方法提供数据的方法。要求该方法必须返回是object[][]
    @DataProvider(name="methodData")
    public Object[][] methodDataTest(Method method){
        Object[][] result = null;

        if(method.getName().equals("test1")) {
            result = new Object[][] {
                    {"zhnagsan",20},
                    {"lisi",25}
            };
        }else if(method.getName().equals("test2")) {
            result = new Object[][] {
                    {"wangwu",50},
                    {"zhaoliu",60}
            };
        }
        return result;
    }

}

