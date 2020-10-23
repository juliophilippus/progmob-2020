package ukdw.com.progmob_2020.CRUD;

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
import ukdw.com.progmob_2020.Model.DefaultResult;
import ukdw.com.progmob_2020.Network.GetDataService;
import ukdw.com.progmob_2020.Network.RetrofitClientInstance;
import ukdw.com.progmob_2020.R;

public class MahasiswaUpdateActivity extends AppCompatActivity {
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mahasiswa_update);

            final EditText edNimLama = (EditText)findViewById(R.id.edNimLama);
            final EditText edNama = (EditText)findViewById(R.id.edUpNama);
            final EditText edNim = (EditText)findViewById(R.id.edUpNim);
            final EditText edAlamat = (EditText)findViewById(R.id.edUpAlamat);
            final EditText edEmail = (EditText)findViewById(R.id.edUpEmail);
            Button btnEdit = (Button) findViewById(R.id.btnUpdate);
            pd = new ProgressDialog(MahasiswaUpdateActivity.this);

        Intent data = getIntent();
        if(data.getExtras() != null){
            edNama.setText(data.getStringExtra("nama"));
            edNim.setText(data.getStringExtra("nim"));
            edNimLama.setText(data.getStringExtra("nim"));
            edAlamat.setText(data.getStringExtra("alamat"));
            edEmail.setText(data.getStringExtra("email"));
        }
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pd.setTitle("Mohon Menunggu");
                pd.show();

                GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
                Call<DefaultResult> call = service.update_mhs(
                        edNama.getText().toString(),
                        edNim.getText().toString(),
                        edNimLama.getText().toString(),
                        edAlamat.getText().toString(),
                        edEmail.getText().toString(),
                        "Kosongkan saja",
                        "72180203"
                );
                call.enqueue(new Callback<DefaultResult>() {
                    @Override
                    public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                        pd.dismiss();
                        Toast.makeText(MahasiswaUpdateActivity.this, "DATA BERHASIL DIUBAH", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(MahasiswaUpdateActivity.this, MainMhsActivity.class);
                        startActivity(intent);
                    }
                    @Override
                    public void onFailure(Call<DefaultResult> call, Throwable t) {
                        pd.dismiss();
                        Toast.makeText(MahasiswaUpdateActivity.this, "DATA TIDAK BERHASIL DIUBAH", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}