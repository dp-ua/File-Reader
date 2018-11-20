package com.examples.filereader.web.controller;

import com.examples.filereader.web.entity.FileInfo;
import com.examples.filereader.web.entity.LineInfo;
import com.examples.filereader.web.repo.FileInfoRepo;
import com.examples.filereader.web.repo.LineInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

@Controller    // This means that this class is a Controller
public class MainController {
    @Autowired
    FileInfoRepo fileInfoRepo;
    @Autowired
    LineInfoRepo lineInfoRepo;

    @GetMapping
    public String main(Map<String, Object> model) {
        model.put("files", fileInfoRepo.findAll());
        return "files";
    }

    @GetMapping(path = "/json")
        public @ResponseBody Iterable<FileInfo> getFileInfoList(){
        return fileInfoRepo.findAll();
    }

    @GetMapping(path = "/fileinfo")
    public String getFileInfo(
            @RequestParam(name = "fileID", required = true) int fileID,
            Map<String, Object> model) {

        Set<LineInfo> set = new LinkedHashSet<>((Collection<? extends LineInfo>) lineInfoRepo.findAll());
        set.removeIf(o -> o.getFileID() != fileID);
        model.put("lines", set);
        return "lines";
    }

    @GetMapping(path = "/fileinfojson")
    public @ResponseBody
    Set<LineInfo> getFileInfoJson(
            @RequestParam(name = "fileID", required = true) int fileID) {

        Set<LineInfo> set = new LinkedHashSet<>((Collection<? extends LineInfo>) lineInfoRepo.findAll());
        set.removeIf(o -> o.getFileID() != fileID);

        return set;
    }





}
