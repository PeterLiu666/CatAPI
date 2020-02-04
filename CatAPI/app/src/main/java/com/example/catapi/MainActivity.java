package com.example.catapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
public class MainActivity extends AppCompatActivity
{
    private ImageView catImage;
    private Button getCat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wireWidgets();




        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Catservice.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final Catservice catservice = retrofit.create(Catservice.class);



        getCat.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                Call<Cat> catCall = catservice.getRandomCat("search");
                catCall.enqueue(new Callback<Cat>() {
                    @Override
                    public void onResponse(Call<Cat> call, Response<Cat> response)
                    {
                        Cat cat = response.body();

                        if(cat != null)
                        {
                            Picasso.get().load((cat.getUrl()).into(catImage));

                        }

                    }

                    @Override
                    public void onFailure(Call<Cat> call, Throwable t)
                    {
                        Log.d("ERROR", "WARNING! RESPONSE FAILURE!");

                    }
                });

            }
        });



    }
    public void wireWidgets()
    {
        catImage = findViewById(R.id.imageView_main_image);
        getCat = findViewById(R.id.button_main_getcat);
    }


}
