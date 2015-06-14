package mapa;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class ConstructorDeMapas{

	protected int maxX;
	protected int maxY;
	protected int bases;
	protected ArrayList<Posicion> posicionesBases = new ArrayList<>();
	protected int minerales;
	protected ArrayList<Posicion> posicionesMinerales = new ArrayList<>();
	protected int volcanes;
	protected ArrayList<Posicion> posicionesVolcanes = new ArrayList<>();
	protected int tamanoLadoBase = 4;
	protected int cantidadMineralesPorBase = 3;

	public void generarRecursosMapa(){
		this.generarPosicionesBases();
		this.generarPosicionesMinerales();
		this.generarPosicionesVolcanes();
	}

	public void generarPosicionesBases(){
		int nroBase;
		Posicion posBase;
		for(nroBase = 0; nroBase < bases; nroBase++){
			switch(nroBase){
				case 0:
					posBase = new Posicion(0,0);
					posicionesBases.add(posBase);
					break;
				case 1:
					posBase = new Posicion(maxX - (tamanoLadoBase + 1),maxY - (tamanoLadoBase + 1));
					posicionesBases.add(posBase);
					break;
				case 2:
					posBase = new Posicion(maxX - (tamanoLadoBase + 1),0);
					posicionesBases.add(posBase);
					break;
				case 3:
					posBase = new Posicion(0,maxY - (tamanoLadoBase + 1));
					posicionesBases.add(posBase);
					break;
				case 4:
					posBase = new Posicion(maxX/2 - (tamanoLadoBase/2),0);
					posicionesBases.add(posBase);
					break;
				case 5:
					posBase = new Posicion(0,maxY/2 - (tamanoLadoBase/2));
					posicionesBases.add(posBase);
					break;
			}
		}
	}

	public void generarPosicionesMinerales(){
		int mineralesPorTriangulo = minerales / 2;
		int i, j, k;
		int posX, posY;
		boolean estaCercaDeBase;
		boolean estaCercaDeMineral;
		boolean posicionOcupada;
		Posicion posMineral, posBase;
		//Se generan minerales afuera de las bases
		for(i = 0; i < minerales; i++){
			do{
				estaCercaDeBase = false;
				estaCercaDeMineral = false;
				if(i < mineralesPorTriangulo){
					posX = (int)(Math.random() * maxX);
					posY = (int)(Math.random() * (maxY - posX));
				}
				else{
					posY = (int)(Math.random() * maxY);
					posX = ((int)(Math.random() * posY)) + (maxX - posY - 1);
				}
				posMineral = new Posicion(posX, posY);
				for(j = 0; j < bases && !estaCercaDeBase; j++){
					if(posMineral.distancia(posicionesBases.get(j)) < (tamanoLadoBase * 2) || posX == (maxX - posY - 1))
						estaCercaDeBase = true;
				}
				for(j = 0; j < posicionesMinerales.size() && !estaCercaDeMineral; j++){
					if(posMineral.distancia(posicionesMinerales.get(j)) < (tamanoLadoBase))
						estaCercaDeMineral = true;
				}
			}while(estaCercaDeBase || estaCercaDeMineral);
			posicionesMinerales.add(posMineral);
		}
		//Se generan minerales en las bases
		for(i = 0; i < bases; i++){
			posBase = posicionesBases.get(i);
			for(j = 0; j < cantidadMineralesPorBase; j++){
				do{
					posicionOcupada = false;
					posMineral = posBase.copiar();
					posMineral.moverEnX((int)(Math.random() * tamanoLadoBase));
					posMineral.moverEnY((int)(Math.random() * tamanoLadoBase));
					for(k = 0; k < posicionesMinerales.size(); k++){
						if(posMineral.equals(posicionesMinerales.get(k)))
							posicionOcupada = true;
					}
				}while(posicionOcupada);
				posicionesMinerales.add(posMineral);
			}
		}
	}

	public void generarPosicionesVolcanes(){
		int i, j;
		Posicion posMineral, posVolcan, posBase;
		boolean posicionOcupada;
		//Se generan volcanes afuera de las bases
		for(i = 0; i < minerales; i++){
			posMineral = posicionesMinerales.get(i);
			do{
				posVolcan = posMineral.copiar();
				posVolcan.moverEnX((int)(Math.random() * tamanoLadoBase));
				posVolcan.moverEnY((int)(Math.random() * tamanoLadoBase));
				posicionOcupada = posVolcan.equals(posMineral);
			}while(posicionOcupada);
			posicionesVolcanes.add(posVolcan);
		}
		//Se generan volcanes en las bases
		for(i = 0; i < bases; i++){
			posBase = posicionesBases.get(i);
			do{
				posicionOcupada = false;
				posVolcan = posBase.copiar();
				posVolcan.moverEnX((int)(Math.random() * tamanoLadoBase));
				posVolcan.moverEnY((int)(Math.random() * tamanoLadoBase));
				for(j = 0; j < posicionesMinerales.size(); j++){
					if(posVolcan.equals(posicionesMinerales.get(j)))
						posicionOcupada = true;
				}
			}while(posicionOcupada);
			posicionesVolcanes.add(posVolcan);
		}
	}

	public int getX(){
		return maxX;
	}

	public int getY(){
		return maxY;
	}

	public ArrayList getPosicionesBases(){
		return posicionesBases;
	}

	public Mapeable getTerreno(Posicion pos){
		int i;
		for(i = 0; i < posicionesMinerales.size(); i ++){
			if(pos.equals(posicionesMinerales.get(i))){
				return (new Mineral());
			}
		}
		for(i = 0; i < posicionesVolcanes.size(); i ++){
			if(pos.equals(posicionesVolcanes.get(i))){
				return (new Volcan());
			}
		}
		return (new Pasto());
	}

	public Posicion getPosicionBase(int i){
		return posicionesBases.get(i);
	}

	public int getLadoBase(){
		return tamanoLadoBase;
	}

};
