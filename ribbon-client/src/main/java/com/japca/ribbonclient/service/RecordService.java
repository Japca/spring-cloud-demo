package com.japca.ribbonclient.service;

import com.japca.ribbonclient.dao.RecordDao;
import com.japca.ribbonclient.entity.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Jakub krhovják on 4/8/18.
 */

@Service
public class RecordService {

	@Autowired
	private RecordDao recordDao;

	public Record save(Record record) {
		return recordDao.save(record);
	}

	public List<Record> getRecords() {
		return recordDao.findAll();
	}
}
