package io.klesogor.Lab03.DTOs;

public class CategoryDTO {
    private String name;
    private Integer id;

    protected CategoryDTO(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
