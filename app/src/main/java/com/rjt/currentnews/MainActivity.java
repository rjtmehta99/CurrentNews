package com.rjt.currentnews;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity
{
//    public final String HINDU_URL = "https://newsapi.org/v1/articles?source=the-hindu&sortBy=latest&apiKey=63d6ac19a44a4b5aa2899f4d4b61fe55";
  //  Gson gson = new Gson();
    Button nationalButton;
    Button internationalButton;
    Button businessButton;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nationalButton = (Button) findViewById(R.id.nationalButton);
        internationalButton = (Button) findViewById(R.id.internationalButton);
        businessButton = (Button) findViewById(R.id.businessButton);

        //USING VOLLEY
        // Instantiate the RequestQueue.
        //Retrieve the existing queue from the manager
//        RequestQueue queue = ConnectionManager.getInstance(this);
        //RequestQueue queue = Volley.newRequestQueue(this);

        //String url =HINDU_URL;
    /*    StringRequest request = new StringRequest(Request.Method.GET, HINDU_URL, new Response.Listener<String>() {
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
    }

    public void nationalIntent(View view)
    {
        Intent intent = new Intent(getApplicationContext(), nationalNews.class);
        startActivity(intent);
    }

    public void internationalIntent(View view)
    {
        Intent intent = new Intent(getApplicationContext(), internationalNews.class);
        startActivity(intent);
    }

    public void businessIntent(View view)
    {
        Intent intent = new Intent(getApplicationContext(), businessNews.class);
        startActivity(intent);
    }

    public void sportsIntent(View view)
    {
        Intent intent = new Intent(getApplicationContext(), sportsNews.class);
        startActivity(intent);
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
}
