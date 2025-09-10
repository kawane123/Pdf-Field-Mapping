package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.PdfFile;
import com.example.demo.repo.PdfFileRepository;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/upload")
public class FileUploadController {

    private final PdfFileRepository pdfFileRepository;

    @Value("${upload.dir:uploads}")
    private String uploadDir;

    public FileUploadController(PdfFileRepository pdfFileRepository) {
        this.pdfFileRepository = pdfFileRepository;
    }

    @PostMapping
    public ResponseEntity<?> uploadPdf(@RequestParam("pdf") MultipartFile file) {
        try {
            Files.createDirectories(Paths.get(uploadDir));
            Path path = Paths.get(uploadDir, file.getOriginalFilename());
            Files.write(path, file.getBytes());

            PdfFile pdf = new PdfFile();
            pdf.setFilename(file.getOriginalFilename());
            pdfFileRepository.save(pdf);

            return ResponseEntity.ok().body(
                new UploadResponse(pdf.getId(), "/files/" + file.getOriginalFilename())
            );
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Upload failed: " + e.getMessage());
        }
    }

    @GetMapping("/files/{filename}")
    public ResponseEntity<?> getFile(@PathVariable String filename) {
        Path path = Paths.get(uploadDir, filename);
        if (!Files.exists(path)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(path.toFile());
    }

    record UploadResponse(Long process, String url) {}
}

