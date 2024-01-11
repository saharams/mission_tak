package com.example.AnonymousForum.comment;

import com.example.AnonymousForum.article.entity.Article;
import com.example.AnonymousForum.article.repo.ArticleRepository;
import com.example.AnonymousForum.comment.dto.CommentDto;
import com.example.AnonymousForum.comment.entity.Comment;
import com.example.AnonymousForum.comment.repo.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final ArticleRepository articleRepository;
    private final CommentRepository commentRepository;

    public CommentDto create(Long articleId, CommentDto dto) {
        Article article = articleRepository.findById(articleId)
                .orElseThrow();
        Comment comment = new Comment(
                dto.getContent(), dto.getWriter(),dto.getPassword(), article
        );

        return CommentDto.fromEntity(commentRepository.save(comment));
    }

    public CommentDto read(Long commentId) {
        return CommentDto.fromEntity(commentRepository.findById(commentId)
                .orElseThrow());
    }

    public CommentDto update(Long commentId, CommentDto dto) {
        Comment comment =
                commentRepository.findById(commentId)
                .orElseThrow();

        comment.setContent(dto.getContent());
        return CommentDto.fromEntity(commentRepository.save(comment));
    }

    public void delete(Long commentId) {
        commentRepository.delete(commentRepository.findById(commentId)
                .orElseThrow());
    }
}
