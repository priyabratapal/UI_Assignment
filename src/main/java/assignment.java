package main.java;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class assignment {
    WebDriver driver;
    @Test(priority = 1)
    public static void main(String[] args) throws InterruptedException {

        String mail = "username";
        String pass = "password";
        System.setProperty("WebDriver.chrome.driver","C:\\Users\\Admin\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.google.com");
        WebElement amazon = driver.findElement(By.xpath("//*[@name='q']"));
        amazon.sendKeys("amazon");
        amazon.sendKeys(Keys.ENTER);
        Thread.sleep(3000);

        List<WebElement> searchCount = driver.findElements(By.xpath("//h3[@class='LC20lb MBeuO DKV0Md']"));
        for(int i=0;i<searchCount.size();i++){
            String searchCnt = searchCount.get(i).getText();
            if(searchCnt != " "){
                System.out.println(searchCnt);
            }
            else {
                System.out.println("====================================");
            }
        }

        //  Click amazon link
        WebElement amazonLink = driver.findElement((By.xpath("//h3[text()='Amazon.in']")));
        amazonLink.click();
        Thread.sleep(6000);

        //Login to Amazon using credentials
        WebElement navLink = driver.findElement(By.id("nav-link-accountList"));
        navLink.click();
        WebElement user = driver.findElement(By.id("ap_email"));
        user.sendKeys(mail);
        WebElement continueBtn = driver.findElement(By.id("continue"));
        continueBtn.click();
        WebElement password = driver.findElement(By.id("ap_password"));
        password.sendKeys(pass);
        WebElement loginBtn = driver.findElement(By.id("signInSubmit"));
        loginBtn.click();
        Thread.sleep(6000);

        //Dashboard dropdown and search Electronics
        WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));
        dropdown.click();
        Select electronics = new Select(driver.findElement(By.id("searchDropdownBox")));
        electronics.selectByVisibleText("Electronics");
        Thread.sleep(4000);

        WebElement DellSearch = driver.findElement(By.id("twotabsearchtextbox"));
        DellSearch.sendKeys("dell computers");
        WebElement searchBtn = driver.findElement(By.id("nav-search-submit-button"));
        searchBtn.click();
        Thread.sleep(6000);

        // Set the Price Range
        WebElement minPrice = driver.findElement(By.id("low-price"));
        minPrice.sendKeys("30000");
        WebElement maxPrice = driver.findElement(By.id("high-price"));
        maxPrice.sendKeys("50000");
        maxPrice.sendKeys(Keys.ENTER);
        Thread.sleep(6000);

        // Checking the filtered prices are present in between the set price range
        List<WebElement> printValue = driver.findElements(By.xpath("//div[@class='s-result-item s-asin " +
                "sg-col-0-of-12 sg-col-16-of-20 sg-col s-widget-spacing-small sg-col-12-of-16']//span[@class='a-price-whole']"));
        int yesCount = 0;
        int noCount = 0;
        for(int i=0;i<printValue.size();i++){
            System.out.println(printValue.get(i).getText());
            String eachValue = printValue.get(i).getText();
            String eachValue1 = eachValue.replace(",","");
            int pri = Integer.parseInt(eachValue1);
            if(30000 < pri && pri < 50000){
                yesCount ++;
            }
            else {
                noCount ++;
            }
        }
        System.out.println(yesCount);
        System.out.println(noCount);

        WebElement pagination2 = driver.findElement(By.xpath("//span[@class='s-pagination-strip']//*[text()='2']"));
        pagination2.click();
        Thread.sleep(6000);

        // Checking the filtered prices are present in between the set price range
        List<WebElement> printValue99 = driver.findElements(By.xpath("//div[@class='s-result-item s-asin " +
                "sg-col-0-of-12 sg-col-16-of-20 sg-col s-widget-spacing-small sg-col-12-of-16']//span[@class='a-price-whole']"));
        int yesCountPage2 = 0;
        int noCountPage2 = 0;
        for(int i=0;i<printValue99.size();i++){
            System.out.println(printValue99.get(i).getText());
            String eachValue99 = printValue99.get(i).getText();
            String eachValue199 = eachValue99.replace(",","");
            int pri99 = Integer.parseInt(eachValue199);
            if(30000 < pri99 && pri99 < 50000){
                yesCountPage2++;
            }
            else{
                if( pri99 < 30000 && 50000 > pri99){
                    noCountPage2++;
                }
                noCountPage2++;
            }
        }
//        System.out.println(yesCountPage2);
//        System.out.println(noCountPage2);
        Thread.sleep(6000);


        WebElement pagination1 = driver.findElement(By.xpath("//span[@class='s-pagination-strip']//*[text()='1']"));
        pagination1.click();
        Thread.sleep(10000);

        // Checking products with rating 5 out of 5
        List<WebElement> rating5of5 = driver.findElements(By.xpath("//span[@class=\"a-size-base\" and text()=\"5.0\"]/preceding::span[3]"));
        for(int i=0;i<rating5of5.size();i++){
            System.out.println(rating5of5.size());
            String rating5Text = rating5of5.get(i).getText();
            System.out.println("Items whos rating is more than 5 Star:: "+rating5Text);

            }

        WebElement pagination2nd = driver.findElement(By.xpath("//span[@class='s-pagination-strip']//*[text()='2']"));
        pagination2nd.click();
        Thread.sleep(6000);
        // Checking products with rating 5 out of 5
        List<WebElement> rating5of5page2 = driver.findElements(By.xpath("(//span[text()='5.0 out of 5 stars']//ancestor::div[5])//ancestor::div[2]/div/h2"));
        for(int i=0;i<rating5of5page2.size();i++){
            System.out.println(rating5of5page2.size());
            String rating5Text = rating5of5page2.get(i).getText();
            if(rating5Text != ""){
                System.out.println(rating5Text);
            }
            else{
                break;
            }
        }

        WebElement pagination1st = driver.findElement(By.xpath("//span[@class='s-pagination-strip']//*[text()='1']"));
        pagination1st.click();
        Thread.sleep(6000);


        WebElement rating5 = driver.findElement(By.xpath("(//span[text()='5.0 out of 5 stars']/following::span[@class='a-price'])[1]"));
        rating5.click();
        Thread.sleep(6000);

        ArrayList<String> wid = new ArrayList<String>(driver.getWindowHandles());
        //switch to active tab
        driver.switchTo().window(wid.get(1));
        System.out.println("Page title of active tab: " + driver.getTitle());
        Thread.sleep(3000);

        WebElement productTitle = driver.findElement(By.id("productTitle"));
        var titleText = productTitle.getText();
        System.out.println(titleText);

        WebElement wishList = driver.findElement(By.id("add-to-wishlist-button-submit"));
        wishList.click();
        Thread.sleep(8000);

        WebElement addedItem = driver.findElement(By.id("huc-item-link"));
        var wishlistItem = addedItem.getText();
        System.out.println(wishlistItem);
        Assert.assertEquals(titleText, wishlistItem);
        driver.close();
    }
}
