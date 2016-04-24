package taw.takeawalk;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        ToggleButton button = (ToggleButton) findViewById(R.id.toggleButton);
        button.setText("Direct-path");
        button.setTextOn("Closed-path");
        button.setTextOff("Direct-path");

        button.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    ((TextView)findViewById(R.id.textView)).setText("");
                    ((TextView)findViewById(R.id.textView2)).setText("or");
                    ((TextView) findViewById(R.id.editText)).setHint("Walking distance");
                    ((TextView) findViewById(R.id.editText2)).setHint("Walking time");
                } else {
                    ((TextView)findViewById(R.id.textView)).setText("Starting point:");
                    ((TextView)findViewById(R.id.textView2)).setText("Destination:");
                    ((TextView) findViewById(R.id.editText)).setHint("Current location");
                    ((TextView) findViewById(R.id.editText2)).setHint("");
                }
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

    public void goToMap(View view) {
        ToggleButton button = (ToggleButton) findViewById(R.id.toggleButton);
        Intent intent = new Intent (this, MapsActivity.class);
        if (button.isChecked()) {
            intent.putExtra("mode", "closed");
        } else {
            intent.putExtra("mode", "direct");
        }
        startActivity(intent);
    }
}
