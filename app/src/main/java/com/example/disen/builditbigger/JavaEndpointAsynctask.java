package com.example.disen.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.disen.myapplication.backend.myApi.MyApi;
import com.example.jokelibrary.LibraryJokeActivity;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

/**
 * Created by disen on 2/12/2018.
 */

public class JavaEndpointAsynctask extends AsyncTask<Context, Void, String> {
private static MyApi myApiService = null;
private Context context;
    private ProgressBar mProgressbar;

    public JavaEndpointAsynctask(Context context,ProgressBar progressBar){
        this.context = context;
        mProgressbar = progressBar;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        mProgressbar.setVisibility(View.VISIBLE);
    }

    @Override
protected String doInBackground(Context... params) {
        if(myApiService == null) {  // Only do this once
        MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
        new AndroidJsonFactory(), null)
        // options for running against local devappserver
        // - 10.0.2.2 is localhost's IP address in Android emulator
        // - turn off compression when running against local devappserver
        .setRootUrl("http://10.0.0.61:8080/_ah/api/")
                //.setRootUrl("http://10.0.2.2:8080/_ah/api/")
        .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
@Override
public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
        abstractGoogleClientRequest.setDisableGZipContent(true);
        }
        });
        // end options for devappserver

        myApiService = builder.build();
        }

        context = params[0];
        //String name = params[0];

        try {
        return myApiService.getJoke().execute().getJoke();
        } catch (IOException e) {
        return e.getMessage();
        }
        }

@Override
protected void onPostExecute(String result) {
    Toast.makeText(context, result, Toast.LENGTH_LONG).show();
    mProgressbar.setVisibility(View.GONE);
    Intent intent = new Intent(context, LibraryJokeActivity.class);
    intent.putExtra("joke",result);
    context.startActivity(intent);
        }
}
