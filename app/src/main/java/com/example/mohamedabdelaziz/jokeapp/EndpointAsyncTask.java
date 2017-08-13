package com.example.mohamedabdelaziz.jokeapp;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import com.example.jokefactory.JokeActivity;
import com.example.mohamedabdelaziz.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

/**
 * Created by Mohamed Abd Elaziz on 8/5/2017.
 */
class EndpointAsyncTask extends AsyncTask<Context, Void, String> {
     MyApi api = null;
     Context context;
    public static String loadedjoke = null;
    public static boolean test=false ;
    @Override
    protected String doInBackground(Context... params) {
        if (api == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new
                    AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/");
            api = builder.build();
        }
        context = params[0];
        try {
            return api.tellJoke().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        loadedjoke=result ;
        if (!test) {
            Intent intent = new Intent(context, JokeActivity.class);
            intent.putExtra("result", result);
            context.startActivity(intent);
        }
    }

}