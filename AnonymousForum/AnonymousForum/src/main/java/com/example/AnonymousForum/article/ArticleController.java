package com.example.AnonymousForum.article;

import com.example.AnonymousForum.article.dto.ArticleDto;
import com.example.AnonymousForum.article.entity.Article;
import com.example.AnonymousForum.article.repo.ArticleRepository;
import com.example.AnonymousForum.boards.*;
import com.example.AnonymousForum.boards.dto.BoardsDto;
import com.example.AnonymousForum.boards.entity.Boards;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("article")
@RequiredArgsConstructor
public class ArticleController {
    private final BoardsService boardsService;
    private final ArticleService articleService;
    private org.springframework.data.domain.Pageable Pageable;

    @GetMapping
    public String article(Model model) {
        //전체 article 읽기
        model.addAttribute("articles", articleService.readAll());
        return "article/index";
    }

    //boards 선택박스를 쓰기위한 write controller
    @GetMapping("write")
    public String articleWrite(

            Model model)

    {
       model.addAttribute("boards",boardsService.viewAll());

        return "article/write";
    }
    //write에 쓰여진 정보를 가져와서 article 생성
    @PostMapping
    public String articleCreate(
            @RequestParam("boardsId")
            Long boardsId,
            @RequestParam("title")
            String title,
            @RequestParam("content")
            String content,
            @RequestParam("writer")
            String writer,
            @RequestParam("password")
            String password

    ) {
        Long newId = articleService.create(boardsId,new ArticleDto(title, content, writer,password)).getId();
        return String.format("redirect:/article/%d", newId);
    }
    //article 하나 읽기
    @GetMapping("{id}")
    public String articleOne(
            @PathVariable("id")
            Long id,
            Model model
    ) {
        model.addAttribute("article",articleService.read(id));
        return "article/read";
    }

    //article 수정폼
    @GetMapping("{id}/edit")
    public String articleEdit(
            @PathVariable("id")
            Long id,
            Model model
    ) {
        model.addAttribute("article", articleService.read(id));
        return "article/edit";
    }
    //article 수정눌렀을시 패스워드가 맞다면 업데이트
    @PostMapping("{id}/update")
    public String articleUpdate(
            @PathVariable("id")
            Long id,
            @RequestParam("title")
            String title,
            @RequestParam("content")
            String content,
            @RequestParam("password")
            String password
    ) {
        articleService.update(id, new ArticleDto(title,content),password);
        return String.format("redirect:/article/%d",id);
    }
    //Delete눌렀을시  패스워드가 맞다면 삭제
    @PostMapping("{id}/edit")
    public String articleDelete(
            @PathVariable("id")
            Long id,
            @PathVariable("password")
            String password
    ) {
        articleService.delete(id,password);
        return "redirect:/article";
    }
}
