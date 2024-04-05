package com.example.demo.board;

import com.example.demo.board.model.BoardDto;
import com.example.demo.board.service.BoardServiceImpl;
import com.example.demo.common.component.MessengerVo;
import com.example.demo.common.component.PageRequestVo;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@ApiResponses(value = {
        @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
        @ApiResponse(responseCode = "404", description = "Customer not found")})
@RestController  //controller + ResponseBody
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RequestMapping(path = "/api/boards/")
@Slf4j
public class BoardController {
    private final BoardServiceImpl boardService;

    @SuppressWarnings("unchecked")
    @PostMapping("")
    public ResponseEntity<MessengerVo> save(BoardDto dto) throws SQLException {
        boardService.save(dto);
        return ResponseEntity.ok(new MessengerVo());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<MessengerVo> deleteById(Long id) throws SQLException {
        boardService.deleteById(id);
        return ResponseEntity.ok(new MessengerVo());
    }
    @GetMapping("")
    public ResponseEntity<MessengerVo> findAll(PageRequestVo vo) throws SQLException {
        boardService.findAll(null);
        return ResponseEntity.ok(new MessengerVo());
    }
    @GetMapping("/{id}")
    public ResponseEntity<MessengerVo> findById(Long id) throws SQLException {
        boardService.findById(id);
        return ResponseEntity.ok(new MessengerVo());
    }
    @GetMapping("/count")
    public ResponseEntity<MessengerVo> count() throws SQLException {
        return ResponseEntity.ok(new MessengerVo());
    }
    @GetMapping("/exists/{id}")
    public ResponseEntity<MessengerVo> existsById(Long id) throws SQLException {
        boardService.existsById(id);
        return ResponseEntity.ok(new MessengerVo());
    }
    //보드컨트롤러

}
