package com.youtube.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;


public class TestSetup {

	@BeforeAll
	static void setup() {
		Configuration.baseUrl = "https://youtube.com";
		Configuration.browserSize = "1920x1080";
	}

	@AfterEach
	void closeBrowser() {
		Selenide.closeWindow();
	}
}
