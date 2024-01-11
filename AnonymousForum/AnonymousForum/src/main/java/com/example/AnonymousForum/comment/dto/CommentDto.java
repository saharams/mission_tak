package com.example.AnonymousForum.comment.dto;


import com.example.AnonymousForum.comment.entity.Comment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class CommentDto {
    private Long id;
    @Setter
    private String content;
    @Setter
    private String writer;
    @Setter
    private String password;

    public CommentDto(String content) {
        this.content = content;
    }

    public CommentDto(String content, String writer,String password) {
        this.content = content;
        this.writer = writer;
        this.password=password;
    }

    public static CommentDto fromEntity(Comment entity) {
        CommentDto dto = new CommentDto();
        dto.id = entity.getId();
        dto.content = entity.getContent();
        dto.writer = entity.getWriter();
        dto.password=entity.getPassword();
        return dto;
    }
}