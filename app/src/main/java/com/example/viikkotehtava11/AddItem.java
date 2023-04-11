package com.example.viikkotehtava11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class AddItem extends AppCompatActivity {

    private ItemStorage storage;
    private EditText editTextName, editTextDesc;
    private Button addItemButton;
    private ImageView imgBackButton;
    private Item newItem;
    private int idCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        storage = ItemStorage.getInstance();

        editTextName = findViewById(R.id.editTextName);
        editTextDesc = findViewById(R.id.editTextDescription);
        addItemButton = findViewById(R.id.addItemButton);
        imgBackButton = findViewById(R.id.imgBackButton);
    }

    public void addItem(View view)  {
        idCounter = storage.getLastId();
        idCounter++;
        newItem = new Item(editTextName.getText().toString(), editTextDesc.getText().toString(), idCounter);
        storage.addItem(newItem);

        //clear textedit
        editTextDesc.setText("");
        editTextName.setText("");
    }

    public void switchToMainActivity(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}