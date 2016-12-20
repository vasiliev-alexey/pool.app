package com.av.pool.app.repository;

import com.av.pool.app.domain.Vote;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by vasiliev-alexey on 20.12.16.
 */
public interface VoteRepository extends CrudRepository<Vote, Long> {
}
