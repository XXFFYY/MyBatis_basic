package com.Xie.mappers;

import com.Xie.pojo.Emp;

import java.util.List;

/**
 * @Description: 批量操作
 * @author: XieFeiYu
 * @eamil: 32096231@qq.com
 * @date:2022/7/15 17:48
 */
public interface EmpMapper3 {
    int insertEmpSome(List<Emp> list);
    int deleteEmpSome(List<Integer> list);
    int updateEmpSome(List<Integer> list);
}
