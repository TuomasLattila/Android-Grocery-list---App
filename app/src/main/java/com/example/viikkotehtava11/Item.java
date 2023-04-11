package com.example.viikkotehtava11;

public class Item  {
    private String name, description;
    private int id;

    public Item(String name, String description, int id)    {
        this.name = name;
        this.description = description;
        this.id = id;
    }

    public String getName()   {
        return name;
    }

    public String getDescription()  {
        return ("Muista: " + description);
    }

    public void setName(String newName)   {
        this.name = newName;
    }

    public void setDescription(String newDescription)   {
        this.description = newDescription;
    }

    public int getId()  {
        return id;
    }
}
