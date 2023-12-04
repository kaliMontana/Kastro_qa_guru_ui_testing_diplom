package com.youtube.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.youtube.helpers.Attach;
import io.qameta.allure.Step;
import org.assertj.core.api.SoftAssertions;

import java.time.Duration;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.youtube.helpers.Waiting.EIGHT_SEC;
import static com.youtube.helpers.Waiting.SIX_SEC;

public class ShortVideosPage {
	private final ElementsCollection shortsItemListElement = $$("#shorts-inner-container ytd-reel-video-renderer h2 yt-formatted-string");
	private final ElementsCollection likeListElement = $$("ytd-toggle-button-renderer span");
	private final SelenideElement commentsElement = $("#comments-button a #text");
	private final SelenideElement shareElement = $("#share-button a #text");

	private static final String DISLIKE_RUS = "Не нравится";
	private static final String DISLIKE = "Dislike";
	private static final String SHARE_RUS = "Поделиться";
	private static final String SHARE = "Share";


	//region Steps
	@Step("Check the existence of short videos")
	public void checkExistenceShortVideosStep() {
		shortsItemListElement.shouldHave(CollectionCondition.sizeGreaterThan(0));

		Attach.attachAsText("Quantity of shorts videos", String.valueOf(shortsItemListElement.size()));
	}

	@Step("Check the existence of short video names")
	public void checkExistenceShortVideoTitlesStep() {
		SoftAssertions softAssertions = new SoftAssertions();

		for (SelenideElement selenideElement : shortsItemListElement) {
			softAssertions.assertThat(selenideElement.shouldBe(enabled, Duration.ofSeconds(SIX_SEC.getValue())).getText())
					.as("The video does not title")
					.isNotNull();

			Attach.attachAsText("Shorts videos titles", selenideElement.getText());
		}

		softAssertions.assertAll();
	}

	@Step("Check the existence of the like icon")
	public void checkLikeIconStep() {
		SoftAssertions softAssertions = new SoftAssertions();

		softAssertions.assertThat(likeListElement.shouldHave(CollectionCondition.sizeGreaterThan(0)).get(1).shouldBe(enabled, Duration.ofSeconds(EIGHT_SEC.getValue())).exists())
				.as("Icon \"Like\" not found")
				.isTrue();
		softAssertions.assertThat(likeListElement.shouldHave(CollectionCondition.sizeGreaterThan(0)).get(1).$("button").getAttribute("aria-label"))
				.as("Icon \"Like\" does not contain a text")
				.isNotNull();

		softAssertions.assertAll();
	}

	@Step("Check the existence of the dislike icon")
	public void checkDislikeIconStep() {
		SoftAssertions softAssertions = new SoftAssertions();

		softAssertions.assertThat(likeListElement.get(1).shouldBe(enabled, Duration.ofSeconds(EIGHT_SEC.getValue())).exists())
				.as("Icon \"dislike\" not found")
				.isTrue();
		softAssertions.assertThat(likeListElement.get(1).shouldBe(visible, Duration.ofSeconds(EIGHT_SEC.getValue())).$("a #text").getText())
				.as("Icon \"Like\" has grown text")
				.isEqualTo(getDislikeText());

		softAssertions.assertAll();
	}

	@Step("Check the existence of the comment icon")
	public void checkCommentsIconStep() {
		SoftAssertions softAssertions = new SoftAssertions();

		softAssertions.assertThat(commentsElement.shouldBe(enabled, Duration.ofSeconds(SIX_SEC.getValue())).exists())
				.as("Icon \"Comments\" not found")
				.isTrue();
		softAssertions.assertThat(commentsElement.getText())
				.as("Icon \"Comments\" does not contain a text")
				.isNotNull();

		softAssertions.assertAll();
	}

	@Step("Check the existence of the share icon")
	public void checkShareIconStep() {
		SoftAssertions softAssertions = new SoftAssertions();

		softAssertions.assertThat(shareElement.shouldBe(enabled, Duration.ofSeconds(SIX_SEC.getValue())).exists())
				.as("Icon \"Comments\" not found")
				.isTrue();
		softAssertions.assertThat(shareElement.getText())
				.as("Icon \"Share\" has grown text")
				.isEqualTo(getShareText());

		softAssertions.assertAll();
	}
	//endregion Steps

	private String getDislikeText() {
		String text = null;

		if (System.getProperty("Launcher").equals("Local")) {
			text = DISLIKE_RUS;
		} else if (System.getProperty("Launcher").equals("Remote")) {
			text = DISLIKE;
		}
		return text;
	}

	private String getShareText() {
		String text = null;

		if (System.getProperty("Launcher").equals("Local")) {
			text = SHARE_RUS;
		} else if (System.getProperty("Launcher").equals("Remote")) {
			text = SHARE;
		}
		return text;
	}
}
