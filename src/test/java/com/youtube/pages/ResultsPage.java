package com.youtube.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.youtube.helpers.Attach;
import io.qameta.allure.Step;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.*;
import static com.youtube.helpers.Waiting.EIGHT_SEC;
import static com.youtube.helpers.Waiting.SIX_SEC;

public class ResultsPage {
	private final ElementsCollection itemListElement = $$("#dismissible");
	private final SelenideElement itemTitleElement = $x("//h1[contains(@class,'title style-scope')]//yt-formatted-string");

	private static final String RESULT_PATH = "/results?search_query=appium";


	@Step("Open the Search page")
	public void openResultPageStep() {
		open(RESULT_PATH);
	}

	@Step("Check the existence of video names")
	public void checkExistenceItemsInResultStep() {
		itemListElement.shouldBe(CollectionCondition.sizeGreaterThan(0), Duration.ofSeconds(SIX_SEC.getValue()));
		Attach.attachAsText("Quantity of videos", String.valueOf(itemListElement.size()));
	}

	@Step("get the name of the first video")
	public String getItemTitleFromResultListStep() {
		String itemTitleFromResult = itemListElement.first().find(By.id("video-title")).getText();
		Attach.attachAsText("Title of first video", itemTitleFromResult);

		return itemTitleFromResult;
	}

	@Step("Click on the first video")
	public void clickOnFirstItemResultStep() {
		itemListElement.first().shouldBe(enabled, Duration.ofSeconds(SIX_SEC.getValue())).click();
	}

	@Step("Get the name of the opened video")
	public String getItemTitle() {
		String itemTitle = itemTitleElement.shouldBe(enabled, Duration.ofSeconds(EIGHT_SEC.getValue())).getOwnText();

		while (itemTitle.equals("")) {
			itemTitle = itemTitleElement.shouldBe(enabled, Duration.ofSeconds(EIGHT_SEC.getValue())).getOwnText();
		}
		Attach.attachAsText("Video's title", itemTitle);

		return itemTitle;
	}

	@Step("Compare the name of the first video in the result list and the name of the opened video")
	public void checkVideoTitlesStep(String itemTitleFromResult, String itemTitle) {
		Assertions.assertThat(itemTitle)
				.as("Video titles not are the same")
				.isEqualTo(itemTitleFromResult);
	}
}
