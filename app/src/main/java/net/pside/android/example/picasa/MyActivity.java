package net.pside.android.example.picasa;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;


public class MyActivity extends Activity {
    private static final String TAG = "MyActivity";

    public static Intent createIntent(Context context, Uri uri) {
        Intent intent = new Intent(context, MyActivity.class);
        intent.putExtra(Intent.EXTRA_STREAM, uri);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        String action = getIntent().getAction();
        String type = getIntent().getType();

        Log.d(TAG, "action:" + action + " /type:" + type);

        Uri imageUri = intent.getParcelableExtra(Intent.EXTRA_STREAM);

        if (imageUri != null) {

            new PicasaTask(this) {
                @Override
                protected void onPostExecute(Bitmap bitmap) {
                    super.onPostExecute(bitmap);

                    ImageView imageView = new ImageView(MyActivity.this);
                    imageView.setImageBitmap(bitmap);
                    setContentView(imageView);

                }
            }.execute(imageUri);

            Log.d(TAG, "ImageUri:" + imageUri.toString());

        }
    }
}
