package salesianas.listaalumnos;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by esaup on 01/12/2016.
 */

public class VectorAlumnos {

    private List<Alumno> VectorAlumos = new ArrayList<>();

    public VectorAlumnos() {
    }

    public void AniadeAlumno(Alumno alumno) {
        VectorAlumos.add(alumno);
    }

    public Alumno getAlumno(int id) {
        return VectorAlumos.get(id);
    }

    public int tamanyo() {
        return VectorAlumos.size();
    }
}
