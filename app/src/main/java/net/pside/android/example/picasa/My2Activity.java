package net.pside.android.example.picasa;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;


public class My2Activity extends Activity {
    private static final String TAG = "My2Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        String action = getIntent().getAction();
        String type = getIntent().getType();

        Log.d(TAG, "action:" + action + " /type:" + type);

        Uri imageUri = intent.getParcelableExtra(Intent.EXTRA_STREAM);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        startActivity(MyActivity.createIntent(this, imageUri));
        finish();
    }
}
