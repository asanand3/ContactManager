package net.anandsingh.contactmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DeleteData extends AppCompatActivity {

    Button delete;

    EditText number;

    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_data);

        delete = (Button) findViewById(R.id.btnDelete);

        number = (EditText) findViewById(R.id.etNumber);

        databaseHelper = new DatabaseHelper(this);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelper.deleteData(number.getText().toString());
            }
        });


    }
}
