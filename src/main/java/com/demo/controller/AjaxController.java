package com.demo.controller;

import com.demo.domain.Word;
import com.demo.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/words")
public class AjaxController {

    private WordRepository wordRepository;

    @Autowired
    public AjaxController(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    @GetMapping()
    @ResponseBody
    public ResponseEntity<List<Word>> showWords() {
        List<Word> words = wordRepository.getAllByOrderByIdAsc();
        return new ResponseEntity<>(words, HttpStatus.OK);
    }

    @PostMapping()
    @ResponseBody
    public ResponseEntity<List<Word>> saveWord(@RequestBody Word word) {
        wordRepository.save(word);
        List<Word> words = wordRepository.getAllByOrderByIdAsc();
        return new ResponseEntity<>(words, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity<List<Word>> deleteWord(@PathVariable Long id) {
        wordRepository.deleteById(id);
        List<Word> words = wordRepository.getAllByOrderByIdAsc();
        return new ResponseEntity<>(words, HttpStatus.OK);
    }

}
