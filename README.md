# API_Automation
This is a Restassured API automation project implemented with CUCUMBER framework. The framework consists of below components : 
1. Feature File, Step defintion file, Runner class as part of cucumber framework.
2. The step Definitions package has hooks as well which allow us to implement setup and teardown approach.
3. As part of Restassured, I have implemented Request and Response builder class which implements Request Specfications and Response Specifications.
4. Implemented Pojo classes for serialization and deserialization.
5. There is a log file as well which will store all the logs while running test classes.
6. A ENUM is also implemented for constant.
7. The test cases will run using maven commands :
   mvn verify -DXmlFile=testng.xml
9. Under resouces folder a config file and a CSV file are stored. I am using CSV file for storing test data.
10. I have used TESTNG as test framework.
11. A jenkinsfile is also implemented to set the jenkins file. After running tests on jenkins it will generate a cucumber report as well.
12. The POM.XML file has all the dependencies and plugins to run tests and generate cucumber report.
