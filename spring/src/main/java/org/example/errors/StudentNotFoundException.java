package org.example.errors;


public class StudentNotFoundException extends RuntimeException{
    public StudentNotFoundException(int id){
        super("Student not found at:"+ id);
    }

}
