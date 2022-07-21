package com.youtube.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.youtube.helpers.Waiting.SIX_SEC;

public class BeforeYouContinuePage {
	//private final SelenideElement rejectAllElement = $("tp-yt-paper-dialog #dialog yt-formatted-string #text");
	private final SelenideElement rejectAllElement = $("ytd-app tp-yt-paper-dialog tp-yt-paper-button #text");

	public void clickOnRejectAll(){
		rejectAllElement.shouldBe(Condition.exist, Duration.ofSeconds(SIX_SEC.getValue())).click();

	}
}
