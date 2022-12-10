# Project to automate testing of the youtube.com site

Site for testing [youtube.com](https://www.youtube.com)

## Content

* <a href="#link-technologies-and-tools">Technologies and tools</a>
* <a href="#link-implemented-tests">Implemented tests</a>
* <a href="#link-starting-test">Starting test </a>

## Technologies and tools

<p align="center">
<img width="6%" src="images/logo/Java.svg">
<img width="6%" src="images/logo/Intelij_IDEA.svg">
<img width="6%" src="images/logo/Gradle.svg">
<img width="6%" src="images/logo/JUnit5.svg">
<img width="6%" src="images/logo/Jenkins.svg">
<img width="6%" src="images/logo/Selenide.svg">
<img width="6%" src="images/logo/Selenoid.svg">
<img width="6%" src="images/logo/GitHub.svg">
<img width="6%" src="images/logo/Allure_Report.svg">
<img width="6%" src="images/logo/Telegram.svg">
</p>

In this project, autotests are written in Java using Selenide for UI tests.

JUnit 5 is used as a unit testing library.

Gradle is used to build the project automatically.

Selenoid launches browsers in Docker containers.

Allure Report generates a test run report.

Jenkins is running tests.

After the run is completed, notifications are sent using the bot in Telegram.

## Implemented tests
- [x] Testing the Search functionality and checking for existence of results
- [x] Testing the functionality of opening a video and checking the existence of its properties such as the title and others
- [x] Testing that the Short Videos icon forwards to the correct page and yours existences
- [x] Checking for the existence of tags in the Header tabs

## Starting test 
<details>
<summary>Details ...</summary>

### Starting tests Locally

* ```gradle clean test -DtestTag=${TAGTEST} -DLauncher=Local allureServe```
* ```gradle clean test -DtestTag=AllTest -DLauncher=Local allureServe```

### Starting tests remotely in Selenoid
* ```gradle clean test -DtestTag=${TAGTEST} -DLauncher=Remote allureServe```
</details>

### Starting tests from Jenkins
......>>>


## Kastro_qa_guru_ui_testing_diplom

The same UI test plus notificacion to Telegram by Bot but without file allure-notifications-4.2.1.jar Command to test
start:
gradle clean test -DtestTag=Search 
gradle clean test -DtestTag=Open 
gradle clean test -DtestTag=ShortVideos 
gradle clean test -DtestTag=HeaderTabs 
gradle clean test -DtestTag=AllTests allureServe

https://jenkins.autotests.cloud/job/C12_Kastro_Vilson_qa_guru_ui_testing_with_notifications_diploma/
