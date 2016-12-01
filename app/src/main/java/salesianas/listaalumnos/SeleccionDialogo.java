package salesianas.listaalumnos;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;

/**
 * Created by esaup on 08/11/2016.
 */

public class SeleccionDialogo extends DialogFragment {



    public interface OnSetTitleListener{
        void setTitle(int item);
    }

    OnSetTitleListener listener;

    public SeleccionDialogo(){};

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final String[] items={"Enviar mensaje","Llamar","Enviar correo"};

        AlertDialog.Builder builder =
                new AlertDialog.Builder(getActivity());

        builder.setTitle("Selección").setItems(items, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        listener.setTitle(item);
                    }
                });

        return builder.create();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            listener = (OnSetTitleListener) activity;

        } catch (ClassCastException e) {
            throw new ClassCastException(
                    activity.toString() +
                            " no implementó OnSetTitleListener");

        }
    }
}
