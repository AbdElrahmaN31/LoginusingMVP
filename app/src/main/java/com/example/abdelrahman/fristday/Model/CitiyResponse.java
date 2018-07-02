package com.example.abdelrahman.fristday.Model;

import com.google.gson.annotations.Expose;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


/**
 * Created by AbdElrahman on 6/30/2018.
 */

public class CitiyResponse {
    @SerializedName("success")
    @Expose
    private String success;
    @SerializedName("cities")
    @Expose
    private List<City> cities = null;

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

}
