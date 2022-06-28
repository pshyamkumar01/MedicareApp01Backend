package com.shyam.angular.springboot.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shyam.angular.springboot.model.DatabaseFile;
import com.shyam.angular.springboot.service.DatabaseFileService;


@RestController

public class FileDownloadController {

    @Autowired
    private DatabaseFileService fileStorageService;
    
    @RequestMapping("/file")
    public String loadFile()
    {
    	return "Dashboard";
    }

    @GetMapping("/downloadFile/{imageName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String imageName, HttpServletRequest request, Model model) {
        // Load file as Resource
        DatabaseFile databaseFile = fileStorageService.getFile(imageName);
        
        model.addAttribute("databaseFile",databaseFile);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(databaseFile.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + databaseFile.getFileName() + "\"")
                .body(new ByteArrayResource(databaseFile.getData()));
        
        
    }
    
    //testing by file name
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/downloadFileByName/{imageName:.+}")
    public ResponseEntity<Resource> downloadFileByName(@PathVariable String imageName, HttpServletRequest request) {
        // Load file as Resource
    	System.out.println("The Image name is: "+imageName);
        DatabaseFile databaseFile = fileStorageService.getFileByName(imageName);
        
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(databaseFile.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + databaseFile.getFileName() + "\"")
                .body(new ByteArrayResource(databaseFile.getData()));
        
        
    }
    

}
