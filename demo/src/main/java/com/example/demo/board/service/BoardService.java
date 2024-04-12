package com.example.demo.board.service;

import com.example.demo.board.model.Board;
import com.example.demo.board.model.BoardDto;
import com.example.demo.common.command.CommandService;
import com.example.demo.common.component.MessengerVo;
import com.example.demo.common.query.QueryService;
import com.example.demo.user.model.UserDto;

import java.util.*;

public interface BoardService extends CommandService<BoardDto>, QueryService<BoardDto> {
    MessengerVo modify(BoardDto boardDto);
    default Board dtoToEntity(BoardDto dto){
        return Board.builder()
                .id(dto.getId())
                .boardType(dto.getBoardType())
                .build();
    }

    default BoardDto entityToDto(Board board){
        return BoardDto.builder()
                .id(board.getId())
                .boardType(board.getBoardType())
                .build();
    }


}
