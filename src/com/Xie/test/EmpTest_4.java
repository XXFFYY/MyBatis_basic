package com.Xie.test;

import com.Xie.mappers.EmpMapper2;
import com.Xie.pojo.Emp;
import com.Xie.utils.SessionUtils;
import org.apache.ibatis.session.SqlSession;

/**
 * @Description: 接口绑定方案下实现增删改
 * @author: XieFeiYu
 * @eamil: 32096231@qq.com
 * @date:2022/7/15 16:54
 */
public class EmpTest_4 {
    public static void main(String[] args) {
        //1.获取会话
        SqlSession session = SessionUtils.getSession();

        //2.获取接口类实现类对象
        EmpMapper2 mapper2 = session.getMapper(EmpMapper2.class);

        //3.调用接口中定义的功能
        Emp emp = new Emp();
        emp.setSal(333);
        emp.setDeptno(2);
        emp.setEmpno(3333);
        emp.setEname("张三");
        int rows = mapper2.insertEmp(emp);
        System.out.println(rows);

        //4.关闭会话
        session.close();
    }
}
