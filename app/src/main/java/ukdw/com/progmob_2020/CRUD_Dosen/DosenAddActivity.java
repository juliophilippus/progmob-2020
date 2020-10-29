package ukdw.com.progmob_2020.CRUD_Dosen;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ukdw.com.progmob_2020.CRUD.MahasiswaAddActivity;
import ukdw.com.progmob_2020.Model.DefaultResult;
import ukdw.com.progmob_2020.Network.GetDataService;
import ukdw.com.progmob_2020.Network.RetrofitClientInstance;
import ukdw.com.progmob_2020.R;

public class DosenAddActivity extends AppCompatActivity {
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dosen_add);

        //variabel
        final EditText edNama = (EditText)findViewById(R.id.editTextNamaDosen);
        final EditText edNidn = (EditText)findViewById(R.id.editTextNidn);
        final EditText edAlamat = (EditText)findViewById(R.id.editTextAlamatDosen);
        final EditText edEmail = (EditText)findViewById(R.id.editTextEmailDosen);
        final EditText edGelar = (EditText)findViewById(R.id.editTextGelar);
        Button btnSimpan = (Button)findViewById(R.id.buttonSimpanDsn);
        pd = new ProgressDialog(DosenAddActivity.this);

        //action
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pd.setTitle("Mohon Menunggu");
                pd.show();

                GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
                Call<DefaultResult> call = service.add_dsn(
                        edNama.getText().toString(),
                        edNidn.getText().toString(),
                        edAlamat.getText().toString(),
                        edEmail.getText().toString(),
                        edGelar.getText().toString(),
                        "kosongkan saja diisi sembarang karena dirandom sistem",
                        "72180203" //diisi nim masing-masing
                );

                call.enqueue(new Callback<DefaultResult>() {
                    @Override
                    public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                        pd.dismiss();
                        Toast.makeText(DosenAddActivity.this,"DATA BERHASIL DISIMPAN",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<DefaultResult> call, Throwable t) {
                        pd.dismiss();
                        Toast.makeText(DosenAddActivity.this,"DATA TIDAK DAPAT DISIMPAN",Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}