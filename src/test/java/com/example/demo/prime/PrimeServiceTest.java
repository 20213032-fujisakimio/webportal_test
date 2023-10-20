package com.example.demo.prime;

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
class PrimeServiceTest {

	// テスト対象クラスを定義
	@Autowired
	private PrimeService target;
	
	@Test
	void execメソッドに10を設定して2改行3改行5改行7改行を出力する() {
		// 1. Ready
		String x = "10";
		String expected = "2\r\n3\r\n5\r\n7\r\n";
		
		// 2. Do
		String result = target.exec(x);
		
		// 3. Check
		assertEquals(expected, result);
		
		// 4. Log
		log.info("結果：" + result);
	}
	
	@Test
	void execメソッドにaを設定して例外をスローする() {
		// 1. Ready
		String x = "a";
		
		// 2. Do & 3. Check
		assertThrows(IllegalArgumentException.class, () -> target.exec(x));
		
		// 4. Log
		log.info("結果：IllegalArgumentException");
	}
	
	@Test
	void execメソッドに1を設定して例外をスローする() {
		// 1. Ready
		String x = "0";
		
		// 2. Do & 3. Check
		assertThrows(IllegalArgumentException.class, () -> target.exec(x));
		
		// 4. Log
		log.info("結果：IllegalArgumentException");
	}
	
	@Test
	void isPrimeメソッドに0を設定してfalseを出力する() {
		// 1. Ready
		int x = 0;
		boolean expected = false;
		
		// 2. Do
		boolean result = target.isPrime(x);
		
		// 3. Check
		assertEquals(expected, result);
		
		// 4. Log
		log.info("結果：" + result);
	}

}
