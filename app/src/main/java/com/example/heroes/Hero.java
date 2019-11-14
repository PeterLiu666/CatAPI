package com.example.heroes;

import android.os.Parcel;
import android.os.Parcelable;

public class Hero implements Parcelable, Comparable<Hero>
{


    private String name;
    private String description;
    private String superpower;
    private int ranking;
    private String image;

    public Hero(String name, String description, String superpower, int ranking, String image)
    {
        this.name = name;
        this.description = description;
        this.superpower = superpower;
        this.ranking = ranking;
        this.image = image;
    }

    @Override
    public String toString() {
        return "No." + ranking + "\n" + name + "\n" + description;

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

    public void setRanking(int ranking) {
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

    public int getRanking() {
        return ranking;
    }

    public String getImage() {
        return image;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.description);
        dest.writeString(this.superpower);
        dest.writeInt(this.ranking);
        dest.writeString(this.image);
    }

    protected Hero(Parcel in) {
        this.name = in.readString();
        this.description = in.readString();
        this.superpower = in.readString();
        this.ranking = in.readInt();
        this.image = in.readString();
    }





    public static final Parcelable.Creator<Hero> CREATOR = new Parcelable.Creator<Hero>() {
        @Override
        public Hero createFromParcel(Parcel source) {
            return new Hero(source);
        }

        @Override
        public Hero[] newArray(int size) {
            return new Hero[size];
        }
    };

    @Override
    public int compareTo(Hero hero)
    {
        return this.getName().compareTo(hero.getName());
    }
}
