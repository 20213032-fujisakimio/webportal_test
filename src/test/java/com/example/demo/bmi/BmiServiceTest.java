package com.example.demo.bmi;

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
class BmiServiceTest {

	// テスト対象クラスを定義
	@Autowired
	private BmiService target;
	
	@Test
	void calcメソッドに170と60を設定して20小数点761を出力する() {
		// 1. Ready
		String x = "170";
		String y = "60";
		String expected = "20.761";
		
		// 2. Do
		String result = target.calc(x, y);
		
		// 3. Check
		assertEquals(expected, result);
		
		// 4. Log
		log.info("結果：" + result);
	}
	
	@Test
	void calc() {
		// 1. Ready
		String x = "a";
		String y = "60";
		
		// 2. Do & 3. Check
		assertThrows(IllegalArgumentException.class, () -> target.calc(x, y));
		
		// 4. Log
		log.info("結果：IllegalArgumentException");
	}

	@Test
	void judgeに各数値を設定して適切なコメントが出力される() {
		// 1. Ready
		String[] x = {"15", "16", "18", "24", "29", "34", "39", "45"};
		String[] expected = {"痩せすぎ", "痩せ", "痩せぎみ", "普通体重", "前肥満", "肥満(1度)", "肥満(2度)", "肥満(3度)"};
		
		// 2. Do
		for(int i = 0; i < x.length; i++ ) {
			String result = target.judge(x[i]);
			
			// 3. Check
			assertEquals(expected[i], result);
			
			// 4. Log
			log.info("結果：" + result);
		}
	}
	
	@Test
	void judgeにaを設定して例外をスローする() {
		// 1. Ready
		String x = "a";
		
		// 2. Do & 3. Check
		assertThrows(IllegalArgumentException.class, () -> target.judge(x));
		
		// 4. Log
		log.info("結果：IllegalArgumentException");
	}

	@Test
	void imgメソッドに各数値を設定して適切なコメントが出力される() {
		// 1. Ready
		String[] x = {"18", "20", "28"};
		String[] expected = { "/img/bmi/gari.png",  "/img/bmi/normal.png", "/img/bmi/puni.png"};
		
		// 2. Do
		for(int i = 0; i < x.length; i++ ) {
			String result = target.img(x[i]);
			
			// 3. Check
			assertEquals(expected[i], result);
			
			// 4. Log
			log.info("結果：" + result);
		}
	}
	
	@Test
	void imgメソッドにaを設定して例外をスローする() {
		// 1. Ready
		String x = "a";
		
		// 2. Do & 3. Check
		assertThrows(IllegalArgumentException.class, () -> target.img(x));
		
		// 4. Log
		log.info("結果：IllegalArgumentException");
	}
	
	@Test
    void execメソッドに170と60を設定して20小数点761と普通体重とイメージURLを表示する() {
        // 1. Ready
        String x = "170";
        String y = "60";
        
        // 2. Do
        BmiData result = target.exec(x, y);
        
        // 3. Check
        assertEquals("20.761", result.getAns());
        assertEquals("普通体重", result.getComment());
        assertEquals("/img/bmi/normal.png", result.getPath());
        
        // 4. Log
        log.info("結果：" + result);
    }

}
