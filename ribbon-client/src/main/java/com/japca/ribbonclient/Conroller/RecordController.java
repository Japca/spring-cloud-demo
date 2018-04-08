package com.japca.ribbonclient.Conroller;

import com.japca.ribbonclient.entity.Record;
import com.japca.ribbonclient.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Jakub krhovják on 4/8/18.
 */

@RestController
public class RecordController {

	@Autowired
	private RecordService recordService;


	@RequestMapping("records")
	public List<Record> getRecords() {
		return recordService.getRecords();
	}

	@RequestMapping("save")
	public Record save() {
		return recordService.save(new Record("new Record", "Detail"));
	}
}
