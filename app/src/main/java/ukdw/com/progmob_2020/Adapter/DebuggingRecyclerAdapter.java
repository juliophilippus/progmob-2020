package ukdw.com.progmob_2020.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import ukdw.com.progmob_2020.Model.Mahasiswa;
import ukdw.com.progmob_2020.Model.MahasiswaDebugging;
import ukdw.com.progmob_2020.R;

public class DebuggingRecyclerAdapter extends RecyclerView.Adapter<DebuggingRecyclerAdapter.ViewHolder> {
    private Context context;
    private List<MahasiswaDebugging> mahasiswaListDebug;

    public DebuggingRecyclerAdapter(Context context) {
        this.context = context;
        mahasiswaListDebug = new ArrayList<>();
    }

    public List<MahasiswaDebugging> getMahasiswaList() {
        return mahasiswaListDebug;
    }

    public void setMahasiswaListDebug(List<MahasiswaDebugging> mahasiswaListDebug) {
        this.mahasiswaListDebug = mahasiswaListDebug;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_list_debugging,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MahasiswaDebugging m = mahasiswaListDebug.get(position);

        holder.txtNama.setText(m.getNama());
        holder.txtNoTelp.setText(m.getNotelp());
        holder.txtNim.setText(m.getNim());
    }

    @Override
    public int getItemCount() {
        return mahasiswaListDebug.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView txtNama, txtNim, txtNoTelp;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNama = itemView.findViewById(R.id.txtNama);
            txtNim = itemView.findViewById(R.id.txtNim);
            txtNoTelp = itemView.findViewById(R.id.txtNoTelp);
        }
    }
}
