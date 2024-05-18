package com.harmonify.backspring;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BackSpringApplicationTests {

	@Test
	void contextLoads() {
		BackSpringApplication main = new BackSpringApplication();

		assert(main.getClass() != null);
	}

}
