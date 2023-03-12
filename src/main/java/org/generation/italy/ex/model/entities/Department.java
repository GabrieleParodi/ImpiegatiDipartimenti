package org.generation.italy.ex.model.entities;

public class Dipartimento {
    private Long id;
    private String name;
    private String address;
    private int maxCapacity;

    public Dipartimento(Long id, String name, String address, int maxCapacity) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.maxCapacity = maxCapacity;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }
}
