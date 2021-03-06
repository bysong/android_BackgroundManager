package org.bbs.android.support.v4.app;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import org.bbs.android.support.v4.backgroundmanager.R;


public class DetailActivity extends Activity {

    private BackgroundManager mBgM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBgM = prepareBackgroundManager(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mBgM.release();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        mBgM = null;
    }

    @Override
    protected void onResume() {
        super.onResume();
        getWindow().getDecorView().postDelayed(new Runnable() {
            @Override
            public void run() {
                mBgM.setColor(Color.RED);
                mBgM.onActivityResume();
            }
        }, 3000);
    }

    private BackgroundManager prepareBackgroundManager(Activity activity) {
        BackgroundManager bgM = BackgroundManager.getInstance(activity);
        bgM.attach(activity.getWindow());
        return bgM;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
