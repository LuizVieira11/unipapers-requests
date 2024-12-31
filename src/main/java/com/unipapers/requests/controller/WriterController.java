package com.unipapers.requests.controller;

import com.unipapers.requests.model.entity.Writer;
import com.unipapers.requests.service.WriterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "api/writers")
public class WriterController {

    private final WriterService service;

    public WriterController(WriterService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Writer>> findAll(){
        List<Writer> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Writer> findById(@PathVariable Long id){
        Writer obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "/email")
    public ResponseEntity<Writer> findByEmail(@RequestParam String email){
        Writer obj = service.findByEmail(email);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "/name")
    public ResponseEntity<List<Writer>> findByName(@RequestParam String name){
        List<Writer> list = service.findByName(name);
        return ResponseEntity.ok().body(list);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Writer> update(@PathVariable Long id, @RequestBody Writer writer){
        Writer updatedWriter = service.update(id, writer);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<Writer> insert(@RequestBody Writer writer) {
        writer = service.insert(writer);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(writer.getId())
                .toUri();
        return ResponseEntity.created(uri).body(writer);
    }

}
