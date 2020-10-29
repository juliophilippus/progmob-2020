package ukdw.com.progmob_2020.CRUD_Dosen;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ukdw.com.progmob_2020.CRUD.MahasiswaUpdateActivity;
import ukdw.com.progmob_2020.CRUD.MainMhsActivity;
import ukdw.com.progmob_2020.Model.DefaultResult;
import ukdw.com.progmob_2020.Network.GetDataService;
import ukdw.com.progmob_2020.Network.RetrofitClientInstance;
import ukdw.com.progmob_2020.R;

public class DosenUpdateActivity extends AppCompatActivity {
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dosen_update);

        final EditText edNidnLama = (EditText)findViewById(R.id.edNidnLama);
        final EditText edNama = (EditText)findViewById(R.id.edUpNamaDosen);
        final EditText edNidn = (EditText)findViewById(R.id.edUpNidn);
        final EditText edAlamat = (EditText)findViewById(R.id.edUpAlamatDosen);
        final EditText edEmail = (EditText)findViewById(R.id.edUpEmailDosen);
        final EditText edGelar = (EditText)findViewById(R.id.edUpGelar);
        Button btnEdit = (Button) findViewById(R.id.btnUpdateDsn);
        pd = new ProgressDialog(DosenUpdateActivity.this);

        Intent data = getIntent();
        if(data.getExtras() != null){
            edNama.setText(data.getStringExtra("nama"));
            edNidn.setText(data.getStringExtra("nidn"));
            edAlamat.setText(data.getStringExtra("alamat"));
            edEmail.setText(data.getStringExtra("email"));
            edGelar.setText(data.getStringExtra("gelar"));
            edNidnLama.setText(data.getStringExtra("nidn"));
        }

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pd.setTitle("Mohon Menunggu");
                pd.show();

                GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
                Call<DefaultResult> call = service.update_dsn(
                        edNama.getText().toString(),
                        edNidn.getText().toString(),
                        edAlamat.getText().toString(),
                        edEmail.getText().toString(),
                        edGelar.getText().toString(),
                        "kosongkan saja",
                        "72180203",
                        edNidnLama.getText().toString()
                );
                call.enqueue(new Callback<DefaultResult>() {
                    @Override
                    public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                        pd.dismiss();
                        Toast.makeText(DosenUpdateActivity.this, "DATA BERHASIL DIUBAH", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(DosenUpdateActivity.this, MainDsnActivity.class);
                        startActivity(intent);
                    }
                    @Override
                    public void onFailure(Call<DefaultResult> call, Throwable t) {
                        pd.dismiss();
                        Toast.makeText(DosenUpdateActivity.this, "DATA TIDAK BERHASIL DIUBAH", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}