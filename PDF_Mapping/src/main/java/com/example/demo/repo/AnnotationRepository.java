package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Annotation;

import java.util.List;

public interface AnnotationRepository extends JpaRepository<Annotation, Long> {
    List<Annotation> findByProcess(Long process);
    List<Annotation> findByProcessAndFormId(Long process, Long formId);
}
