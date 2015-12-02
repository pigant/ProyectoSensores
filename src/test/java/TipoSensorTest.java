import com.ignacio.proyectosensores.BLL.TipoSensor;
import com.ignacio.proyectosensores.DAL.BD;
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ignacio
 */
public class TipoSensorTest {

	public TipoSensorTest() {
	}

	@BeforeClass
	public static void setUpClass() throws SQLException {
		BD.setTesting();
	}

	@AfterClass
	public static void tearDownClass() {
	}

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
	}

	// TODO add test methods here.
	// The methods must be annotated with annotation @Test. For example:
	//
	// @Test
	// public void hello() {}
	@Test
	public void CRUD_tipo_sensor() {
		//creacion
		TipoSensor t = new TipoSensor("Termomentro test");
		boolean s = t.save();
		assertTrue("No se guardo 'tipo_sensor'", s);
		//update
		t.setNombre("Termostato test");
		s = t.save();
		assertTrue("No se actualizo 'tipo_sensor'", s);
		//read
		TipoSensor t2 = TipoSensor.find(t.getId());
		assertTrue("No se obtubo correctamente el sensor", t2.equals(t));
		//delete
		s = t.delete();
		assertTrue("No se elimino correctamente el 'sensor'", s);
	}
}
