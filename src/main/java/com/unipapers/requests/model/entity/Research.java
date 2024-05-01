package com.unipapers.requests.model.entity;

import jakarta.persistence.*;

@Entity(name = "tab_research")
public class Research {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @Column(unique = true)
    private String textFileName;
    @ManyToOne
    @JoinColumn(name = "writer_id")
    private Writer writer;

    public Research(){}

    public Research(Long id, String name, String description, String textFileName, Writer writer) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.textFileName = textFileName;
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

    public String getTextFileName() {
        return textFileName;
    }

    public void setTextFileName(String textFileName) {
        this.textFileName = textFileName;
    }

    public Writer getWriter() {
        return writer;
    }

    public void setWriter(Writer writer) {
        this.writer = writer;
    }
}
