package ukdw.com.progmob_2020.CRUD;

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
            Button btnUp = (Button) findViewById(R.id.btnUpdate);
            pd = new ProgressDialog(MahasiswaUpdateActivity.this);

            btnUp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    pd.setTitle("Mohon menunggu");
                    pd.show();

                    GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
                    Call<DefaultResult> del= service.delete_mhs(
                            edNimLama.getText().toString(),
                            "72180203"

                    );

                    del.enqueue(new Callback<DefaultResult>() {
                        @Override
                        public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                            Toast.makeText(MahasiswaUpdateActivity.this,"BERHASIL DIUBAH",Toast.LENGTH_LONG).show();

                        }

                        @Override
                        public void onFailure(Call<DefaultResult> call, Throwable t) {
                            pd.dismiss();
                            Toast.makeText(MahasiswaUpdateActivity.this,"Error",Toast.LENGTH_LONG).show();
                        }
                    });

                    Call<DefaultResult> add= service.add_mhs(
                            edNama.getText().toString(),
                            edNim.getText().toString(),
                            edAlamat.getText().toString(),
                            edEmail.getText().toString(),
                            "kosongkan saja",
                            "72180203"
                    );
                    add.enqueue(new Callback<DefaultResult>() {
                        @Override
                        public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                            pd.dismiss();
                            Toast.makeText(MahasiswaUpdateActivity.this,"BERHASIL DIUBAH",Toast.LENGTH_LONG).show();

                        }

                        @Override
                        public void onFailure(Call<DefaultResult> call, Throwable t) {
                            pd.dismiss();
                            Toast.makeText(MahasiswaUpdateActivity.this,"Error",Toast.LENGTH_LONG).show();
                        }
                    });
                }
            });
    }
}