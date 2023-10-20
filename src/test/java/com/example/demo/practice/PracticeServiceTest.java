package com.example.demo.practice;

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
class PracticeServiceTest {

	// テスト対象クラスを定義
	@Autowired
	private PracticeService target;
	
	@Test
	void level0メソッドにgondoとhcsを設定してgondoアットマークhcsを出力する() {
		// 1. Ready
		String x = "gondo";
		String y = "hcs";
		String expected = "gondo@hcs";
		
		// 2. Do
		String result = target.level0(x, y);
		
		// 3. Check
		assertEquals(expected, result);
		
		// 4. Log
		log.info("結果：" + result);
	}

	@Test
	void level1メソッドに180に半角に2を設定して460を出力する() {
		// 1. Ready
		String x = "180 2";
		int expected = 460;
		
		// 2. Do
		int result = target.level1(x);
		
		// 3. Check
		assertEquals(expected, result);
		
		// 4. Log
		log.info("結果：" + result);
	}
	
	@Test
	void level1メソッドに180に2を設定して0を出力する() {
		// 1. Ready
		String x = "1802";
		int expected = 0;
		
		// 2. Do
		int result = target.level1(x);
		
		// 3. Check
		assertEquals(expected, result);
		
		// 4. Log
		log.info("結果：" + result);
	}
	
	@Test
	void level1メソッドにgondoに半角にsyunを設定して0を出力する() {
		// 1. Ready
		String x = "gondo syun";
		int expected = 0;
		
		// 2. Do
		int result = target.level1(x);
		
		// 3. Check
		assertEquals(expected, result);
		
		// 4. Log
		log.info("結果：" + result);
	}

	@Test
	void level2メソッドにgondosyunを設定してnを出力する() {
		// 1. Ready
		String x = "gondosyun";
		String expected = "n";
		
		// 2. Do
		String result = target.level2(x);
		
		// 3. Check
		assertEquals(expected, result);
		
		// 4. Log
		log.info("結果：" + result);
	}
	
	@Test
	void level2メソッドに空文字を設定して空文字を出力する() {
		// 1. Ready
		String x = "";
		String expected = "";
		
		// 2. Do
		String result = target.level2(x);
		
		// 3. Check
		assertEquals(expected, result);
		
		// 4. Log
		log.info("結果：" + result);
	}
	
	@Test
	void level2メソッドにnullを設定して例外をスローする() {
		// 1. Ready
		String x = null;
		
		// 2. Do & 3. Check
		assertThrows(IllegalArgumentException.class, () -> target.level2(x));
		
		// 4. Log
		log.info("結果：IllegalArgumentException");
	}

	@Test
	void level3メソッドにTaiueoAIUEOtを設定してTtを出力する() {
		// 1. Ready
		String x = "TaiueoAIUEOt";
		String expected = "Tt";
		
		// 2. Do
		String result = target.level3(x);
		
		// 3. Check
		assertEquals(expected, result);
		
		// 4. Log
		log.info("結果：" + result);
	}

	@Test
	void level3メソッドにxXを設定してxXを出力する() {
		// 1. Ready
		String x = "xX";
		String expected = "xX";
		
		// 2. Do
		String result = target.level3(x);
		
		// 3. Check
		assertEquals(expected, result);
		
		// 4. Log
		log.info("結果：" + result);
	}
	
	@Test
	void level4メソッドにxoooxを設定してoを出力する() {
		// 1. Ready
		String x = "xoooo";
		String expected = "o";
		
		// 2. Do
		String result = target.level4(x);
		
		// 3. Check
		assertEquals(expected, result);
		
		// 4. Log
		log.info("結果：" + result);
	}
	
	@Test
	void level4メソッドにxxxooを設定してxを出力する() {
		// 1. Ready
		String x = "xxxxo";
		String expected = "x";
		
		// 2. Do
		String result = target.level4(x);
		
		// 3. Check
		assertEquals(expected, result);
		
		// 4. Log
		log.info("結果：" + result);
	}
	
	@Test
	void level4メソッドにxoxoxを設定してdrawを出力する() {
		// 1. Ready
		String x = "xoxox";
		String expected = "draw";
		
		// 2. Do
		String result = target.level4(x);
		
		// 3. Check
		assertEquals(expected, result);
		
		// 4. Log
		log.info("結果：" + result);
	}
	
	@Test
	void level4メソッドにxxxを設定して例外をスローする() {
		// 1. Ready
		String x = "xxx";
		
		// 2. Do & 3. Check
		assertThrows(IllegalArgumentException.class, () -> target.level4(x));
		
		// 4. Log
		log.info("結果：IllegalArgumentException");
	}
	
	@Test
	void level4メソッドにxxxxxxを設定して例外をスローする() {
		// 1. Ready
		String x = "xxxxxx";
		
		// 2. Do & 3. Check
		assertThrows(IllegalArgumentException.class, () -> target.level4(x));
		
		// 4. Log
		log.info("結果：IllegalArgumentException");
	}
	
	@Test
	void level4メソッドにaiueoを設定して例外をスローする() {
		// 1. Ready
		String x = "aiueo";
		
		// 2. Do & 3. Check
		assertThrows(IllegalArgumentException.class, () -> target.level4(x));
		
		// 4. Log
		log.info("結果：IllegalArgumentException");
	}

}
