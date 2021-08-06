package com.fm.newsProject.api.controllers;

import com.fm.newsProject.core.utilities.results.DataResult;
import com.fm.newsProject.core.utilities.results.Result;
import com.fm.newsProject.models.concretes.Writer;
import com.fm.newsProject.services.concretes.WriterManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/writer")
@CrossOrigin(origins = "http://localhost:4200")
public class WriterController {
    private WriterManager writerManager;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    public WriterController(WriterManager writerManager) {
        this.writerManager = writerManager;
    }

    @GetMapping("/getall")
    public DataResult<List<Writer>> getAll(){
        return this.writerManager.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Writer writer){
        return this.writerManager.add(writer);
    }

    @PostMapping("/update")
    public Result update(@RequestBody Writer writer){
        return this.writerManager.update(writer);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Writer writer){
        return this.writerManager.delete(writer);
    }

    @GetMapping("/getbyid/{id}")
    public DataResult<Writer> getById(@RequestParam int id){
        return this.writerManager.getById(id);
    }
}
