package ukdw.com.progmob_2020.Pertemuan6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.content.SharedPreferences;
import android.widget.Button;

import ukdw.com.progmob_2020.R;

public class PrefActivity extends AppCompatActivity {
    String isLogin = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pref);

        Button btnPref = (Button)findViewById(R.id.btnPref);

        SharedPreferences pref = PrefActivity.this.getSharedPreferences("prefs_file",MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();

        isLogin = pref.getString("isLogin","0");

        if(isLogin.equals("1")){
            btnPref.setText("logout");
        }else {
            btnPref.setText(("Login"));
        }

        btnPref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isLogin = pref.getString("isLogin","0");
                if(isLogin.equals("0")){
                    editor.putString("isLogin","1");
                    btnPref.setText("Logout");
                }else{
                    editor.putString("isLogin","0");
                    btnPref.setText("Login");
                }
                editor.commit();
            }
        });

    }
}