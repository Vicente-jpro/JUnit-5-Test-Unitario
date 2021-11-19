package Student;

import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.standard.PrinterInfo;

import StudentDomain.Student;
import StudentException.StudentDeleteException;
import StudentException.StudentNotFoundException;
import StudentService.StudentServicedb;

public class Main {

	public static void main(String[] args) throws StudentNotFoundException, StudentDeleteException {
		// TODO Auto-generated method stub
		
		Student student = new Student(1, "Vicente");
		Student student2 = new Student(2, "Luísa");
		Student student3 = new Student(3, "Madalena");
		Student student4 = new Student(0, null);
//
		
//		List<Student> list = new ArrayList<>();
//		list.add(student);
//		list.add(student2);
//		list.add(student3);
//		for ( int i = 0; i < list.size(); i++) {
//			if ( list.get(i).getId() == 3)
//				System.out.print("Elemento encontrado : "+list.get(i)+"\n");
//		}		
		StudentServicedb studentServicedb = new StudentServicedb();
		
		studentServicedb.save(student);
		studentServicedb.save(student2);
		studentServicedb.save(student3);
//		studentServicedb.save(student4);
		studentServicedb.read();
		System.out.println("\n");
		
		Student student5 = new Student(3, "Xavier");
		Student student6 = new Student(2, "Edmar");
		
		Student student7 = new Student(6, "AA");
		
		studentServicedb.update(student5);
		studentServicedb.update(student6);
//		studentServicedb.update(student4);
		studentServicedb.read();
		
		System.out.println("\n");
		studentServicedb.delete(student5);
//		studentServicedb.delete(student4);
		
		System.out.println(studentServicedb.getStudent(student7));
		
		studentServicedb.read();
		
		
		
		
	}

}
