package com.demo.repository;

import com.demo.domain.Word;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WordRepository extends JpaRepository<Word, Long> {

    List<Word> getAllByOrderByIdAsc();

}
