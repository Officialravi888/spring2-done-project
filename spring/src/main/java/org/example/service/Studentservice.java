package org.example.service;


import org.example.errors.StudentNotFoundException;
import org.example.model.Student;
import org.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Studentservice {
    @Autowired
    StudentRepository studentRepository;

    //getting all students
    public List<Student> getStudents(){
        ArrayList<Student> students = new ArrayList<>();
        studentRepository.findAll().forEach(students::add);
        return students;
    }

    //find student
    public Student getStudent(int id){
        return studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
    }

    //create a student
    public Student createStudent(Student student){
        return studentRepository.save(student);
    }

    //delete a student
    public void deleteStudent(int id){
        getStudent(id);
        studentRepository.deleteById(id);
    }

    //update student
    public void updateStudent(int id,Student student ){
        if(getStudent(id)!=null){
            studentRepository.save(student);
        }
    }
}
