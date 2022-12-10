package com.youtube.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.youtube.helpers.Attach;
import io.qameta.allure.Step;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.*;
import static com.youtube.helpers.Waiting.SIX_SEC;

public class MainPage {
	private final SelenideElement searchElement = $("#search-input");
	private final ElementsCollection itemListElement = $$(".sbse");

	private final SelenideElement shortsElement = $(".style-scope ytd-guide-section-renderer");

	private static final String SEARCHED_WORD = "Appium";


	@Step("Open the main page")
	public void openMainPageStep() {
		open("");
	}

	@Step("Put the searched word in the search element")
	public void searchStep() {
		searchElement.shouldBe(enabled, Duration.ofSeconds(SIX_SEC.getValue())).click();
		searchElement.find(By.id("search")).setValue(SEARCHED_WORD);
	}

	@Step("Check the amount of results in the pop-up list")
	public void checkQuantityResultStep() {
		itemListElement.shouldHave(CollectionCondition.sizeGreaterThan(0));
		Attach.attachAsText("Quantity od result", String.valueOf(itemListElement.size()));
	}

	@Step("Check if exits the searched word in the pop-up list")
	public void checkExistenceWordInResultStep() {
		SoftAssertions softAssertions = new SoftAssertions();

		itemListElement.forEach(x -> softAssertions.assertThat(x.getText())
				.as("Result element does not contains searched word")
				.containsIgnoringCase(SEARCHED_WORD));

		softAssertions.assertAll();
	}

	@Step("Click on Panoramic element")
	public void clickOnPanoramicVideosStep() {
		shortsElement.shouldBe(enabled, Duration.ofSeconds(SIX_SEC.getValue())).click();
	}
}
