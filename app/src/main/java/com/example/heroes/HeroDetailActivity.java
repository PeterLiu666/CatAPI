package com.example.heroes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HeroDetailActivity extends AppCompatActivity {
    private TextView name;
    private TextView description;
    private TextView ranking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero_detail);

        wireWidgets();

    }

    public void wireWidgets()
    {
        name = findViewById(R.id.textView_name_detail);
        description = findViewById(R.id.textView_description_detail);
        ranking = findViewById(R.id.textView_ranking_detail);
    }
}
