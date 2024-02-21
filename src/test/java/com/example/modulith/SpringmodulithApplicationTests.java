package com.example.modulith;

import com.example.modulith.order.Order;
import com.example.modulith.order.OrderManagement;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringmodulithApplicationTests {

	@Autowired
	OrderManagement orders;

	@Test
	void completesOrder() throws Exception {

		orders.complete(new Order());

		Thread.sleep(2000);
	}

}
