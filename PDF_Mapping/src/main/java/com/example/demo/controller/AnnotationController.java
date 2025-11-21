package com.example.demo.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Annotation;
import com.example.demo.repo.AnnotationRepository;

import java.util.List;

@RestController
public class AnnotationController {

    private final AnnotationRepository annotationRepository;

    public AnnotationController(AnnotationRepository annotationRepository) {
        this.annotationRepository = annotationRepository;
    }

    
    @PostMapping("/api/pdf-annotation-mappings/bulk/")
    public ResponseEntity<?> saveMappings(@RequestBody List<Annotation> annotations) {
        List<Annotation> saved = annotationRepository.saveAll(annotations);
        return ResponseEntity.ok(saved);
    }

   
    @PostMapping("/app_admin/api/fetch-create-table/")
    public ResponseEntity<?> fetchMappings(@RequestBody FetchRequest req) {
        List<Annotation> result;
        if (req.formId() != null) {
            result = annotationRepository.findByProcessAndFormId(req.process(), req.formId());
        } else {
            result = annotationRepository.findByProcess(req.process());
        }
        return ResponseEntity.ok(result);
    }

    record FetchRequest(Long process, Long formId) {}
}
