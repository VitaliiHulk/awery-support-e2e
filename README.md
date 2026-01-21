\# Awery Support Form - E2E Tests



Automated end-to-end tests for the support request form on the Awery Support Page.



\## Tech Stack

* &nbsp;Java 17
* &nbsp;Maven
* &nbsp;Selenium WebDriver 4
* &nbsp;JUnit 5
* &nbsp;WebDriverManager



\## How to Run

1\. Requirements: JDK 17 and Google Chrome browser.

2\. Run via terminal:

   mvn clean test

3\. Alternatively, run SupportFormTest.java directly from the IDE.



\## Project Highlights

* Page Object Model (POM): Separation of test logic and UI elements for better maintainability.
* Smart Waits: Implementation of WebDriverWait to ensure test stability and prevent flakiness.
* Safe Upload: Conditional logic that checks for file existence before attempting an upload.
* Error Validation: Automated verification of the "SOMETHING WENT WRONG" message after form submission.



\## Project Structure

* &nbsp;src/test/java/pages: Page classes containing locators and methods.
* &nbsp;src/test/java/tests: Test cases and scenarios.
* &nbsp;src/test/java/utils: Configuration and WebDriver setup.
