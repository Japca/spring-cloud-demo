package com.japca.ribbonclient.service;

import com.japca.ribbonclient.dao.RecordDao;
import com.japca.ribbonclient.entity.Record;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Collections;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.BDDMockito.given;

/**
 * Created by Jakub krhovják on 4/8/18.
 */

@RunWith(MockitoJUnitRunner.class)
public class RecordServiceTest {

	@Spy
	private RecordService recordService;

	@Mock
	private RecordDao recordDao;

	@Before
	public void init() {
		recordService.setRecordDao(recordDao);
	}

	@Test
	public void getRecordCountDoubledEmptyListTest() {
		given(recordDao.findAll()).willReturn(Collections.emptyList());
		assertThat(recordService.getRecordCountDoubled()).isEqualTo(0);
	}


	@Test
	public void getRecordCountDoubledNullTest() {
		given(recordDao.findAll()).willReturn(null);
		assertThat(recordService.getRecordCountDoubled()).isEqualTo(0);
	}

	@Test
	public void getRecordCountDoubledSingletonListTest() {
		given(recordDao.findAll()).willReturn(Collections.singletonList(new Record()));
		assertThat(recordService.getRecordCountDoubled()).isEqualTo(2);
	}
}
