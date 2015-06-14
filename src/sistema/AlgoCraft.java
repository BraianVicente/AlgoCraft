package sistema;

import jugador.Jugador;
import mapa.Mapa;
import tiempo.Tiempo;
import turno.Turno;

public class AlgoCraft {

    private Jugador jugador1;
    private Jugador jugador2;
    private Turno turno;
    private Mapa mapaDelJuego;
    private Tiempo tiempoDeJuego;
// Agregar funcion que no permita mas de 1 ataque de unidad a la vez.
    public AlgoCraft(Jugador jugador1, Jugador jugador2, Jugador empieza){

        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        //this.mapaDelJuego = mapaDelJuego;
        turno = new Turno(empieza);
        tiempoDeJuego = new Tiempo(0);
    }

    public void pasarTurno(){

        if(turno.getTurno().equals(jugador2)){
            turno.setTurno(jugador1);
            jugador1.recolectar();
            
        } else {

            turno.setTurno(jugador2);
            jugador2.recolectar();
        }

        tiempoDeJuego.sumarTiempo();
    }
    
    public Jugador turnoDe(){
        
        return turno.getTurno();
    }
}
