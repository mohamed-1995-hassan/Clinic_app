package com.example.mohamed.clinic_app;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Mohamed on 18/10/2018.
 */
public class getdoctors implements Parcelable
{

    private String full_name;
    private String password;
    private String email_address;
    private String image;
    private String departement;
    private String discription;
    private String lat;
    private String lon;


    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }



    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }





    protected getdoctors(Parcel in) {
        full_name = in.readString();
        password = in.readString();
        email_address = in.readString();
        image = in.readString();
        departement = in.readString();
        discription = in.readString();
        lat=in.readString();
        lon=in.readString();
    }

    public static final Creator<getdoctors> CREATOR = new Creator<getdoctors>() {
        @Override
        public getdoctors createFromParcel(Parcel in) {
            return new getdoctors(in);
        }

        @Override
        public getdoctors[] newArray(int size) {
            return new getdoctors[size];
        }
    };

    public String getEmail_address() {
        return email_address;
    }

    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }




    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }



    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(full_name);
        parcel.writeString(password);
        parcel.writeString(email_address);
        parcel.writeString(image);
        parcel.writeString(departement);
        parcel.writeString(discription);
        parcel.writeString(lat);
        parcel.writeString(lon);
    }
}
