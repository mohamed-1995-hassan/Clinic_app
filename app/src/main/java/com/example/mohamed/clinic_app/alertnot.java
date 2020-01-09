package com.example.mohamed.clinic_app;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Mohamed on 24/10/2018.
 */
public class alertnot implements Parcelable {

    private int id;
    private String pat_pass;
    private String doc_pass;
    private String hour;
    private String minit;
    private String time;
    private String full_name;
    private String email_address;
    private String password;
    private String image;
    private String departement;
    private String discription;
    private String medecine;


    protected alertnot(Parcel in) {
        id = in.readInt();
        pat_pass = in.readString();
        doc_pass = in.readString();
        hour = in.readString();
        minit = in.readString();
        time = in.readString();
        full_name = in.readString();
        email_address = in.readString();
        password = in.readString();
        image = in.readString();
        departement = in.readString();
        discription = in.readString();
        medecine = in.readString();
    }

    public static final Creator<alertnot> CREATOR = new Creator<alertnot>() {
        @Override
        public alertnot createFromParcel(Parcel in) {
            return new alertnot(in);
        }

        @Override
        public alertnot[] newArray(int size) {
            return new alertnot[size];
        }
    };

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getEmail_address() {
        return email_address;
    }

    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPat_pass() {
        return pat_pass;
    }

    public void setPat_pass(String pat_pass) {
        this.pat_pass = pat_pass;
    }

    public String getDoc_pass() {
        return doc_pass;
    }

    public void setDoc_pass(String doc_pass) {
        this.doc_pass = doc_pass;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getMinit() {
        return minit;
    }

    public void setMinit(String minit) {
        this.minit = minit;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMedecine() {
        return medecine;
    }

    public void setMedecine(String medecine) {
        this.medecine = medecine;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(pat_pass);
        parcel.writeString(doc_pass);
        parcel.writeString(hour);
        parcel.writeString(minit);
        parcel.writeString(time);
        parcel.writeString(full_name);
        parcel.writeString(email_address);
        parcel.writeString(password);
        parcel.writeString(image);
        parcel.writeString(departement);
        parcel.writeString(discription);
        parcel.writeString(medecine);
    }
}
