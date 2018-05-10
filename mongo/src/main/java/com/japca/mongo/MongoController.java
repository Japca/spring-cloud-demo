package com.japca.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Jakub Krhovják on 5/10/18.
 */
@RestController
public class MongoController {

	@Autowired
	private MongoDao mongoDao;

	@PostMapping("/saveItem")
	public void saveItem(Record record) {
		mongoDao.save(record);
	}
}
