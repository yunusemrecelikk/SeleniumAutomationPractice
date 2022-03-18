<div id="top"></div>

<br />
<div align="center">
  <h3 align="center">automationpractice.com Selenium Automation Practices</h3>

  <p align="center">
    Selenium Test Automation Practices
  </p>
</div>


## About The Project

This project using Java with Maven Selenium and Maven JUnit libraries.

There is positive and negative test cases.

# Positive Test Cases (src/test/java/com/automationpractice/tests/PositiveTests.java)

# 1. Automate User Registration process of e-commerce website.
* Open this url  http://automationpractice.com/index.php
* Click on sign in link.
* Enter your email address in 'Create and account' section.
* Click on Create an Account button.
* Enter your Personal Information, Address and Contact info.
* Click on Register button.
* Validate that user is created.

# Negative Test Cases (src/test/java/com/automationpractice/tests/NegativeTests.java)

# 1. Verify invalid email address error.
* Open this url  http://automationpractice.com/index.php
* Click on sign in link.
* Enter invalid email address in the email box and click enter.
* Validate that an error message is displaying saying "Invalid email address."

# 2. Verify error messages for mandatory fields.
* Open this url  http://automationpractice.com/index.php
* Click on sign in link.
* Enter email address and click Register button.
* Leave the mandatory fields (marked with *) blank and click Register button.
* Verify that error has been displayed for the mandatory fields.

## Credits

[Automate Amazon like E-Commerce Website with Selenium WebDriver](https://www.techlistic.com/2020/06/automate-ecommerce-website.html )

## License
Distributed under the GNU General Public License v3.0 License. See `LICENSE` for more information.


## Contact

Yunus Emre Çelik - [@bashengaistaken](https://twitter.com/bashengaistaken) - yunusemre.celik@testinium.com

Project Link: [https://github.com/yunusemrecelikk/SeleniumAutomationPractice](https://github.com/yunusemrecelikk/SeleniumAutomationPractice)
