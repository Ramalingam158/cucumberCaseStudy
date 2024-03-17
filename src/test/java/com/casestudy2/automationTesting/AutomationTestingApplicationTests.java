package com.casestudy2.automationTesting;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@CucumberContextConfiguration
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources")
class AutomationTestingApplicationTests {
	@Test
	void contextLoads() {
	}
}
