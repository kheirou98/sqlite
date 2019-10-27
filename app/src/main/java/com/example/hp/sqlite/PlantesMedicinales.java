package com.example.hp.sqlite;


public class PlantesMedicinales {
    private int id;
    private String name;
    private byte[] image;
    private String nomLatin;
    private String famille;
    private String proprietes;
    private String posologie;
    private String precautions;
    private String partieUtilises;

    public PlantesMedicinales(String name, byte[] image, int id,String nomLatin, String famille, String proprietes, String partieUtilises,
                              String posologie, String precautions) {
        this.name = name;
        this.image = image;
        this.id = id;
        this.nomLatin = nomLatin;
        this.famille = famille;
        this.proprietes = proprietes;
        this.partieUtilises = partieUtilises;
        this.posologie = posologie;
        this.precautions = precautions;



    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getNomLatin() {
        return nomLatin;
    }

    public String getFamille() {
        return famille;
    }

    public String getProprietes() {
        return proprietes;
    }

    public String getPosologie() {
        return posologie;
    }

    public String getPrecautions() {
        return precautions;
    }

    public String getPartieUtilises() {
        return partieUtilises;
    }

    public void setNomLatin(String nomLatin) {
        this.nomLatin = nomLatin;
    }

    public void setFamille(String famille) {
        this.famille = famille;
    }

    public void setProprietes(String proprietes) {
        this.proprietes = proprietes;
    }

    public void setPosologie(String posologie) {
        this.posologie = posologie;
    }

    public void setPartieUtilises(String partieUtilises) {
        this.partieUtilises = partieUtilises;
    }

    public void setPrecautions(String precautions) {
        this.precautions = precautions;
    }
}
