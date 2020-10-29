package ukdw.com.progmob_2020.CRUD_Matkul;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import ukdw.com.progmob_2020.Adapter.DosenCRUDRecyclerAdapter;
import ukdw.com.progmob_2020.Adapter.MatkulCRUDRecyclerAdapter;
import ukdw.com.progmob_2020.CRUD_Dosen.DosenGetAllActivity;
import ukdw.com.progmob_2020.Model.Dosen;
import ukdw.com.progmob_2020.Model.Matakuliah;
import ukdw.com.progmob_2020.Network.GetDataService;
import ukdw.com.progmob_2020.Network.RetrofitClientInstance;
import ukdw.com.progmob_2020.R;


public class MatkulGetAllActivity extends AppCompatActivity {

    RecyclerView rvMtkl;
    MatkulCRUDRecyclerAdapter mtklAdapter;
    ProgressDialog pd;
    List<Matakuliah> matakuliahList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matkul_get_all);

        rvMtkl = (RecyclerView)findViewById(R.id.rvGetMatkulAll);
        pd = new ProgressDialog(this);
        pd.setTitle("Mohon Bersabar");
        pd.show();

        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        Call<List<Matakuliah>> call = service.getMatkul("72180203");

        call.enqueue(new Callback<List<Matakuliah>>() {
            @Override
            public void onResponse(Call<List<Matakuliah>> call, Response<List<Matakuliah>> response) {
                pd.dismiss();
                matakuliahList = response.body();
                mtklAdapter = new MatkulCRUDRecyclerAdapter(matakuliahList);

                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MatkulGetAllActivity.this);
                rvMtkl.setLayoutManager(layoutManager);
                rvMtkl.setAdapter(mtklAdapter);

            }

            @Override
            public void onFailure(Call<List<Matakuliah>> call, Throwable t) {
                pd.dismiss();
                Toast.makeText(MatkulGetAllActivity.this,"error",Toast.LENGTH_LONG);
            }
        });
    }
}