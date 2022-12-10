package com.youtube.helpers;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class Attach {
	private static final String TEXT_PLAIN_TYPE = "text/plain";
	private static final String TEXT_HTML_TYPE = "text/html";
	private static final String IMAGE_PNG_TYPE = "image/png";


	@Attachment(value = "{attachName}", type = TEXT_PLAIN_TYPE)
	public static String attachAsText(String attachName, String message) {
		return message;
	}

	@Attachment(value = "Page source", type = TEXT_HTML_TYPE)
	public static byte[] pageSource() {
		return getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8);
	}

	@Attachment(value = "{attachName}", type = IMAGE_PNG_TYPE)
	public static byte[] screenshotAs(String attachName) {
		return ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
	}

	@Attachment(value = "Video", type = TEXT_HTML_TYPE, fileExtension = ".html")
	public static String addVideo() {
		return "<html><body><video width='100%' height='100%' controls autoplay><source src='"
				+ getVideoUrl(getSessionId())
				+ "' type='video/mp4'></video></body></html>";
	}

	public static URL getVideoUrl(String sessionId) {
		String videoUrl = "https://selenoid.autotests.cloud/video/" + sessionId + ".mp4";

		try {
			return new URL(videoUrl);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String getSessionId() {
		return ((RemoteWebDriver) getWebDriver()).getSessionId().toString();
	}
}
