package com.example.heroes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class HeroDetailActivity extends AppCompatActivity {
    private TextView name;
    private TextView superpower;
    private TextView ranking;
    private TextView description;

    private ImageView imageViewPortrait;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero_detail);



        wireWidgets();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent lastIntent = getIntent();


        Hero hero = lastIntent.getParcelableExtra(HeroesListActivity.EXTRA_HERO);


        name.setText(hero.getName());
        superpower.setText(hero.getSuperpower());
        ranking.setText(String.valueOf(hero.getRanking()));
        description.setText(hero.getDescription());

        int resourceImage = getResources().getIdentifier(hero.getImage(), "drawable", getPackageName());
        imageViewPortrait.setImageDrawable(getResources().getDrawable(resourceImage));






    }



    public void wireWidgets()
    {
        name = findViewById(R.id.textView_name_detail);
        superpower = findViewById(R.id.textView_superpower_detail);
        ranking = findViewById(R.id.textView_ranking_detail);
        description = findViewById(R.id.textView_description_detail);

        imageViewPortrait = findViewById(R.id.imageView_image_detail);
    }
}
