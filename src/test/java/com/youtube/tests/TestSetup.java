package com.youtube.tests;

import com.codeborne.selenide.Configuration;
import com.youtube.config.WebDriverRemoteConfig;
import com.youtube.helpers.Attach;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.youtube.helpers.Helper.format;


public class TestSetup {
	private static WebDriverRemoteConfig config = ConfigFactory.create(WebDriverRemoteConfig.class);
	private static final String baseUrl = config.getBaseUrl();
	private static final String browserName = config.getBrowserName();
	private static final String browserSize = config.getBrowserSize();


	@BeforeAll
	static void setup() {
		switch (System.getProperty("Launcher")) {
			case "Local":
				Configuration.baseUrl = baseUrl;
				Configuration.browserSize = browserSize;
				Configuration.browser = browserName;
				break;
			case "Remote":
				Configuration.baseUrl = baseUrl;
				Configuration.browser = browserName;
				Configuration.browserSize = browserSize;
				//Configuration.remote = format("https://{}:{}@{}",
				Configuration.remote = format("http://{}:{}@{}",
						config.getSelenoidUserName(),
						config.getSelenoidPassword(),
						config.getRemoteUrl()
				);

				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setCapability("enableVNC", true);
				capabilities.setCapability("enableVideo", true);
				Configuration.browserCapabilities = capabilities;
				break;
			default:
				throw new RuntimeException("No such environment");
		}
	}

	@AfterEach
	void addAttachments() {
		Attach.screenshotAs("Youtube test screenshot");
		Attach.pageSource();
		Attach.addVideo();

		closeWebDriver();
	}
}
