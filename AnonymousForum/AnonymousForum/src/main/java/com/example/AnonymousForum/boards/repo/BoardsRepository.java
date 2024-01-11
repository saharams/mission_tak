package com.example.AnonymousForum.boards.repo;

import com.example.AnonymousForum.boards.entity.Boards;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardsRepository extends JpaRepository<Boards,Long> {

/*
    Page<Boards> findAllByArticlesOrderByArticlesIdIdDesc(Long id,Pageable pageable);
*/


}
