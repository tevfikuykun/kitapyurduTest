import com.opencsv.CSVReader;
import org.junit.Test;
import java.io.FileReader;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import static org.junit.Assert.assertEquals;
import org.openqa.selenium.Keys;


public class kitapyurdu_Test extends Resources {

    @Test
    public void openlink() {
        // https://www.kitapyurdu.com/ sitesi açılır.
        driver.get(link);
    }
    @Test
    public void controllink() {
        //Ana sayfanın açıldığı kontrol edilir.
        assertEquals(link, "https://www.kitapyurdu.com/");
    }


    @Test
    public void searchroman() {
        //Arama kutucuguna roman kelimesi girilir.
        //Klavyeden “enter” tuşuna basılır.
        driver.findElement(By.xpath(Xpath)).click();
        driver.findElement(By.xpath(Xpath)).sendKeys(SearchData);
        driver.findElement(By.xpath(Xpath)).sendKeys(Keys.ENTER);
    }

    @Test
    public void choose() {
        //Listelenen kitapların arasından rastgele bir kitap seçilir.
        driver.findElement(By.xpath(SelectProduct)).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void addtoCart() {
        //Sepete ekle butonuna basılır.
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scroll(0,550)");
        driver.findElement(By.id(AddToCartId)).click();
    }

    private int getCartCount(){
        String cartnum= driver.findElement(By.xpath(CartNumber)).getText();
        return Integer.parseInt(cartnum);
    }


    public boolean  isProductCountUp(){
        //Sayfanın sağ üst kısmında bulunan sepet ikonundaki değer kontrol edilir.
        return getCartCount()>0;
    }


    @Test
    public void gotoCart() {
        //Sepetim butonuna tıklanır
        //Sepete git butonuna tıklanır.
        driver.findElement(By.xpath(MyCart)).click();
        driver.findElement(By.xpath(GoToMyCart)).click();
    }
    //Sepetteki ürün miktarı bulunur.
    private int findProductCount(){
        String prod_quan= driver.findElement(By.xpath(NumberOfProduct)).getText();
        return Integer.parseInt(prod_quan);
    }
    //Sepetteki ürün miktarının 1 fazlası bulunur.
    private int increaseProductCount(){
        return findProductCount()+1;
    }

    @Test
    public void increaseProduct() {
        //Ürün miktarı “1” adet arttırılır.
        String newPrdCount=driver.findElement(By.xpath(NumberOfProduct+1)).getText();
        driver.findElement(By.xpath(NumberOfProduct)).click();
        driver.findElement(By.xpath(NumberOfProduct)).sendKeys(newPrdCount);


    }

    @Test
    public void refreshButton() {
        //Yenile butonuna basılır.
        driver.findElement(By.xpath(RefreshButton)).click();
    }

   public void RefreshingText(){
       //Sepetiniz güncelleniyor yazısının geldiği kontrol edilir.
       driver.findElement(By.xpath(Refreshing));
   }


    @Test
    public void xbutton() {
        //Çarpı butonuna basılır.
        WebElement deleteButton = driver.findElement(By.cssSelector(DeleteProduct));
        deleteButton.click();
    }

    @Test
    public void isCartEmpty(){
        //Sepetin boş olduğu kontrol edilir
        assertEquals(EmptyCart,"Sepetiniz boş");
    }


}
