package com.company.androidspannable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {
    private List<Contact> contactList = new ArrayList<>();
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        getSupportActionBar().hide();
        setInitialData();
        recyclerView = findViewById(R.id.list);
        ContactAdapter contactAdapter = new ContactAdapter(this, contactList);
        recyclerView.setAdapter(contactAdapter);
    }

    private void setInitialData() {

        contactList.add(new Contact(R.drawable.face, "Anna Anna", "+375291255196"));
        contactList.add(new Contact(R.drawable.face_1, "Max Max", "358742596814"));
        contactList.add(new Contact(R.drawable.face_2, "David David", "358742596814"));
        contactList.add(new Contact(R.drawable.face_3, "James James", "358742596814"));
        contactList.add(new Contact(R.drawable.face_4, "Lidia Lidia", "358742596814"));
        contactList.add(new Contact(R.drawable.face_5, "Alice Alice", "358742596814"));
        contactList.add(new Contact(R.drawable.face_6, "Mark Mark", "358742596814"));
        contactList.add(new Contact(R.drawable.face_7, "Edvard Edvard", "358742596814"));
        contactList.add(new Contact(R.drawable.face_8, "Britney Britney", "358742596814"));
        contactList.add(new Contact(R.drawable.face_9, "Antony Antony", "358742596814"));
        contactList.add(new Contact(R.drawable.face_10, "Mary Mary", "358742596814"));
    }
}