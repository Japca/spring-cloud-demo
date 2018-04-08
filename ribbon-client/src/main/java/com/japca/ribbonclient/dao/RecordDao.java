package com.japca.ribbonclient.dao;

import com.japca.ribbonclient.entity.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Jakub krhovják on 4/8/18.
 */

@Repository
public interface RecordDao extends JpaRepository<Record, Long> {
}
