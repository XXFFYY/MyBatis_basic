package com.Xie.test;

import com.Xie.mappers.EmpMapper3;
import com.Xie.pojo.Emp;
import com.Xie.utils.SessionUtils;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import static java.util.List.*;

/**
 * @Description: 批量操作测试
 * @author: XieFeiYu
 * @eamil: 32096231@qq.com
 * @date:2022/7/16 9:42
 */
public class EmpTest_5 {
    public static void main(String[] args) {
        //1.打开会话
        SqlSession session = SessionUtils.getSession();

        //2.获取实现类对象
        EmpMapper3 mapper3 = session.getMapper(EmpMapper3.class);

        //3.执行SQL
            //批量删除
//        List<Integer> list = new ArrayList<>();
//        list.add(1111);
//        list.add(3333);
//        mapper3.deleteEmpSome(list);


        //批量插入
//        Emp emp1 = new Emp(1001, "王二", 2);
//        Emp emp2 = new Emp(1002, "王三", 1);
//        List list = new ArrayList<>();
//        list.add(emp1);
//        list.add(emp2);
//        mapper3.insertEmpSome(list);


        //批量修改
        List list = new ArrayList<>();
        Emp emp1 = new Emp(1001, "王二二", 2);
        Emp emp2 = new Emp(1002, "王三三", 1);
        list.add(emp1);
        list.add(emp2);
        mapper3.updateEmpSome(list);
    }
}
