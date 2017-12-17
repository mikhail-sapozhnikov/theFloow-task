# README for the FlowDrive test automation task


### Steps to run tests:

1) Install and configure Java, Android, Maven, Appium and Android emulator (Genymotion) on your machine
2) Clone project files to any folder
3) Launch Appium server using default port (4723)
4) Launch Android emulator (Open GApps should be installed in order to launch the app)
5) Run tests

### Ways to run tests:
- From IDE
- From command line:
```bash
mvn clean test
```

[BaseSetup](https://github.com/mikhail-sapozhnikov/theFloow-task/blob/master/src/main/java/com/thefloow/base/BaseSetup.java) - Android driver configuration  
[Pages](https://github.com/mikhail-sapozhnikov/theFloow-task/tree/master/src/main/java/com/thefloow/pages) - classes with page objects  
[Tests](https://github.com/mikhail-sapozhnikov/theFloow-task/tree/master/src/test/java/com/thefloow/flowdrivetest) - some examples of tests to show my approach  
[testng.xml](https://github.com/mikhail-sapozhnikov/theFloow-task/blob/master/src/test/resources/testng.xml) - here we can include or exclude tests from the run
