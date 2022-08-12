package com.org;

import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Employee {
	static ArrayList<Employee> emplist = new ArrayList<Employee>();
	String id;
	String name;
	String skills;
	int age;
	int salary;
	Date doj;

	public Employee(String id, String name, String skills, int age, int salary, Date doj) {
		super();
		this.id = id;
		this.name = name;
		this.skills = skills;
		this.age = age;
		this.salary = salary;
		this.doj = doj;
	}

	public static void insert() throws ParseException {

		Scanner sc = new Scanner(System.in);
		UUID uuid = UUID.randomUUID();
		String id = uuid.toString();
		System.out.println("Enter the Employee Name");
		String name = sc.nextLine();
		
		System.out.println("Enter the Employee Skills");
		String Skills = sc.nextLine();
		
		System.out.println("Enter the Employee Age");
		int age = sc.nextInt();
		
		System.out.println("Enter the Employee Salary");
		int salary = sc.nextInt();
		
		System.out.println("Enter the Employee Date of Joining in (DD/MM/YYYY) format ");
        String doj = sc.next();
		
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date date = sdf.parse(doj);
		
		Employee emp = new Employee(id, name, Skills, age, salary, date);
		emplist.add(emp);

	}

	public static void read() {
		if (emplist.size() != 0) {
			
			for (Employee emp : emplist) {
				
				System.out.println("Employee Informations ");
				System.out.println();
				System.out.println("Employee UUID is " + emp.getId());
                System.out.println("Employee Name is " + emp.getName());
				System.out.println("Employee Skills is " + emp.getSkills());
				System.out.println("Employee Age is " + emp.getAge());
				System.out.println("Employee Salary is " + emp.getSalary());
				System.out.println("Employee Date of Joining is " + emp.getDoj());
			}
		} 
		else {
			System.out.println("There is no employee detail's.. ");
		}
	}

	public static void delete() {
		System.out.println("Enter the Id to delete detail's");
		Scanner sc = new Scanner(System.in);
		String id = sc.next();
		boolean found = false;
		Employee empdelete = null;

		for (Employee Emp : emplist) {
			if (Emp.getId().equals(id)) {
				empdelete = Emp;
				found = true;
			}
		}
		if (!found) {
			System.out.println("Employee is not present..Please Enter the Valid ID");
		} else {
			emplist.remove(empdelete);
			System.out.println("Employee Deleted Successfully.. ");
		}
	}
    public static void update() {
		System.out.println("Enter the Employee Id to Update the detail's ");
		Scanner sc = new Scanner(System.in);
		String id = sc.nextLine();
		boolean found = false;

		for (Employee Emp : emplist) {
			if (Emp.getId().equals(id)) {
				System.out.println("Enter the Employee Name ");
				String name = sc.nextLine();
				Emp.setName(name);
				
				System.out.println("Enter the Employee Skills ");
				String skills = sc.nextLine();
				Emp.setSkills(skills);
				
				
				System.out.println("Enter the Employee Salary ");
				int salary = sc.nextInt();
				Emp.setSalary(salary);
				
				System.out.println("Enter the Employee Age ");
				int age = sc.nextInt();
				Emp.setAge(age);
				found = true;
			}
		}
		if (!found) {
			System.out.println("Invalid ID..Please Enter the Correct Id ");
		} else {
			System.out.println("Detail's Updated Successfully...");
		}
	}

	public static void searchbyuuid() {
		System.out.println("Enter the ID to get the Employee Detail's ");
		Scanner sc = new Scanner(System.in);
		String id = sc.next();
		boolean found = false;
		for (Employee emp : emplist) {
			
			if (emp.getId().equals(id)) {
				System.out.println("Employee Name is " + emp.getName());
				System.out.println("Employee Skills is " + emp.getSkills());
				System.out.println("Employee Age is " + emp.getAge());
				System.out.println("Employee Salary is " + emp.getSalary());
				System.out.println("Employee Date of Joining is " + emp.getDoj());
				found = true;
			}
		}
		if (!found) {
			System.out.println("Invalid Id... Please Enter Correct Id");
		}
		else {
			System.out.println(".....");
		}
	}

	public static void SortingByAge() {
		int i, j;
        if(emplist.size()!=0)
        {
            System.out.println("Detail's Sorted by age Successfully...");
		    for (i = 0; i < emplist.size(); i++)
		    {
			    for (j = i + 1; j < emplist.size(); j++) 
			    {
                    if (emplist.get(i).getAge() > emplist.get(j).getAge()) 
                    {
					    Employee temp = emplist.get(i);
					    emplist.set(i, emplist.get(j));
					    emplist.set(j, temp);
				    }
			    }
		     }
        }
        else
        {
        	System.out.println("There are no Employee Detail's.. ");
        }
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return id + " " + name + " " + skills + " " + age + " " + salary + " " + doj;
	}

	public static ArrayList<Employee> getEmplist() {
		return emplist;
	}

	public static void setEmplist(ArrayList<Employee> emplist) {
		Employee.emplist = emplist;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	public static void exit() {
		System.exit(0);
	}

	public static void main(String[] args) throws ParseException {

		while (true) {
			System.out.println("Enter your Choice");
			System.out.println("1. Insert");
			System.out.println("2. Read  ");
			System.out.println("3. Delete ");
			System.out.println("4. Update ");
			System.out.println("5. SearchByUUID");
			System.out.println("6. SortingByAge");
			System.out.println("7. Exit    ");
			Scanner sc = new Scanner(System.in);
			int ch = sc.nextInt();
			
			switch (ch) {
			case 1:
				insert();
				break;
			
			case 2:
				read();
				break;
			
			case 3:
				delete();
				break;
			
			case 4:
				update();
				break;
			
			case 5:
				searchbyuuid();
				break;
			
			case 6:
				SortingByAge();
				break;
			
			case 7:
				exit();
				break;
			
			default:
				System.out.println("Invalid Choice");
			}
		}
	}
}
