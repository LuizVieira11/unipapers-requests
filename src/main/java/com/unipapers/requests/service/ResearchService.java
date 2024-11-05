package com.unipapers.requests.service;

import com.unipapers.requests.model.entity.Research;
import com.unipapers.requests.model.entity.Writer;
import com.unipapers.requests.model.repository.ResearchRepository;
import com.unipapers.requests.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResearchService {

    @Autowired
    private ResearchRepository researchRepository;

    public List<Research> findAll(){
        return researchRepository.findAll();
    }

    public Research findById(Long id){
        Optional<Research> obj = researchRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public List<Research> findByName(String name){
        List<Research> list = researchRepository.findResearchByNameContaining(name);
        return list;
    }

    public List<Research> findByWriter(Writer writer){
        return researchRepository.findResearchByWriter(writer);
    }

    public Research insert(Research research){
        return researchRepository.save(research);
    }

}