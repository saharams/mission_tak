package com.example.AnonymousForum.article.dto;

import com.example.AnonymousForum.article.ArticleService;
import com.example.AnonymousForum.article.entity.Article;
import com.example.AnonymousForum.boards.entity.Boards;
import com.example.AnonymousForum.comment.dto.CommentDto;
import com.example.AnonymousForum.boards.*;
import com.example.AnonymousForum.comment.entity.Comment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
@NoArgsConstructor
public class ArticleDto {
    private Long id;
    @Setter
    private String title;
    @Setter
    private String content;
    @Setter
    private String writer;
    @Setter
    private String password;
    @Setter
    private Boards boards;
    @Setter
    private Article article;
    private List<CommentDto> comments = new ArrayList<>();
    public ArticleDto(String title, String content, String password) {
        this.title = title;
        this.content = content;
        this.password=password;
    }

    public ArticleDto(String title, String content, String writer,String password) {
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.password=password;
    }
    public ArticleDto( Boards boards,Long id,String title, String content, String writer, String password) {
        this.boards=boards;
        this.id=id;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.password=password;

    }

    public ArticleDto(String s) {
        System.out.println(s);
    }

    public ArticleDto(String title, String content) {
        this.title=title;
        this.content=content;
    }

   /* public ArticleDto(Article article) {
        this.article=article;
    }
*/

    // static factory method
    public static ArticleDto fromEntity(Article entity) {
        ArticleDto dto = new ArticleDto();
        dto.boards=entity.getBoards();
        dto.id = entity.getId();
        dto.title = entity.getTitle();
        dto.content = entity.getContent().replace("\n", "<br>");
        dto.writer = entity.getWriter();
        dto.password=entity.getPassword();
        dto.comments = new ArrayList<>();
        for (Comment comment: entity.getComments())
            dto.comments.add(CommentDto.fromEntity(comment));
        return dto;
    }
}