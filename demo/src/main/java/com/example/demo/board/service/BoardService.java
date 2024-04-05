package com.example.demo.board.service;

import com.example.demo.board.model.Board;
import com.example.demo.board.model.BoardDto;
import com.example.demo.common.command.CommandService;
import com.example.demo.common.query.QueryService;

import java.util.*;

public interface BoardService extends CommandService<BoardDto>, QueryService<BoardDto> {

    default Board dtoToEntity(BoardDto dto){
        return Board.builder().build();
    }

    default BoardDto entityToDto(Optional<Board> optional){
        return BoardDto.builder().build();
    }


}
