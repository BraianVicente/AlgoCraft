package pruebasMapa;

import junit.framework.Assert;
import org.junit.Test;
import mapa.Mapa;
import mapa.ConstructorDeMapaChico;
import mapa.Posicion;
import mapa.Pasto;
import edificio.edificiosTerran.Barraca;
import unidad.Unidad;
import unidad.unidadTerran.Marine;

public class MapaTest {

	@Test
	public void testMapaAgregaEdificioEnPasto(){
		ConstructorDeMapaChico cMapa = new ConstructorDeMapaChico();
		Mapa mapa = new Mapa(cMapa);
		Posicion pos = new Posicion(0, 0);
		while(!(cMapa.getTerreno(pos) instanceof Pasto)){
			pos.moverEnX(1);
		}
		Assert.assertTrue(mapa.construirEdificio(new Barraca(), pos));
	}

	@Test
	public void testMapaUnidadCercaDeEdificioCreadorEnPasto(){
		ConstructorDeMapaChico cMapa = new ConstructorDeMapaChico();
		Mapa mapa = new Mapa(cMapa);
		Posicion posEdificio = new Posicion(0, 0);
		while(!(cMapa.getTerreno(posEdificio) instanceof Pasto)){
			posEdificio.moverEnX(1);
		}
		mapa.construirEdificio(new Barraca(), posEdificio);
		Posicion posUnidad = mapa.agregarUnidad(new Marine(), posEdificio);
		Assert.assertEquals(1, posUnidad.distanciaEnX(posEdificio));
		Assert.assertTrue(cMapa.getTerreno(posUnidad) instanceof Pasto);
	}

	@Test
	public void testMapaUnidadSePuedeMoverAPos(){
		ConstructorDeMapaChico cMapa = new ConstructorDeMapaChico();
		Mapa mapa = new Mapa(cMapa);
		int i;
		Unidad unidad;
		Posicion posUnidad;
		Posicion posDestino;
		do{
			Posicion posEdificio = new Posicion(0, 0);
			while(!(cMapa.getTerreno(posEdificio) instanceof Pasto)){
				posEdificio.moverEnX(1);
			}
			mapa.construirEdificio(new Barraca(), posEdificio);
			unidad = new Marine();
			posUnidad = mapa.agregarUnidad(unidad, posEdificio);
	
			posDestino = posUnidad.copiar();
			posDestino.moverEnX(1);
			for(i = 1; !(cMapa.getTerreno(posDestino) instanceof Pasto) && i <= 7; i++){
				if(i % 2 == 0)
					posDestino.moverEnX(1);
				else
					posDestino.moverEnY(1);
			}
		}while(i > 7);
		Assert.assertTrue(mapa.mover(unidad, posUnidad, posDestino, 7));
	}

	@Test
	public void testSoloHayLugarParaDesplegar12TropasEnBase(){
		ConstructorDeMapaChico cMapa = new ConstructorDeMapaChico();
		Mapa mapa = new Mapa(cMapa);
		int nJugador = 0;
		int k = 0;

		try{
			for(k = 0;;k++)
				mapa.desplegarTropaInicial(new Marine(), nJugador);
		}
		catch(Exception e){
			Assert.assertEquals(12, k);
		};
	}

};
