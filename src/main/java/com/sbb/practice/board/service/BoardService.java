package com.sbb.practice.board.service;

import com.sbb.practice.base.repository.BoardRepository;
import com.sbb.practice.board.dto.BoardDto;
import com.sbb.practice.board.entity.Board;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public void create(BoardDto boardDto) {
        Board board = Board.builder()
                .title(boardDto.getTitle())
                .content(boardDto.getContent())
                .regDt(LocalDateTime.now())
                .author("admin")
                .build();
        boardRepository.save(board);
    }

    public List<Board> getAll() {
        return boardRepository.findAll();
    }
}
