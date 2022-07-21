package com.Xie.test;

import com.Xie.pojo.Emp;
import com.Xie.utils.SessionUtils;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: XXX
 * @author: XieFeiYu
 * @eamil: 32096231@qq.com
 * @date:2022/7/10 12:22
 */
public class EmpTest_1 {
    public static void main(String[] args) throws IOException, ParseException {
        //1.获取会话
        SqlSession session = SessionUtils.getSession();

        //2.执行sql
        //基本数据类型|包装类：根据员工编号查询员工信息
        Emp emp = session.selectOne("com.Xie.mappers.EmpMapper.queryEmpByNo", 7369);
        System.out.println(emp);

        //String : 根据工种查询员工信息
        List<Emp> list = session.selectList("com.Xie.mappers.EmpMapper.queryEmpByJob", "CLERK");
        System.out.println(list);

        //Date : 根据员工入职日期查询员工信息
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2022-07-12");
        list = session.selectList("com.Xie.mappers.EmpMapper.queryEmpByDate", date);
        System.out.println(list);

        //JAVABEAN : 根据员工姓名与薪资查询员工信息
        Emp e = new Emp();
        e.setEname("SMITH");
        e.setSal(800.0);
        emp = session.selectOne("com.Xie.mappers.EmpMapper.queryEmpByNameSal", e);
        System.out.println(emp);

        //Map : 根据员工薪资或部门编号查询员工信息
        Map map = new HashMap<>();
        map.put("sal",200);
        map.put("deptno", 1);
        list = session.selectList("com.Xie.mappers.EmpMapper.queryEmpBySalDeptno", map);
        System.out.println(list);

        //数组|List : 根据员工部门编号查询员工信息
        list = session.selectList("com.Xie.mappers.EmpMapper.queryEmpByDeptno", new int[]{1,2});
        System.out.println(list);
        //3.关闭
        session.close();
    }
}
