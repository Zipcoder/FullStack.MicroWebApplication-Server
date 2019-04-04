package com.example.demo.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class VideoController {
    List<String> returnList = new ArrayList<>();

    @GetMapping("/videos/")
    public List<String> getVideoList(){

        returnList.add("Video1");
        returnList.add("Video2");
        returnList.add("Video3");
        returnList.add("Video4");
        returnList.add("Video5");

        return returnList;
    }

//    @GetMapping("/videos/{id}")
//    public String getVideoList(@PathVariable String id){
//
//
//        return returnList.get(id);
//    }
}
