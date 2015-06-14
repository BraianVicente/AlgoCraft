package raza.terran;

import raza.Raza ;
import edificio.Edificio;
import edificio.edificiosTerran.* ;

public class Terran extends Raza {

	public Edificio crearCentroDeMineral() {
		Edificio nuevoEdificio = new CentroDeMineral();
		return nuevoEdificio ;
	}

	public Edificio crearRefineria() {
		Edificio nuevoEdificio = new Refineria();
		return nuevoEdificio ;
	}

	public Edificio crearBarraca() {
		Edificio nuevoEdificio = new Barraca();
		return nuevoEdificio ;
	}

	public Edificio crearFabrica() {
		Edificio nuevoEdificio = new Fabrica();
		return nuevoEdificio ;
	}

	public Edificio crearPuertoEstelar() {
		Edificio nuevoEdificio = new PuertoEstelar();
		return nuevoEdificio ;
	}

	public Edificio crearDepositoDeSuministros(){
		Edificio nuevoEdificio = new DepositoDeSuministros();
		return nuevoEdificio ;
	}


}
