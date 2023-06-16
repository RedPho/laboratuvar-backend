package com.emin.laboratuvar.controllers;

import com.emin.laboratuvar.models.FileDB;
import com.emin.laboratuvar.services.FileStorageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
@CrossOrigin("http://localhost:8081")
public class FileController {

    @Autowired
    private FileStorageService storageService;

    @PostMapping("/upload")
    public ResponseEntity uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";
        try {
            storageService.store(file);

            message = "Dosya basariyla yuklendi: " + file.getOriginalFilename();
            return new ResponseEntity(message, HttpStatus.OK);
        } catch (Exception e) {
            message = "Dosya yuklenirken bir hata olustu: " + file.getOriginalFilename() + "!";
            return new ResponseEntity(message, HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping("/files/{id}")
    public ResponseEntity<byte[]> getFile(@PathVariable String id) {
        FileDB fileDB = storageService.getFile(id);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getName() + "\"")
                .body(fileDB.getData());
    }
}