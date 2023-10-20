package com.example.demo.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
class BeginnerServiceTest {

	// テスト対象クラスを定義
	@Autowired
	private BeginnerService target;
	
	@Test
	void addメソッドに1と2を設定して3を出力する() {
		// 1. Ready
		int x = 1;
		int y = 2;
		int expected = 3;
		
		// 2. Do
		int result = target.add(x, y);
		
		// 3. Check
		assertEquals(expected, result);
		
		// 4. Log
		log.info("結果：" + result);
	}

	@Test
	void evenOddメソッドに10を設定して偶数を出力する() {
		// 1. Ready
		int x = 10;
		String expected = "偶数";
		
		// 2. Do
		String result = target.evenOdd(x);
		
		// 3. Check
		assertEquals(expected, result);
		
		// 4. Log
		log.info("結果：" + result);
	}
	
	@Test
	void evenOddメソッドに11を設定して奇数を出力する() {
		// 1. Ready
		int x = 11;
		String expected = "奇数";
		
		// 2. Do
		String result = target.evenOdd(x);
		
		// 3. Check
		assertEquals(expected, result);
		
		// 4. Log
		log.info("結果：" + result);
	}

	@Test
	void sumメソッドに10を設定して55を出力する() {
		// 1. Ready
		int x = 10;
		int expected = 55;
		
		// 2. Do
		int result = target.sum(x);
		
		// 3. Check
		assertEquals(expected, result);
		
		// 4. Log
		log.info("結果：" + result);
	}

	@Test
	void powerメソッドに2と3を設定して8を出力する() {
		// 1. Ready
		int x = 2;
		int y = 3;
		double expected = 8.0;
		
		// 2. Do
		double result = target.power(x, y);
		
		// 3. Check
		assertEquals(expected, result);
		
		// 4. Log
		log.info("結果：" + result);
	}
	
	@Test
	void powerメソッドに0と0を設定して例外をスローする() {
		// 1. Ready
		int x = 0;
		int y = 0;
		
		// 2. Do & 3. Check
		assertThrows(IllegalArgumentException.class, () -> target.power(x, y));
		
		// 4. Log
		log.info("結果：IllegalArgumentException");
	}
	
	@Test
	void powerメソッドに1と0を設定して例外をスローする() {
		// 1. Ready
		int x = 1;
		int y = 0;
		
		// 2. Do & 3. Check
		assertThrows(IllegalArgumentException.class, () -> target.power(x, y));
		
		// 4. Log
		log.info("結果：IllegalArgumentException");
	}

}
