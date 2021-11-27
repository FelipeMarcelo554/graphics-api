package com.felipemarcelo554.graphicsAPI.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Graphic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private String name;

    @OneToMany
    private List<GraphicValue> values = new ArrayList<>();

    public Graphic() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getUser() {
        return userId;
    }

    public void setUser(Long userId) {
        this.userId = userId;
    }

    public List<GraphicValue> getValues() {
        return values;
    }

    public void setValues(List<GraphicValue> values) {
        this.values = values;
    }

}
