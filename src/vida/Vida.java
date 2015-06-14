package vida;
import vida.VidaAgotadaException ;
public class Vida {
    private int vida ;

    public Vida(int vidaInicial) {
        vida = vidaInicial ;
    }

    public void quitarVida(int poderAtaque) throws VidaAgotadaException  {
        if (this.getVida() >= poderAtaque ) {
			this.setVida(this.getVida() - poderAtaque) ;
		} else {
			this.setVida(0) ;
			throw new VidaAgotadaException() ;
		}
    }

    public int getVida(){
        return this.vida ;
    }

    public void setVida(int nuevaVida) {
        this.vida = nuevaVida ;
    }

}
