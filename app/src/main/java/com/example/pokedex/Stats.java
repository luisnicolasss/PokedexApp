package com.example.pokedex;

import android.os.Parcel;
import android.os.Parcelable;

public class Stats implements Parcelable {
    private String hp;
    private String attack;
    private String defense;
    private String speed;


    public Stats(String hp, String attack, String defense, String speed) {
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
    }

    protected Stats(Parcel in) {
        hp = in.readString();
        attack = in.readString();
        defense = in.readString();
        speed = in.readString();
    }

    public static final Creator<Stats> CREATOR = new Creator<Stats>() {
        @Override
        public Stats createFromParcel(Parcel in) {
            return new Stats(in);
        }

        @Override
        public Stats[] newArray(int size) {
            return new Stats[size];
        }
    };

    public String getHp() {
        return hp;
    }

    public String getAttack() {
        return attack;
    }

    public String getDefense() {
        return defense;
    }

    public String getSpeed() {
        return speed;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(hp);
        parcel.writeString(attack);
        parcel.writeString(defense);
        parcel.writeString(speed);
    }
}
