package com.example.lesson_assumed_app.model;

import java.time.LocalDate;

public class Lesson{
    // DBからレッスン記録の内容を一通り取得
    private int id;
    private LocalDate lessonDate;
    private String studentName;
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