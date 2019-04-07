package com.service.Comments;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentFind extends JpaRepository<CommRec, Long> {
    CommRec getById(long id);

    List<CommRec> getAllByQuery(long query);
}
