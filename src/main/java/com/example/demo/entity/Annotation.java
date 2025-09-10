package com.example.demo.entity;



import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Annotation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long process; 
    private Long formId;
    private Long fieldId;
    private String fieldName;
    private String fieldHeader;
    private int page;
    private String bboxJson;  
    private Double scale;
    private String fieldType;
    private String metadataJson;

    private LocalDateTime createdAt = LocalDateTime.now();

   
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getProcess() { return process; }
    public void setProcess(Long process) { this.process = process; }
    public Long getFormId() { return formId; }
    public void setFormId(Long formId) { this.formId = formId; }
    public Long getFieldId() { return fieldId; }
    public void setFieldId(Long fieldId) { this.fieldId = fieldId; }
    public String getFieldName() { return fieldName; }
    public void setFieldName(String fieldName) { this.fieldName = fieldName; }
    public String getFieldHeader() { return fieldHeader; }
    public void setFieldHeader(String fieldHeader) { this.fieldHeader = fieldHeader; }
    public int getPage() { return page; }
    public void setPage(int page) { this.page = page; }
    public String getBboxJson() { return bboxJson; }
    public void setBboxJson(String bboxJson) { this.bboxJson = bboxJson; }
    public Double getScale() { return scale; }
    public void setScale(Double scale) { this.scale = scale; }
    public String getFieldType() { return fieldType; }
    public void setFieldType(String fieldType) { this.fieldType = fieldType; }
    public String getMetadataJson() { return metadataJson; }
    public void setMetadataJson(String metadataJson) { this.metadataJson = metadataJson; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
