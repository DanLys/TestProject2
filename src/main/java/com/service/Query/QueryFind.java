package com.service.Query;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QueryFind extends JpaRepository<QueryRec, Long> {
    QueryRec getById(long id);

    boolean existsById(long id);
}
