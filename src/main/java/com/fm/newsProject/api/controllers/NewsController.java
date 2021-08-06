package com.fm.newsProject.api.controllers;

import java.util.List;

import com.fm.newsProject.core.utilities.results.SuccessResult;
import com.fm.newsProject.models.dtos.NewsDtoToAdd;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.fm.newsProject.core.utilities.results.DataResult;
import com.fm.newsProject.core.utilities.results.Result;
import com.fm.newsProject.models.concretes.News;
import com.fm.newsProject.services.abstracts.NewsService;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping("/api/news")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class NewsController {
	private final NewsService newsService;
	
	@Autowired
	public NewsController(NewsService newsService) {
		super();
		this.newsService = newsService;
	}

	
	
	@GetMapping("/getall")
	public DataResult<List<News>> getAll(){
		return this.newsService.getAll();
	}

	@GetMapping("/getallbycategoryid/{categoryId}")
	public DataResult<List<News>> getAllByCategoryId(@PathVariable int categoryId){
		return this.newsService.getAllByCategoryId(categoryId);
	}
	
	@GetMapping("/getbyid/{id}")
	public DataResult<News> getById(@PathVariable int id){
		return this.newsService.getById(id);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody News news) {
		return this.newsService.add(news);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestBody News news) {
		return this.newsService.delete(news);
	}

	@PostMapping("/addwithimg")
	public Result addWithImage(@RequestBody NewsDtoToAdd news){
		return null;
	}

	@PostMapping("/update")
	public Result update(@RequestBody News news) {
		return this.newsService.update(news);
	}
	
	@GetMapping("/deletebyid/{id}")
	public Result deleteById(@PathVariable int id) {
		return this.newsService.deleteById(id);
	}
}
