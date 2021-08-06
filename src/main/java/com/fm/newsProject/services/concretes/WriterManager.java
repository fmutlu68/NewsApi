package com.fm.newsProject.services.concretes;

import com.fm.newsProject.core.utilities.results.DataResult;
import com.fm.newsProject.core.utilities.results.Result;
import com.fm.newsProject.core.utilities.results.SuccessDataResult;
import com.fm.newsProject.core.utilities.results.SuccessResult;
import com.fm.newsProject.models.concretes.Writer;
import com.fm.newsProject.repositories.concretes.nHibernate.NhWriterRepository;
import com.fm.newsProject.services.abstracts.WriterService;
import com.fm.newsProject.services.businessAnnotations.Validate;
import com.fm.newsProject.services.validationRules.concretes.Validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WriterManager implements WriterService {

    private NhWriterRepository writerRepository;

    @Autowired
    public WriterManager(NhWriterRepository writerRepository) {
        this.writerRepository = writerRepository;
    }

    @Override
    @Validate(currentValidation = Validations.WRITERVALIDATOR)
    public Result add(Writer writer) {
        writerRepository.add(writer);
        return new SuccessResult("Yazar Ekleme İşlemi Başarılı.");
    }

    @Override
    public Result delete(Writer writer) {
        writerRepository.delete(writer);
        return new SuccessResult("Yazar Silme İşlemi Başarılı.");
    }

    @Override
    @Validate(currentValidation = Validations.WRITERVALIDATOR)
    public Result update(Writer writer) {
        writerRepository.update(writer);
        return new SuccessResult("Yazar Güncelleme İşlemi Başarılı.");
    }

    @Override
    public DataResult<List<Writer>> getAll() {
        return new SuccessDataResult<List<Writer>>(writerRepository.getAll());
    }

    @Override
    public DataResult<Writer> getById(int id) {
        return new SuccessDataResult<Writer>(writerRepository.get(w -> w.getWriterId() == id, "Yazar"));
    }
}
