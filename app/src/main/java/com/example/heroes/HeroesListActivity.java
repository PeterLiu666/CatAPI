package com.example.heroes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HeroesListActivity extends AppCompatActivity
{
    private List<Hero> heroesList;
    private ListView heroesListView;
    private MenuItem menu;
    ArrayAdapter<Hero> heroesListAdapter;

    public static final String EXTRA_HERO = "hero";


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.sort_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.sort_by_name:
                Collections.sort(heroesList);
                heroesListAdapter.notifyDataSetChanged();

                return true;


            case R.id.sort_by_rank:
                Collections.sort(heroesList, new Comparator<Hero>()
                {

                    @Override
                    public int compare(Hero hero, Hero t1)
                    {
                        return hero.getRanking() - t1.getRanking();
                    }
                });
                heroesListAdapter.notifyDataSetChanged();


                return true;


            default:
                Collections.sort(heroesList);
                heroesListAdapter.notifyDataSetChanged();

                return true;
        }
    }

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



        heroesListAdapter = new HeroAdapter(heroesList);
        heroesListView.setAdapter(heroesListAdapter);
        setListeners();




    }


    private class HeroAdapter extends ArrayAdapter<Hero>
    {

        private List<Hero> heroesList;



        public HeroAdapter(List<Hero> heroesList) {
            super(HeroesListActivity.this, -1, heroesList);
            this.heroesList = heroesList;

        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = getLayoutInflater();
            if(convertView == null)
            {
                convertView = inflater.inflate(R.layout.item_hero, parent, false);

            }

            TextView textViewName = convertView.findViewById(R.id.textView_name_item);
            TextView textViewDescription = convertView.findViewById(R.id.textView_description_item);
            TextView textViewRanking = convertView.findViewById(R.id.textView_ranking_item);

            textViewName.setText(heroesList.get(position).getName());
            textViewDescription.setText(heroesList.get(position).getDescription());
            textViewRanking.setText(String.valueOf(heroesList.get(position).getRanking()));




            return convertView;
        }
    }






    public void wireWidgets()
    {
        heroesListView = findViewById(R.id.ListView_heroesList_list);

    }

    public void setListeners()
    {
        heroesListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l)
            {


                Hero hero = heroesList.get(position);



                Intent targetIntent = new Intent(HeroesListActivity.this, HeroDetailActivity.class);

                targetIntent.putExtra(EXTRA_HERO, hero);

                startActivity(targetIntent);



            }
        });

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


