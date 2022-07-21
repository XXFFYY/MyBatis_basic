package com.Xie.test;

import com.Xie.pojo.Dept;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Description: XXX
 * @author: XieFeiYu
 * @eamil: 32096231@qq.com
 * @date:2022/7/9 14:28
 */

/*
    Mybatis基础使用
        1.项目配置
            1）新建项目
            2）项目下新建lib,jar包放入目录下
               mybatis核心 jar包
               mybatis依赖jar包
               数据库驱动jar包
            3)add as lib....
        2.定义核心配置文件
        3.定义SQL映射文件
        4.基础使用
 */
public class DeptTest_1 {
    public static void main(String[] args) throws IOException {
        //1.加载核心配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");

        //2.构件SqlSessionFactory实例
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

        //3.获取SqlSession会话
        SqlSession session = factory.openSession();

        //4.执行 sql
        //selectList("命名空间.id")
        List<Dept> list = session.selectList("com.Xie.mappers.DeptMapper.queryAll");

        //5.处里结果
        list.forEach(System.out::println);

        //6.关闭会话
        session.close();
    }
}
