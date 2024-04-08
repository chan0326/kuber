package com.example.demo.article;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.example.demo.article.model.ArticleDto;
import com.example.demo.article.repository.ArticleRepository;
import com.example.demo.article.service.ArticleServiceImpl;
import com.example.demo.common.component.MessengerVo;
import com.example.demo.common.component.PageRequestVo;
import com.example.demo.user.model.User;
import com.example.demo.user.model.UserDto;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@ApiResponses(value = {
        @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
        @ApiResponse(responseCode = "404", description = "Customer not found")})
@RestController  //controller + ResponseBody
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RequestMapping(path = "/api/articles/")
@Slf4j
public class ArticleController {
    private final ArticleServiceImpl articleService;

    @SuppressWarnings("static-access")
    @PostMapping("")
    public ResponseEntity<MessengerVo> save(@RequestBody ArticleDto dto) throws SQLException {
        log.info("입력받은 정보: {}",dto);
        return ResponseEntity.ok(articleService.save(dto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<MessengerVo> deleteById(@RequestParam Long id) throws SQLException {
        log.info("입력받은 정보: {}",id);
        return ResponseEntity.ok(articleService.deleteById(id));
    }
    @GetMapping("")
    public ResponseEntity<List<ArticleDto>> findAll() throws SQLException {
        return ResponseEntity.ok(articleService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<ArticleDto>> findById(@RequestParam Long writer) throws SQLException {
        return ResponseEntity.ok(articleService.findById(writer));
    }
    @GetMapping("/count")
    public ResponseEntity<Long> count() throws SQLException {
        return ResponseEntity.ok(articleService.count());
    }
    @PostMapping("/search")
    public ResponseEntity<List<UserDto>> findUsersByWriter(@RequestBody ArticleDto param) {
        //log.info("입력받은 정보 : {}", name );
//        return ResponseEntity.ok(articleService.findUsersByWriter(param.getWriter()));
        return  null;
    }

    @PutMapping("/modify")
    public ResponseEntity<MessengerVo> modify(@RequestBody ArticleDto param) {
        log.info("입력받은 정보 : {}", param );
        return ResponseEntity.ok(articleService.modify(param));
    }


}
