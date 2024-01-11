package com.example.AnonymousForum.article;

import com.example.AnonymousForum.article.dto.ArticleDto;
import com.example.AnonymousForum.article.entity.Article;
import com.example.AnonymousForum.article.repo.ArticleRepository;
import com.example.AnonymousForum.boards.*;
import com.example.AnonymousForum.boards.entity.Boards;
import com.example.AnonymousForum.boards.repo.BoardsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final BoardsRepository boardsRepository;

    public ArticleDto create(Long boardsId, ArticleDto dto) {
        Boards boards = boardsRepository.findById(boardsId)
                .orElseThrow();
        Article article = new Article(boards, dto.getId(), dto.getTitle(), dto.getContent(),
                dto.getWriter(), dto.getPassword());


        return ArticleDto.fromEntity(articleRepository.save(article));
    }

    public List<ArticleDto> readAll() {
        List<ArticleDto> articleList = new ArrayList<>();
        //최신글을 먼저볼 수 있도록 내림차순 정렬
        List<Article> desc = articleRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
        for (Article article : desc) {
            articleList.add(ArticleDto.fromEntity(article));

        }
        return articleList;

    }

    public ArticleDto read(Long id) {
        Article article = articleRepository.findById(id).orElseThrow();

        return ArticleDto.fromEntity(article);
    }

    public List<ArticleDto> desc() {
        List<ArticleDto> articleDtoList = new ArrayList<>();
        List<Article> desc = articleRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
        for (Article article : desc) {
            articleDtoList.add(ArticleDto.fromEntity(article));
        }
        return articleDtoList;
    }

    public ArticleDto update(Long id, ArticleDto dto,String password) {
        Article article = articleRepository.findById(id).orElseThrow();
        System.out.println(article.getPassword());


        // 비밀번호 일치 여부 확인
        if (article.getPassword().equals(password)){
            // 일치하면 게시글 수정
            article.setTitle(dto.getTitle());
            article.setContent(dto.getContent());
        } else {
            return new ArticleDto("비밀번호가 일치하지 않습니다.");
        }
        return ArticleDto.fromEntity(articleRepository.save(article));
    }

    public void delete(Long id,String password) {
        Article article=articleRepository.findById(id).orElseThrow();
        //System.out.println(article.getPassword());
        System.out.println(password);
        if(article.getPassword().equals(password)){
            articleRepository.delete(articleRepository.findById(id).orElseThrow());
        }

        }
    }



