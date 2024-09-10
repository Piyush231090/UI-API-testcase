## airalo_coding_exercise
# UI Automation Test 
 # Project Overview
This project automates UI testing for a web application using Selenium WebDriver with Java. It tests specific user interactions, validates the correctness of data displayed on the UI, and checks for functionality like selecting a country and validating pricing information.
 # Prerequisites
Before setting up the project, ensure that the following are installed on your machine:
1) Java Development Kit (JDK)
2) Apache Maven 
3) ChromeDriver 
4) IDE – You can use any Java IDE such as IntelliJ IDEA, Eclipse, or Visual Studio Code.
5) Git – To clone the repository (optional if not cloned).
# Running Tests in Java
Open your project in your preferred IDE (IntelliJ, Eclipse, etc.).
Navigate to the Main.java file in the UI folder.
Run the main method to execute the test.
The Main.java file contains the logic for interacting with the browser and running UI tests.
Driver.java sets up the WebDriver instance and manages browser sessions.
UIComponents.java holds the page object model (POM) for various UI elements using @FindBy annotations for element locators.
WebClient.java manages API interactions using the Rest-Assured framework.

# Overview of Approach
I identified key UI elements and actions that are critical to the workflow: handling pop-ups, country selection, and verifying text and price information.
The project follows the Page Object Model (POM) design pattern for maintaining separation of concerns between test logic and UI element locators.
Browser interactions and environment setup are abstracted using the Driver class, providing reusability across tests.
Test Execution:
Selenium WebDriver automates browser interactions (e.g., button clicks, text validation).
assert statements are used to validate if the actual UI data matches the expected results.
If any action fails (e.g., country selection or price validation), the test logs a failure and cleans up the browser session.
Error Handling:
Basic error handling is implemented using try-catch blocks to ensure that tests fail gracefully and log errors.

# API Test
# Project Overview
This project focuses on automating API testing for submitting and retrieving orders using OAuth authentication. The project leverages Rest-Assured for API testing and covers:
OAuth token generation for authentication.
Submitting orders to the backend.
Retrieving a list of orders with and without pagination.

# Prerequisites
Ensure the following are installed:
Java Development Kit (JDK) 
Apache Maven 
Git – To clone the repository (optional).
API endpoint credentials – You will need the Client ID and Client Secret to generate the OAuth token.

# Running API Tests
Step 1: Generate OAuth Token
Before making any API requests, you must generate an OAuth token. The token will be used for authenticating API requests.
Run the OAuthTest to generate the token. This token will be automatically stored and used for subsequent API calls.
Step 2: Submitting an Order
You can submit an order using the OrderImpl.java class. 
Step 3: Retrieving Orders List
You can retrieve the list of orders with or without pagination. 

# Test Case Overview
1. OAuth Token Generation:
This test generates an OAuth token using client credentials.
The token is stored for future API requests to authenticate the client.
2. Submit an Order:
Submits an order using package details such as quantity, package ID, and description.
The response from the server will confirm the order's success or failure.
3. Retrieve Order List:
Retrieves a list of orders.
Optionally supports pagination to fetch orders in pages.
