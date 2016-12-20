package com.av.pool.app.repository;

import com.av.pool.app.domain.Option;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by vasiliev-alexey on 20.12.16.
 */
public interface OptionRepository extends CrudRepository<Option, Long> {
}
