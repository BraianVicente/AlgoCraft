package raza.protoss;

import raza.Raza;
import edificio.Edificio;
import edificio.edificiosProtoss.Acceso;
import edificio.edificiosProtoss.ArchivosTemplarios;
import edificio.edificiosProtoss.Asimilador;
import edificio.edificiosProtoss.NexoMineral;
import edificio.edificiosProtoss.Pilon;
import edificio.edificiosProtoss.PuertoEstelar;

public class Protoss extends Raza {

	public Edificio crearAcceso() {
		Edificio nuevoEdificio = new Acceso() ;
		return nuevoEdificio ;
	}

	public Edificio crearPuertoEstelar() {
		Edificio nuevoEdificio = new PuertoEstelar() ;
		return nuevoEdificio ;
	}

	public Edificio crearArchivosTemplarios() {
		Edificio nuevoEdificio = new ArchivosTemplarios();
		return nuevoEdificio;
	}

	public Edificio crearNexoMineral() {
		Edificio nuevoEdificio = new NexoMineral();
		return nuevoEdificio;
	}

	public Edificio crearAsimilador() {
		Edificio nuevoEdificio = new Asimilador();
		return nuevoEdificio;
	}

	public Edificio crearPilon() {
		Edificio nuevoEdificio = new Pilon() ;
		return nuevoEdificio;
	}

}
