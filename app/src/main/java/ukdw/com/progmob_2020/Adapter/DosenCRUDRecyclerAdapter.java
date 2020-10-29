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
import ukdw.com.progmob_2020.CRUD_Dosen.DosenUpdateActivity;
import ukdw.com.progmob_2020.Model.Dosen;
import ukdw.com.progmob_2020.Model.Mahasiswa;
import ukdw.com.progmob_2020.R;

public class DosenCRUDRecyclerAdapter extends RecyclerView.Adapter<DosenCRUDRecyclerAdapter.ViewHolder> {
    private Context context;
    private List<Dosen> dosenList;

    public DosenCRUDRecyclerAdapter(Context context) {
        this.context = context;
        dosenList = new ArrayList<>();
    }

    public DosenCRUDRecyclerAdapter(List<Dosen> dosenList){
        this.dosenList = dosenList;
    }

    public List<Dosen> getDosenList() {
        return dosenList;
    }

    public void setDosenList(List<Dosen> dosenList) {
        this.dosenList = dosenList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_cardview_dosen, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Dosen d = dosenList.get(position);

        holder.txtNama.setText(d.getNama());
        holder.txtNidn.setText(d.getNidn());
        holder.txtAlamat.setText(d.getAlamat());
        holder.txtEmail.setText(d.getEmail());
        holder.txtGelar.setText(d.getGelar());
        holder.d = d;
    }

    @Override
    public int getItemCount() {
        return dosenList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView txtNama, txtNidn, txtAlamat ,txtEmail ,txtGelar;
        private RecyclerView rvGetDsnAll;
        Dosen d;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNama = itemView.findViewById(R.id.txtNama);
            txtNidn = itemView.findViewById(R.id.txtNidn);
            txtAlamat = itemView.findViewById(R.id.txtAlamat);
            txtEmail = itemView.findViewById(R.id.txtEmail);
            txtGelar = itemView.findViewById(R.id.txtGelar);
            rvGetDsnAll = itemView.findViewById(R.id.rvGetDsnAll);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(itemView.getContext(), DosenUpdateActivity.class);
                    intent.putExtra("nidn",d.getNidn());
                    intent.putExtra("nama",d.getNama());
                    intent.putExtra("alamat",d.getAlamat());
                    intent.putExtra("email",d.getEmail());
                    intent.putExtra("gelar",d.getGelar());

                    itemView.getContext().startActivity(intent);
                }
            });
        }
    }
}
