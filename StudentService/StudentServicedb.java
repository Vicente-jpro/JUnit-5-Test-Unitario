package StudentService;

import java.util.ArrayList;
import java.util.List;

import StudentDomain.Student;
import StudentEnum.EnumException;
import StudentException.StudentDeleteException;
import StudentException.StudentNotFoundException;

public class StudentServicedb implements StudentService {

	private List<Student> list = new ArrayList<Student>();
	private static boolean STUDENT_NOT_FOUND = false;
	private static boolean STUDENT_FOUND = true;
	private static int ZERO = 0;
	private static String NULL_NAME = null;

	@Override
	public void save(Student student) throws IllegalArgumentException {
		if (isValidEstudent(student)) {
			list.add(student);
		} else {
			throw new IllegalArgumentException(EnumException.INVALID_STUDENT.message + " : " + student);
		}
	}

	@Override
	public List<Student> read() {
		list.stream().sorted().forEach( studentInList -> {
			System.out.println( studentInList );
		});
		return list;
	}

	@Override
	public void delete(Student student) throws StudentNotFoundException, StudentDeleteException {
		if (!list.isEmpty() && student.getId() > ZERO) {
			if (isValidID(student))
				list.remove(getStudentIndexInList(student));
			else
				throw new StudentDeleteException(EnumException.ESTUDENT_NOT_FOUND_DELETE.message + " : "+student);
		} else
			throw new StudentNotFoundException(EnumException.ESTUDENT_NOT_FOUND_DELETE.message + " : " + student);
			
	}

	@Override
	public void update(Student student) throws StudentNotFoundException {

		if (isValidID(student)) {
			int index = getStudentIndexInList(student);
			list.get(index).setName(student.getName());
		} else
			throw new StudentNotFoundException(EnumException.ESTUDENT_NOT_FOUND_UPDATE.message + ": " + student);
	}

	private boolean isValidID(Student student) {
		
			for (Student studentInList : list) {
				if (studentInList.getId() == student.getId())
					return STUDENT_FOUND;
			}

		return STUDENT_NOT_FOUND;
	}

	private boolean isValidEstudent(Student student) {

		return student.getId() > ZERO && student.getName() != NULL_NAME;

	}

	private int getStudentIndexInList(Student student) {
			
			for ( int i = 0; i < list.size(); i++) {
				if ( list.get(i).getId() == student.getId())
					return i;
			}
		
		return -1;
	}

	@Override
	public Student getStudent(Student student) throws StudentNotFoundException {
		try {

			if (isValidEstudent(student)) {
				int index = getStudentIndexInList(student);
				student = list.get(index);
			}

		} catch (Exception e) {
			throw new StudentNotFoundException(EnumException.ESTUDENT_NOT_FOUND.message, e);
		}

		return student;
	}

}
