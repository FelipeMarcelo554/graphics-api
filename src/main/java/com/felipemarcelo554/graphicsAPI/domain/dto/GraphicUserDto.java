package com.felipemarcelo554.graphicsAPI.domain.dto;

import com.felipemarcelo554.graphicsAPI.domain.Graphic;
import com.felipemarcelo554.graphicsAPI.domain.GraphicValue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GraphicUserDto {

    private String graphicName;

    private List<ValuesDto> values = new ArrayList<>();

    public GraphicUserDto() {
    }

    public GraphicUserDto(Graphic graphic) {

        this.graphicName = graphic.getName();

        List<ValuesDto> values = new ArrayList<>();

        for (GraphicValue graphicValue :
                graphic.getValues()) {

            Optional<ValuesDto> optValues = values.stream().filter(x -> x.getName().equals(graphicValue.getName())).findFirst();
            if (optValues.isPresent()) {
                optValues.get().setValues(optValues.get().getValues().concat(", " + graphicValue.getValue()));
            } else {
                values.add(
                        new ValuesDto(graphicValue.getName(), graphicValue.getValue())
                );
            }
        }

        this.values = values;
    }

    public String getGraphicName() {
        return graphicName;
    }

    public void setGraphicName(String graphicName) {
        this.graphicName = graphicName;
    }

    public List<ValuesDto> getValues() {
        return values;
    }

    public void setValues(List<ValuesDto> values) {
        this.values = values;
    }
}
