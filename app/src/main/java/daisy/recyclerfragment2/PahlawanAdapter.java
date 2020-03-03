package daisy.recyclerfragment2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PahlawanAdapter extends RecyclerView.Adapter<PahlawanAdapter.ViewHolder> {
    private ArrayList<PahlawanModel> pahlawanModels;
    private Context context;

    public PahlawanAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemRow= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pahlawan,parent,false);
        return new ViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Glide.with(context).load(getPahlawanModels().get(position).getHeroImages()).into(holder.gambar);
        holder.nama_pahlawan.setText(getPahlawanModels().get(position).heroNames);
        holder.deskripsi.setText(getPahlawanModels().get(position).heroDetails);

        holder.itempahlawan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context,PahlawanDetail.class);
                intent.putExtra("foto",getPahlawanModels().get(position).getHeroImages());
                intent.putExtra("nama",getPahlawanModels().get(position).getHeroNames());
                intent.putExtra("detail",getPahlawanModels().get(position).getHeroDetails());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return getPahlawanModels().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView gambar;
        private TextView nama_pahlawan,deskripsi;
        LinearLayout itempahlawan;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            gambar=itemView.findViewById(R.id.gambar);
            nama_pahlawan=itemView.findViewById(R.id.nama_pahlawan);
            deskripsi=itemView.findViewById(R.id.deskripsi);
            itempahlawan = itemView.findViewById(R.id.itempahlawan);
        }
    }

    public ArrayList<PahlawanModel> getPahlawanModels() {
        return pahlawanModels;
    }

    public void setPahlawanModels(ArrayList<PahlawanModel> pahlawanModels) {
        this.pahlawanModels = pahlawanModels;
    }
}

