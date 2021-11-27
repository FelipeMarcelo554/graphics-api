package com.felipemarcelo554.graphicsAPI.domain.dto;

public class ValuesDto {

    private String name;

    private String values;

    public ValuesDto() {
    }

    public ValuesDto(String name, String values) {
        this.name = name;
        this.values = values;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValues() {
        return values;
    }

    public void setValues(String values) {
        this.values = values;
    }

    @Override
    public String toString() {
        return "ValuesDto{" +
                "name='" + name + '\'' +
                ", values='" + values + '\'' +
                '}';
    }
}
