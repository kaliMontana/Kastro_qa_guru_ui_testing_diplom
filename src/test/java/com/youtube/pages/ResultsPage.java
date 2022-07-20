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
	public final SelenideElement itemTitleElement = $x("//h1[contains(@class,'title style-scope')]//yt-formatted-string");

	private static final String RESULT_PATH = "/results?search_query=appium";


	@Step
	public void openResultPageStep() {
		open(RESULT_PATH);
	}

	@Step
	public void checkExistenceItemsInResultStep() {
		itemListElement.shouldBe(CollectionCondition.sizeGreaterThan(0), Duration.ofSeconds(SIX_SEC.getValue()));
		Attach.attachAsText("Quantity of videos", String.valueOf(itemListElement.size()));
	}


	@Step
	public String getItemTitleFromResultListStep() {
		String itemTitleFromResult = itemListElement.first().find(By.id("video-title")).getText();
		Attach.attachAsText("Title of first video", itemTitleFromResult);

		return itemTitleFromResult;
	}

	@Step
	public void clickOnFirstItemResultStep() {
		itemListElement.first().shouldBe(enabled, Duration.ofSeconds(SIX_SEC.getValue())).click();
	}

	@Step
	public String getItemTitle() {
		String itemTitle = itemTitleElement.shouldBe(enabled, Duration.ofSeconds(EIGHT_SEC.getValue())).getOwnText();

		while (itemTitle.equals("")) {
			itemTitle = itemTitleElement.shouldBe(enabled, Duration.ofSeconds(EIGHT_SEC.getValue())).getOwnText();
		}
		Attach.attachAsText("Video's title", itemTitle);

		return itemTitle;
	}

	@Step
	public void checkVideoTitlesStep(String itemTitleFromResult, String itemTitle) {
		Assertions.assertThat(itemTitle)
				.as("Video titles not are the same")
				.isEqualTo(itemTitleFromResult);
	}
}
