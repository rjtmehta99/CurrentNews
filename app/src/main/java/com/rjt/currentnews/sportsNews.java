package com.rjt.currentnews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.rjt.currentnews.model.Article;
import com.rjt.currentnews.model.Result;

public class sportsNews extends AppCompatActivity
{
    public final String ESPN_URL = "https://newsapi.org/v1/articles?source=espn&sortBy=top&apiKey=63d6ac19a44a4b5aa2899f4d4b61fe55";
    public final String ESPNC_URL = "https://newsapi.org/v1/articles?source=espn-cric-info&sortBy=latest&apiKey=63d6ac19a44a4b5aa2899f4d4b61fe55";
    public final String TSB_URL = " https://newsapi.org/v1/articles?source=the-sport-bible&sortBy=top&apiKey=63d6ac19a44a4b5aa2899f4d4b61fe55";
    public final String BBCS_URL = "https://newsapi.org/v1/articles?source=bbc-sport&sortBy=top&apiKey=63d6ac19a44a4b5aa2899f4d4b61fe55";

    Gson gson = new Gson();


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setTitle("Sports News");
        setContentView(R.layout.activity_sports_news);

        StringRequest request1 = new StringRequest(Request.Method.GET, ESPN_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response1) {
                Log.i("ESPNResponse:", response1);
                Result result1 = gson.fromJson(response1, Result.class);
                if (result1 != null)
                {

                    for (Article res1 : result1.getArticles())
                    {
                        Log.i("ESPNURL", res1.getUrl());
                    }

                    for (Article res1 : result1.getArticles())
                    {
                        Log.i("ESPNTitle", res1.getTitle());
                    }
                    for (Article res1 : result1.getArticles())
                    {
                        Log.i("ESPNurlToImage", res1.getUrlToImage());
                    }
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //Error detected
                Log.i("Error", "Error in ESPN");
                error.printStackTrace();
            }
        });
        ConnectionManager.getInstance(this).add(request1);

        StringRequest request2 = new StringRequest(Request.Method.GET, ESPNC_URL, new Response.Listener<String>()
        {
            @Override
            public void onResponse(String response2) {
                Log.i("ESPNCResponse:", response2);
                Result result2 = gson.fromJson(response2, Result.class);
                if (result2 != null) {
                    for (Article res2 : result2.getArticles()) {
                        Log.i("ESPNCJURL", res2.getUrl());
                    }
                    for (Article res2 : result2.getArticles()) {
                        Log.i("ESPNCTitle", res2.getTitle());
                    }
                    for (Article res2 : result2.getArticles()) {
                        Log.i("ESPNCurlToImage", res2.getUrlToImage());
                    }
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //Error detected
                Log.i("Error", "Error in ESPNC");
                error.printStackTrace();
            }
        });
        ConnectionManager.getInstance(this).add(request2);



        StringRequest request3 = new StringRequest(Request.Method.GET, TSB_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response3) {
                Log.i("TSBResponse:", response3);
                Result result3 = gson.fromJson(response3, Result.class);
                if (result3 != null) {
                    for (Article res3 : result3.getArticles()) {
                        Log.i("TSBUrl", res3.getUrl());
                    }
                    for (Article res3 : result3.getArticles()) {
                        Log.i("TSBTitle", res3.getTitle());
                    }
                    for (Article res3 : result3.getArticles()) {
                        Log.i("TSBurlToImage", res3.getUrlToImage());
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


        StringRequest request4 = new StringRequest(Request.Method.GET, BBCS_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response4) {
                Log.i("BBCSResponse:", response4);
                Result result4 = gson.fromJson(response4, Result.class);
                if (result4 != null) {
                    for (Article res4 : result4.getArticles()) {
                        Log.i("BBCSUrl", res4.getUrl());
                    }
                    for (Article res4 : result4.getArticles()) {
                        Log.i("BBCSTitle", res4.getTitle());
                    }
                    for (Article res4 : result4.getArticles()) {
                        Log.i("BBCSurlToImage", res4.getUrlToImage());
                    }
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                //Error detected
                Log.i("Error", "Error in BBCS");
                error.printStackTrace();
            }
        });
        ConnectionManager.getInstance(this).add(request4);

       }
}
