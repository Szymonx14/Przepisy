package com.example.przepisy;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class listaPrzepisowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_lista_przepisow);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        String kategoriaPrzepisu = getIntent().getStringExtra("KATEGORIA");
        Toast.makeText(this, kategoriaPrzepisu, Toast.LENGTH_SHORT).show();
        ArrayList<Przepis> przepisy = RepozytoriumPrzepisow.zwrocPrzepisyZKategorii(kategoriaPrzepisu);

        ListView listView = findViewById(R.id.listViewListaPrzepisow);
        ArrayAdapter<Przepis> arrayAdapter = new ArrayAdapter<>(
                listaPrzepisowActivity.this,
                android.R.layout.simple_list_item_1,
                przepisy
        );

        /*
        1. dane -> ty ArrayList przeposy
        2. listView -> zadeklarowac i znalezc po id
        3. ArrayList
            - kontekst aplikacji - this
            - widok na pojedynczy element -> tu andtoid.R.layout. simple...
            - lsta z danymi
           4. przypisac ArrayAdpater do ListView
        */
        listView.setAdapter(arrayAdapter);
    }
}