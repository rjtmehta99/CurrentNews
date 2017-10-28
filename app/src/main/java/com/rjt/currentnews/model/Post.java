package com.rjt.currentnews.model;

/*
This contains all the information we want from a post i.e. Hindu News
*/

import com.google.gson.annotations.SerializedName;

public class Post
{
    /*
    Serialized is used to match JSON entry of title with our Post.java
    and GSON will run through all of these and will create their respective variables
    */

    @SerializedName("title")
     String status;
     //public String getSta()
    //{
      //  return title;
    //}

    @SerializedName("url")
     String source;

    @SerializedName("urlToImage")
     String sortBy;

    //@Override
    /*public String toString() {
        return status + source + sortBy;
    }*/

}
