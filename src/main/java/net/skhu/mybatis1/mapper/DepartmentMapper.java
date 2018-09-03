package net.skhu.mybatis1.mapper;

import net.skhu.mybatis1.dto.Department;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DepartmentMapper {
    List<Department> findAll();
}
