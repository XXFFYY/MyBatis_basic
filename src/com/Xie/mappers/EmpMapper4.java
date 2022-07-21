package com.Xie.mappers;

import com.Xie.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description: 测试动态SQL
 * @author: XieFeiYu
 * @eamil: 32096231@qq.com
 * @date:2022/7/16 12:16
 */
public interface EmpMapper4 {
    /*
        根据员工姓名查询员工信息
            name有效，sal无效
        根据员工薪资查询员工信息
            name无效，sal有效
        根据员工薪资与姓名查询员工信息
            name有效，sal有效
        查询所有员工数据
            两个参数都无效，默认查询所有
            参数无效：null,指定的默认值
     */
    List<Emp> queryEmpByNameSal(@Param("name") String name,@Param("sal") Double sal);

    /*
        查询所有员工信息
        如果存在员工名称 优先使用员工名称查询
        如果存在员工薪资 根据员工薪资查询
        如果都存在 员工名称优先
     */
    List<Emp> queryEmpByNameSal2(@Param("name") String name,@Param("sal") Double sal);

    /*
        修改员工信息
     */
    int updateNameDeptnoByEmpno(Emp emp);

    /*
        根据用户名模糊查询员工信息

     */
    List<Emp> queryEmpByNameLike(String name);

}
