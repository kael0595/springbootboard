package com.sbb.practice.board.controller;

import com.sbb.practice.board.dto.BoardDto;
import com.sbb.practice.board.entity.Board;
import com.sbb.practice.board.service.BoardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/create")
    public String boardCreateForm(BoardDto boardDto) {
        return "board/createForm";
    }

    @PostMapping("/create")
    public String boardCreate(@ModelAttribute @Valid BoardDto boardDto,
                              BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "board/createForm";
        }

        boardService.create(boardDto);

        return "redirect:/board/list";
    }

    @GetMapping("/list")
    public String boardList(Model model) {
        List<Board> boardList = boardService.getAll();
        model.addAttribute("boardList", boardList);
        return "board/list";
    }

    @GetMapping("/detail/{id}")
    public String boardDetail(Model model,
                              @PathVariable("id") Integer boardId) {

        Board board = boardService.selectBoard(boardId);

        model.addAttribute("board", board);

        return "board/detail";

    }

}
