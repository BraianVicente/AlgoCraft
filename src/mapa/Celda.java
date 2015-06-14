package mapa;

import unidad.Unidad;
import edificio.Edificio;


public class Celda{

	Mapeable terreno;
	Mapeable ocupanteTierra;
	Mapeable ocupanteAire;

	public Celda() throws Exception{
		throw new Exception();
	}

	public Celda(Mapeable terrenoMapeable){
		terreno = terrenoMapeable;
		ocupanteTierra = new Vacio();
		ocupanteAire = new Vacio();
	}

	public boolean ocupar(Mapeable ocupante){
		if(ocupante instanceof Edificio && ocupanteTierra instanceof Vacio)
			ocupanteTierra = ocupante;
		else if(ocupante instanceof Unidad && terreno instanceof Pasto){
			if(((Unidad)ocupante).esTerrestre() && ocupanteTierra instanceof Vacio && terreno instanceof Pasto)
				ocupanteTierra = ocupante;
			else if(!((Unidad)ocupante).esTerrestre() && ocupanteAire instanceof Vacio)
				ocupanteAire = ocupante;
			else
				return false;
		}
		else
			return false;
		return true;
	}

	public void desocupar(Mapeable ocupante){
		if(ocupante == ocupanteTierra){
			ocupanteTierra = new Vacio();
		}
		else if(ocupante == ocupanteAire){
			ocupanteAire = new Vacio();
		}
	}

	public boolean puedePasar(boolean esTerrestre){
		if((esTerrestre && ocupanteTierra instanceof Vacio) || (!esTerrestre && ocupanteAire instanceof Vacio))
			return true;
		return false;
	}

	public Mapeable getTerreno(){
		return terreno;
	}

	public Mapeable getOcupanteTierra(){
		return ocupanteTierra;
	}

	public Mapeable getOcupanteAire(){
		return ocupanteAire;
	}

};
