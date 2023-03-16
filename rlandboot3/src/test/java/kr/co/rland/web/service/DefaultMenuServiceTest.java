package kr.co.rland.web.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import kr.co.rland.web.repository.MenuRepository;

@SpringBootTest
class DefaultMenuServiceTest {

	@Autowired
	private MenuService service;
	
	@Test
	void test() {
		service.pointUp();
		System.out.println("작업완료");
	}
}
