package com.felipemarcelo554.graphicsAPI.domain.response;

import com.felipemarcelo554.graphicsAPI.domain.Graphic;
import com.felipemarcelo554.graphicsAPI.domain.dto.GraphicUserDto;

import java.util.List;
import java.util.stream.Collectors;

public class GraphicUserResponse {

    private List<GraphicUserDto> graphics;

    public GraphicUserResponse() {
    }

    public GraphicUserResponse(List<GraphicUserDto> graphics) {
        this.graphics = graphics;
    }

    public List<GraphicUserDto> getGraphics() {
        return graphics;
    }

    public void setGraphics(List<GraphicUserDto> graphics) {
        this.graphics = graphics;
    }

    public static GraphicUserResponse toResponse(List<Graphic> graphics){

        List<GraphicUserDto> lstDto = graphics.stream().map(graphic ->  new GraphicUserDto(graphic)).collect(Collectors.toList());

        return new GraphicUserResponse(lstDto);
    }
}
