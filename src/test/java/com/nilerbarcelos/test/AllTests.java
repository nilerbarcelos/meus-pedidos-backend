package com.nilerbarcelos.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.springframework.test.context.ActiveProfiles;

import com.nilerbarcelos.controller.CustomerControllerTest;
import com.nilerbarcelos.controller.OrderControllerTest;
import com.nilerbarcelos.controller.ProductControllerTest;

@RunWith(Suite.class)
@ActiveProfiles("test")
@SuiteClasses({ CustomerControllerTest.class, OrderControllerTest.class, ProductControllerTest.class })
public class AllTests {

}
