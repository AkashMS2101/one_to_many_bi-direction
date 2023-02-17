package one_to_many_bi2.controller;

import java.util.ArrayList;
import java.util.List;

import one_to_many_bi2.dao.StudentDAO;
import one_to_many_bi2.dto.School;
import one_to_many_bi2.dto.Student;

public class StudentMain {
	public static void main(String[] args) {
		Student student = new Student();
		StudentDAO dao = new StudentDAO();
		School school = new School();
		
		student.setId(1);
		student.setName("yashu");
		student.setMarks(60);
		student.setPhone(985236);
		
		school.setId(101);
		school.setLocation("Banglore");
		school.setName("KVH");
		
		List<Student> list =new ArrayList<Student>();
		list.add(student);
		
		student.setSchool(school);
		school.setList(list);
		
		//dao.saveStudent(student);
		//dao.deleteStudent(1);
		//dao.updateStudent(1, "Suhas");
		dao.displayById(1);
	}
}
