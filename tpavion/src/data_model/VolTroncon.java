package data_model;

import java.sql.Time;

public class VolTroncon {

    private int troncon;
    private int vol;
    private Time heureDepart;
    private Time heureSortie;

    /**
     * Constructeur pour un VolTroncon
     * @param troncon
     * @param vol
     * @param heureDepart
     * @param heureSortie
     */
    public VolTroncon(int troncon,int vol,Time heureDepart,Time heureSortie){
        this.troncon = troncon;
        this.vol = vol;
        this.heureDepart = heureDepart;
        this.heureSortie = heureSortie;
    }

    /**
     * Getter d'un tronçon
     * @return int
     */
    public int getTroncon() {
        return troncon;
    }

    /**
     * Setter d'un tronçon
     * @param troncon
     */
    public void setTroncon(int troncon) {
        this.troncon = troncon;
    }

    /**
     * Getter d'un vol
     * @return int
     */
    public int getVol() {
        return vol;
    }

    /**
     * Setter d'un vol
     * @param vol
     */
    public void setVol(int vol) {
        this.vol = vol;
    }

    /**
     * Getter de l'heure de départ
     * @return Time
     */
    public Time getHeureDepart() {
        return heureDepart;
    }

    /**
     * Setter de l'heure de départ
     * @param heureDepart
     */
    public void setHeureDepart(Time heureDepart) {
        this.heureDepart = heureDepart;
    }

    /**
     * Getter de l'heure de sortie
     * @return Time
     */
    public Time getHeureSortie() {
        return heureSortie;
    }

    /**
     * Setter de l'heure de sortie
     * @param heureSortie
     */
    public void setHeureSortie(Time heureSortie) {
        this.heureSortie = heureSortie;
    }
}
