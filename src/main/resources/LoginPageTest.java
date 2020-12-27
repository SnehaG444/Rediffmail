import org.testng.Assert;

public class LoginPageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	
	public LoginPageTest() {
		super();
	
	@BeforeMethod
	public void setUp() {
		initializaton();
	loginpage = new LoginPage();	
		
		
	}
	
	@Test (Priority =1)
	public void LoginPageTitleTest() {
	String Title = 	loginpage.validateLoginPageTitle();
	Assert.assertEquals(Title, "Rediffmail");
	}
	
	@Test (Priority =2)
	public void loginTest() {
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
}
