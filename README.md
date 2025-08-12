<h1> Wikipedia Mobile App Automation</h1>

<h2>## 📌 Project Overview</h2>
This project automates an **End-to-End** testing flow for the **Wikipedia mobile application** using **Appium** with **Java**, **Maven**, **TestNG**, **Allure Reports**, and **Log4j2** for logging.  
The framework is built using **Page Object Model (POM)** combined with the **Fluent Pattern** for better readability and maintainability.</br>

---

<h2>## 🛠 Tech Stack.</h2></br>
- **Java** – Programming language.</br>
- **Appium** – Mobile automation framework.</br>
- **Maven** – Build automation and dependency management.</br>
- **TestNG** – Test execution and reporting.</br>
- **Log4j2** – Logging.</br>
- **Allure TestNG** – Advanced reporting.</br>
- **Page Object Model (POM)** – Structured test design.</br>
- **Fluent Pattern** – Readable method chaining
.</br>
---

<h2>4️⃣ Configure the Project</h2>h2></br>
Update config.properties with:</br>

platformName=Android</br>

deviceName=emulator-5554</br>

appPackage=org.wikipedia</br>

appActivity=org.wikipedia.main.MainActivity</br>

automationName=UiAutomator2</br>

<h2>🧩 Design Patterns Used</h2>
POM (Page Object Model): Separates page elements & actions from test scripts.

Fluent Pattern: Allows method chaining for readable test flows.

<h2> Run Tests</h2>h2></br>
mvn clean test -DsuiteXmlFile=testng.xml</br>
mvn clean test
</br>

<h2>ogs & Reports</h2>
Logs: Generated automatically in /logs folder.

Reports: Allure reports are stored in /allure-results and can be served via allure serve.
