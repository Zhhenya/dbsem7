package com.db.campus.property.dto;

public class ResultInventoryDto {

    private Long id;
    private String result;
    private ObjectPropertyDto objectProperty;
    private InventoryDto inventory;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public ObjectPropertyDto getObjectProperty() {
        return objectProperty;
    }

    public void setObjectProperty(ObjectPropertyDto objectProperty) {
        this.objectProperty = objectProperty;
    }

    public InventoryDto getInventory() {
        return inventory;
    }

    public void setInventory(InventoryDto inventory) {
        this.inventory = inventory;
    }
}
