package com.example.heroes;

public class Hero
{


    private String name;
    private String description;
    private String superpower;
    private String ranking;
    private String image;

    public Hero(String name, String description, String superpower, String ranking, String image)
    {
        this.name = name;
        this.description = description;
        this.superpower = superpower;
        this.ranking = ranking;
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSuperpower(String superpower) {
        this.superpower = superpower;
    }

    public void setRanking(String ranking) {
        this.ranking = ranking;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getSuperpower() {
        return superpower;
    }

    public String getRanking() {
        return ranking;
    }

    public String getImage() {
        return image;
    }


}
