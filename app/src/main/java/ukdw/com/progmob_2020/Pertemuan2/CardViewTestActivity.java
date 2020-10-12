package ukdw.com.progmob_2020.Pertemuan2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import ukdw.com.progmob_2020.Adapter.MahasiswaCardAdapter;
import ukdw.com.progmob_2020.Model.Mahasiswa;
import ukdw.com.progmob_2020.R;

public class CardViewTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view_test);

        //variabel
        RecyclerView rv = (RecyclerView)findViewById(R.id.rvLatihan);
        MahasiswaCardAdapter mahasiswaCardAdapter;

        //data dummy
        List<Mahasiswa> mahasiswaList = new ArrayList<Mahasiswa>();

        //generate data mahasiswa
        Mahasiswa m1 = new Mahasiswa("Julio","72180203","082242113275");
        Mahasiswa m2 = new Mahasiswa("Yose","72180204","082242113271");
        Mahasiswa m3 = new Mahasiswa("Deden","72180205","082242113272");
        Mahasiswa m4 = new Mahasiswa("Dito","72180206","082242113273");
        Mahasiswa m5 = new Mahasiswa("Dica","72180207","082242113274");
        Mahasiswa m6 = new Mahasiswa("Rahul","72180208","082242113278");
        Mahasiswa m7 = new Mahasiswa("Acen","72180209","082242113279");

        mahasiswaList.add(m1);
        mahasiswaList.add(m2);
        mahasiswaList.add(m3);
        mahasiswaList.add(m4);
        mahasiswaList.add(m5);
        mahasiswaList.add(m6);
        mahasiswaList.add(m7);

        mahasiswaCardAdapter = new MahasiswaCardAdapter(CardViewTestActivity.this);
        mahasiswaCardAdapter.setMahasiswaList(mahasiswaList);

        rv.setLayoutManager(new LinearLayoutManager(CardViewTestActivity.this));
        rv.setAdapter(mahasiswaCardAdapter);

        //action
    }
}