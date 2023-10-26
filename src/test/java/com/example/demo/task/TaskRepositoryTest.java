package com.example.demo.task;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
class TaskRepositoryTest {

	// モック対象クラスを定義
	@SpyBean
	private NamedParameterJdbcTemplate mock;
	
	// テスト対象クラスを定義
	@Autowired
	private TaskRepository target;
	
	@Test
	void findAllメソッドのモック値にList型のMapを設定() {
		// 0. Mock
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("user_id", "gon");
		List<Map<String, Object>> returnValue = new ArrayList<Map<String, Object>>();
		returnValue.add(map);
		
		doReturn(returnValue).when(mock).queryForList(anyString(), anyMap());
		
		// 1. Ready
		String x = "gon";
		
		// 2. Do
		List<Map<String, Object>> result = target.findAll(x);
		
		// 3. Check
		assertEquals(x, result.get(0).get("user_id"));
		
		// 4. Log
		log.info("結果：" + x, result.get(0).get("user_id"));
	}

	@Test
	void saveメソッドにモック値1を設定しSQLExceptionが出力されない() {
		// 0. Mock
		int returnValue = 1;
		doReturn(returnValue).when(mock).update(anyString(), anyMap());
		
		// 1. Ready
		TaskData taskData = new TaskData();
		
		// 2. Do & 3. Check
		assertDoesNotThrow(() -> target.save(taskData));
		
		// 4. Log
		log.info("結果：SQLExceptionが発生しない");
	}
	
	@Test
	void saveメソッドにモック値0を設定しSQLExceptionを出力() {
		// 0. Mock
		int returnValue = 0;
		doReturn(returnValue).when(mock).update(anyString(), anyMap());
		
		// 1. Ready
		TaskData taskData = new TaskData();
		
		// 2. Do & 3. Check
		assertThrows(SQLException.class, () -> target.save(taskData));
		
		// 4. Log
		log.info("結果：SQLException");
	}

	@Test
	void deleteメソッドにモック値1を設定しSQLExceptionが出力されない() {
		// 0. Mock
		int returnValue = 1;
		doReturn(returnValue).when(mock).update(anyString(), anyMap());
		
		// 1. Ready
		int id = 0;
		
		// 2. Do & 3. Check
		assertDoesNotThrow(() -> target.delete(id));
		
		// 4. Log
		log.info("結果：SQLExceptionが発生しない");
	}
	
	@Test
	void deleteメソッドにモック値0を設定しSQLExceptionを出力() {
		// 0. Mock
		int returnValue = 0;
		doReturn(returnValue).when(mock).update(anyString(), anyMap());
		
		// 1. Ready
		int id = 0;
		
		// 2. Do & 3. Check
		assertThrows(SQLException.class, () -> target.delete(id));
		
		// 4. Log
		log.info("結果：SQLException");
	}
	
	@Test
	void updateメソッドにモック値0を設定しSQLExceptionを出力() {
		// 0. Mock
		int returnValue = 0;
		doReturn(returnValue).when(mock).update(anyString(), anyMap());
		
		// 1. Ready
		int id = 0;
		
		// 2. Do & 3. Check
		assertThrows(SQLException.class, () -> target.update(id));
		
		// 4. Log
		log.info("結果：SQLException");
	}
	
	@Test
	void updateメソッドにモック値1を設定しSQLExceptionが出力されない() {
		// 0. Mock
		int returnValue = 1;
		doReturn(returnValue).when(mock).update(anyString(), anyMap());
		
		// 1. Ready
		int id = 0;
		
		// 2. Do & 3. Check
		assertDoesNotThrow(() -> target.update(id));
		
		// 4. Log
		log.info("結果：SQLExceptionが発生しない");
	}
	
	@Test
	void fileOutメソッドにモック値heandlerを設定() {
		// 0. Mock
		TaskRowCallbackHandler handler = new TaskRowCallbackHandler();
		doNothing().when(mock).query(anyString(), anyMap(), handler);
		
		// 1. Ready
		String x = "gon";
		
		// 2. Do & 3. Check
		target.fileOut(x);
		
		// 4. Log
		log.info("結果：CSV出力完了");
	}

}
