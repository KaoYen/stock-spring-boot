package com.stock.repository.extension;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomRepository<T, ID> {

    <S extends T> List<S> batchInsert(Iterable<S> entities);
}
