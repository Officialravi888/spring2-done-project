package org.example.errors0;


public class StudentNotFoundException extends RuntimeException{
    public StudentNotFoundException(int id){
        super("Student not found at:"+ id);
    }

}
