# Insider WebSite Test Automation

Automation framework for testing [Insider](https://useinsider.com/) careers pages using **Java**, **Selenium**, and **TestNG**, following the **Page Object Model (POM)** pattern.

---

## Features

- POM-based page and test structure  
- Cross-browser support: Chrome & Firefox  
- Dynamic waits for elements, dropdowns, and hover actions  
- Scroll and hover utilities for QA and location selections  
- Multi-tab support for "View Role" links  

---

## Project Structure

src/
├─ main/java/pages/ # Page classes
├─ test/java/tests/ # Test classes
└─ main/java/utils/ # Utilities (DriverFactory, ConfigReader)


- **BasePage.java** – Common Selenium actions (click, type, scroll, hover, getText)  
- **DriverFactory.java** – Initializes WebDriver and manages browser lifecycle  
- **CareerPage.java** – Career & Open Positions page object  
- **NavBarPage.java** – Navigation bar object to access Career page  

---

## Setup

1. Clone repository:  
   ```bash
   git clone https://github.com/busrataltekin/https://github.com/busrataltekin/busra_taltekin_automation_task

2. Install dependencies:
mvn clean install

3. Running tests
mvn test 

