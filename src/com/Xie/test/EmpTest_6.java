package com.Xie.test;

import com.Xie.mappers.EmpMapper4;
import com.Xie.pojo.Emp;
import com.Xie.utils.SessionUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @Description: 动态SQL测试
 * @author: XieFeiYu
 * @eamil: 32096231@qq.com
 * @date:2022/7/16 12:26
 */
public class EmpTest_6 {
    public static void main(String[] args) {
        //1.获取会话
        SqlSession session = SessionUtils.getSession();

        //2.获取实现类对象
        EmpMapper4 mapper4 = session.getMapper(EmpMapper4.class);

        //3.执行SQL
        List<Emp> list = mapper4.queryEmpByNameSal2("SMITH",100.0);
        list.forEach(System.out::println);

//        Emp emp1 = new Emp(1001,"", 0);
//        mapper4.updateNameDeptnoByEmpno(emp1);
        list = mapper4.queryEmpByNameLike("S");
        list.forEach(System.out::println);
        //4.关闭会话
        session.close();
    }
}
