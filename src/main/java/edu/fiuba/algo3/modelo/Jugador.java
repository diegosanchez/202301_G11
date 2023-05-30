package edu.fiuba.algo3.modelo;


public class Jugador {

    int credito;
    int vida;

    public Jugador(int nuevoCredito,int nuevaVida){

        this.credito = nuevoCredito;
        this.vida = nuevaVida;

    }

    public Boolean creditoIgual(int unCredito){

        return this.credito == unCredito;

    }

    public Boolean vidaIgual(int unaVida){

        return (this.vida == unaVida);

    }

    public TorreBlanca construirTorreBlanca(int creditoTorreBlanca, Casillero unCasillero){
        
        if(this.credito > creditoTorreBlanca && unCasillero.esTierra()){
            
            this.credito = this.credito - creditoTorreBlanca;
            return (new TorreBlanca());

        }

        return null;
    }


    public TorrePlateada construirTorrePlateada(int creditoTorrePlateada, Casillero unCasillero){

        if(this.credito > creditoTorrePlateada && unCasillero.esTierra()){
            
            this.credito = this.credito - creditoTorrePlateada;
            return (new TorrePlateada());

        }

    
        return null;

    }



}
