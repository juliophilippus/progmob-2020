package ukdw.com.progmob_2020;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.List;

import ukdw.com.progmob_2020.CRUD.MainMhsActivity;
import ukdw.com.progmob_2020.CRUD_Dosen.MainDsnActivity;
import ukdw.com.progmob_2020.CRUD_Matkul.MainMatkulActivity;
import ukdw.com.progmob_2020.Model.User;
import ukdw.com.progmob_2020.Pertemuan2.ListActivity;
import ukdw.com.progmob_2020.Pertemuan6.LoginActivity;
import ukdw.com.progmob_2020.Pertemuan6.PrefActivity;

public class HomeActivity extends AppCompatActivity {

    ProgressDialog pd;
    List<User> users;
    SharedPreferences session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //variabel
        ImageView imgMhs = (ImageView)findViewById(R.id.imgMhs);
        ImageView imgDsn = (ImageView)findViewById(R.id.imgDosen);
        ImageView imgMk = (ImageView)findViewById(R.id.imgMatkul);
        ImageView imgLogout = (ImageView)findViewById(R.id.imgLogout);

        //action
        imgMhs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, MainMhsActivity.class);
                startActivity(intent);
            }
        });

        imgDsn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, MainDsnActivity.class);
                startActivity(intent);
            }
        });

        imgMk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, MainMatkulActivity.class);
                startActivity(intent);
            }
        });

        imgLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = session.edit();
                editor.clear();
                editor.apply();
                finish();
                Intent Intent = new Intent(HomeActivity.this,LoginActivity.class);
                startActivity(Intent);
            }
        });
    }
}