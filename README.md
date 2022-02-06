# MusalaSofy

Programming Language: JAVA

Worked with: Selenium WebDriver, TestNG, Maven

Tests are implemented to run in parallel which can be configet via testng.xml file and for Test Case 1(via DataProvider also)

How to execut the tests ?
1. Via testng file 
  -Set browser name in config.properties file and run testng.xml 
2. Maven command: mvn clean test -Dbrowser={browserName}

Report
After test execution a report is being generated in Reports folder.
Oen file in browser to see the details of the test output.

Data

There are being used different ways to handle the data that are being used.
  1. DataProvider
  2. JSON

Note: Java and Maven should be in your system env path.

Thanks!!
