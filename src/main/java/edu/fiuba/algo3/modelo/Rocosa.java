package edu.fiuba.algo3.modelo;

public class Rocosa extends Casillero {

    public Rocosa (int nuevax, int nuevay) {
        this.tipo = "Rocosa";
        this.x = nuevax;

        this.y = nuevay;
    }

    
    public Boolean esTierra(){

        return false;

    }

    @Override
    public int obtenerx(){

        return this.x;
    }

	@Override
    public int obtenery(){

        return this.y;
    }

    
}
