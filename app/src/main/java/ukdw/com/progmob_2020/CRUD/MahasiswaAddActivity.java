package ukdw.com.progmob_2020.CRUD;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ukdw.com.progmob_2020.Adapter.MahasiswaCRUDRecyclerAdapter;
import ukdw.com.progmob_2020.Model.DefaultResult;
import ukdw.com.progmob_2020.Model.Mahasiswa;
import ukdw.com.progmob_2020.Network.GetDataService;
import ukdw.com.progmob_2020.Network.RetrofitClientInstance;
import ukdw.com.progmob_2020.R;

public class MahasiswaAddActivity extends AppCompatActivity {
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mahasiswa_add);

        //variabel
        final EditText edNama = (EditText)findViewById(R.id.editTextNama);
        final EditText edNim = (EditText)findViewById(R.id.editTextNim);
        final EditText edAlamat = (EditText)findViewById(R.id.editTextAlamat);
        final EditText edEmail = (EditText)findViewById(R.id.editTextEmail);
        Button btnSimpan = (Button)findViewById(R.id.buttonSimpanMhs);
        pd = new ProgressDialog(MahasiswaAddActivity.this);

        //action
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pd.setTitle("Mohon Menunggu");
                pd.show();

                GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
                Call<DefaultResult> call = service.add_mhs(
                     edNama.getText().toString(),
                     edNim.getText().toString(),
                     edAlamat.getText().toString(),
                     edEmail.getText().toString(),
                        "kosongkan saja diisi sembarang karena dirandom sistem",
                        "72180203" //diisi nim masing-masing
                );

                call.enqueue(new Callback<DefaultResult>() {
                    @Override
                    public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                        pd.dismiss();
                        Toast.makeText(MahasiswaAddActivity.this,"DATA BERHASIL DISIMPAN",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<DefaultResult> call, Throwable t) {
                        pd.dismiss();
                        Toast.makeText(MahasiswaAddActivity.this,"GAGAL",Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}