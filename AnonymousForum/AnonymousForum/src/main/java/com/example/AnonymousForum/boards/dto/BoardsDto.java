package com.example.AnonymousForum.boards.dto;

import com.example.AnonymousForum.article.dto.ArticleDto;
import com.example.AnonymousForum.article.entity.Article;
import com.example.AnonymousForum.boards.entity.Boards;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.jaxb.SpringDataJaxb;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
@NoArgsConstructor
public class BoardsDto {
    private Long id;
    @Setter
    private String category;
    private List<ArticleDto> articles=new ArrayList<>();


    public BoardsDto(String category) {
        this.category = category;
    }
/*    public BoardsDto(Long id){
        this.id=id;
    }*/

    public static BoardsDto fromEntity(Boards entity){
        BoardsDto dto=new BoardsDto();
        dto.id=entity.getId();
        dto.category=entity.getCategory();
        dto.articles=new ArrayList<>();

        for(Article article:entity.getArticles()) {
            dto.articles.add(ArticleDto.fromEntity(article));
        }
        return dto;
    }

}
