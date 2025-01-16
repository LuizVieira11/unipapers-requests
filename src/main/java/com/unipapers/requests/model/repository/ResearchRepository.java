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

    List<Research> findResearchByNameContaining(String name);
    List<Research> findResearchByWriter(Writer writer);

    @Query(value = "select " +
            "r.id, r.name, r.description, r.blob_file, " +
            "w.id, w.name, w.phone, w.email, w.password, " +
            "w.course, w.ra, r.collaborators " +
            "from tab_research r " +
            "join tab_writer w on r.writer_id = w.id " +
            "where r.name like %:name% or w.name like %:name%", nativeQuery = true)
    List<Research> findResearchByNameOrWriterContaining(@Param("name") String name);

}
