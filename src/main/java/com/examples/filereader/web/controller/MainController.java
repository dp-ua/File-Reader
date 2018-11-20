package com.examples.filereader.web.controller;

import com.examples.filereader.web.entity.FileInfo;
import com.examples.filereader.web.repo.FileInfoRepo;
import com.examples.filereader.web.repo.LineInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller    // This means that this class is a Controller
public class MainController {
    @Autowired
    FileInfoRepo fileInfoRepo;
    @Autowired
    LineInfoRepo lineInfoRepo;

    @GetMapping
    public @ResponseBody Iterable<FileInfo> getAllFiles(){
        return fileInfoRepo.findAll();
    }

}
