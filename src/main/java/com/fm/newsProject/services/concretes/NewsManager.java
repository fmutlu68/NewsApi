package com.fm.newsProject.services.concretes;

import java.util.List;

import com.fm.newsProject.core.utilities.errors.EntityNotFoundError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fm.newsProject.core.utilities.results.DataResult;
import com.fm.newsProject.core.utilities.results.Result;
import com.fm.newsProject.core.utilities.results.SuccessDataResult;
import com.fm.newsProject.core.utilities.results.SuccessResult;
import com.fm.newsProject.models.concretes.News;
import com.fm.newsProject.repositories.abstracts.NewsRepository;
import com.fm.newsProject.services.abstracts.NewsService;
import com.fm.newsProject.services.businessAnnotations.Validate;
import com.fm.newsProject.services.validationRules.concretes.Validations;

@Service
public class NewsManager implements NewsService{

	private NewsRepository newsRepository;
	
	@Autowired
	public NewsManager(NewsRepository newsRepository) {
		super();
		this.newsRepository = newsRepository;
	}

	@Override
	@Validate(currentValidation = Validations.NEWSVALIDATOR)
	public Result add(News news) {
		newsRepository.add(news);
		return new SuccessResult("Haber Ekleme Başarılı.");
	}

	@Override
	public Result delete(News news) {
		newsRepository.delete(news);
		return new SuccessResult("Haber Silme İşlemi Başarılı.");
	}

	@Override
	@Validate(currentValidation = Validations.NEWSVALIDATOR)
	public Result update(News news) {
		newsRepository.update(news);
		return new SuccessResult("Haber Güncelleme İşlemi Başarılı.");
	}

	@Override
	public DataResult<List<News>> getAll() {
		return new SuccessDataResult<List<News>>(newsRepository.getAll(),"Haberler Listelendi.");
	}

	@Override
	public DataResult<List<News>> getAllByCategoryId(int categoryId) {
		return new SuccessDataResult<List<News>>(newsRepository.getAll(n -> n.getCategory().getId() == categoryId));
	}

	@Override
	public DataResult<News> getById(int id) {
		return new SuccessDataResult<News>(newsRepository.get(n -> n.getId() == id , "Haber") );
	}

	@Override
	public Result deleteById(int id) {
		var result = getById(id);
		if (result.getData() == null) {
			throw new EntityNotFoundError("Haber","Nuamraya Göre Silme","Girilen Numaraya Ait Haber Bulunamadı.");
		}else {
			newsRepository.delete(result.getData());
			return new SuccessResult("Haber Silme İşlemi Başarılı.");
		}
	}

}
