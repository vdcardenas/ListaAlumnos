package salesianas.listaalumnos;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by esaup on 05/11/2016.
 */

public class AdaptadorAlumnos extends RecyclerView.Adapter<AdaptadorAlumnos.ViewHolder> {

    protected VectorAlumnos contactos;
    protected LayoutInflater inflador;   //Crea Layouts a partir del XML
    protected Context contexto;          //Lo necesitamos para el inflador
    protected View.OnClickListener onClickListener;

    public AdaptadorAlumnos(Context contexto, VectorAlumnos contact) {
        this.contexto = contexto;
        this.contactos = contact;
        inflador = (LayoutInflater) contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView foto;
        TextView nombre;
        TextView curso;



        ViewHolder(View itemView) {
            super(itemView);
            foto = (ImageView) itemView.findViewById(R.id.foto);
            nombre = (TextView) itemView.findViewById(R.id.nombre);
            curso = (TextView) itemView.findViewById(R.id.ciclo_form);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflador.inflate(R.layout.elemento_lista, parent, false);
        v.setOnClickListener(onClickListener);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int posicion) {
        holder.nombre.setText(contactos.getAlumno(posicion).getNombre());
        holder.curso.setText(contactos.getAlumno(posicion).getCurso());
        holder.foto.setImageResource(contactos.getAlumno(posicion).getImagen());
    }

    @Override
    public int getItemCount() {
        return contactos.tamanyo();
    }

    public void setOnItemClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }
}
