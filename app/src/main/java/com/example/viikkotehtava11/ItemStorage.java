package com.example.viikkotehtava11;

import java.io.Serializable;
import java.util.ArrayList;

public class ItemStorage implements Serializable{
    private ArrayList<Item> itemList = new ArrayList<>();

    private static ItemStorage storage = null;

    private ItemStorage()   {
    }

    public static ItemStorage getInstance() {
        if (storage == null) {
            storage = new ItemStorage();
        }
        return storage;
    }

    public void addItem(Item newItem)   {
        itemList.add(newItem);
    }

    public ArrayList<Item>  getItemList()   {
        return itemList;
    }

    public void removeItem(int id)   {
        int i = 0;
        for (Item item: itemList)   {
            if (item.getId() == id) {
                break;
            }
            i++;
        }
        itemList.remove(i);
    }

    public int getLastId()  {
        int lastId = 0;

        for (Item item: itemList)   {
            if (lastId < item.getId())  {
                lastId = item.getId();
            }
        }
        return lastId;
    }

    public void alphabeticalOrder() {
        int i, j;
        Item tempItem;

        for (i = 0; i < itemList.size(); i++)   {
            for (j = i+1; j < itemList.size(); j++)  {
                if (itemList.get(i).getName().toLowerCase().compareTo(itemList.get(j).getName().toLowerCase()) > 0)    {
                    tempItem = itemList.get(i);
                    itemList.set(i, itemList.get(j));
                    itemList.set(j, tempItem);
                }
            }
        }
    }

    public void timeOrder() {
        int i, j;
        Item tempItem;

        for (i = 0; i < itemList.size(); i++)   {
            for (j = i+1; j < itemList.size(); j++)  {
                if (itemList.get(i).getId() > itemList.get(j).getId())    {
                    tempItem = itemList.get(i);
                    itemList.set(i, itemList.get(j));
                    itemList.set(j, tempItem);
                }
            }
        }
    }
}