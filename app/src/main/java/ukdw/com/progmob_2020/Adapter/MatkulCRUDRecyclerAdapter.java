package ukdw.com.progmob_2020.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ukdw.com.progmob_2020.CRUD.MahasiswaUpdateActivity;
import ukdw.com.progmob_2020.CRUD_Matkul.MatkulUpdateActivity;
import ukdw.com.progmob_2020.Model.Mahasiswa;
import ukdw.com.progmob_2020.Model.Matakuliah;
import ukdw.com.progmob_2020.R;

public class MatkulCRUDRecyclerAdapter extends RecyclerView.Adapter<MatkulCRUDRecyclerAdapter.ViewHolder> {
    private Context context;
    private List<Matakuliah> matakuliahList;


    public MatkulCRUDRecyclerAdapter(Context context) {
        this.context = context;
        matakuliahList = new ArrayList<>();
    }

    public MatkulCRUDRecyclerAdapter(List<Matakuliah> matakuliahList) {
        this.matakuliahList = matakuliahList;
    }


    public List<Matakuliah> getMatakuliahList() {
        return matakuliahList;
    }

    public void setMatakuliahList(List<Matakuliah> matakuliahList) {
        this.matakuliahList = matakuliahList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_cardview_matkul,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Matakuliah mk = matakuliahList.get(position);

        holder.txtNama.setText(mk.getNama());
        holder.txtKodeMk.setText(mk.getKode());
        holder.txtHariMk.setText(mk.getHari());
        holder.txtSesiMk.setText(mk.getSesi());
        holder.txtSksMk.setText(mk.getSks());
        holder.mk = mk;
    }


    @Override
    public int getItemCount() {
        return matakuliahList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView txtNama,txtKodeMk,txtHariMk,txtSesiMk,txtSksMk;
        private RecyclerView rvMatakuliah;
        Matakuliah mk;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNama = itemView.findViewById(R.id.txtNamaMatkul);
            txtKodeMk = itemView.findViewById(R.id.txtKode);
            txtHariMk = itemView.findViewById(R.id.txtHari);
            txtSesiMk = itemView.findViewById(R.id.txtSesi);
            txtSksMk = itemView.findViewById(R.id.txtSks);
//            rvMatakuliah = itemView.findViewById(R.id.rvMatakuliah);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(itemView.getContext(), MatkulUpdateActivity.class);
                    intent.putExtra("nama",mk.getNama());
                    intent.putExtra("kode",mk.getKode());
                    intent.putExtra("hari",mk.getHari());
                    intent.putExtra("sesi",mk.getSesi());
                    intent.putExtra("sks",mk.getSks());

                    itemView.getContext().startActivity(intent);
                }
            });
        }
    }
}
