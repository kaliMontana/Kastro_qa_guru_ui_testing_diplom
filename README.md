# Project to automate testing of the youtube.com site
Site for testing [youtube.com](https://www.youtube.com)
## Content
![This is an image]()
## Kastro_qa_guru_ui_testing_diplom
The same UI test plus notificacion to Telegram by Bot but without file allure-notifications-4.2.1.jar
Command to test start:
gradle clean test -DtestTag=Search
gradle clean test -DtestTag=Open
gradle clean test -DtestTag=ShortVideos
gradle clean test -DtestTag=HeaderTabs
gradle clean test -DtestTag=AllTests allureServe

https://jenkins.autotests.cloud/job/C12_Kastro_Vilson_qa_guru_ui_testing_with_notifications_diploma/
