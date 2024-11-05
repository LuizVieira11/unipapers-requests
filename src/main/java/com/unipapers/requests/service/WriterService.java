package com.unipapers.requests.service;

import com.unipapers.requests.model.entity.Writer;
import com.unipapers.requests.model.repository.WriterRepository;
import com.unipapers.requests.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WriterService {

    @Autowired
    private WriterRepository writerRepository;

    public List<Writer> findAll(){
        return writerRepository.findAll();
    }

    public Writer findByEmail(String email) {
        Optional<Writer> obj = writerRepository.findWriterByEmail(email);
        return obj.orElseThrow(() -> new ResourceNotFoundException(email));
    }

    public Writer findById(Long id) {
        Optional<Writer> obj = writerRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Writer insert(Writer writer) {
        return writerRepository.save(writer);
    }

}
