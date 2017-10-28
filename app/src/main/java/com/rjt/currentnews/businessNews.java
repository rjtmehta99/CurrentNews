package com.rjt.currentnews;

import android.graphics.Color;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageButton;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.rjt.currentnews.model.Article;
import com.rjt.currentnews.model.Result;

import java.util.ArrayList;

public class businessNews extends AppCompatActivity {
    public final String TWSJ_URL = "https://newsapi.org/v1/articles?source=the-wall-street-journal&sortBy=top&apiKey=63d6ac19a44a4b5aa2899f4d4b61fe55";
    public final String TE_URL = "https://newsapi.org/v1/articles?source=the-economist&sortBy=top&apiKey=63d6ac19a44a4b5aa2899f4d4b61fe55";
    public final String FT_URL = "https://newsapi.org/v1/articles?source=financial-times&sortBy=top&apiKey=63d6ac19a44a4b5aa2899f4d4b61fe55";
    public final String BL_URL = "https://newsapi.org/v1/articles?source=bloomberg&sortBy=top&apiKey=63d6ac19a44a4b5aa2899f4d4b61fe55";

    ImageButton twsjButton, teButton, ftButton, blButton;
    GridLayout gridLayout;
    Gson gson = new Gson();



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setTitle("Business News");
        setContentView(R.layout.activity_business_news);

        //getActionBar().setTitle("Business News");


        twsjButton = (ImageButton) findViewById(R.id.twsjButton);
        //twsjButton.setBackgroundColor(Color.parseColor("#000000"));
        twsjButton.setBackground(null);

        teButton = (ImageButton) findViewById(R.id.teButton);
        teButton.setBackground(null);
        //teButton.setBackgroundColor(Color.parseColor("#000000"));

        ftButton = (ImageButton) findViewById(R.id.ftButton);
        ftButton.setBackground(null);
        //ftButton.setBackgroundColor(Color.parseColor("#000000"));

        blButton = (ImageButton) findViewById(R.id.blButton);
        blButton.setBackground(null);
        //blButton.setBackgroundColor(Color.parseColor("#000000"));

        //ftButton = (ImageButton) findViewById(R.)

        StringRequest request1 = new StringRequest(Request.Method.GET, TWSJ_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response1) {
                Log.i("TWSJResponse:", response1);
                Result result1 = gson.fromJson(response1, Result.class);
                if (result1 != null) {
                    for (Article res1 : result1.getArticles()) {
                        Log.i("TWSJURL", res1.getUrl());
                    }
                    for (Article res1 : result1.getArticles()) {
                        Log.i("TSWJTitle", res1.getTitle());
                    }
                    for (Article res1 : result1.getArticles()) {
                        Log.i("TWSJurlToImage", res1.getUrlToImage());
                    }
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //Error detected
                Log.i("Error", "Error in TWSJ");
                error.printStackTrace();
            }
        });
        ConnectionManager.getInstance(this).add(request1);

        StringRequest request2 = new StringRequest(Request.Method.GET, TE_URL, new Response.Listener<String>()
        {
            @Override
            public void onResponse(String response2) {
                Log.i("TEResponse:", response2);
                Result result2 = gson.fromJson(response2, Result.class);
                if (result2 != null) {
                    for (Article res2 : result2.getArticles()) {
                        Log.i("TEJURL", res2.getUrl());
                    }
                    for (Article res2 : result2.getArticles()) {
                        Log.i("TETitle", res2.getTitle());
                    }
                    for (Article res2 : result2.getArticles()) {
                        Log.i("TEurlToImage", res2.getUrlToImage());
                    }
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //Error detected
                Log.i("Error", "Error in TE");
                error.printStackTrace();
            }
        });
        ConnectionManager.getInstance(this).add(request2);



        StringRequest request3 = new StringRequest(Request.Method.GET, FT_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response3) {
                Log.i("FTResponse:", response3);
                Result result3 = gson.fromJson(response3, Result.class);
                if (result3 != null) {
                    for (Article res3 : result3.getArticles()) {
                        Log.i("FTUrl", res3.getUrl());
                    }
                    for (Article res3 : result3.getArticles()) {
                        Log.i("FTTitle", res3.getTitle());
                    }
                    for (Article res3 : result3.getArticles()) {
                        Log.i("FTurlToImage", res3.getUrlToImage());
                    }
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //Error detected
                Log.i("Error", "Error in FT");
                error.printStackTrace();
            }
        });
        ConnectionManager.getInstance(this).add(request3);


        StringRequest request4 = new StringRequest(Request.Method.GET, BL_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response4) {
                Log.i("BLResponse:", response4);
                Result result4 = gson.fromJson(response4, Result.class);
                if (result4 != null) {
                    for (Article res4 : result4.getArticles()) {
                        Log.i("BLUrl", res4.getUrl());
                    }
                    for (Article res4 : result4.getArticles()) {
                        Log.i("BLTitle", res4.getTitle());
                    }
                    for (Article res4 : result4.getArticles()) {
                        Log.i("BLurlToImage", res4.getUrlToImage());
                    }
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                //Error detected
                Log.i("Error", "Error in BL");
                error.printStackTrace();
            }
        });
        ConnectionManager.getInstance(this).add(request4);

    }
}
