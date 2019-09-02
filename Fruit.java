package com.royan.fruitlist;

public class Fruit
{
    private int id;
    private int calories;
    private String name;
    private int imageId;

    public Fruit(int id, String name, int imageId, int calories)
    {
        this.id = id;
        this.calories = calories;
        this.name = name;
        this.imageId = imageId;
    }

    public int getId()
    {
        return id;
    }

    public int getCalories()
    {
        return calories;
    }

    public String getName()
    {
        return name;
    }

    public int getImageId()
    {
        return imageId;
    }

    @Override
    public String toString()
    {
        return "Fruit{" +
                "id=" + id +
                ", calories=" + calories +
                ", name='" + name + '\'' +
                ", imageId=" + imageId +
                '}';
    }
}
