package data_model;

public class Vol {

    private int id;
    private int frequence;

    /**
     * Constructeur pour un vol
     * @param id
     * @param frequence
     */
    public Vol(int id,int frequence){
        this.id = id;
        this.frequence = frequence;
    }

    /**
     * Constructeur pour un vol
     * @param frequence
     */
    public Vol(int frequence){
        this.frequence = frequence;
    }

    /**
     * Getter de l'id
     * @return int
     */
    public int getId() {
        return id;
    }

    /**
     * Setter de l'id
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter de la frequence
     * @return int
     */
    public int getFrequence() {
        return frequence;
    }

    /**
     * Setter de la frequence
     * @param frequence
     */
    public void setFrequence(int frequence) {
        this.frequence = frequence;
    }
}
