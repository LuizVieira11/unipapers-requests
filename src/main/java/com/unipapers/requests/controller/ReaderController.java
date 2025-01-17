package com.unipapers.requests.controller;

import com.unipapers.requests.model.entity.Reader;
import com.unipapers.requests.service.ReaderService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/readers")
public class ReaderController {

    private final ReaderService service;

    public ReaderController(ReaderService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Reader>> findAll(){
        List<Reader> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Reader> findById(@PathVariable Long id){
        Reader obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "/email")
    public ResponseEntity<Reader> findByEmail(@RequestParam String email){
        Reader obj = service.findByEmail(email);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Reader> insert(@RequestBody Reader reader){
        reader = service.insert(reader);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(reader.getId())
                .toUri();
        return ResponseEntity.created(uri).body(reader);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Reader> update(@PathVariable Long id, @RequestBody Reader reader){
        Reader obj = service.update(id, reader);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }

}
