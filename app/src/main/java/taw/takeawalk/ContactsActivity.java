package taw.takeawalk;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class ContactsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);
    }

    public void call(View view) {
        Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:2170000000"));
        try {
            startActivity(callIntent);
        } catch (SecurityException e) {

        }
    }

    public void message(View view) {
        AlertDialog alertDialog = new AlertDialog.Builder(ContactsActivity.this).create();
        alertDialog.setTitle("Alert");
        alertDialog.setMessage("Message(s) sent!");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
            new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
        alertDialog.show();
    }
}
