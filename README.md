Frameworkium-BDD [![Build Status][status-svg]][status]
======================================================

This is a Cucumber implementation of [Frameworkium][frameworkium], it utilises all the features of 
[frameworkium-core][core] with an added BDD layer provided from the Cucumber-JVM framework to give you a BDD Automation solution.

## Getting Started

1. Clone this project `git clone https://github.com/Frameworkium/frameworkium-bdd.git`
2. Create your own package for your project under `src/test/java`
3. Add your package to a new `<package>` tag of the `<configuration>` section of the `cucumber-jvm-parallel-plugin` 
plugin in the `pom.xml`
```
 <configuration>
   <glue>
     <package>com.your.package</package>
   </glue>
```

5. Create a `glue` package within your project package where you will put all your step definition classes 
6. Create a `pages` package within your project package where you will put your page object classes
6. Create feature files in `src/test/resources/features`
7. Run tests using `mvn clean verify`

## Project Layout

Frameworkium-BDD uses conventional Cucumber-JVM layout as shown below. the main package and features package path is already configured within the pom.xml so that TestNG knows where all the necessary components are when tests are run.

The layout looks something like this

```
.
├── src/
|    ├── test/
|        ├── java/
|        |   └── com.your.package/
|        |       ├── glue/
|        |       |   └──AStepClass.java  
|        |       └── pages/
|        |           └──PageObjectClass.java
|        └── resources/
|            ├── features/
|            |	└── Feature_file.feature
└── pom.xml
```

An overview of some of the important packages 

| Package/file  | Description | 
| ------------- | ------------- | 
| glue  | Contain your 'step definition' classes (e.g AStepClass.java) which join together the page object layer with the feature file | 
| pages  | Contain page object classes  | 
| features  | Contain your 'feature files' which hold all your test scenario's  |

## Running Tests
### Command Line Options 
See the main Frameworkium *[docs](https://frameworkium.github.io/#_pages/Command-Line-Options.md)* for the full list of command line options. The only addition we have made is adding a `tags` parameter to select the cucumber tests you to run (this replaces the `tests` and `groups` TestNG parameters used in Frameworkium)

#### Examples
Run all tests with the @ui tag
```
mvn clean verify -Dtags=@ui
```

Run all test that DO NOT have the tag @wip
```
mvn clean verify -Dtags=~@wip
```

Run all test that have the tag @p1 OR @smoke
```
mvn clean verify -Dtags=@p1,@smoke
```
Comprehensive docs on cucumber tagging can be found on the official cucumber wiki [here](https://github.com/cucumber/cucumber/wiki/Tags)


If no tag property is set all tests will be executed

### API tests
Tag your API Sceanrios with the `@api` tag so the correct `BaseTest` is configured and a browser window isn't opened. This also means you could have UI and API scenario's in the same feature file if you wished

You can also use one tag at the feature level to create an API runner for all tests in the feature file

### Parallel Execution 
Parallel execution is available out the box in the same way as Frameworkium (*[docs](https://frameworkium.github.io/#_pages/Command-Line-Options.md)*), by parsing the `threads` parameter for the amount of browser instances to run in parallel. It can also can be configured to use Selenium Grid (*[docs](https://frameworkium.github.io/#_pages/Selenium-Grid.md)*)

We achieve parallel execution by running multiple 'Runner' classes in parallel with different runner classes
executing different tests. We utilise this by using a plugin (*[docs](https://github.com/temyers/cucumber-jvm-parallel-plugin)*) 
that autogenerates a runner class in the target directory at runtime for each scenario which will then in turn be run in 
parallel if you are using selenium grid. 


## Reporting
The Allure reporting used in frameworkium is also used with this framework generated by running ```mvn allure:report``` after the test run has completed


[status-svg]: https://travis-ci.org/Frameworkium/frameworkium-bdd.svg?branch=master
[status]: https://travis-ci.org/Frameworkium/frameworkium-bdd
[frameworkium]: https://github.com/Frameworkium/frameworkium
[core]: https://github.com/Frameworkium/frameworkium-core
