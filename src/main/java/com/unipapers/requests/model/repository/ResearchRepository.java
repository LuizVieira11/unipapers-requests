package com.unipapers.requests.model.repository;

import com.unipapers.requests.model.entity.Research;
import com.unipapers.requests.model.entity.Writer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResearchRepository extends JpaRepository<Research, Long> {

    List<Research> findResearchByNameContaining(String name);
    List<Research> findResearchByWriter(Writer writer);

}
