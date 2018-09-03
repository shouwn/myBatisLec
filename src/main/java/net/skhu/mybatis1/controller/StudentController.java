package net.skhu.mybatis1.controller;

import java.util.List;

import net.skhu.mybatis1.dto.Department;
import net.skhu.mybatis1.dto.Student;
import net.skhu.mybatis1.mapper.DepartmentMapper;
import net.skhu.mybatis1.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("student")
public class StudentController {

    @Autowired private StudentMapper studentMapper;
    @Autowired private DepartmentMapper departmentMapper;

    @RequestMapping("list")
    public String list(Model model) {
        System.out.println("TEST");
        List<Student> students = studentMapper.findAll();
        model.addAttribute("students", students);
        return "student/list";
    }

    @RequestMapping(value="create", method=RequestMethod.GET)
    public String create(Model model) {
        Student student = new Student();
        List<Department> departments = departmentMapper.findAll();
        model.addAttribute("student", student);
        model.addAttribute("departments", departments);
        return "student/edit";
    }

    @RequestMapping(value="create", method=RequestMethod.POST)
    public String create(Model model, Student student) {
        studentMapper.insert(student);
        return "redirect:list";
    }

    @RequestMapping(value="edit", method=RequestMethod.GET)
    public String edit(Model model, @RequestParam("id") int id) {
        Student student = studentMapper.findOne(id);
        List<Department> departments = departmentMapper.findAll();
        model.addAttribute("student", student);
        model.addAttribute("departments", departments);
        return "student/edit";
    }

    @RequestMapping(value="edit", method=RequestMethod.POST)
    public String edit(Model model, Student student) {
        studentMapper.update(student);
        return "redirect:list";
    }

    @RequestMapping("delete")
    public String delete(Model model, @RequestParam("id") int id) {
        studentMapper.delete(id);
        return "redirect:list";
    }
}