package com.rjt.currentnews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.rjt.currentnews.model.Article;
import com.rjt.currentnews.model.Result;

public class internationalNews extends AppCompatActivity
{
    public final String BBC_URL = "https://newsapi.org/v1/articles?source=bbc-news&sortBy=top&apiKey=63d6ac19a44a4b5aa2899f4d4b61fe55";
    public final String TIME_URL = "https://newsapi.org/v1/articles?source=time&sortBy=top&apiKey=63d6ac19a44a4b5aa2899f4d4b61fe55";
    public final String TN_URL = "https://newsapi.org/v1/articles?source=the-new-york-times&sortBy=top&apiKey=63d6ac19a44a4b5aa2899f4d4b61fe55";
    public final String TG_URL = " https://newsapi.org/v1/articles?source=the-guardian-uk&sortBy=top&apiKey=63d6ac19a44a4b5aa2899f4d4b61fe55";

    Button bbcImg, timeImg, tntyImg, tgImg;
    Gson gson = new Gson();



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setTitle("International News");
        setContentView(R.layout.activity_international_news);

        StringRequest request1 = new StringRequest(Request.Method.GET, BBC_URL, new Response.Listener<String>()
        {
            @Override
            public void onResponse(String response1)
            {
                Log.i("BBCResponse:", response1);
                Result result1 = gson.fromJson(response1, Result.class);
                if(result1 !=null )
                {
                    for(Article res1 : result1.getArticles())
                    {
                        Log.i("BBCURL", res1.getUrl());
                    }
                    for(Article res1 : result1.getArticles())
                    {
                        Log.i("BBCTitle", res1.getTitle());
                    }
                    for(Article res1 : result1.getArticles())
                    {
                        Log.i("BBCurlToImage", res1.getUrlToImage());
                    }
                }

            }
        }, new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                //Error detected
                Log.i("Error", "Error in BBC");
                error.printStackTrace();
            }
        });
        ConnectionManager.getInstance(this).add(request1);



    StringRequest request2 = new StringRequest(Request.Method.GET, TG_URL, new Response.Listener<String>()
    {
        @Override
        public void onResponse(String response2)
        {
            Log.i("BBCResponse:", response2);
            Result result2 = gson.fromJson(response2, Result.class);
            if(result2 !=null )
            {
                for(Article res2 : result2.getArticles())
                {
                    Log.i("TGurl", res2.getUrl());
                }
                for(Article res2 : result2.getArticles())
                {
                    Log.i("TGTitle", res2.getTitle());
                }
                for(Article res2 : result2.getArticles())
                {
                    Log.i("TGurlToImage", res2.getUrlToImage());
                }
            }

        }
    }, new Response.ErrorListener()
    {
        @Override
        public void onErrorResponse(VolleyError error)
        {
            //Error detected
            Log.i("Error", "Error in TG");
            error.printStackTrace();
        }
    });
        ConnectionManager.getInstance(this).add(request2);

        StringRequest request3 = new StringRequest(Request.Method.GET, TIME_URL, new Response.Listener<String>()
        {
            @Override
            public void onResponse(String response3)
            {
                Log.i("TIMEResponse:", response3);
                Result result3 = gson.fromJson(response3, Result.class);
                if(result3 !=null )
                {
                    for(Article res3 : result3.getArticles())
                    {
                        Log.i("TIMEurl", res3.getUrl());
                    }
                    for(Article res3 : result3.getArticles())
                    {
                        Log.i("TIMETitle", res3.getTitle());
                    }
                    for(Article res3 : result3.getArticles())
                    {
                        Log.i("TIMEurlToImage", res3.getUrlToImage());
                    }
                }

            }
        }, new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                //Error detected
                Log.i("Error", "Error in TIME");
                error.printStackTrace();
            }
        });
        ConnectionManager.getInstance(this).add(request3);



        StringRequest request4 = new StringRequest(Request.Method.GET, TN_URL, new Response.Listener<String>()
        {
            @Override
            public void onResponse(String response4)
            {
                Log.i("TNResponse:", response4);
                Result result4 = gson.fromJson(response4, Result.class);
                if(result4 !=null )
                {
                    for(Article res4 : result4.getArticles())
                    {
                        Log.i("TNurl", res4.getUrl());
                    }
                    for(Article res4 : result4.getArticles())
                    {
                        Log.i("TNTitle", res4.getTitle());
                    }
                    for(Article res4 : result4.getArticles())
                    {
                        Log.i("TNurlToImage", res4.getUrlToImage());
                    }
                }

            }
        }, new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                //Error detected
                Log.i("Error", "Error in TN");
                error.printStackTrace();
            }
        });
        ConnectionManager.getInstance(this).add(request4);
    }













}
