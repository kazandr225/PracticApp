package com.example.practicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public class MainActivity implements Parcelable {

    //id title image description
    public Integer id;
    public String title;
    public String image;
    public String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MainActivity(Integer id, String title, String image, String description)
    {
        this.id = id;
        this.title = title;
        this.image = image;
        this.description = description;
    }

    protected MainActivity(Parcel in) {
        id = in.readInt();
        title = in.readString();
        image = in.readString();
        description = in.readString();
    }

    public static final Creator<MainActivity> CREATOR = new Creator<MainActivity>() {
        @Override
        public MainActivity createFromParcel(Parcel in) {return new MainActivity(in);}

        @Override
        public MainActivity[] newArray(int size) {return new MainActivity[size];}
    };

    @Override
    public  int describeContents(){ return 0; }

    @Override
    public void writeToParcel(Parcel dest, int i) {
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(id);
        }
        dest.writeString(title);
        dest.writeString(image);
        dest.writeString(description);
    }
}