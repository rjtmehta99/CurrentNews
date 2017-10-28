package com.rjt.currentnews;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.rjt.currentnews.model.Article;
import com.rjt.currentnews.model.Result;

public class nationalNews extends AppCompatActivity
{
    public final String HINDU_URL = "https://newsapi.org/v1/articles?source=the-hindu&sortBy=latest&apiKey=63d6ac19a44a4b5aa2899f4d4b61fe55";
    public final String TOI_URL = " https://newsapi.org/v1/articles?source=the-times-of-india&sortBy=latest&apiKey=63d6ac19a44a4b5aa2899f4d4b61fe55";
    Button hinduImg;
    Button toiImg;
    Gson gson = new Gson();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setTitle("National News");
        setContentView(R.layout.activity_national_news);
        StringRequest request = new StringRequest(Request.Method.GET, HINDU_URL, new Response.Listener<String>()
        {
            @Override
            public void onResponse(String response)
            {
                Log.i("Response:", response);
                //Correct response
                //Instantiate Post object
                //Post myPost = gson.fromJson(response, Post.class);
                Result result = gson.fromJson(response, Result.class);
                //Article article = gson.fromJson(response, Article.class);

                if(result !=null )
                {
                    for(Article res : result.getArticles())
                    {
                        Log.i("URL", res.getUrl());
                        //Log.i("Title", res.getTitle());
                        //Log.i("urlToImage", res.getUrlToImage());
                    }
                    for(Article res : result.getArticles())
                    {
                        //   Log.i("URL", res.getUrl());
                        Log.i("Title", res.getTitle());
                        //Log.i("urlToImage", res.getUrlToImage());
                    }
                    for(Article res : result.getArticles())
                    {
                        //   Log.i("URL", res.getUrl());
                        //Log.i("Title", res.getTitle());
                        Log.i("urlToImage", res.getUrlToImage());
                    }
                }
                //Log.i("Article", article.toString());
            }
        }, new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                //Error detected
                error.printStackTrace();
            }
        });
        ConnectionManager.getInstance(this).add(request);



        //USING OKHTTP ONLY
        /*OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(HINDU_URL)
                .build();

        client.newCall(request).enqueue(new Callback()
        {
            @Override
            public void onFailure(Call call, IOException e)
            {

            }

            //If the call is successful then this is called else onFailure is called
            @Override
            public void onResponse(Call call, Response response) throws IOException
            {
                Log.i("Response:", response.toString());
            }
        }); */


        //MyAsyncTask myAsyncTask = new MyAsyncTask();
        //myAsyncTask.execute("Send", "Nudes");

        StringRequest request1 = new StringRequest(Request.Method.GET, TOI_URL, new Response.Listener<String>()
        {
            @Override
            public void onResponse(String response1)
            {
                Log.i("TOIResponse:", response1);
                Result result1 = gson.fromJson(response1, Result.class);
                if(result1 !=null )
                {
                    for(Article res1 : result1.getArticles())
                    {
                        Log.i("TOIURL", res1.getUrl());
                    }
                    for(Article res1 : result1.getArticles())
                    {
                        Log.i("TOITitle", res1.getTitle());
                    }
                    for(Article res1 : result1.getArticles())
                    {
                        Log.i("TOIurlToImage", res1.getUrlToImage());
                    }
                }

            }
        }, new Response.ErrorListener()
        {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                //Error detected
                error.printStackTrace();
            }
        });
        ConnectionManager.getInstance(this).add(request1);




















    }

    /*private class MyAsyncTask extends AsyncTask<String, Void, String>
    {

        @Override
        protected String doInBackground(String... params)
        {
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(HINDU_URL)
                    .build();

            Response response = null;
            try
            {
                response = client.newCall(request).execute();
                return response.body().string();
            }

            catch (IOException e)
            {
                e.printStackTrace();
            }



            return null;

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.i("Result:", s);
        }
    }*/
    public void displayToi(View view)
    {
        Intent intent = new Intent(getApplicationContext(), TOI.class);
        startActivity(intent);
    }

    public void displayHindu(View view)
    {
        Intent intent = new Intent(getApplicationContext(), HINDU.class);
        startActivity(intent);
    }


}
