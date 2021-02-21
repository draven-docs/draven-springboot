package noxus.draven.selenium3;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * 〈功能概述〉<br>
 *
 * @className: SelenimuApplication
 * @package: noxus.draven.selenium3
 * @author: draven
 * @date: 2021/2/21 00:07
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SelenimuApplicationTest {

    private WebDriver driver;
    private String baseUrl = "https://www.baidu.com/";
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        //设置firefox.exe 路径
        //System.setProperty("webdriver.firefox.bin", "E:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
        //设置firefox驱动路经  selenium3.0之后需设置 firefox版本要求大于48
        //System.setProperty("webdriver.gecko.driver", "E:\\java\\javaTool\\driver\\geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "/Users/draven/Documents/documents/python/software/selenium/driver/cdriver/chromedriver");
        //driver = new FirefoxDriver();
        driver = new ChromeDriver();
        // baseUrl = "";
        // 隐式等待
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testUntitledTestCase() throws Exception {
        driver.get("https://www.baidu.com/");
        driver.findElement(By.id("kw")).clear();
        driver.findElement(By.id("kw")).sendKeys("test");
        driver.findElement(By.id("form")).submit();
        System.out.println("----over---");
    }

    @Test
    public void testLogin() throws Exception {
        String LoginString = "登录";
        String RegisterString = "立即注册";
        String LoginUserNameString = "用户名登录";
        driver.get("https://www.baidu.com/");
        driver.findElement(By.linkText(LoginString)).click();
        driver.findElement(By.linkText(RegisterString)).click();
        String windowHandle = driver.getWindowHandle();
        log.info("{}", windowHandle);
        Set<String> windowHandles = driver.getWindowHandles();
        log.info("切换前的窗口： {}", windowHandles);

        Object[] objects = windowHandles.toArray();
        driver.switchTo().window(objects[1].toString());
        log.info("{}", driver.getWindowHandle());

        log.info("切换后的窗口： {}", driver.getWindowHandle());
        driver.findElement(By.id("TANGRAM__PSP_4__userName")).sendKeys("1213");

        driver.switchTo().window(objects[0].toString());
        log.info("切换回登录窗口： {}", driver.getWindowHandle());
        driver.findElement(By.id("TANGRAM__PSP_11__footerULoginBtn")).click();


        System.out.println("----over---");

        Thread.sleep(3000);
        driver.close();
    }

    private void setValue(WebDriver driver, String xps, String values) {
        driver.findElement(By.xpath(xps)).click();
        driver.findElement(By.xpath(xps)).clear();
        driver.findElement(By.xpath(xps)).sendKeys(values);

    }

    //
    @Test
    public void testInfodisc() throws Exception {
        String infodiscUrl = "http://ip/infodisc";

        driver.get(infodiscUrl);
        driver.findElement(By.id("ucMemCode")).clear();
        driver.findElement(By.id("ucMemCode")).sendKeys("ucMemCode");

        driver.findElement(By.id("ucOperCode")).clear();
        driver.findElement(By.id("ucOperCode")).sendKeys("ucOperCode");
        //driver.findElement(By.id("form")).submit();
        driver.findElement(By.id("passwordShow")).clear();
        driver.findElement(By.id("passwordShow")).sendKeys("passwordShow");

        Thread.sleep(3000);

        WebElement element = driver.findElement(By.xpath("//*[@id='loginForm']/button"));
        element.click();

        driver.findElement(By.xpath("//*[@id=\"collapse-DISCZXD11\"]/div/ul/li[4]/a")).click();
        // iframe问题
        // WebDriver mainFrame = driver.switchTo().frame("mainFrame");
        WebElement iframe = driver.findElement(By.id("jerichotabiframe_0"));
        driver.switchTo().frame(iframe);

        //WebDriver jerichotabiframe_0 = driver.switchTo().frame("jerichotabiframe_0");
        driver.findElement(By.linkText("查询")).click();

        driver.findElement(By.linkText("新增")).click();


        //driver.findElement(By.id("bondCLNType")).sendKeys("501");

        // Select level = new Select(driver.findElement(By.id("bondCLNType")));

        //  展开选项
        driver.findElement(By.xpath("//*[@id='clnAddForm']/table/tbody/tr[1]/td[1]/span[1]/span/a[2]")).click();
        driver.findElement(By.xpath("//*[@id='_easyui_combobox_i5_1']")).click();


        //List<WebElement> webElements = level.getOptions();
        setValue(driver,"//*[@id='clnAddForm']/table/tbody/tr[1]/td[2]/span[1]/input[1]","测试股说一句");
        //driver.findElement(By.xpath("//*[@id='clnAddForm']/table/tbody/tr[1]/td[2]/span[1]/input[1]")).click();
        //driver.findElement(By.xpath("//*[@id='clnAddForm']/table/tbody/tr[1]/td[2]/span[1]/input[1]")).clear();

        //driver.findElement(By.xpath("//*[@id='clnAddForm']/table/tbody/tr[1]/td[2]/span[1]/input[1]")).sendKeys("测试股说一句");

        //driver.findElement(By.xpath("//*[@id='clnAddForm']/table/tbody/tr[2]/td[1]/span/input[1]")).sendKeys("10086");
        setValue(driver,"//*[@id='clnAddForm']/table/tbody/tr[2]/td[1]/span/input[1]","10086");


        setValue(driver,"//*[@id='clnAddForm']/table/tbody/tr[2]/td[2]/span/input[1]","我是简单的");

       /* driver.findElement(By.xpath("//*[@id='clnAddForm']/table/tbody/tr[4]/td[1]/span[1]/span/a[2]")).click();
        driver.findElement(By.xpath("//*[@id='clnAddForm']/table/tbody/tr[4]/td[1]/span[1]/input[1]")).sendKeys("北京");


        driver.findElement(By.xpath("//*[@id='clnAddForm']/table/tbody/tr[4]/td[1]/span[1]/input[1]")).clear();

        driver.findElement(By.xpath("//*[@id='clnAddForm']/table/tbody/tr[4]/td[1]/span[1]/input[1]")).sendKeys("测");
*/

        //新建一个List，用来存储每个选项的文本值
        //List<String> downs = new ArrayList<String>();

        //for (WebElement webElement : webElements) {
        //  System.out.println("下拉框选项的值：" + webElement.getText());
        //  downs.add(webElement.getText());
        // }

        //*[@id="clnAddForm"]/table/tbody/tr[1]/td[1]/span[1]/input[1]


//*[@id="bondCLNListForm"]/table/tbody/tr[5]/td/a[1]/span/span[1]
        // #bondCLNListForm > table > tbody > tr:nth-child(5) > td > a:nth-child(1)
        // #bondCLNListForm > table > tbody > tr:nth-child(5) > td > a:nth-child(1) > span > span.l-btn-text
        //*[@id="bondCLNListForm"]/table/tbody/tr[5]/td/a[1]/span/span[1]
        //*[@id="bondCLNListForm"]/table/tbody/tr[5]/td/a[1]/span/span[1]

        //http://106.39.35.74/infodisc/bondinfo/CLN/getCLNBondInfo
        //element.submit();
        //


        //driver.close();
        //
        System.out.println("----over---");
    }

    @Test
    public void test163() throws Exception {
        String infodiscUrl = "https://mail.163.com/";
        //String infodiscUrl = "https://www.baidu.com/";
        driver.get(infodiscUrl);
        //WebElement element = driver.findElement(By.xpath("//*[@name='email']"));
        String title = driver.getTitle();

        //WebDriver frame = driver.switchTo().frame("");
        WebDriver webDriver = driver.switchTo().defaultContent();
        WebDriver webDriver1 = driver.switchTo().parentFrame();
        //*[@id="auto-id-1613839330986"]

        /*driver.findElement(By.id("ucMemCode")).clear();
        driver.findElement(By.id("ucMemCode")).sendKeys("0000000");
        //*[@id="auto-id-1613838979758"]


        driver.findElement(By.id("ucOperCode")).clear();
        driver.findElement(By.id("ucOperCode")).sendKeys("shenhe2xp");
        //driver.findElement(By.id("form")).submit();
        driver.findElement(By.id("passwordShow")).clear();
        driver.findElement(By.id("passwordShow")).sendKeys("123456");

        Thread.sleep(3000);

        WebElement element = driver.findElement(By.xpath("//*[@id='loginForm']/button"));
        element.click();*/
        //element.submit();
        //


        //driver.close();
        //

        Thread.sleep(1000);
        driver.close();
        System.out.println("----over---");
    }
}
