package com.example.viikkotehtava11;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    private Button addButton, listOrderButton;
    private ImageButton calendarButton;
    private ItemStorage storage;
    private RecyclerView recyclerView;
    private ItemListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        storage = ItemStorage.getInstance();

        addButton = findViewById(R.id.addButton);
        listOrderButton = findViewById(R.id.ListOrderButton);
        calendarButton = findViewById(R.id.calendarButton);
        recyclerView = findViewById(R.id.recyclerViewMain);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ItemListAdapter(getApplicationContext(), storage.getItemList());
        recyclerView.setAdapter(adapter);
    }

    public void switchToAddItem(View view) {
        Intent intent = new Intent(this, AddItem.class);
        startActivity(intent);
    }

    public void setListInAlphabeticalOrder(View view)   {
        storage.alphabeticalOrder();
        adapter.notifyDataSetChanged();
    }

    public void setListInTimeOrder(View view)   {
        storage.timeOrder();
        adapter.notifyDataSetChanged();
    }
}