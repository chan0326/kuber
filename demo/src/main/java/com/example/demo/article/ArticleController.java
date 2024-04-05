package com.example.demo.article;

import java.sql.SQLException;

import com.example.demo.article.model.ArticleDto;
import com.example.demo.article.repository.ArticleRepository;
import com.example.demo.article.service.ArticleServiceImpl;
import com.example.demo.common.component.MessengerVo;
import com.example.demo.common.component.PageRequestVo;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@ApiResponses(value = {
        @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
        @ApiResponse(responseCode = "404", description = "Customer not found")})
@RestController  //controller + ResponseBody
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RequestMapping(path = "/api/articles/")
public class ArticleController {
    private final ArticleServiceImpl articleService;

    @SuppressWarnings("unchecked")
    @PostMapping("")
    public ResponseEntity<MessengerVo> save(ArticleDto dto) throws SQLException {
        articleService.save(dto);
        return ResponseEntity.ok(new MessengerVo());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<MessengerVo> deleteById(Long id) throws SQLException {
        articleService.deleteById(id);
        return ResponseEntity.ok(new MessengerVo());
    }
    @GetMapping("")
    public ResponseEntity<MessengerVo> findAll(PageRequestVo vo) throws SQLException {
        articleService.findAll(null);
        return ResponseEntity.ok(new MessengerVo());
    }
    @GetMapping("/{id}")
    public ResponseEntity<MessengerVo> findById(Long id) throws SQLException {
        return ResponseEntity.ok(new MessengerVo());
    }
    @GetMapping("/count")
    public ResponseEntity<MessengerVo> count() throws SQLException {
        return ResponseEntity.ok(new MessengerVo());
    }
    @GetMapping("/exists/{id}")
    public ResponseEntity<MessengerVo> existsById(Long id) throws SQLException {
        return ResponseEntity.ok(new MessengerVo());
    }

}
