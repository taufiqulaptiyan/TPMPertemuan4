package daisy.recyclerfragment2;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PahlawanDetail extends AppCompatActivity {
    TextView tnama,tdetail;
    ImageView ifoto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_pahlawan);

        tnama = findViewById(R.id.tvnama);
        tdetail = findViewById(R.id.tvdetail);

        Bundle bundle = getIntent().getExtras();

        String nama = bundle.getString("nama");
        String detail = bundle.getString("detail");

        tnama.setText(nama);
        tdetail.setText(detail);
        tdetail.setMovementMethod(new ScrollingMovementMethod());
    }
}
