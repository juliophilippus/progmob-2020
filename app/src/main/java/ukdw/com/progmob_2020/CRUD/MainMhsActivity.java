package ukdw.com.progmob_2020.CRUD;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import ukdw.com.progmob_2020.R;

public class MainMhsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_mhs);

        //variabel
        Button btnLihatMhs = (Button)findViewById(R.id.buttonGetMhs);
        Button btnTambahMhs = (Button)findViewById(R.id.buttonAddMhs);
        Button btnDelMhs = (Button)findViewById(R.id.buttonDelMhs);
        Button btnUpdateMhs = (Button)findViewById(R.id.buttonUpdateMhs);

        //action
        btnLihatMhs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMhsActivity.this, MahasiswaGetAllActivity.class);
                startActivity(intent);
            }
        });

        btnTambahMhs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMhsActivity.this, MahasiswaAddActivity.class);
                startActivity(intent);
            }
        });

        btnDelMhs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMhsActivity.this, HapusMhsActivity.class);
                startActivity(intent);
            }
        });

        btnUpdateMhs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMhsActivity.this, MahasiswaUpdateActivity.class);
                startActivity(intent);
            }
        });
    }
}