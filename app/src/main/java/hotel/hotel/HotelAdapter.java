package hotel.hotel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

public class HotelAdapter extends BaseAdapter {

    private Context context;
    private List<Hotel> hoteis;

    public HotelAdapter(Context context, List<Hotel> hoteis) {
        this.context = context;
        this.hoteis = hoteis;
    }

    @Override
    public int getCount() {
        return hoteis.size();
    }

    @Override
    public Object getItem(int i) {
        return hoteis.get(i);
    }

    @Override
    public long getItemId(int i) {
        return hoteis.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        Hotel hotel = hoteis.get(i);
        ViewHolder holder = null;

        // se nao ha convertView crie uma e crie seus campos
        if (view == null) {
            view = LayoutInflater.from(context)
                    .inflate(R.layout.list_item, null);
            holder = new ViewHolder();
            holder.tvNome = view.findViewById(R.id.tvNome);
            holder.tvEndereco = view.findViewById(R.id.tvEndereco);
            holder.rbEstrelas = view.findViewById(R.id.rbEstrelas);
            view.setTag(holder);
        } else{
            holder = (ViewHolder)view.getTag();
        }
        // preencha seus campos com os dados do hotel
        holder.tvNome.setText(hotel.getNome());
        holder.tvEndereco.setText(hotel.getEndereco());
        holder.rbEstrelas.setRating(hotel.getEstrelas());

        return view;

    }

    static class ViewHolder {
        TextView tvNome;
        TextView tvEndereco;
        RatingBar rbEstrelas;
    }

}