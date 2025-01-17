package com.unipapers.requests.service;

import com.unipapers.requests.model.entity.Research;
import com.unipapers.requests.model.entity.Writer;
import com.unipapers.requests.model.repository.ResearchRepository;
import com.unipapers.requests.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ResearchService {

    private final ResearchRepository researchRepository;

    public ResearchService(ResearchRepository researchRepository) {
        this.researchRepository = researchRepository;
    }

    public List<Research> findAll(){
        return researchRepository.findAll();
    }

    public Research findById(Long id){
        Optional<Research> obj = researchRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public List<Research> findByName(String name){
        List<Research> list = researchRepository.findResearchByNameOrWriterContaining(name);
        return list;
    }

    public Research insert(Research research){
        return researchRepository.save(research);
    }

}
