package testNG;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class pruebaTestNG {


	public class DemoPrecedencia {

		@Test(dataProvider = "Generador")
	  public void TestGenerado(Integer n, String s) {
		  System.out.println("El generador provee: "+s+" -"+" - "+n);
	  }
	  @BeforeMethod
	  public void beforeMethod() {
		  System.out.println("beforeMethod()");
	  }

	  @AfterMethod
	  public void afterMethod() {
		  System.out.println("afterMethod()");
	  }


	  @DataProvider
	  public Object[][] Generador() {
		  System.out.println("Genero casos");
	    return new Object[][] {
	      new Object[] { 1, "a" },
	      new Object[] { 2, "b" },
	    };
	  }
	  @BeforeClass
	  public void beforeClass() {
		  System.out.println("beforeClass");
	  }

	  @AfterClass
	  public void afterClass() {
		  System.out.println("afterClass()");
	  }

	  @BeforeTest
	  public void beforeTest() {
		  System.out.println("beforeTest()");
		  
	  }

	  @AfterTest
	  public void afterTest() {
		  System.out.println("afterTest()");
	  }

	  @BeforeSuite
	  public void beforeSuite() {
		  System.out.println("beforeSuite()");
	  }

	  @AfterSuite
	  public void afterSuite() {
		  System.out.println("afterSuite()");
	  }


	  @Test
	  public void test1() {
		  System.out.println("Ejecuto Test1");
	  }

	  @Test
	  public void test2() {
		  System.out.println("Ejecuto Test2");
	  }
	  @Test
	  public void testSinEmplementar() {
	    throw new RuntimeException("Este test aun no esta implementado");
	  }


}
}