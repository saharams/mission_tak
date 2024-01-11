package com.example.AnonymousForum.boards;
import com.example.AnonymousForum.article.*;
import com.example.AnonymousForum.article.dto.ArticleDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("boards")
@RequiredArgsConstructor
public class BoardsController {
    private final BoardsService boardsService;

    @GetMapping
    public String boards(Model model){
        model.addAttribute("boardsList",boardsService.viewAll());

        return "boards/index";
    }
    @GetMapping("{boardsId}")
    public String boardsOne(
            @PathVariable("boardsId")
            Long boardsId,
            Model model
    ){
        model.addAttribute("boards",boardsService.view(boardsId));
        return "boards/read";
    }



}
