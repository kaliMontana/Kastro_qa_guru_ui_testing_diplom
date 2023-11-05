package com.youtube.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;
import static com.youtube.helpers.Waiting.SIX_SEC;

public class BeforeYouContinuePage {
	//private final SelenideElement rejectAllElement = $x("//*[text()='Reject all']");
	private final SelenideElement rejectAllElement = $x("//button[contains(@aria-label, 'Reject the use of cookies')]");


	@Step("Click on the Reject element")
	public void clickOnRejectAllStep() {
		sleep(2000);

		if (rejectAllElement.exists()) {
			rejectAllElement.shouldBe(Condition.exist, Duration.ofSeconds(SIX_SEC.getValue()))
					.shouldHave(Condition.text("Reject all"), Duration.ofSeconds(5)).click();
		}
	}
}
