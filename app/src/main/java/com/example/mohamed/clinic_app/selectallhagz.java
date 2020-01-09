package com.example.mohamed.clinic_app;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Mohamed on 17/10/2018.
 */
public class selectallhagz implements Parcelable {
    private int id;
    private String full_name;
    private String email_address;
    private String password;
    private String date;
    private String doctor_pass;
    private String patient_pass;
    private String price;


    protected selectallhagz(Parcel in) {
        id = in.readInt();
        full_name = in.readString();
        email_address = in.readString();
        password = in.readString();
        date = in.readString();
        doctor_pass = in.readString();
        patient_pass = in.readString();
        price = in.readString();
    }

    public static final Creator<selectallhagz> CREATOR = new Creator<selectallhagz>() {
        @Override
        public selectallhagz createFromParcel(Parcel in) {
            return new selectallhagz(in);
        }

        @Override
        public selectallhagz[] newArray(int size) {
            return new selectallhagz[size];
        }
    };

    public String getDoctor_pass() {
        return doctor_pass;
    }

    public void setDoctor_pass(String doctor_pass) {
        this.doctor_pass = doctor_pass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPatient_pass() {
        return patient_pass;
    }

    public void setPatient_pass(String patient_pass) {
        this.patient_pass = patient_pass;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(full_name);
        parcel.writeString(email_address);
        parcel.writeString(password);
        parcel.writeString(date);
        parcel.writeString(doctor_pass);
        parcel.writeString(patient_pass);
        parcel.writeString(price);
    }
}
