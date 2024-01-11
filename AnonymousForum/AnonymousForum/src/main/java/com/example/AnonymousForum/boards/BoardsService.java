package com.example.AnonymousForum.boards;

import com.example.AnonymousForum.article.dto.ArticleDto;
import com.example.AnonymousForum.article.entity.Article;
import com.example.AnonymousForum.article.repo.ArticleRepository;
import com.example.AnonymousForum.boards.dto.BoardsDto;
import com.example.AnonymousForum.boards.entity.Boards;
import com.example.AnonymousForum.boards.repo.BoardsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardsService {
    private final BoardsRepository boardsRepository;
    private final ArticleRepository articleRepository;

   /* public BoardsDto create(BoardsDto dto) {
        Boards boards = new Boards(
                dto.getCategory());
        return BoardsDto.fromEntity(repository.save(boards));

    }
*/
    public BoardsDto view(Long id) {

        Boards boards;
        boards = boardsRepository.findById(id).orElseThrow();
        return BoardsDto.fromEntity(boards);
    }

    public List<BoardsDto> viewAll() {
        List<BoardsDto> boardsList = new ArrayList<>();
        for (Boards boards : boardsRepository.findAll()) {
            boardsList.add(BoardsDto.fromEntity(boards));
        }
        return boardsList;
    }

}