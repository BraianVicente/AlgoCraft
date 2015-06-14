package escudo;

import escudo.EscudoInsuficienteException;

public class Escudo {

    private int escudoActual ;
    private int escudoMaximo ;

    public Escudo(int i) {
        this.setEscudo(i) ;
        this.setEscudoMaximo(i) ;
    }

    public int getEscudo() {
        return escudoActual;
    }

    public void reducirEscudo(int ataque) throws EscudoInsuficienteException {
        if (this.getEscudo() >= ataque ) {
            this.setEscudo(this.getEscudo() - ataque) ;
        } else {
            this.setEscudo(0) ;
            int escudoFaltante = (ataque - this.getEscudo()) ;
            throw new EscudoInsuficienteException(escudoFaltante) ;
        }
    }

    public void setEscudo(int escudo) {
        this.escudoActual = escudo ;
    }

    private void setEscudoMaximo(int escudo){
        this.escudoMaximo = escudo ;
    }

    private int getEscudoMaximo(){
        return this.escudoMaximo ;
    }

    public void aumentarEscudo(){
        int aumento = (this.getEscudo() + 5 );

        if ( aumento >= this.getEscudoMaximo() ) {
            this.setEscudo(this.getEscudoMaximo() ) ;
        } else {
            this.setEscudo( aumento ) ;
        }
    }


}
