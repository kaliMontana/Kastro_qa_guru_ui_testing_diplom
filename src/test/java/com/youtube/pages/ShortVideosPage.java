package com.youtube.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.youtube.helpers.Attach;
import io.qameta.allure.Step;
import org.assertj.core.api.SoftAssertions;

import java.time.Duration;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.youtube.helpers.Waiting.SIX_SEC;

public class ShortVideosPage {
	private final ElementsCollection shortsItemListElement = $$("#shorts-inner-container ytd-reel-video-renderer h2 yt-formatted-string");
	private final ElementsCollection likeListElement = $$("ytd-toggle-button-renderer");
	private final SelenideElement commentsElement = $("#comments-button a #text");
	private final SelenideElement shareElement = $("#share-button a #text");

	private static final String DISLIKE_RUS = "Не нравится";
	private static final String DISLIKE = "Dislike";
	private static final String SHARE = "Поделиться";


	@Step
	public void checkExistenceShortVideosStep() {
		shortsItemListElement.shouldHave(CollectionCondition.sizeGreaterThan(0));

		Attach.attachAsText("Quantity of shorts videos", String.valueOf(shortsItemListElement.size()));
	}

	@Step
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

	@Step
	public void checkLikeIconStep() {
		SoftAssertions softAssertions = new SoftAssertions();

		softAssertions.assertThat(likeListElement.get(0).shouldBe(enabled, Duration.ofSeconds(SIX_SEC.getValue())).exists())
				.as("Icon \"Like\" not found")
				.isTrue();
		softAssertions.assertThat(likeListElement.get(0).$("a #text").getText())
				.as("Icon \"Like\" does not contain a text")
				.isNotNull();

		softAssertions.assertAll();
	}

	@Step
	public void checkDislikeIconStep() {
		SoftAssertions softAssertions = new SoftAssertions();

		softAssertions.assertThat(likeListElement.get(1).shouldBe(enabled, Duration.ofSeconds(SIX_SEC.getValue())).exists())
				.as("Icon \"dislike\" not found")
				.isTrue();
		softAssertions.assertThat(likeListElement.get(1).$("a #text").getText())
				.as("Icon \"Like\" has grown text")
				.isEqualTo(getDislikeText());

		softAssertions.assertAll();
	}

	@Step
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

	@Step
	public void checkShareIconStep() {
		SoftAssertions softAssertions = new SoftAssertions();

		softAssertions.assertThat(shareElement.shouldBe(enabled, Duration.ofSeconds(SIX_SEC.getValue())).exists())
				.as("Icon \"Comments\" not found")
				.isTrue();
		softAssertions.assertThat(shareElement.getText())
				.as("Icon \"Share\" has grown text")
				.isEqualTo(SHARE);

		softAssertions.assertAll();
	}

	private String getDislikeText() {
		String text = null;

		if (System.getProperty("Launcher").equals("Local")) {
			text = DISLIKE_RUS;
		} else if (System.getProperty("Launcher").equals("Remote")) {
			text = DISLIKE;
		}
		return text;
	}
}
