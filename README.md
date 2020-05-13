1. Verify user can login with valid data.
2. Verify user can add item to the cart
3. Verify user can add multiply items in the cart
4. Verify Correct list of items has been loaded
5. Verify item details are correct (name, descrp, price)
6. Verify user can delete item from the cart
7. Verify user can continue shopping from cart
8. Verify user can proceed to checkout from cart
9. Verify user can enter valid checkout data and continue
10. Verify user can cancel checkout
11. Verify that checkout data is correct (total price / items names / qty)
12. Verify checkout tax is 8%
13. Verify user can finish checkout
14. Verify user can cancel checkout 
______________________________________________________________________________________

1. Обновить версии всех библиотек в проекте и ее вывод:
mvn versions:display-dependency-updates 
[INFO] The following dependencies in Dependencies have newer versions:
[INFO]   org.seleniumhq.selenium:selenium-java ...... 3.141.59 -> 4.0.0-alpha-5
2. Запустить тесты используя mvn clean test команду и ее вывод, например
mvn clean test
[ERROR] Tests run: 9, Failures: 3, Errors: 0, Skipped: 0, Time elapsed: 50.77 s <<< FAILURE! - in TestSuite
3. Использовать параметры для запуска конкретных тестов и методов 
mvn clean test -Dtest=SauceDemoTests#demoTestsFromLecture+loginWithPageFactoryPattern
[INFO] Results:
[INFO]
[ERROR] Failures: 
[ERROR]   SauceDemoTests.loginWithPageFactoryPattern:23 ? ClassCast class com.sun.proxy....
[INFO]
[ERROR] Tests run: 2, Failures: 1, Errors: 0, Skipped: 0
4. Создать альтернативный pom.xml и запустить из него mvn билд
mvn clean test -f pom_alter.xml
5. Пробросить параметр из mvn command line внутрь теста 
mvn clean test -Dtest=SauseDemo#loginWithRegularUser -Duser=standard_user -Dpassword=secret_sauce


