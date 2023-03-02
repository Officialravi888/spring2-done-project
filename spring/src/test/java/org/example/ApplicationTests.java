package org.example;

import org.example.model.Student;
import org.example.repository.StudentRepository;
import org.example.service.Studentservice;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.when;

@SpringBootTest
class ApplicationTests {

	@Autowired
	private Studentservice studentservice;
	@Mock
	private StudentRepository studentRepository;
	@Mock
	private Student student;

	@Test
	void contextLoads() {
	}
	@Test
	void createUser(){
		Student student=new Student(1,"raj",23,"raj@gmail.com");
		when(studentRepository.save(student)).thenReturn(student);
		assertThat(studentservice.createStudent(student));

	}
	@Test
	void getAllStudent(){
	List<Student> student=new ArrayList<>();
	Student student1=new Student(1,"raj",132,"raj@gmail.com");
	student.add(student1);

		when(studentRepository.findAll()).thenReturn(student);
		assertThat(studentservice.getStudents());
	}
//	@Test
//	void getAllStudentBYId(){
//		List<Student> student=new ArrayList<>();
//		Student student3=new Student(0,"raj",132,"raj@gmail.com");
//		student.add(student3);
//
//		when(studentRepository.findById(0)).thenReturn(Optional.of(student3));
//		assertThat(studentservice.getStudent(0).getName()).isEqualTo(student3.getName());
//	}

	@Test
	void createStudent(){
		List<Student> students=new ArrayList<>();
		Student student2=new Student(1,"Tom",24,"R@gmail.com");
		students.add(student2);
		when(studentRepository.save(student2)).thenReturn(student2);
		assertThat(studentservice.getStudents());
	}

	@Test
	void deleteStudent(){
Student student2=new Student(3,"Tom",24,"R@gmail.com");
		doAnswer(Answers.CALLS_REAL_METHODS).when(studentRepository).deleteById(any());

		assertThat(studentservice.deleteStudent(3)).isPresent();
	}
}
