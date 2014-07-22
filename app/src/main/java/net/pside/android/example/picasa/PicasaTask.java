package net.pside.android.example.picasa;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;

import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Created by keima on 2014/07/22.
 */
public class PicasaTask extends AsyncTask<Uri, Void, Bitmap> {

    private Context context;

    public PicasaTask(Context context) {
        this.context = context;
    }

    @Override
    protected Bitmap doInBackground(Uri... params) {
        try {
            InputStream is = context.getContentResolver().openInputStream(params[0]);
            return BitmapFactory.decodeStream(is);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
