package net.skhu.mybatis1.dto;

import lombok.Data;

@Data
public class Student {
    private int id;
    private String studentNumber;
    private String name;
    private int departmentId;
    private int year;
    private String departmentName;
}
