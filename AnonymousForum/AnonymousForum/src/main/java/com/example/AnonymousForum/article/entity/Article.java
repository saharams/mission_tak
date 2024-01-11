package com.example.AnonymousForum.article.entity;

import com.example.AnonymousForum.boards.entity.Boards;
import jakarta.persistence.*;
import com.example.AnonymousForum.comment.entity.Comment;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Setter
    private String title;
    @Setter
    @Lob
    private String content;
    @Setter
    private String writer;
    @Setter
    private String password;
    @ManyToOne
    private Boards boards;
    @OneToMany(mappedBy = "article")
    private final List<Comment> comments = new ArrayList<>();
    public Article(String title, String content, String writer,String password) {
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.password=password;

    }

    /*public Article(Long id, String title, String content, String writer, String password) {
        this.id=id;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.password=password;

    }*/
    public Article(Long id, String title, String content, String writer, String password) {
        this.id=id;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.password=password;


    }

    public Article() {

    }

    public Article(Boards boards, Long id, String title, String content, String writer, String password) {
        this.boards=boards;
        this.id=id;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.password=password;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                ", comments=" + comments +'\''+
                ", password=" + password +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(id, article.id) && Objects.equals(title, article.title) && Objects.equals(content, article.content) && Objects.equals(writer, article.writer) && Objects.equals(password,article.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, content, writer,password);
    }


}
