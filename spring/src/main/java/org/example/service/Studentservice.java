package org.example.service;


import org.example.errors0.StudentNotFoundException;
import org.example.model.Student;
import org.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

@Service
public class Studentservice {
    @Autowired
   public StudentRepository studentRepository;

    //getting all students
    public List<Student> getStudents(){
        ArrayList<Student> students = new ArrayList<>();
        //studentRepository.findAll().forEach((students::add ));
        studentRepository.findAll().forEach((a )->students.add(a));
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
    public OptionalDouble deleteStudent(int id){

        studentRepository.deleteById(id);
        return null;
    }

    //update student
    public void updateStudent(int id,Student student ){
        if(getStudent(id)!=null){
            studentRepository.save(student);
        }
    }
}
