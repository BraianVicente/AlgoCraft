package unidad;

import vida.Vida;
import mapa.Mapeable;
import mapa.Posicion;
import recursos.Recursos;
import tiempo.Tiempo;
import edificio.Edificio ;
import tiempo.TiempoConsumidoException;

public interface Unidad extends Mapeable {

    public void actualizarAtaque() ;

    public String getNombre() ;

    public Recursos costoUnidad() ;

    public void recibirAtaque(Unidad atacante ) ;

    public  void realizarAtaque(Unidad atacado ) ;

    public  void realizarAtaque(Edificio atacado ) ;

    public int suministro();

    public int poderAtaqueAereo() ;

    public int poderAtaqueTerrestre() ;

    public void restarTiempo() throws TiempoConsumidoException ;

    public boolean construccionFinalizada() ;

    public boolean equals(Object obj) ;

    public boolean estaMuerta() ;

    public boolean esTerrestre() ;

}
