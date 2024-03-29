package com.youtube.tests;

import com.youtube.pages.BeforeYouContinuePage;
import com.youtube.pages.MainPage;
import com.youtube.pages.ResultsPage;
import com.youtube.pages.ShortVideosPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Owner("Castro W.")
@Story("Youtube features")
@Link("https://www.youtube.com")
public class FeatureTests extends TestSetup {
	MainPage mainPage = new MainPage();
	ResultsPage resultsPage = new ResultsPage();
	ShortVideosPage shortVideosPage = new ShortVideosPage();
	BeforeYouContinuePage beforeYouContinuePage = new BeforeYouContinuePage();


	@Test
	@Tag("Search")
	@Feature("Search")
	@DisplayName("Check search a video")
	public void searchFeatureTest() {
		mainPage.openMainPageStep();

		beforeYouContinuePage.clickOnRejectAllStep();

		mainPage.searchStep();
		mainPage.checkQuantityResultStep();
		mainPage.checkExistenceWordInResultStep();
	}

	@Test
	@Tag("Open")
	@Feature("Open video")
	@DisplayName("Check open video")
	public void openVideoFeatureTest() {
		resultsPage.openResultPageStep();

		beforeYouContinuePage.clickOnRejectAllStep();

		resultsPage.checkExistenceItemsInResultStep();

		String itemTitleFromResult = resultsPage.getItemTitleFromResultListStep();

		resultsPage.clickOnFirstItemResultStep();

		String itemTitle = resultsPage.getItemTitle();
		resultsPage.checkVideoTitlesStep(itemTitleFromResult, itemTitle);
	}

	@Test
	@Tag("ShortVideos")
	@Feature("Short Videos")
	@DisplayName("Check short videos")
	public void checkShortVideosFeatureTest() {
		mainPage.openMainPageStep();

		beforeYouContinuePage.clickOnRejectAllStep();

		mainPage.clickOnPanoramicVideosStep();

		shortVideosPage.checkExistenceShortVideosStep();
		shortVideosPage.checkExistenceShortVideoTitlesStep();
		shortVideosPage.checkLikeIconStep();
		shortVideosPage.checkDislikeIconStep();
		shortVideosPage.checkCommentsIconStep();
		shortVideosPage.checkShareIconStep();
	}

	@Test
	@Tag("HeaderTabs")
	@Feature("Header tabs")
	@DisplayName("Check Header tabs")
	public void checkHeaderTabsTest() {
		mainPage.openMainPageStep();

		beforeYouContinuePage.clickOnRejectAllStep();

		mainPage.checkHeaderTabsSteps();
	}
}
