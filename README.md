# DATA AND KEYWORD DRIVEN AUTOMATION FRAMEWORK WITH JENKINS

# 📌 Overview

This project is a Data-Driven and Keyword-Driven Automation Framework built with:
##### ✔ Selenium WebDriver (for browser automation)
##### ✔ TestNG (for test execution and reporting)
##### ✔ Maven (for dependency management)
##### ✔ Jenkins (for CI/CD pipeline integration)
##### ✔ Allure Reports (for detailed test reporting)

It supports data-driven testing (Excel-based test data) and keyword-driven testing (modular actions defined in properties files).

# 📂 Project Structure

##### DATA_AND_KEYWORD_DRIVEN_AUTOMATION_FRAMEWORK_with_JENKINS  
##### │  
##### ├── **src/main/java**  
##### │   ├── **Base**  
##### │   │   └── TestBase.java          # Base test setup (WebDriver, configurations)  
##### │   ├── **Listeners**              # TestNG listeners for logging/extent reports  
##### │   ├── **Utilities**              # Helper classes (Excel reader, config loader)  
##### │  
##### ├── **src/test/java**  
##### │   ├── **TestCases**  
##### │   │   └── LoginTest.java         # Example test case  
##### │   ├── **Runner**  
##### │   │   └── TestNG.xml             # TestNG suite configuration  
##### │  
##### ├── **src/test/resources**  
##### │   ├── **Excel**                  # Test data files (.xlsx)  
##### │   ├── **Properties**  
##### │   │   ├── Config.properties      # Environment config (URLs, credentials)  
##### │   │   └── OR.properties          # Locators (Page Object Model alternative)  
##### │   ├── **Logs**                   # Log files (if logging is enabled)  
##### │  
##### ├── **target**                     # Compiled classes & test reports  
##### ├── **allure-results**             # Allure report data (generated after test runs)  
##### ├── **pom.xml**                    # Maven dependencies & plugins  
##### └── **README.md**                  # This file


# ⚙️ Setup & Execution

### Prerequisites

✅ Java 11+ (or Java 21, as configured in pom.xml)

✅ Maven 3.8+

✅ Chrome/Firefox (for Selenium WebDriver)

✅ Jenkins (for CI/CD)

## 1️⃣ Running Locally
### Install dependencies
`mvn clean install`
### Run tests (with TestNG)
`mvn test`
### Generate Allure report
`allure serve allure-results`

## 2️⃣ Running in Jenkins
Create a new Jenkins job (Freestyle or Pipeline).

## Set up Git repo:
**Repository URL:** https://github.com/fahim150283/AutomationWithJenkins.git

**Branch:** master
## Add build step:
`mvn clean test`

## Add Post-build Action: 
Publish Allure Report (allure-results)

# 🔧 Key Features
#### ✔ Data-Driven Testing – Test data stored in Excel sheets.
#### ✔ Keyword-Driven Testing – Actions defined in OR.properties.
#### ✔ Configurable – Environment settings in Config.properties.
#### ✔ CI/CD Ready – Works with Jenkins for automated runs.
#### ✔ Detailed Reporting – Allure reports for test analytics

# 📊 Reports
#### 🔹 Allure Report (after test execution):
#### 🔹TestNG Report (in target/surefire-reports/).

# 📌 Notes
Update Config.properties with your environment details.

For Jenkins, ensure Java & Maven paths are configured.

If Lombok errors occur, check pom.xml for Java module fixes.

# 📜 License
MIT License – Free to use and modify.

# Happy Testing! 🚀