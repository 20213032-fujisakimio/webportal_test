package com.example.demo.user;

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
class UserRepositoryTest {

	// モック対象クラスを定義
	@SpyBean
	private NamedParameterJdbcTemplate mock;
	
	// テスト対象クラスを定義
	@Autowired
	private UserRepository target;
	
	@Test
	void selectAllメソッドのモック値にList型のMapを設定() {
		// 0. Mock
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("user_id", "gon");
		List<Map<String, Object>> returnValue = new ArrayList<Map<String, Object>>();
		returnValue.add(map);
		
		doReturn(returnValue).when(mock).queryForList(anyString(), anyMap());
		
		// 1. Ready
		Map<String, Object> readyMap = new HashMap<String, Object>();
		readyMap.put("user_id", "gon");
		List<Map<String, Object>> expected = new ArrayList<Map<String, Object>>();
		expected.add(readyMap);
		
		// 2. Do
		List<Map<String, Object>> result = target.selectAll();
		
		// 3. Check
		assertEquals(expected.get(0).get("user_id"), result.get(0).get("user_id"));
		
		// 4. Log
		log.info("結果：" + expected.get(0).get("user_id"), result.get(0).get("user_id"));
	}

	@Test
	void selectOneメソッドのモック値にList型のMapを設定() {
		// 0. Mock
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("user_id", "gon");
		List<Map<String, Object>> returnValue = new ArrayList<Map<String, Object>>();
		returnValue.add(map);
		
		doReturn(returnValue).when(mock).queryForList(anyString(), anyMap());
		
		// 1. Ready
		String x = "gon";
		
		// 2. Do
		List<Map<String, Object>> result = target.selectOne(x);
		
		// 3. Check
		assertEquals(x, result.get(0).get("user_id"));
		
		// 4. Log
		log.info("結果：" + x, result.get(0).get("user_id"));
	}
	
	@Test
	void insertメソッドにモック値1を設定しSQLExceptionが出力されない() {
		// 0. Mock
		int returnValue = 1;		// 110行目のyodateRowに1を設定するという意味
		doReturn(returnValue).when(mock).update(anyString(), anyMap());
		
		// 1. Ready
		UserData userData = new UserData();
		
		// 2. Do & 3. Check
		assertDoesNotThrow(() -> target.insert(userData));
		
		// 4. Log
		log.info("結果：SQLExceptionが発生しない");
	}

	@Test
	void insertメソッドにモック値0を設定しSQLExceptionを出力() {
		// 0. Mock
		int returnValue = 0;		// 110行目のyodateRowに0を設定するという意味
		doReturn(returnValue).when(mock).update(anyString(), anyMap());
		
		// 1. Ready
		UserData userData = new UserData();
//		int excepted = 1;
		
		// 2. Do & 3. Check
		assertThrows(SQLException.class, () -> target.insert(userData));
		
		// 4. Log
		log.info("結果：SQLException");
	}
	
	@Test
	void updateWithPasswordメソッドにモック値1を設定しSQLExceptionが出力されない() {
		// 0. Mock
		int returnValue = 1;
		doReturn(returnValue).when(mock).update(anyString(), anyMap());
		
		// 1. Ready
		UserData userData = new UserData();
		
		// 2. Do & 3. Check
		assertDoesNotThrow(() -> target.updateWithPassword(userData));
		
		// 4. Log
		log.info("結果：SQLExceptionが発生しない");
	}

	@Test
	void updateWithPasswordメソッドにモック値0を設定しSQLExceptionを出力() {
		// 0. Mock
		int returnValue = 0;
		doReturn(returnValue).when(mock).update(anyString(), anyMap());
		
		// 1. Ready
		UserData userData = new UserData();
		
		// 2. Do & 3. Check
		assertThrows(SQLException.class, () -> target.updateWithPassword(userData));
		
		// 4. Log
		log.info("結果：SQLException");
	}

	@Test
	void updateWithoutPasswordメソッドにモック値1を設定しSQLExceptionが出力されない() {
		// 0. Mock
		int returnValue = 1;
		doReturn(returnValue).when(mock).update(anyString(), anyMap());
		
		// 1. Ready
		UserData userData = new UserData();
		
		// 2. Do & 3. Check
		assertDoesNotThrow(() -> target.updateWithoutPassword(userData));
		
		// 4. Log
		log.info("結果：SQLExceptionが発生しない");
	}
	
	@Test
	void updateWithoutPasswordメソッドにモック値0を設定しSQLExceptionを出力() {
		// 0. Mock
		int returnValue = 0;
		doReturn(returnValue).when(mock).update(anyString(), anyMap());
		
		// 1. Ready
		UserData userData = new UserData();
		
		// 2. Do & 3. Check
		assertThrows(SQLException.class, () -> target.updateWithoutPassword(userData));
		
		// 4. Log
		log.info("結果：SQLException");
	}

	@Test
	void deleteメソッドにモック値1を設定しSQLExceptionが出力されない() {
		// 0. Mock
		int returnValue = 1;
		doReturn(returnValue).when(mock).update(anyString(), anyMap());
		
		// 1. Ready
		String x = "gon";
		
		// 2. Do & 3. Check
		assertDoesNotThrow(() -> target.delete(x));
		
		// 4. Log
		log.info("結果：SQLExceptionが発生しない");
	}
	
	@Test
	void deleteメソッドにモック値0を設定しSQLExceptionを出力() {
		// 0. Mock
		int returnValue = 0;
		doReturn(returnValue).when(mock).update(anyString(), anyMap());
		
		// 1. Ready
		String x = "gon";
		
		// 2. Do & 3. Check
		assertThrows(SQLException.class, () -> target.delete(x));
		
		// 4. Log
		log.info("結果：SQLException");
	}

}
