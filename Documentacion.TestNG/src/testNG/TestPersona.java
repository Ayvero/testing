package testNG;
/***********PASO 3 DESDE ACA CREANDO UN GENERADOR - TestPersona.java*******************/

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Demo.Persona;



public class TestPersona {
	 @DataProvider
	  public Persona[] GeneradorPersona() {
		  System.out.println("Genero casos");
	    return new Persona[] {
			 new Persona("Juan","26.150.235","1979-01-01",42,true),
			 new Persona("Pedro","27.280.234","1980-02-01",41,true),
			 new Persona("Maria","28.184.259","1981-03-01",47,true),
			 new Persona("Cecilia","32.234.528","1983-04-01",38,true),
			 new Persona("Carlos","33.124.235","1985-04-01",36,true),
			 new Persona("Jose","35.345.534","1987-04-01",34,true)

	    };
	  }
		@Test(dataProvider = "GeneradorPersona", invocationCount=2)
		public void testEdadBienCalculada(Persona p) {
			
			int edadReportada = p.getEdad();
			int edadReal= getEdad(p.getFechaNacimiento());
			Assert.assertEquals(edadReportada, edadReal);
			//Assert.assertTrue("Fallo en el calculo de la edad",edadReportada == edadReal);
		}
		
		
		
		
		public int getEdad(String fechaNacimiento) {
		  try {
	          // Crea un objeto SimpleDateFormat para parsear la fecha de nacimiento.
	          SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	          
	          // Parsea la fecha de nacimiento.
	          Date fechaNac = sdf.parse(fechaNacimiento);
	          
	          // Obtiene la fecha actual.
	          Date fechaActual = new Date();
	          
	          // Crea un objeto Calendar para calcular la diferencia entre las fechas.
	          Calendar calNac = Calendar.getInstance();
	          Calendar calActual = Calendar.getInstance();
	          calNac.setTime(fechaNac);
	          calActual.setTime(fechaActual);
	          
	          // Calcula la diferencia de años.
	          int edad = calActual.get(Calendar.YEAR) - calNac.get(Calendar.YEAR);
	          
	          // Verifica si el cumpleaños ya pasó este año.
	          if (calNac.get(Calendar.MONTH) > calActual.get(Calendar.MONTH) ||
	              (calNac.get(Calendar.MONTH) == calActual.get(Calendar.MONTH) &&
	               calNac.get(Calendar.DAY_OF_MONTH) > calActual.get(Calendar.DAY_OF_MONTH))) {
	              edad--;
	          }
	          
	          return edad;
	      } catch (ParseException e) {
	          e.printStackTrace();
	          return -1; // Manejo de errores
	      }
		}
		


}