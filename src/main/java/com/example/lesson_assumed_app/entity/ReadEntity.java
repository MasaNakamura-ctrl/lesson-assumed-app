package com.example.lesson_assumed_app.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="history")
public class ReadEntity {
    // DBからレッスン記録の内容を一通り取得
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "lessonDate")
    private LocalDate lessonDate;

    @Column(name = "studentName")
    private String studentName;

    @Column(name = "lessonMemo")
    private String lessonMemo;

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public LocalDate getLessonDate(){
        return lessonDate;
    }

    public void setLessonDate(LocalDate lessonDate){
        this.lessonDate = lessonDate;
    }

    public String getStudentName(){
        return studentName;
    }

    public void setStudentName(String studentName){
        this.studentName = studentName;
    }

    public String getLessonMemo(){
        return lessonMemo;
    }

    public void setLessonMemo(String lessonMemo){
        this.lessonMemo = lessonMemo;
    }
}
