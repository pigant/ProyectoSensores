package com.ignacio.proyectosensores.BLL;

import com.ignacio.proyectosensores.DAL.CodigoRepetidoException;
import com.ignacio.proyectosensores.DAL.MaquinaDAL;
import com.ignacio.proyectosensores.DAL.SensorDAL;
import com.ignacio.proyectosensores.DAL.SinBaseDatosException;
import com.ignacio.proyectosensores.DAL.TipoSensorDAL;
import com.ignacio.proyectosensores.DAL.TipoUnidadDAL;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ignacio
 */
public class Sensor {

	public static ArrayList<Sensor> findLike(String text) throws SinBaseDatosException {
		return SensorDAL.findLike(text);
	}

	private Integer id;
	private String nombre;
	private String escala;
	private String detalle;
	private boolean escalaPositiva;
	private Maquina maquina;
	private TipoUnidad tipoUnidad;
	private TipoSensor tipoSensor;

	public Sensor() {
	}

	public Sensor(String nombre, String escala, String detalle, boolean escalaPositiva) {
		this.nombre = nombre;
		this.escala = escala;
		this.detalle = detalle;
		this.escalaPositiva = escalaPositiva;
	}

	public Sensor(Integer id, String nombre, String escala, String detalle, boolean escalaPositiva) {
		this.id = id;
		this.nombre = nombre;
		this.escala = escala;
		this.detalle = detalle;
		this.escalaPositiva = escalaPositiva;
	}

	//
	//Read
	public static Sensor find(int id) throws SinBaseDatosException {
		Sensor s = SensorDAL.find(id);
		return SensorDAL.find(id);
	}

	public void findMaquina() throws SinBaseDatosException {
		Maquina m = MaquinaDAL.findBySensor(id);
		setMaquina(m);
		m.findLugar();
	}

	public void findTipoSensor() throws SinBaseDatosException {
		TipoSensor ts = TipoSensorDAL.findBySensor(id);
		setTipoSensor(ts);
	}
	public void findTipoUnidad() throws SinBaseDatosException {
		TipoUnidad tu = TipoUnidadDAL.findBySensor(id);
		setTipoUnidad(tu);
	}

	public void findDependencias(){
		try {
			findMaquina();
		} catch (SinBaseDatosException ex) {
			Logger.getLogger(Sensor.class.getName()).log(Level.SEVERE, null, ex);
		}
		try {
			findTipoSensor();
		} catch (SinBaseDatosException ex) {
			Logger.getLogger(Sensor.class.getName()).log(Level.SEVERE, null, ex);
		}
		try {
			findTipoUnidad();
		} catch (SinBaseDatosException ex) {
			Logger.getLogger(Sensor.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	//Create and update
	public boolean save() throws SinBaseDatosException, CodigoRepetidoException {
		boolean s = false;
		if (id == null) {
			//guardar
			id = SensorDAL.guardar(
					nombre,
					escala,
					detalle,
					escalaPositiva,
					maquina.getId(),
					tipoSensor.getId(),
					tipoUnidad.getId()
			);
			if (id != null) {
				s = true;
			}
		} else {
			s = SensorDAL.actualizar(
					id,
					nombre,
					escala,
					detalle,
					escalaPositiva,
					maquina.getId(),
					tipoSensor.getId(),
					tipoUnidad.getId());
		}
		return s;
	}

	//delete
	public boolean delete() throws SinBaseDatosException {
		return SensorDAL.delete(id);
	}

	//
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEscala() {
		return escala;
	}

	public void setEscala(String escala) {
		this.escala = escala;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public boolean isEscalaPositiva() {
		return escalaPositiva;
	}

	public void setEscalaPositiva(boolean escalaPositiva) {
		this.escalaPositiva = escalaPositiva;
	}

	public Maquina getMaquina() {
		return maquina;
	}

	public void setMaquina(Maquina maquina) {
		this.maquina = maquina;
	}

	public TipoUnidad getTipoUnidad() {
		return tipoUnidad;
	}

	public void setTipoUnidad(TipoUnidad tipoUnidad) {
		this.tipoUnidad = tipoUnidad;
	}

	public TipoSensor getTipoSensor() {
		return tipoSensor;
	}

	public void setTipoSensor(TipoSensor tipoSensor) {
		this.tipoSensor = tipoSensor;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 79 * hash + Objects.hashCode(this.id);
		hash = 79 * hash + Objects.hashCode(this.nombre);
		hash = 79 * hash + Objects.hashCode(this.escala);
		hash = 79 * hash + Objects.hashCode(this.detalle);
		hash = 79 * hash + (this.escalaPositiva ? 1 : 0);
		hash = 79 * hash + Objects.hashCode(this.maquina);
		hash = 79 * hash + Objects.hashCode(this.tipoUnidad);
		hash = 79 * hash + Objects.hashCode(this.tipoSensor);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Sensor other = (Sensor) obj;
		if (!Objects.equals(this.id, other.id)) {
			return false;
		}
		if (!Objects.equals(this.nombre, other.nombre)) {
			return false;
		}
		if (!Objects.equals(this.escala, other.escala)) {
			return false;
		}
		if (!Objects.equals(this.detalle, other.detalle)) {
			return false;
		}
		if (this.escalaPositiva != other.escalaPositiva) {
			return false;
		}
		if (!Objects.equals(this.maquina, other.maquina)) {
			return false;
		}
		if (!Objects.equals(this.tipoUnidad, other.tipoUnidad)) {
			return false;
		}
		if (!Objects.equals(this.tipoSensor, other.tipoSensor)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return nombre;
	}

}
