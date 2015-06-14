package mapa;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import unidad.Unidad;
import edificio.Edificio;


public class Mapa {

    private Map<Posicion, Celda> mapa = new HashMap<>();
    private int maxX;
    private int maxY;
    private int minX;
    private int minY;
    private ArrayList<Posicion> posicionesBases = new ArrayList<>();
    private int ladoBase;

    public Mapa(ConstructorDeMapas constructor){
        int i, j;
        Posicion p;
        Celda c;
        Mapeable mapeable;
        posicionesBases = constructor.getPosicionesBases();
        maxX = constructor.getX() - 1;
        maxY = constructor.getY() - 1;
        minX = 0;
        minY = 0;
        ladoBase = constructor.getLadoBase();
        for(i = 0; i <= maxX; i++){
            for(j = 0; j <= maxY; j++){
                p = new Posicion(i,j);
                mapeable = constructor.getTerreno(p);
                c = new Celda(mapeable);
                mapa.put(p,c);
            }
        }
    }

    public Posicion desplegarTropaInicial(Unidad unidad, int jugador) throws Exception{
        Posicion posBase = posicionesBases.get(jugador);
        Posicion posCandidata = posBase.copiar();
        int i, j;

        for(i = 0; i < ladoBase; posCandidata.moverEnX(1), i++){
                for(j = 0; j < ladoBase; posCandidata.moverEnY(1), j++){
                    if((mapa.get(posCandidata)).ocupar(unidad))
                        return posCandidata;
                }
                posCandidata.moverEnY(-ladoBase);
        }
        throw new Exception();
    }

    public ArrayList posicionesAlcanzables(Posicion posUnidad, int distanciaMax){
        ArrayList<Posicion> posicionesPosiblesMovimientos = new ArrayList<>();
        Posicion posPosible = posUnidad.copiar();
        posPosible.moverEnX(Math.max(-distanciaMax, -(posPosible.distanciaEnX(new Posicion(minX,minY)))));
        posPosible.moverEnY(Math.max(-distanciaMax, -(posPosible.distanciaEnY(new Posicion(minX,minY)))));

        int i, j;
        for(i = 0; i < (distanciaMax * 2); i++){
            for(j = 0; j < (distanciaMax * 2); j++){
                if((posPosible.distanciaEnX(posUnidad) + posPosible.distanciaEnY(posUnidad)) < distanciaMax){
                    posicionesPosiblesMovimientos.add(posPosible);
                    posPosible = posPosible.copiar();
                }
            }
        }
        return posicionesPosiblesMovimientos;
    }

    public boolean mover(Unidad unidad, Posicion posInicial, Posicion posFinal, int maxMovimiento){
        if(!this.esPosibleMover(unidad, posInicial, posFinal, maxMovimiento)){
            (mapa.get(posInicial)).desocupar(unidad);
            if((mapa.get(posFinal)).ocupar(unidad))
                return true;
            (mapa.get(posInicial)).ocupar(unidad);
        }
        return false;
    }

    public boolean esPosibleMover(Unidad unidad, Posicion posInicial, Posicion posFinal, int maxMovimiento){
        ArrayList<Posicion> posiblesMovimientos = posicionesAlcanzables(posInicial, maxMovimiento);
        boolean movimientoPosible = false;
        for(int i = 0; i < posiblesMovimientos.size() && !movimientoPosible; i++){
            if(posFinal.equals(posiblesMovimientos.get(i)))
                movimientoPosible = true;
        }
        if(movimientoPosible){
            if(!this.existeCamino(posInicial, posFinal, posInicial, unidad.esTerrestre(), maxMovimiento))
                movimientoPosible = false;
        }
        return movimientoPosible;
    }

    public boolean existeCamino(Posicion posInicial, Posicion posFinal, Posicion posAnterior, boolean esTerrestre,int maxMovimiento){
        ArrayList<Posicion> posProbadas = new ArrayList<>();
        Posicion caminante;
        if(posInicial.equals(posFinal))
            return true;
        else if(posInicial.distanciaEnX(posFinal) + posFinal.distanciaEnY(posFinal) > maxMovimiento)
            return false;

        int dirPrincipalX = 1;
        int dirPrincipalY = 1;
        if(posFinal.distanciaEnXConSigno(posInicial) < 0)
            dirPrincipalX= -1;
        else if(posFinal.distanciaEnXConSigno(posInicial) == 0)
            dirPrincipalX= 0;
        if(posFinal.distanciaEnYConSigno(posInicial) < 0)
            dirPrincipalY= -1;
        else if(posFinal.distanciaEnYConSigno(posInicial) == 0)
            dirPrincipalY= 0;

        int maxMovimientoX = (maxMovimiento - posInicial.distanciaEnX(posFinal) - posInicial.distanciaEnY(posFinal))/2 + posInicial.distanciaEnX(posFinal);
        int maxMovimientoY = (maxMovimiento - posInicial.distanciaEnX(posFinal) - posInicial.distanciaEnY(posFinal))/2 + posInicial.distanciaEnY(posFinal);
        int minMovimientoX = (maxMovimiento - posInicial.distanciaEnX(posFinal) - posInicial.distanciaEnY(posFinal))/2;
        int minMovimientoY = minMovimientoX;

        if(maxMovimientoX > 0){
            caminante = posInicial.copiar();
            caminante.moverEnX(dirPrincipalX);
            if(posicionPasable(caminante, posInicial, posFinal, posAnterior, esTerrestre, maxMovimiento))
                return true;
        }

        if(maxMovimientoY > 0){
            caminante = posInicial.copiar();
            caminante.moverEnY(dirPrincipalY);
            if(posicionPasable(caminante, posInicial, posFinal, posAnterior, esTerrestre, maxMovimiento))
                return true;
        }

        if(minMovimientoX > 0){
            caminante = posInicial.copiar();
            caminante.moverEnY(-dirPrincipalX);
            if(posicionPasable(caminante, posInicial, posFinal, posAnterior, esTerrestre, maxMovimiento))
                return true;
        }

        if(minMovimientoY > 0){
            caminante = posInicial.copiar();
            caminante.moverEnY(-dirPrincipalY);
            if(posicionPasable(caminante, posInicial, posFinal, posAnterior, esTerrestre, maxMovimiento))
                return true;
        }

        return false;
    }

    public boolean posicionPasable(Posicion pos, Posicion posInicial, Posicion posFinal, Posicion posAnterior, boolean esTerrestre, int maxMovimiento){
        if(pos.equals(posAnterior))
            return false;

        if((mapa.get(pos)).puedePasar(esTerrestre) && pos.distanciaEnX(posInicial) + pos.distanciaEnY(posInicial) + pos.distanciaEnX(posFinal) + pos.distanciaEnY(posFinal) <= maxMovimiento){
            if(existeCamino(pos, posFinal, posAnterior, esTerrestre, maxMovimiento - 1))
                return true;
        }
        return false;
    }

    public void sacarMapeable(Mapeable mapeable, Posicion posMapeable){
        (mapa.get(posMapeable)).desocupar(mapeable);
    }

    public boolean construirEdificio(Edificio edificio, Posicion posEdificio){
        return (mapa.get(posEdificio)).ocupar(edificio);
    }

    public Posicion agregarUnidad(Unidad unidad, Posicion posEdificioGenerador){
        int i, j;
        Posicion posUnidad = posEdificioGenerador.copiar();
        int maxMovimientoX = posUnidad.distanciaEnX(new Posicion(maxX, maxY));
        int maxMovimientoY = posUnidad.distanciaEnY(new Posicion(maxX, maxY));
        int minMovimientoX = posUnidad.distanciaEnX(new Posicion(minX, minY));
        int minMovimientoY = posUnidad.distanciaEnY(new Posicion(minX, minY));
        for(i = 1;;i++){
            for(j = 1; j <= i; j++){
                posUnidad.moverEnX(Math.min(j, maxMovimientoX));
                if((mapa.get(posUnidad)).ocupar(unidad))
                    return posUnidad;
            }
            for(j = 1; j <= i; j++){
                posUnidad.moverEnY(Math.min(i, maxMovimientoY));
                if((mapa.get(posUnidad)).ocupar(unidad))
                    return posUnidad;
            }
            i++;
            for(j = -1; j >= -i; j--){
                posUnidad.moverEnX(Math.max(j, -minMovimientoX));
                if((mapa.get(posUnidad)).ocupar(unidad))
                    return posUnidad;
            }
            for(j = -1; j >= -i; j--){
                posUnidad.moverEnY(Math.max(-i, -minMovimientoY));
                if((mapa.get(posUnidad)).ocupar(unidad))
                    return posUnidad;
            }
        }
    }

    public Celda getCelda(Posicion posicion){
        return mapa.get(posicion);
    }

};
