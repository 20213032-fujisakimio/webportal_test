package com.example.demo.task;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
class TaskServiceTest {
	
	// モック対象クラスを定義
	@SpyBean
	private TaskRepository mock;
	
	// テスト対象クラスを定義
	@Autowired
	private TaskService target;

	@Test
	void selectAllメソッドのモック値にList型のMapを設定() throws ParseException {
        // 0.Mock
		Date limitday;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		limitday = format.parse("2022-11-11");
		
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", 1);
        map.put("userId", "gon");
        map.put("title", "このレコードは消さないこと");
        map.put("limitday", limitday);
        map.put("complate", false);
        
        List<Map<String, Object>> returnValue = new ArrayList<Map<String, Object>>();
        returnValue.add(map);
        String x = "gon";
        doReturn(returnValue).when(mock).findAll(x);
        
        // 1.Ready
        int expected = 1;
        
        // 2.Do
        TaskEntity result = target.selectAll(x);
        
        // 3.Check
        assertEquals(expected, result.getTaskList().get(0).getId());

        // 4.Log
        log.info("結果：" + result);
	}

	@Test
	void insertメソッドのモック値にany型を設定() throws SQLException {
		// 0. Mock
		doNothing().when(mock).save(any());
		
		// 1. Ready
		String userId = "gon";
		String title = "このレコードは消さないこと";
		String limitday = "2022-11-11";
		boolean expected = true;
		
        // 2.Do
        boolean result = target.insert(userId, title, limitday);
        
        // 3.Check
        assertEquals(expected, result);

        // 4.Log
        log.info("結果：" + result);
	}
	
	@Test
	void insertメソッドのモック値にany型を設定して例外をスローする() throws SQLException {
		// 0. Mock
		doThrow(new SQLException("")).when(mock).save(any());
		
		// 1. Ready
		String userId = "gon";
		String title = "このレコードは消さないこと";
		String limitday = "2022-11-11";
		boolean expected = false;
		
        // 2.Do
        boolean result = target.insert(userId, title, limitday);
        
        // 3.Check
        assertEquals(expected, result);

        // 4.Log
        log.info("結果：" + result);
	}

	@Test
	void deleteメソッドのモック値にany型を設定() throws SQLException {
		// 0.Mock
		doNothing().when(mock).delete(anyInt());
		
		// 1.Ready
        String x = "01";
        
        // 2.Do
        boolean result = target.delete(x);
        
        // 3.Check
        assertDoesNotThrow(() -> target.delete(x));

        // 4.Log
        log.info("結果：" + result);
	}
	
	@Test
	void deleteメソッドのモック値にany型を設定して例外をスローする() throws SQLException {
		// 0.Mock
		doThrow(new SQLException("")).when(mock).delete(anyInt());
		
		// 1.Ready
        String x = "01";
        boolean expected = false;
        
        // 2.Do
        boolean result = target.delete(x);
        
        // 3.Check
        assertEquals(expected, result);

        // 4.Log
        log.info("結果：" + result);
	}

	@Test
	void testComplate() {
		fail("まだ実装されていません");
	}

	@Test
	void testTaskListCsvOut() {
		fail("まだ実装されていません");
	}

	@Test
	void testGenerateHeader() {
		fail("まだ実装されていません");
	}

	@Test
	void testGetFile() {
		fail("まだ実装されていません");
	}

	@Test
	void testValidateStringString() {
		fail("まだ実装されていません");
	}

	@Test
	void testValidateString() {
		fail("まだ実装されていません");
	}

	@Test
	void testRefillToData() {
		fail("まだ実装されていません");
	}

	@Test
	void testMappingSelectResult() {
		fail("まだ実装されていません");
	}

}
