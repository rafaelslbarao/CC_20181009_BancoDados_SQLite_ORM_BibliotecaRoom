package br.com.datamob.controledeuniversidade;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.datamob.controledeuniversidade.database_room.view_entity.UniversidadeCidadeEntity;

public class ListaDeUniversidadesAdapter extends ArrayAdapter<UniversidadeCidadeEntity>
{
    private LayoutInflater inflater;

    public ListaDeUniversidadesAdapter(@NonNull Context context, @NonNull List<UniversidadeCidadeEntity> objects)
    {
        super(context, R.layout.item_lista_universidades, objects);
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        Holder holder;
        if(convertView == null)
        {
            convertView = inflater.inflate(R.layout.item_lista_universidades, null);
            holder = new Holder();
            convertView.setTag(holder);
            holder.tvCodigo = convertView.findViewById(R.id.tvCodigo);
            holder.tvNome = convertView.findViewById(R.id.tvNome);
            holder.tvCidade = convertView.findViewById(R.id.tvCidade);
        }
        else
            holder = (Holder) convertView.getTag();
        //
        UniversidadeCidadeEntity item = getItem(position);
        holder.tvCodigo.setText(item.getCodigo().toString());
        holder.tvNome.setText(item.getNome_universidade());
        holder.tvCidade.setText(item.getNome_cidade() + " - " + item.getEstado());
        //
        return convertView;
    }

    private class Holder
    {
        public TextView tvCodigo;
        public TextView tvNome;
        public TextView tvCidade;
    }
}
