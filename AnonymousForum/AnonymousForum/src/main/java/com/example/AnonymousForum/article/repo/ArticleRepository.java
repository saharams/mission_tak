package com.example.AnonymousForum.article.repo;

import com.example.AnonymousForum.article.dto.ArticleDto;
import com.example.AnonymousForum.article.entity.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article,Long> {


/*    Page<Article> findeAll (Pageable pageable);*/
}
