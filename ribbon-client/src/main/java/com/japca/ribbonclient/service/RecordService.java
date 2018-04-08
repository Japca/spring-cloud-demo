package com.japca.ribbonclient.service;

import com.japca.ribbonclient.dao.RecordDao;
import com.japca.ribbonclient.entity.Record;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Jakub krhovják on 4/8/18.
 */

@Service
public class RecordService {

	private RecordDao recordDao;

	public Record save(Record record) {
		return recordDao.save(record);
	}

	public List<Record> getRecords() {
		return recordDao.findAll();
	}


	public int getRecordCountDoubled() {
		 List<Record> records = getRecords();
		 if(CollectionUtils.isNotEmpty(records)) {
		 	return records.size() * 2;
		 }
		 return 0;
	}

	@Autowired
	public void setRecordDao(RecordDao recordDao) {
		this.recordDao = recordDao;
	}
}
