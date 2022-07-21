package com.youtube.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.youtube.dataProviders.TabHeadersEngData;
import com.youtube.dataProviders.TabHeadersRusData;
import com.youtube.helpers.Attach;
import io.qameta.allure.Step;
import org.assertj.core.api.SoftAssertions;

import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.Selenide.$$;
import static com.youtube.helpers.Waiting.EIGHT_SEC;
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

		for (SelenideElement tabsListElem : tabsListTextElements.shouldHave(CollectionCondition.sizeGreaterThan(0),
				Duration.ofSeconds(EIGHT_SEC.getValue()))) {
			softAssertions.assertThat(tabsListElem.getText())
					.as("Tab name no is in the list")
					.isIn(getTabHeadersDataProvider());

			Attach.attachAsText("Tab name", tabsListElem.getText());
		}

		softAssertions.assertAll();
	}

	private List<String> getTabHeadersDataProvider() {
		List<String> tabHeaderList = null;

		if (System.getProperty("Lancher").equals("Local")) {
			tabHeaderList = TabHeadersRusData.getTabsValuesList();
		} else if (System.getProperty("Lancher").equals("Remote")) {
			tabHeaderList = TabHeadersEngData.getTabsValuesList();
		}
		return tabHeaderList;
	}
}
