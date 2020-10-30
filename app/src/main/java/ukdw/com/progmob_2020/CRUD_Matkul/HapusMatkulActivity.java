package ukdw.com.progmob_2020.CRUD_Matkul;

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
import ukdw.com.progmob_2020.CRUD_Dosen.HapusDsnActivity;
import ukdw.com.progmob_2020.Model.DefaultResult;
import ukdw.com.progmob_2020.Network.GetDataService;
import ukdw.com.progmob_2020.Network.RetrofitClientInstance;
import ukdw.com.progmob_2020.R;

public class HapusMatkulActivity extends AppCompatActivity {
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hapus_matkul);

        //variabel
        EditText edHapusMatkul = (EditText)findViewById(R.id.editTextHapusMatkul);
        Button btnHapusMatkul = (Button)findViewById(R.id.buttonHapusMatkul);
        pd = new ProgressDialog(HapusMatkulActivity.this);

        btnHapusMatkul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pd.setTitle("Mohon Menunggu");
                pd.show();

                GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
                Call<DefaultResult> call = service.delete_mtkl(
                        edHapusMatkul.getText().toString(),"72180203"
                );

                call.enqueue(new Callback<DefaultResult>() {
                    @Override
                    public void onResponse(Call<DefaultResult> call, Response<DefaultResult> response) {
                        pd.dismiss();
                        Toast.makeText(HapusMatkulActivity.this,"DATA BERHASIL DIHAPUS",Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(HapusMatkulActivity.this, MainMatkulActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<DefaultResult> call, Throwable t) {
                        pd.dismiss();
                        Toast.makeText(HapusMatkulActivity.this,"DATA TIDAK BERHASIL DIHAPUS",Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}