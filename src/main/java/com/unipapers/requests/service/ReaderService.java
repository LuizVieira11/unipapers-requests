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

    private final ReaderRepository readerRepository;

    ReaderService(ReaderRepository readerRepository) {
        this.readerRepository = readerRepository;
    }

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

    public Reader update(Long id, Reader reader) {
        Optional<Reader> updatedReader = readerRepository.findById(id);
        if (updatedReader.isPresent()) {
            updatedReader.get().setName(reader.getName());
            updatedReader.get().setEmail(reader.getEmail());
            updatedReader.get().setPassword(reader.getPassword());
            updatedReader.get().setPhone(reader.getPhone());
            readerRepository.save(updatedReader.get());
        }
        return updatedReader.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Reader insert(Reader reader) {
        return readerRepository.save(reader);
    }

}
