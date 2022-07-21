package com.Xie.test;

import com.Xie.pojo.Dept;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @Description: XXX
 * @author: XieFeiYu
 * @eamil: 32096231@qq.com
 * @date:2022/7/10 10:40
 */
/*
    查询测试
        selectOne
        selectList
        selectMap
 */
public class DeptTest_2 {
    public static void main(String[] args) throws IOException {
        //1.获取会话
        SqlSession session = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml")).openSession();

        //2.执行sql
        //selectOne("") 执行指定的sql查询数据，返回一个结果，对象，如果没有查询到返回null
            //只有一个参数，参数为命名空间.id
        //selectOne("",Object) 第一个参数为命名空间.id,第二个参数为sql语句的实参
        Dept dept = session.selectOne("com.Xie.mappers.DeptMapper.queryDeptByDeptno", 10);

        //selectList("命名空间.id")
        //selectOne("命名空间.id",Object) 第二个参数为sql语句的实参,查询到返回存储数据的集合，没查询到返回空list
        List<Dept> list = session.selectList("com.Xie.mappers.DeptMapper.queryDeptByDeptno", 20);
        System.out.println(list);


//        session.selectMap("","") 返回结果为Map  第一个参数为命名空间.id,第二个参数返回的Map集合中key的字段名
//        session.selectMap("",object,"") 返回结果为Map  第一个参数为命名空间.id,第二个参数为sql实参，第三个参数返回的Map集合中key的字段名
        //注意：Map 的value类型为JavaBean类型
        Map<String,Dept> map = session.selectMap("com.Xie.mappers.DeptMapper.queryAll", "dname");
        System.out.println(map);

        List<String> list2 = session.selectList("com.Xie.mappers.DeptMapper.queryName");
        System.out.println(list2);

        //3.关闭会话
        session.close();
    }
}
