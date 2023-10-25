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
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
class UserServiceTest {

	// モック対象クラスを定義
	@SpyBean
	private UserRepository mock;
	
	// テスト対象クラスを定義
	@Autowired
	private UserService target;
	
	@Test
    void getUserListメソッドのモック値にList型のMapを設定() {
        // 0.Mock
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("user_id", "gon");
        map.put("enabled", true);
        
        List<Map<String, Object>> returnValue = new ArrayList<Map<String, Object>>();
        returnValue.add(map);
        doReturn(returnValue).when(mock).selectAll();
        
        // 1.Ready
        String expected = "gon";
        
        // 2.Do
        UserEntity result = target.getUserList();
        
        // 3.Check
        assertEquals(expected, result.getUserlist().get(0).getUserId());

        // 4.Log
        log.info("結果：" + result);
	}

	@Test
	void insertOneメソッドのモック値にString型を設定() throws SQLException{
		// 0. Mock
		doNothing().when(mock).insert(any());
		
		// 1. Ready
		UserForm userForm = new UserForm();
		userForm.setUserId("gon");
		userForm.setPassword("pass");
		boolean expected = true;
		
        // 2.Do
        boolean result = target.insertOne(userForm);
        
        // 3.Check
        assertEquals(expected, result);

        // 4.Log
        log.info("結果：" + result);
	}
	
	@Test
	void insertOneメソッドのモック値にString型を設定して例外をスローする() throws SQLException{
		// 0. Mock
		doThrow(new SQLException("")).when(mock).insert(any());
		
		// 1. Ready
		UserForm userForm = new UserForm();
		userForm.setUserId("gon");
		userForm.setPassword("pass");
		boolean expected = false;
		
        // 2.Do
        boolean result = target.insertOne(userForm);
        
        // 3.Check
        assertEquals(expected, result);

        // 4.Log
        log.info("結果：" + result);
	}

	@Test
	void getUseメソッドのモック値にList型のMapを設定() {
        // 0.Mock
		Map<String, Object> map = new HashMap<String, Object>();
        map.put("user_id", "gon");
        map.put("enabled", true);
        
        List<Map<String, Object>> returnValue = new ArrayList<Map<String, Object>>();
        returnValue.add(map);
        doReturn(returnValue).when(mock).selectOne(anyString());
        
        // 1.Ready
        UpdateUserForm userForm = new UpdateUserForm();
        userForm.setUserId("gon");
        
        boolean expected = false;
        
        // 2.Do
        boolean result = target.getUser(userForm);
        
        // 3.Check
        assertEquals(expected, result);

        // 4.Log
        log.info("結果：" + result);
	}

	@Test
	void updateOneメソッドのモック値にData型のuserDataを設定でパスワード空() throws SQLException{
		// 0. Mock
		doNothing().when(mock).updateWithoutPassword(any());
		
		// 1. Ready
		UpdateUserForm userForm = new UpdateUserForm();
		userForm.setUserId("gon");
		userForm.setPassword("");
		boolean expected = true;
		
        // 2.Do
        boolean result = target.updateOne(userForm);
        
        // 3.Check
        assertEquals(expected, result);

        // 4.Log
        log.info("結果：" + result);
	}
	@Test
	void updateOneメソッドのモック値にData型のuserDataを設定() throws SQLException{
		// 0. Mock
		doNothing().when(mock).updateWithPassword(any());
		
		// 1. Ready
		UpdateUserForm userForm = new UpdateUserForm();
		userForm.setUserId("gon");
		userForm.setPassword("pass");
		boolean expected = true;
		
        // 2.Do
        boolean result = target.updateOne(userForm);
        
        // 3.Check
        assertEquals(expected, result);

        // 4.Log
        log.info("結果：" + result);
	}
	
	@Test
	void updateOneメソッドのモック値にData型のuserDataを設定して例外をスローする() throws SQLException{
		// 0. Mock
		doThrow(new SQLException("")).when(mock).updateWithoutPassword(any());
		
		// 1. Ready
		UpdateUserForm userForm = new UpdateUserForm();
		userForm.setUserId("gon");
		userForm.setPassword("pass");
		boolean expected = false;
		
        // 2.Do
        boolean result = target.updateOne(userForm);
        
        // 3.Check
        assertEquals(expected, result);

        // 4.Log
        log.info("結果：" + result);
	}

	@Test
	void deleteOneメソッドのモック値にString型のuserIdを設定() throws SQLException {
		// 0.Mock
		doNothing().when(mock).delete(anyString());
		
		// 1.Ready
        String userId = "gon";
        
        // 2.Do
        boolean result = target.deleteOne(userId);
        
        // 3.Check
        assertDoesNotThrow(() -> target.deleteOne(userId));

        // 4.Log
        log.info("結果：" + result);
	}
	
	@Test
	void deleteOneメソッドのモック値にString型を設定して例外をスローする() throws SQLException {
		// 0.Mock
		doThrow(new SQLException()).when(mock).delete(any());
		
		// 1.Ready
        String userId = "gon";
        boolean expected = false;
        
        // 2.Do
        boolean result = target.deleteOne(userId);
        
        // 3.Check
        assertEquals(expected, result);

        // 4.Log
        log.info("結果：" + result);
	}

	@Test
	void deleteメソッドのモック値にList型を設定() throws SQLException {
		// 0.Mock
		doNothing().when(mock).delete(any());
		
		// 1.Ready
        String userId = "gon,watanabe,iino,sato";
        
        // 2.Do
        boolean result = target.delete(userId);
        
        // 3.Check
        assertDoesNotThrow(() -> target.deleteOne(userId));

        // 4.Log
        log.info("結果：" + result);
	}
	
	@Test
	void deleteメソッドのモック値にList型を設定して例外をスローする() throws SQLException {
		// 0.Mock
		doThrow(new SQLException("")).when(mock).delete(any());
		
		// 1.Ready
        String userId = "gon,watanabe,iino,sato";
        
        // 2.Do
        boolean result = target.delete(userId);
        
        // 3.Check
        assertDoesNotThrow(() -> target.deleteOne(userId));

        // 4.Log
        log.info("結果：" + result);
	}

}
