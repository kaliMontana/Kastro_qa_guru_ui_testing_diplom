package com.youtube.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.youtube.dataProviders.TabHeadersData;
import com.youtube.helpers.Attach;
import io.qameta.allure.Step;
import org.assertj.core.api.SoftAssertions;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$$;
import static com.youtube.helpers.Waiting.SIX_SEC;

public class HeaderTabs {
	private final ElementsCollection tabsListTextElements = $$("#chips yt-chip-cloud-chip-renderer #text");
	private final ElementsCollection tabsListElements = $$("#chips yt-chip-cloud-chip-renderer");

	private static final String TRUE = "true";


	@Step
	public void checkHeaderTabsSteps() {
		SoftAssertions softAssertions = new SoftAssertions();

		softAssertions.assertThat(tabsListTextElements.shouldBe(CollectionCondition.sizeGreaterThan(0),
						Duration.ofSeconds(SIX_SEC.getValue())).size())
				.as("there are no elements in the Header Tabs")
				.isGreaterThan(0);
		softAssertions.assertThat(tabsListElements.first().getAttribute("aria-selected"))
				.as("THe first tab \"Все\" not is selected")
				.isEqualTo(TRUE);

		for (SelenideElement tabsListElem : tabsListTextElements) {
			softAssertions.assertThat(tabsListElem.getText())
					.as("Tab name no is in the list")
					.isIn(TabHeadersData.getTabsValuesList());

			Attach.attachAsText("Tab name", tabsListElem.getText());
		}

		softAssertions.assertAll();
	}
}
