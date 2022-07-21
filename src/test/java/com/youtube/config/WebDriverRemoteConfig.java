package com.youtube.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
		"classpath:config/remoteLauncher.properties",
		"classpath:config/credentials.properties"
})
public interface WebDriverRemoteConfig extends Config {
	@Key("browser.name")
	@DefaultValue("chrome")
	String getBrowserName();

	@Key("browser.size")
	String getBrowserSize();

	@Key("base.url")
	String getBaseUrl();

	@Key("remote.url")
	String getRemoteUrl();

	@Key("selenoid.username")
	String getSelenoidUserName();

	@Key("selenoid.password")
	String getSelenoidPassword();
}
