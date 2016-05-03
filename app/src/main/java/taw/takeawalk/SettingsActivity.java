package taw.takeawalk;


import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.support.v7.app.ActionBar;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.preference.RingtonePreference;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.support.v4.app.NavUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.List;

/**
 * A {@link PreferenceActivity} that presents a set of application settings. On
 * handset devices, settings are presented as a single list. On tablets,
 * settings are split by category, with category headers shown to the left of
 * the list of settings.
 * <p>
 * See <a href="http://developer.android.com/design/patterns/settings.html">
 * Android Design: Settings</a> for design guidelines and the <a
 * href="http://developer.android.com/guide/topics/ui/settings.html">Settings
 * API Guide</a> for more information on developing a Settings UI.
 */
public class SettingsActivity extends Activity {

    Intent myIntent = getIntent();

    private Spinner distUnitSp;
    private Spinner weightUnitSp;
    private Spinner defModeSp;
    private static final String[]distUnits = {"mi","km"};
    private static final String[]weightUnits = {"lbs", "kg"};
    private static final String[]modes = {"Closed path", "Direct path"};

    private Button contactsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        distUnitSp = (Spinner) findViewById(R.id.spinner1);

        ArrayAdapter<String> distAdapter = new ArrayAdapter<>(SettingsActivity.this,
                android.R.layout.simple_spinner_item,distUnits);

        distAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        distUnitSp.setAdapter(distAdapter);
        distUnitSp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // do something when a distance unit is clicked
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });

        weightUnitSp = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<String> weightAdapter = new ArrayAdapter<>(SettingsActivity.this,
                android.R.layout.simple_spinner_item,weightUnits);

        weightAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        weightUnitSp.setAdapter(weightAdapter);

        defModeSp = (Spinner) findViewById(R.id.spinner3);
        ArrayAdapter<String> modeAdapter = new ArrayAdapter<>(SettingsActivity.this,
                android.R.layout.simple_spinner_item,modes);

        modeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        defModeSp.setAdapter(modeAdapter);

        contactsButton = (Button) findViewById(R.id.button_contacts);
        contactsButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                gotoContacts(view);
            }
        });
    }

    private void gotoContacts(View view) {
        Intent toContacts = new Intent (this, ManageContactsActivity.class);
        startActivity(toContacts);
    }

}
