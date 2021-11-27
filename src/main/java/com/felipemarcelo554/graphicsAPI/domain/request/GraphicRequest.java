package com.felipemarcelo554.graphicsAPI.domain.request;

import com.felipemarcelo554.graphicsAPI.domain.Graphic;
import com.felipemarcelo554.graphicsAPI.domain.GraphicValue;
import com.felipemarcelo554.graphicsAPI.domain.dto.ValuesDto;

import java.util.Arrays;
import java.util.List;

public class GraphicRequest {

    private Long userId;

    private String nomeGrafico;

    private List<ValuesDto> values;


    public GraphicRequest() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getNomeGrafico() {
        return nomeGrafico;
    }

    public void setNomeGrafico(String nomeGrafico) {
        this.nomeGrafico = nomeGrafico;
    }

    public List<ValuesDto> getValues() {
        return values;
    }

    public void setValues(List<ValuesDto> values) {
        this.values = values;
    }

    @Override
    public String toString() {
        return "GraphicRequest{" +
                "userId=" + userId +
                ", nomeGrafico='" + nomeGrafico + '\'' +
                ", values=" + values +
                '}';
    }

    public static Graphic toEntity(GraphicRequest graphicRequest){

        Graphic graphic = new Graphic();

        graphic.setName(graphicRequest.getNomeGrafico());
        graphic.setUser(graphicRequest.getUserId());

        graphicRequest.getValues().forEach(valuesDto -> {

            String arr[] = valuesDto.getValues().trim().split(" ,");

            for (String s : arr) {
                graphic.getValues().add(
                        new GraphicValue(
                                valuesDto.getName(),
                                s
                        ));
            }
        });

        return graphic;
    }
}
