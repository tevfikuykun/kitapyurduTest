import com.opencsv.CSVReader;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileNotFoundException;
import java.io.FileReader;




public class Resources {
    protected WebDriver driver;

    protected String link = "https://www.kitapyurdu.com/";
    protected String Xpath="//input[@id='search-input']";
    protected String SearchData=readCsv();
    protected String SelectProduct="//a[@class='name']/div/p";
    protected String AddToCartId="button-cart";
    protected String MyCart="//*[@id='cart']";
    protected String GoToMyCart="//*[@id='js-cart']";
    protected String CartNumber="//*[@id='cart-items']";
    protected String NumberOfProduct="//select[@name='quantity']";
    protected String DeleteProduct="//*[@class='fa fa-times red-icon']";
    protected String RefreshButton="//*[@class='fa fa-refresh green-icon']";
    protected String Refreshing="//*[@class='swal2-title ky-swal-title-single']";
    protected String EmptyCart="//*[@id='cart-items-empty']";


    @Before
    public void setup(){        System.setProperty("webdriver.chrome.driver" , "C:\\Users\\Tevfik UYKUN\\KitapYurduTest\\target\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.kitapyurdu.com/");
        driver.navigate().to("https://www.kitapyurdu.com/");
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    public String readCsv(){
        try {
            CSVReader reader = new CSVReader(new FileReader("C:\\Users\\Tevfik UYKUN\\KitapYurduTest\\src\\test\\java\\Search.csv"));
        }
        catch (FileNotFoundException e){
            System.out.println("roman");
        }
        return "roman";
    }

}