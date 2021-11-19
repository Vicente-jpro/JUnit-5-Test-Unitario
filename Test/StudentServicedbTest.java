package Test;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.Matcher.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.CollectionUtils;

import StudentDomain.Student;
import StudentEnum.EnumException;
import StudentException.StudentDeleteException;
import StudentException.StudentNotFoundException;
import StudentService.StudentServicedb;

class StudentServicedbTest {

	private StudentServicedb studentServicedb;
	private static int ID_ZERO = 0;
	private static String NULL_NAME = null;

	@Test
	@DisplayName("Save person ")
	void save() {
		studentServicedb = new StudentServicedb();
		assertAll("Save persons and throw exception if exits an unvalide ", () -> {

			studentServicedb.save(new Student(1, "Vicente"));

			// When invalide Student is tring to be saved
			IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
					() -> studentServicedb.save(new Student(ID_ZERO, NULL_NAME)));

			assertEquals(EnumException.INVALID_STUDENT.message + " : " + new Student(ID_ZERO, NULL_NAME),
					exception.getMessage());
		});

	}

	@Test
	@Order(1)
	@DisplayName("Delete student")
	void deleteTest() throws StudentNotFoundException, StudentDeleteException {

		this.studentServicedb = new StudentServicedb();

		studentServicedb.save(new Student(4, "Português"));
		studentServicedb.delete(new Student(4, "Português"));

	}

	@Test
	@Order(2)
	@DisplayName("Delete  ->  Student Not Found Exception")
	void deleteStudentNotFoundExceptionTest() {

		this.studentServicedb = new StudentServicedb();

		// Exception when list is empty
		StudentNotFoundException studentNotFoundException = assertThrows(StudentNotFoundException.class,
				() -> studentServicedb.delete(new Student(4, "Português")));

		assertEquals(EnumException.ESTUDENT_NOT_FOUND_DELETE.message + " : " + new Student(4, "Português"),
				studentNotFoundException.getMessage());

	}

	@Test
	@Order(3)
	@DisplayName("Delete -> Student Delete Exception")
	void deleteStudentDeleteExceptionTest() throws StudentNotFoundException, StudentDeleteException {

		this.studentServicedb = new StudentServicedb();

		studentServicedb.save(new Student(4, "Português"));

		// Exception when is invalid student (id that do not exist in list)
		StudentDeleteException studentDeleteException = assertThrows(StudentDeleteException.class,
				() -> studentServicedb.delete(new Student(5, "Português")));
s
		assertEquals(EnumException.ESTUDENT_NOT_FOUND_DELETE.message + " : " + new Student(5, "Português"),
				studentDeleteException.getMessage());

	}

	@Test
	void updateTest() {

	}

	@Test
	void isValidIDTest() {

	}

	@Test
	void isValidEstudentTest() {

	}

	@Test
	void getStudentIndexInListTest() {

	}

}
