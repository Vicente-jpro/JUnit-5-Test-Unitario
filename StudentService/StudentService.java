package StudentService;

import java.util.List;

import StudentDomain.Student;
import StudentException.StudentDeleteException;
import StudentException.StudentNotFoundException;

public interface StudentService {
	void save(Student student);
	List<Student> read();
	void delete(Student student) throws StudentNotFoundException, StudentDeleteException;
	void update(Student student) throws StudentNotFoundException;
	Student getStudent(Student student) throws StudentNotFoundException;
}
