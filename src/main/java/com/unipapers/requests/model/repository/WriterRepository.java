package com.unipapers.requests.model.repository;

import com.unipapers.requests.model.entity.Writer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WriterRepository extends JpaRepository<Writer, Long> {

    Optional<Writer> findWriterByEmail(String email);

    List<Writer> findWriterByNameContaining(String email);

}
