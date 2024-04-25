package com.unipapers.requests.service;

import com.unipapers.requests.model.entity.Reader;
import com.unipapers.requests.model.repository.ReaderRepository;
import com.unipapers.requests.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReaderService {

    @Autowired
    private ReaderRepository readerRepository;

    public List<Reader> findAll(){
        return readerRepository.findAll();
    }

    public Reader findByEmail(String email) {
        Optional<Reader> obj = readerRepository.findReaderByEmail(email);
        return obj.orElseThrow(() -> new ResourceNotFoundException(email));
    }

    public Reader findById(Long id) {
        Optional<Reader> obj = readerRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Reader insert(Reader reader) {
        return readerRepository.save(reader);
    }

}
