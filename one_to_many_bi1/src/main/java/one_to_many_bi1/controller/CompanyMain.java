package one_to_many_bi1.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import one_to_many_bi1.dao.CompanyDao1;
import one_to_many_bi1.dao.EmployeeDAO;
import one_to_many_bi1.dto.Company;
import one_to_many_bi1.dto.Employee;

public class CompanyMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Company company = new Company();
		Employee employee = new Employee();
		CompanyDao1 companyDao1= new CompanyDao1();
		EmployeeDAO dao = new EmployeeDAO();
		boolean exit = true;
		do {
			System.out.println("Enter your choice");
			System.out.println("1.to insert");
			int choice=scanner.nextInt();
			switch (choice) {
			case 1:{
				System.out.println("enter the company details");
				System.out.println("company id");
				int c_id=scanner.nextInt();
				System.out.println("comapny name");
				String c_name=scanner.next();
				System.out.println("company gst code");
				String gst = scanner.next();
				
				company.setId(c_id);
				company.setName(c_name);
				company.setGst(gst);
				
				System.out.println("enter the employee details");
				System.out.println("Employee id");
				int e_id=scanner.nextInt();
				System.out.println("employee name");
				String e_name=scanner.next();
				System.out.println("employee phone number");
				long phone = scanner.nextLong();
				
				employee.setId(e_id);
				employee.setName(e_name);
				employee.setPhone(phone);
				
				List<Employee> list = new ArrayList<Employee>();
				list.add(employee);
				
				company.setList(list);
				employee.setCompany(company);
				
				dao.saveEmployee(employee);
				break;
			}
			}
		}while(exit);
	}
}
