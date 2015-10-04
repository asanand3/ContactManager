package net.anandsingh.contactmanager;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SearchData extends AppCompatActivity {

    EditText searchText;
    Button search;
    TextView name, email;

    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_data);

        databaseHelper = new DatabaseHelper(this);

        searchText = (EditText) findViewById(R.id.etSearch);

        search = (Button) findViewById(R.id.btSearch);

        name = (TextView) findViewById(R.id.tvName);

        email = (TextView) findViewById(R.id.tvEmail);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cursor cursor = databaseHelper.getData(searchText.getText().toString());

                name.setText(" ");
                email.setText(" ");

                while(cursor.moveToNext())
                {
                    name.setText(cursor.getString(1));
                    email.setText(cursor.getString(3));
                }


            }
        });
    }
}
