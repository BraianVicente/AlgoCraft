package mapa;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import unidad.Unidad;
import edificio.Edificio;


public class MapaVisible{

	private Map<Posicion, Celda> mapaVisible = new HashMap<>();
	private int maxX;
	private int maxY;
	private int minX;
	private int minY;
	Mapa mapaDeJuego;

	public MapaVisible(Mapa mapa, ConstructorDeMapas constructor, int jugador){
		int i, j;
		Posicion p;
		Celda c;
		mapaDeJuego = mapa;
		maxX = constructor.getX() - 1;
		maxY = constructor.getY() - 1;
		minX = 0;
		minY = 0;
		int ladoBase = constructor.getLadoBase();
		Posicion posBase = constructor.getPosicionBase(jugador);
		for(i = 0; i <= maxX; i++){
			for(j = 0; j <= maxY; j++){
				p = new Posicion(i,j);
				if(posBase.distanciaEnXConSigno(p) < ladoBase && posBase.distanciaEnYConSigno(p) < ladoBase)
					c = mapa.getCelda(p);
				else
					c = new Celda(new Vacio());
				mapaVisible.put(p,c);
			}
		}
	}

	public void actualizar(Posicion posicion, int maxVista){
		ArrayList<Posicion> posicionesVisibles = mapaDeJuego.posicionesAlcanzables(posicion, maxVista);
		Posicion pos;
		Celda celda;
		for(int i = 0; i < posicionesVisibles.size(); i++){
			pos = posicionesVisibles.get(i);
			if((mapaVisible.get(pos)).getTerreno() instanceof Vacio){
				celda = mapaDeJuego.getCelda(pos);
				mapaVisible.put(pos,celda);
			}
		}
	}

};
