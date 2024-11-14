package com.unipapers.requests.model.entity;

import jakarta.persistence.*;

@Entity(name = "tab_research")
public class Research {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @Lob
    @Column(columnDefinition = "BLOB", unique = true)
    private byte[] blobFile;
    @ManyToOne
    @JoinColumn(name = "writer_id")
    private Writer writer;

    private String collaborators;

    public Research(){}

    public Research(Long id, String name, String description, byte[] blobFile, Writer writer) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.blobFile = blobFile;
        this.writer = writer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getBlobFile() {
        return blobFile;
    }

    public void setBlobFile(byte[] blobFile) {
        this.blobFile = blobFile;
    }

    public Writer getWriter() {
        return writer;
    }

    public void setWriter(Writer writer) {
        this.writer = writer;
    }

    public String getCollaborators() {
        return collaborators;
    }

    public void setCollaborators(String collaborators) {
        this.collaborators = collaborators;
    }
}
