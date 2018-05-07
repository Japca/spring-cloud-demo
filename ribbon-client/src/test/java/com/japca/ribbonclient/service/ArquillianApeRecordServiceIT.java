package com.japca.ribbonclient.service;

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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Jakub Krhovják on 5/7/18.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
public class ArquillianApeRecordServiceIT {

//	@ClassRule
//	public static ContainerDslRule postgresSql = new ContainerDslRule("postgres:10.3-alpine")
//			.withPortBinding("5432->5432")
//			.withEnvironment( "POSTGRES_USER","postgres",
//					    "POSTGRES_PASSWORD","postgres",
//								   "POSTGRES_DB","postgres")
//			.withAwaitStrategy(AwaitBuilder.logAwait("LOG: autovacum launcher started",2));


	@Rule
	public ArquillianPersistenceRule arquillianPersistenceRule = new ArquillianPersistenceRule();

	@DbUnit
	@ArquillianResource
	RdbmsPopulator rdbmsPopulator;

	@Autowired
	private RecordService recordService;

	@Value("${spring.datasource.url}")
	private String dbUrl;


	@Before
	public void setUp() throws Exception {
		rdbmsPopulator.forUri(dbUrl)
				.fromSpringBootConfiguration()
				.usingDataSet("test-data.yml")
				.execute();
	}

	@Test
	public void name() {
		assertThat(recordService.findByName("a test")).isNotNull();
	}

	@After
	public void tearDown() throws Exception {
		rdbmsPopulator.forUri(dbUrl)
				.fromSpringBootConfiguration()
				.usingDataSet("test-data.yml")
				.clean();
	}
}
