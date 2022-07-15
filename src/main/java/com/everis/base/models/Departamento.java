package com.everis.base.models;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonPropertyOrder({"departments", "landings", "more_categories"})
public class Departamento {
    private List<Object> departments;
    private List<Object> landings;
    private List<Object> more_categories;

    @Override
    public String toString() {
        return "{" +
                "departments='" + departments + '\'' +
                "landings='" + landings + '\'' +
                "more_categories='" + more_categories + '\'' +
                '}';
    }

    public List<Object> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Object> departments) {
        this.departments = departments;
    }

    public List<Object> getLandings() {
        return landings;
    }

    public void setLandings(List<Object> landings) {
        this.landings = landings;
    }

    public List<Object> getMore_categories() {
        return more_categories;
    }

    public void setMore_categories(List<Object> more_categories) {
        this.more_categories = more_categories;
    }
}

