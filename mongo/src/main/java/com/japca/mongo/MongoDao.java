package com.japca.mongo;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by Jakub Krhovják on 5/10/18.
 */
public interface MongoDao extends CrudRepository<Record, String> {
}
