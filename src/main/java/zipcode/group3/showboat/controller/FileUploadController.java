package zipcode.group3.showboat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import zipcode.group3.showboat.service.FileStorageService;

@Controller
@RequestMapping("/videoplayer")
public class FileUploadController {

    private FileStorageService storage;

    @Autowired
    public FileUploadController(FileStorageService storage) {
        this.storage = storage;
    }

    @GetMapping("/{filename}")
    public ResponseEntity<Resource> download(@PathVariable String filename) {
        return new ResponseEntity<>(storage.load(filename), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file) {
        System.out.println(file.isEmpty());
        return new ResponseEntity<>(storage.store(file), HttpStatus.OK);
    }
}
