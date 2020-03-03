package daisy.recyclerfragment2;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    private BottomNavigationView main_navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        main_navigation = findViewById(R.id.main_navigation);
        main_navigation.setOnNavigationItemSelectedListener(this);

        if(savedInstanceState==null){
            main_navigation.setSelectedItemId(R.id.navigation_pahlawan);
        }
    }

    private void setLayout(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout, fragment).commit();
    }

    @Override
    public boolean onNavigationItemSelected( MenuItem Item) {
        switch (Item.getItemId()){
            case R.id.navigation_pahlawan:
                setLayout(new fragment_pahlawan());
                return true;

            case R.id.navigation_biodata:
                setLayout(new fragment_biodata());
                return true;
        }
        return false;
    }
}
