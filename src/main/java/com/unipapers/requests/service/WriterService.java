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

    private final WriterRepository writerRepository;

    public WriterService(WriterRepository writerRepository) {
        this.writerRepository = writerRepository;
    }

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

    public List<Writer> findByName(String name) {
        List<Writer> list = writerRepository.findWriterByNameContaining(name);
        return list;
    }

    public Writer update(Long id, Writer writer) {
        Optional<Writer> obj = writerRepository.findById(id);
        if (obj.isPresent()) {
            obj.get().setName(writer.getName());
            obj.get().setEmail(writer.getEmail());
            obj.get().setPassword(writer.getPassword());
            obj.get().setPhone(writer.getPhone());
            obj.get().setCourse(writer.getCourse());
            obj.get().setRA(writer.getRA());
            writerRepository.save(obj.get());
        }
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Writer insert(Writer writer) {
        return writerRepository.save(writer);
    }

}
