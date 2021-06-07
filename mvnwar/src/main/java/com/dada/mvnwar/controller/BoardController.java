package com.dada.mvnwar.controller;

import com.dada.mvnwar.model.Board;
import com.dada.mvnwar.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardRepository boardRepository;

    @GetMapping("/list")
    public String list(Model model) {
        List<Board> boards = boardRepository.findAll();
        model.addAttribute("boards", boards);
        return "board/list";
    }

    // 수정일 경우 위해 RequestParam 과 조건문을 사용한다.
    @GetMapping("/form")
    public String form(Model model, @RequestParam(required = false) Long id ) {
        if(id == null){
            model.addAttribute("board", new Board()); // id 값이 없으면...신규
        } else {
            Board board = boardRepository.findById(id).orElse(null); // 값없음 경우를 명시해야함.
            model.addAttribute("board", board);
        }

        return "board/form";
    }

    @PostMapping("/form")
    public String formsubmit(@ModelAttribute Board board) {
        boardRepository.save(board);
        return "redirect:/board/list";
    }
}
