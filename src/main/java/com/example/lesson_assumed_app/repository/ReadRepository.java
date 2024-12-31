package com.example.lesson_assumed_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lesson_assumed_app.entity.ReadEntity;


public interface ReadRepository extends JpaRepository<ReadEntity, Integer>{
}
