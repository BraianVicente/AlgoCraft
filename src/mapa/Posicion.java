package mapa;



public class Posicion{

    private int x;
    private int y;

    public void print(){
        System.out.printf("X= %d, Y= %d\n", x, y);
    }

    public Posicion() throws Exception{
        throw new Exception();
    }

    public Posicion(int posX, int posY){
        x = posX;
        y = posY;
    }

    public Posicion copiar(){
        return (new Posicion(x, y));
    }

    public int distancia(Posicion otraPosicion){
        int distanciaX = this.distanciaEnX(otraPosicion);
        int distanciaY = this.distanciaEnY(otraPosicion);
        return (int)Math.sqrt((distanciaX * distanciaX) + (distanciaY * distanciaY));
    }

    public int distanciaEnX(Posicion otraPosicion){
        int distanciaX = distanciaEnXConSigno(otraPosicion);
        if(distanciaX < 0)
            distanciaX = -distanciaX;
        return distanciaX;
    }

    public int distanciaEnY(Posicion otraPosicion){
        int distanciaY = distanciaEnYConSigno(otraPosicion);
        if(distanciaY < 0)
            distanciaY = -distanciaY;
        return distanciaY;
    }

    public int distanciaEnXConSigno(Posicion otraPosicion){
        return (x -otraPosicion.x);
    }

    public int distanciaEnYConSigno(Posicion otraPosicion){
        return (y -otraPosicion.y);
    }

    public void moverEnX(int movimiento){
        x = x + movimiento;
    }

    public void moverEnY(int movimiento){
        y = y + movimiento;
    }

    @Override
    public int hashCode() {
        final int primo = 31;
        int resultado = 1;
        resultado = primo * resultado + x;
        resultado = primo * resultado + y;
        return resultado;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Posicion other = (Posicion) obj;
        if (x != other.x)
            return false;
        if (y != other.y)
            return false;
        return true;
    }

};
