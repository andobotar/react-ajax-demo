package com.demo.controller;

import com.demo.domain.Word;
import com.demo.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class JspController {

    private WordRepository wordRepository;

    @Autowired
    public JspController(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("wordObj", new Word());
        model.addAttribute("words", wordRepository.getAllByOrderByIdAsc());
        return "home";
    }

    @PostMapping("/saveWord")
    public String saveWord(@ModelAttribute("wordObj") Word word, Model model) {
        wordRepository.save(word);
        model.addAttribute("wordObj", new Word());

        List<Word> words = wordRepository.getAllByOrderByIdAsc();
        model.addAttribute("words", words);
        return "home";
    }

    @GetMapping("/deleteWord/{id}")
    public String deleteWord(@PathVariable("id") Long id, Model model) {
        wordRepository.deleteById(id);
        model.addAttribute("wordObj", new Word());
        model.addAttribute("words", wordRepository.getAllByOrderByIdAsc());
        return "home";
    }
}
