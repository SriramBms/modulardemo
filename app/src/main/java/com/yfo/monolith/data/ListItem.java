package com.yfo.monolith.data;

import com.google.gson.annotations.SerializedName;

public class ListItem {

    @SerializedName("id")
    public Integer id;
    @SerializedName("name")
    public String name;
    @SerializedName("year")
    public Integer year;
    @SerializedName("pantone_value")
    public String pantoneValue;

}
