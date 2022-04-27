package com.example.oscarapp.apiMovie;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.IOException;

public class DownloadTask extends AsyncTask<String, Void, Bitmap> {


    private ImageView image;

    public DownloadTask( ImageView image) {

        this.image = image;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Bitmap doInBackground(String... strings) {
        Bitmap bitmap = null;
        try{
            bitmap = DownloadRequest.downloadImage(strings[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        image.setImageBitmap(bitmap);
    }
}

