package taw.takeawalk;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ManageContactsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mngcontacts);
        ListView myListView = (ListView) findViewById(R.id.listView);
        myListView.setChoiceMode(AbsListView.CHOICE_MODE_SINGLE);
        ArrayList<String> myStringArray1 = new ArrayList<String>();
        myStringArray1.add("Steve");
        myStringArray1.add("Bob");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, myStringArray1);
        myListView.setAdapter(arrayAdapter);
    }
}
