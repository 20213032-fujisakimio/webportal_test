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
class ExpertServiceTest {

	// テスト対象クラスを定義
	@Autowired
	private ExpertService target;
	
	@Test
	void factorialメソッドに3を設定して6を出力する() {
		// 1. Ready
		int x = 3;
		int expected = 6;
		
		// 2. Do
		int result = target.factorial(x);
		
		// 3. Check
		assertEquals(expected, result);
		
		// 4. Log
		log.info("結果：" + result);
	}

	@Test
	void maxメソッドにリストの6と5と9と4と0を設定して9を出力する() {
		// 1. Ready
		int[] x = {6,5,9,4,0};
		int expected = 9;
		
		// 2. Do
		int result = target.max(x);
		
		// 3. Check
		assertEquals(expected, result);
		
		// 4. Log
		log.info("結果：" + result);
	}
	
	@Test
	void maxメソッドに空のリストを設定して例外をスローする() {
		// 1. Ready
		int[] x = {};
		
		// 2. Do & 3. Check
		assertThrows(IllegalArgumentException.class, () -> target.max(x));
		
		// 4. Log
		log.info("結果：IllegalArgumentException");
	}

	@Test
	void commonメソッドにリストの6と5と9と4と0とリストの2と5と3と4と1を設定して2を出力する() {
		// 1. Ready
		int[] x = {6,5,9,4,0};
		int[] y = {2,5,3,4,1};
		int expected = 2;
		
		// 2. Do
		int result = target.common(x, y);
		
		// 3. Check
		assertEquals(expected, result);
		
		// 4. Log
		log.info("結果：" + result);
	}

	@Test
	void bubbleSortメソッドにリストの2と5と3と4と1を設定してリストの1と2と3と4と5を出力する() {
		// 1. Ready
		int[] x = {2,5,3,4,1};
		int[] expected = {1,2,3,4,5};
		
		// 2. Do
		int[] result = target.bubbleSort(x);
		
		// 3. Check
		assertArrayEquals(expected, result);
		
		// 4. Log
		log.info("結果：" + result);
	}

}
