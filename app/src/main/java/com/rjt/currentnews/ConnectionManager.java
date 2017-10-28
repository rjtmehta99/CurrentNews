package com.rjt.currentnews;

/*
 This will be the singleton class - instantiation will be done only once and it will be shared
 */

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class ConnectionManager
{
    private static RequestQueue sQueue;

    //Method to create the static queue which is going to create an object if it doesn't exist and if it exists, it will return the object
    //Return type is RequestQueue
    public static RequestQueue getInstance(Context context)
    {
        if(sQueue == null)
        {
            sQueue = Volley.newRequestQueue(context);
        }

        return sQueue;
    }

    //RequestQueue queue = Volley.newRequestQueue(this);
}
