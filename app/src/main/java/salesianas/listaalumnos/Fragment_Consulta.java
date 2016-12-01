package salesianas.listaalumnos;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by esaup on 01/12/2016.
 */

public class Fragment_Consulta extends Fragment {

    public Fragment_Consulta() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_consulta, container, false);
        return rootView;
    }

}
