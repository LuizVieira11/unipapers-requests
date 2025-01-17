package com.unipapers.requests.model.repository;

import com.unipapers.requests.model.entity.Research;
import com.unipapers.requests.model.entity.Writer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResearchRepository extends JpaRepository<Research, Long> {

    @Query("SELECT r FROM tab_research r " +
            "JOIN FETCH r.writer w " +
            "WHERE r.name LIKE %:name% OR w.name LIKE %:name%")
    List<Research> findResearchByNameOrWriterContaining(@Param("name") String name);

}
