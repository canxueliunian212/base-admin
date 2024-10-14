package com.test;

import com.qbc.BaseAdminApplication;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.security.RunAs;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassNme TestClass
 * @Description TODO
 * @Author chenpei
 * @Date 2024/09/16 12:23
 * @Version 1.0
 **/
//@SpringBootTest(classes = BaseAdminApplication.class)
//@RunWith(SpringRunner.class)
public class TestClass {

    public static void main(String[] args) {
        List<int[]> list = new ArrayList<>();
        list.add(new int[]{1});
        list.add(new int[]{2});
        int[][] array = list.toArray(new int[1][]);
        System.out.println(array);

    }
}
