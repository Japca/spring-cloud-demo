package com.japca.ribbonclient.service;

import com.japca.ribbonclient.entity.Record;
import lombok.extern.slf4j.Slf4j;
import org.arquillian.ape.junit.rule.ArquillianPersistenceRule;
import org.arquillian.ape.rdbms.core.RdbmsPopulator;
import org.arquillian.ape.rdbms.dbunit.DbUnit;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by Jakub Krhovják on 5/7/18.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
public class ArquillianApeRecordServiceTest {

	@Rule
	public ArquillianPersistenceRule arquillianPersistenceRule = new ArquillianPersistenceRule();

	@DbUnit
	@ArquillianResource
	RdbmsPopulator rdbmsPopulator;

	@Autowired
	private RecordService recordService;

	@Before
	public void setUp() throws Exception {
		rdbmsPopulator.forUri("jdbc:postgresql://172.17.0.2:5432/postgres")
				.withDriver(org.postgresql.Driver.class)
				.withUsername("postgres")
				.withPassword("postgres")
				.usingDataSet("test-data.yml")
				.execute();
	}

	@Test
	public void name() {
		List<Record> records = recordService.getRecords();
		log.info("---------------------------------------------------------------Records: ", records);
	}

	@After
	public void tearDown() throws Exception {
		rdbmsPopulator.forUri("jdbc:postgresql://172.17.0.2:5432/postgres")
				.withDriver(org.postgresql.Driver.class)
				.withUsername("postgres")
				.withPassword("postgres")
				.clean();
	}
}
