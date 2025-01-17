package com.unipapers.requests.model.entity;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Base64;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tab_research")
public class Research {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @Lob
    @Column(columnDefinition = "MEDIUMBLOB", unique = true)
    private byte[] blobFile;

    @ManyToOne
    @JoinColumn(name = "writer_id")
    private Writer writer;

    private String collaborators;

}
