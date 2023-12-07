package org.example.model;

public class Pet {
    private String type;
    private String name;
    private String breed;
    private int age;

    public Pet() {
    }

    public Pet(String type, String name, String breed, int age) {
        this.type = type;
        this.name = name;
        this.breed = breed;
        this.age = age;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getBreed() {
        return breed;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Pet - "+ type + '\'' +
                ", name ='" + name + '\'' +
                ", breed ='" + breed + '\'' +
                ", age =" + age;
    }
}
