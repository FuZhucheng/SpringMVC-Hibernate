package com.fuzhu.repository;

import com.fuzhu.model.BlogEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ${符柱成} on 2016/12/30.
 */
@Repository
public interface BlogPageDao extends PagingAndSortingRepository<BlogEntity, Long> {
}
