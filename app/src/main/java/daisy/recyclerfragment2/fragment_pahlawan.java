package daisy.recyclerfragment2;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class fragment_pahlawan extends Fragment {
    private RecyclerView rv_pahlawan;
    private ArrayList<PahlawanModel> PahlawanModels = new ArrayList<>();

    public fragment_pahlawan() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View tampil =  inflater.inflate(R.layout.fragment_pahlawan, container, false);

        rv_pahlawan = tampil.findViewById(R.id.rv_pahlawan);
        rv_pahlawan.setHasFixedSize(true);
        PahlawanModels.addAll(PahlawanData.getListData());

        show();

        return tampil;
    }

    private void show() {
        rv_pahlawan.setLayoutManager(new LinearLayoutManager(getActivity()));
        PahlawanAdapter pahlawanAdapters = new PahlawanAdapter(getActivity());
        pahlawanAdapters.setPahlawanModels(PahlawanModels);
        rv_pahlawan.setAdapter(pahlawanAdapters);
    }

}
