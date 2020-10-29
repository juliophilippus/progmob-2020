package ukdw.com.progmob_2020.CRUD_Matkul;

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
import ukdw.com.progmob_2020.CRUD_Dosen.DosenAddActivity;
import ukdw.com.progmob_2020.Model.DefaultResult;
import ukdw.com.progmob_2020.Network.GetDataService;
import ukdw.com.progmob_2020.Network.RetrofitClientInstance;
import ukdw.com.progmob_2020.R;

public class MatkulAddActivity extends AppCompatActivity {
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matkul_add);

        EditText edNama = (EditText)findViewById(R.id.editTextNamaMatkul);
        EditText edKode = (EditText)findViewById(R.id.editTextKode);
        EditText edHari = (EditText)findViewById(R.id.editTextHari);
        EditText edSesi = (EditText)findViewById(R.id.editTextSesi);
        EditText edSks = (EditText)findViewById(R.id.editTextSks);
        Button btnSimpanMk = (Button)findViewById(R.id.buttonSimpanMatkul);
        pd = new ProgressDialog(MatkulAddActivity.this);

        btnSimpanMk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pd.setTitle("Mohon Menunggu");
                pd.show();

                GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
                Call<DefaultResult> call = service.add_mtkl(
                       edNama.getText().toString(),
                        edKode.getText().toString(),
                        edHari.getText().toString(),
                        edSesi.getText().toString(),
                        edSks.getText().toString(),
                        "72180203"
                );
                call.enqueue(new Callback<DefaultResult>() {
                    @Override
                    public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                        pd.dismiss();
                        Toast.makeText(MatkulAddActivity.this, "DATA BERHASIL DISIMPAN", Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<DefaultResult> call, Throwable t) {
                        pd.dismiss();
                        Toast.makeText(MatkulAddActivity.this, "DATA TIDAK DAPAT DISIMPAN", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}