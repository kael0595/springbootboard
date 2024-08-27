package com.sbb.practice.board.controller;

import com.sbb.practice.board.dto.BoardDto;
import com.sbb.practice.board.service.BoardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

}
