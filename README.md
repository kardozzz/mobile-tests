# Проект по автоматизации тестирования мобильного приложения Wikipedia


## :pushpin: Содержание:

- [Используемый стек](#computer-используемый-стек)
- [Запуск автотестов](#arrow_forward-запуск-автотестов)
- [Сборка в Jenkins](#-сборка-в-jenkins)
- [Пример Allure-отчета](#-пример-allure-отчета)
- [Интеграция с Allure TestOps](#-интеграция-с-allure-testOps)
- [Уведомления в Telegram](#-уведомления-в-telegram)

## :computer: Используемый стек

<p align="center">
<a href="https://www.jetbrains.com/">
<img width="6%" title="IntelliJ IDEA" src="images/Idea.svg">
</a>
<a href="https://www.java.com/">
<img width="6%" title="Java" src="images/Java.svg">
</a>
<a href="https://docs.qameta.io/allure/">
<img width="6%" title="Allure Report" src="images/Allure.svg">
</a>
<a href="https://qameta.io/">
<img width="5%" title="Allure TestOps" src="images/Allure_TO.svg">
</a>
<a href="https://gradle.org/">
<img width="6%" title="Gradle" src="images/Gradle.svg">
</a>
<a href="https://junit.org/junit5/">
<img width="6%" title="JUnit5" src="images/Junit5.svg">
</a>

<a href="https://appium.io/">
<img src="images/Appium.svg" width="6%" title="Appium" alt="Appium"/>
</a> 
<a href="https://github.com/">
<img width="6%" title="GitHub" src="images/GitHub.svg">
</a>
<a href="https://www.jenkins.io/">
<img width="6%" title="Jenkins" src="images/Jenkins.svg">
</a>
<a href="https://web.telegram.org/">
<img width="6%" title="Telegram" src="images/Telegram.svg">
</a>
</p>

- Тесты в данном проекте написаны на языке Java с использованием фреймворка для автоматизации мобильных приложений [Appium](https://appium.io/)
- В качестве сборщика был использован [Gradle](https://gradle.org/)
- [JUnit5](https://junit.org/junit5/) задействован в качестве фреймворка модульного тестирования
- Для удаленного запуска реализована джоба в [jenkins](https://www.jenkins.io/) с формированием Allure-отчета и
  отправкой результатов в <code>Telegram</code> при помощи бота
- Осуществлена интеграция с [Allure TestOps](https://docs.qameta.io/allure/)

## :spiral_notepad: Список тестов

:white_check_mark: Тест начального экрана <br />
:white_check_mark: Тест на пропуск начального экрана <br />
:white_check_mark: Успешный поиск статей <br />
:white_check_mark: Не успешный поиск статей <br />



### Варианты запуска тестов

- ```emulator``` -Запуск тестов на эмуляторе.
- ```browserstack``` -Запуск тестов на browserstack.
> Для локального запуска через browserstack потребуется создать auth.properties в src/test/properties и указать name и key пользователя.

> Для локального запуска через emulator потребуется выполнить установку и [настройку](https://autotest.how/appium-setup-for-local-android-tutorial-md) эмулятора
### Запуск тестов из терминала

```
./gradlew clean mobile_tests -DdeviceHost=emulator
./gradlew clean mobile_tests -DdeviceHost=browserstack
```

При выполнении команды тесты запустятся локально.

## <img width="4%" style="vertical-align:middle" title="Jenkins" src="images/Jenkins.svg"> [Сборка в Jenkins](https://jenkins.autotests.cloud/job/diplom_mobile/)



<p align="center">
<img title="Jenkins Build" src="images/jenkins_build.png">
</p>

## <img width="4%" style="vertical-align:middle" title="Allure Report" src="images/Allure.svg"> [Пример Allure-отчета](https://jenkins.autotests.cloud/job/diplom_mobile/7/allure/)

#### Главная страница отчета Allure содержит следующие блоки:

- <code><strong>*ALLURE REPORT*</strong></code> - отображает дату и время теста, общее количество запущенных тестов, а
  также диаграмму с процентом и количеством успешных, упавших и сломавшихся в процессе выполнения тестов
- <code><strong>*TREND*</strong></code> - отображает тенденцию выполнения тестов для всех запусков
- <code><strong>*SUITES*</strong></code> - отображает распределение тестов по сьютам
- <code><strong>*CATEGORIES*</strong></code> - отображает распределение неудачных тестов по типам дефектов

<p align="center">
<img title="Allure Overview" src="images/allure_report.png">
</p>


## <img width="4%" style="vertical-align:middle" title="Allure TestOps" src="images/Allure_TO.svg"> [Интеграция с Allure TestOps](https://allure.autotests.cloud/project/4567/launches)

#### На вкладке Dashboards отображается:

- Количество тест-кейсов и их статус
- Соотношение ручных/автоматизированных тестов
- Результаты запусков/прохождения тестов в графике по датам

<p align="center">
<img title="Allure TestOps DashBoard" src="images/testOpsDashBord.png">
</p>

#### На вкладке Launches можно увидеть:

- Результаты запусков автоматизированных тестов
- Результаты запуска тестов из Allure TestOps

<p align="center">
<img title="Allure TestOps DashBoard" src="images/testOpsRun.png">
</p>
``

<p align="center">
<img title="Allure TestOps DashBoard" src="images/testOpsResultTests.png">
</p>


### <img width="4%" style="vertical-align:middle" title="Telegram" src="images/Telegram.svg"> Уведомления в Telegram

После завершения сборки, бот, созданный в <code>Telegram</code>, автоматически обрабатывает и отправляет сообщение с
результатом.
<p align="center">
<img title="Telegram" src="images/screens/tgBot.png">
</p>

<a id="video"></a>
## <a name="Видео прохождения тестов">**Видео прохождения тестов**</a>

<p align="center">
<img title="Selenoid Video" src="images/test_run.gif" width="550" height="360"  alt="video">   
</p>