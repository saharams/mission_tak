package com.example.AnonymousForum.boards.entity;

import com.example.AnonymousForum.article.entity.Article;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Getter
@Entity
public class Boards {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Setter
    private String category;
    @OneToMany(mappedBy = "boards")
    private final List<Article> articles = new ArrayList<>();

    public Boards(Long id){

    }
    public Boards(String category){
        this.category=category;
    }

    public Boards() {

    }

    @Override
    public String toString(){
        return "Boards{" +
               "id=" +id +
               ",category=" + category + '\'' +
               " articles=" + articles +
               '}';
    }
    @Override
    public boolean equals(Object o){
        if(this==o)return true;
        if(o==null||getClass()!=o.getClass())return false;
        Boards boards= (Boards) o;
        return Objects.equals(id,boards.id)&& Objects.equals(category,boards.category);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id,category);
    }
}
