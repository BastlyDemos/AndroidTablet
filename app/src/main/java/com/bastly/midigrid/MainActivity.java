package com.bastly.midigrid;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.bastly.bastlysdk.Bastly;
import com.bastly.bastlysdk.interfaces.MessageListener;
import com.bastly.midigrid.models.Sound;


public class MainActivity extends Activity implements MessageListener<Sound> {

    private static final String TAG = MainActivity.class.getName();
    private Bastly<Sound> bastly;
    private GridView grid;
    private static final String APIKEY = "6bdfe310-0db3-11e5-8f7e-095df2532ac5";
    private String CHANNEL = "DEMOMHD";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        grid = (GridView) findViewById(R.id.midiPad);
        bastly = new Bastly("tablet", APIKEY, this, Sound.class);
        grid.setAdapter(new ImageAdapter(this));
    }


    @Override
    protected void onResume() {
        super.onResume();

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG, "clicked " + (position + 1));
                bastly.send(CHANNEL, new Sound("tablet", String.valueOf(position + 1)));
            }
        });
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

    @Override
    public void onMessageReceived(String s, Sound sound) {

    }
}
