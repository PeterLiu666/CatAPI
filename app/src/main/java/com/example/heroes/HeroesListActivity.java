package com.example.heroes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class HeroesListActivity extends AppCompatActivity
{
    private List<Hero> heroesList;
    private ListView heroesListView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heroes_list);

        wireWidgets();

        InputStream inputHeroesFile = getResources().openRawResource(R.raw.heroes);


        String json = readFile(inputHeroesFile);


        // create a gson object
        Gson gson = new Gson();
        // read your json file into an array of questions
        Hero[] heroesArray =  gson.fromJson(json, Hero[].class);
        // convert your array to a list using the Arrays utility class
        heroesList = Arrays.asList(heroesArray);

        ArrayAdapter<Hero> heroesListAdapter = new ArrayAdapter<Hero>(this, android.R.layout.simple_list_item_1, heroesList);
        heroesListView = heroesListAdapter;



    }
    public void wireWidgets()
    {
        heroesListView = findViewById(R.id.ListView_heroesList_list);
    }


    public String readFile(InputStream inputStream)
    {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        byte buf[] = new byte[1024];
        int len;
        try
        {
            while ((len = inputStream.read(buf)) != -1)
            {
                outputStream.write(buf, 0, len);
            }
            outputStream.close();
            inputStream.close();
        }
        catch (IOException e)
        {

        }
        return outputStream.toString();
    }

}


