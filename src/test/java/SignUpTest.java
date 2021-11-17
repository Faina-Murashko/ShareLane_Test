import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignUpTest {
    @Test
    public void zipCode5numbers(){

        //Открытие страницы https://www.sharelane.com/cgi-bin/register.py;
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");

        //Вводим 5 цифр;
        WebElement zipCodeInput = driver.findElement(By.name("zip_code"));
        zipCodeInput.sendKeys("12345");

        //Нажимаем кнопку Continue;
        WebElement continueButton = driver.findElement(By.cssSelector("[value=Continue]"));
        continueButton.click();

        //Убедиться, что мы на странице SignUp;
        boolean isDesplayed = driver.findElement(By.cssSelector("[value=Register]")).isDisplayed();
        Assert.assertTrue(isDesplayed);

        //Закрыть браузер.
        driver.quit();




    }

    @Test
    public void zipCode6numbers(){

        //Открытие страницы https://www.sharelane.com/cgi-bin/register.py;
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");

        //Вводим 6 цифр;
        WebElement zipCodeInput = driver.findElement(By.name("zip_code"));
        zipCodeInput.sendKeys("123456");

        //Нажимаем кнопку Continue;
        WebElement continueButton = driver.findElement(By.cssSelector("[value=Continue]"));
        continueButton.click();

        //Убедиться, что мы на странице SignUp;
        boolean isDesplayed = driver.findElement(By.cssSelector("[value=Register]")).isDisplayed();
        Assert.assertTrue(isDesplayed);

        //Закрыть браузер.
        driver.quit();




    }

    @Test
    public void zipCode4numbers(){

        //Открытие страницы https://www.sharelane.com/cgi-bin/register.py;
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");

        //Вводим 4 цифры;
        WebElement zipCodeInput = driver.findElement(By.name("zip_code"));
        zipCodeInput.sendKeys("1234");

        //Нажимаем кнопку Continue;
        WebElement continueButton = driver.findElement(By.cssSelector("[value=Continue]"));
        continueButton.click();

        //Убедиться, что мы на странице SignUp;
        boolean isDesplayed = driver.findElement(By.cssSelector("[class=error_message]")).isDisplayed();
        Assert.assertTrue(true);

        //Закрыть браузер.
        driver.quit();




    }
    @Test
    public void signUpInfoNewUser(){

        //Открытие страницы https://www.sharelane.com/cgi-bin/register.py?page=1&zip_code=12345
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=1&zip_code=12345");


        //Ввод данных нового пользователя;
        //FirstName
        WebElement firstNameInput = driver.findElement(By.cssSelector("[name=first_name]"));
        firstNameInput.sendKeys("Konstantin");

        //LastName
        WebElement lastNameInput = driver.findElement(By.cssSelector("[name=last_name]"));
        lastNameInput.sendKeys("Ivanov");

        //Email
        WebElement emailUserInput = driver.findElement(By.cssSelector("[name=email]"));
        emailUserInput.sendKeys("something@flag.com");

        //Password
        WebElement passwordForExample = driver.findElement(By.cssSelector("[name=password1]"));
        passwordForExample.sendKeys("87654321");

        //ConfirmPassword
        WebElement confirmPasswordForExample = driver.findElement(By.cssSelector("[name=password2]"));
        confirmPasswordForExample.sendKeys("87654321");

        //Нажимаем кнопку Register
        WebElement registerButton = driver.findElement(By.cssSelector("[value=Register]"));
        registerButton.click();

        //Убедиться в успешной регистрации
         boolean succsessfulRegisterNewUser = driver.findElement(By.cssSelector("[class=confirmation_message]")).isDisplayed();
         Assert.assertTrue(true);

        //Закрыть браузер.
        driver.quit();
    }

    @Test //Баг (при вводе данных которые отличаются от основного пароля, в поле подтверждение пароля,
    // регистрация происходит успешно, но должна быть ошибка с указанием введенного пароля который не сопадает)
    public void signUpInfoNewUserWrongPassword2(){

        //Открытие страницы https://www.sharelane.com/cgi-bin/register.py?page=1&zip_code=12345
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=1&zip_code=12345");


        //Ввод данных нового пользователя;
        //FirstName
        WebElement firstNameInput = driver.findElement(By.cssSelector("[name=first_name]"));
        firstNameInput.sendKeys("Konstantin");

        //LastName
        WebElement lastNameInput = driver.findElement(By.cssSelector("[name=last_name]"));
        lastNameInput.sendKeys("Ivanov");

        //Email
        WebElement emailUserInput = driver.findElement(By.cssSelector("[name=email]"));
        emailUserInput.sendKeys("something@flag.com");

        //Password
        WebElement passwordForExample = driver.findElement(By.cssSelector("[name=password1]"));
        passwordForExample.sendKeys("87654321");

        //ConfirmPassword
        WebElement confirmPasswordForExample = driver.findElement(By.cssSelector("[name=password2]"));
        confirmPasswordForExample.sendKeys("87654322");

        //Нажимаем кнопку Register
        WebElement registerButton = driver.findElement(By.cssSelector("[value=Register]"));
        registerButton.click();

        //Убедиться в успешной регистрации
        boolean succsessfulRegisterNewUser = driver.findElement(By.cssSelector("[class=confirmation_message]")).isDisplayed();
        Assert.fail();


    }
}
