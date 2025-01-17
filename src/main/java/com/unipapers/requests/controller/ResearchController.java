package com.unipapers.requests.controller;

import com.unipapers.requests.model.entity.Research;
import com.unipapers.requests.model.entity.Writer;
import com.unipapers.requests.service.ResearchService;
import com.unipapers.requests.service.WriterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Base64;
import java.util.List;

@Controller
@RequestMapping(value = "/api/researches")
public class ResearchController {

    private final ResearchService service;

    private final WriterService writerService;

    public ResearchController(ResearchService service, WriterService writerService) {
        this.service = service;
        this.writerService = writerService;
    }

    @GetMapping
    public ResponseEntity<List<Research>> findAll(){
        List<Research> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Research> findById(@PathVariable Long id){
        Research obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "/name")
    public ResponseEntity<List<Research>> findByName(@RequestParam String name){
        List<Research> list = service.findByName(name);
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<Research> insert(@RequestBody Research research){
        research.setWriter(writerService.findById(research.getWriter().getId()));
        research = service.insert(research);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(research.getId())
                .toUri();
        return ResponseEntity.created(uri).body(research);
    }

}
