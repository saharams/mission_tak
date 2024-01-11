package com.example.AnonymousForum.comment.entity;

import com.example.AnonymousForum.article.entity.Article;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    private String content;
    @Setter
    private String writer;
    @Setter
    private String password;
    @Setter
    @ManyToOne
    private Article article;

    public Comment() {
    }

    public Comment(String content, String writer,String password, Article article) {
        this.content = content;
        this.writer = writer;
        this.password=password;
        this.article = article;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", articleId=" + article.getId() +
                ", content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                ", password='=" + password +'\''+
                '}';
    }
}
