package hotel.hotel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Hotel> hoteis;
    private HotelAdapter hotelAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hoteis = getHoteis();
        hotelAdapter = new HotelAdapter(this, hoteis);
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(hotelAdapter);

    }

    private List<Hotel>getHoteis(){
        List<Hotel> aux = new ArrayList<>();
        aux.add(new Hotel(0, "Hotel 1", "Avenida 1", 2f));
        aux.add(new Hotel(1, "Hotel 2", "Avenida 2", 5f));
        aux.add(new Hotel(2, "Hotel 3", "Avenida 3", 4f));
        aux.add(new Hotel(3, "Hotel 4", "Avenida 4", 3f));
        return aux;
    }
}
