package com.company.project.model;

import javax.persistence.*;

public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String t;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return t
     */
    public String getT() {
        return t;
    }

    /**
     * @param t
     */
    public void setT(String t) {
        this.t = t;
    }
}