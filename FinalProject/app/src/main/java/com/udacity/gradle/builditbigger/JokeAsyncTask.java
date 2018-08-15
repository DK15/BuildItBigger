package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;

import java.io.IOException;

class JokeAsyncTask extends AsyncTask<Context, Void, String> {

    private static MyApi myApi = null;
    private Context context;

    @Override
    protected String doInBackground(Context... params) {

        if (myApi == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(),
                    null).setRootUrl("http://10.0.2.2:8080/_ah/api/");

            myApi = builder.build();
        }

        context = params[0];

        try {
            return myApi.tellJoke().execute().getData();
        } catch (IOException e) {
            return e.getLocalizedMessage();
        }
    }

    private JokeListener jokeListener;

    public interface JokeListener {
        void onComplete(String result);
    }

    public JokeAsyncTask(JokeListener listener) {
        jokeListener = listener;
    }

    @Override
    protected void onPostExecute(String result) {

        if (result != null) {
            jokeListener.onComplete(result);

        }
    }
}
