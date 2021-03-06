package salesianas.listaalumnos;

import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, SeleccionDialogo.OnSetTitleListener{

    public AdaptadorAlumnos adaptador;
    public VectorAlumnos VecAlumnos = new VectorAlumnos();
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView recyclerView;
    final String dialogoSeleccion = "DialogoSeleccion";
    private long id;
    private Alumno alumno;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        VecAlumnos.AniadeAlumno(new Alumno("Contacto1", "1DAM"));
        VecAlumnos.AniadeAlumno(new Alumno("Contacto2", "2DAM"));
        VecAlumnos.AniadeAlumno(new Alumno("Contacto3", "1DAM"));



        recyclerView = (RecyclerView) findViewById(R.id.lista);
        adaptador = new AdaptadorAlumnos(this, VecAlumnos);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DecoracionItem(this, LinearLayout.VERTICAL));
        recyclerView.setAdapter(adaptador);

        registerForContextMenu(recyclerView);


        adaptador.setOnItemClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                id = (long) recyclerView.getChildAdapterPosition(view);
                DialogFragment fragment = new SeleccionDialogo();
                fragment.show(getFragmentManager(), dialogoSeleccion);
            }
        });




        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Esto lo he hecho yo por que soy mejor que tu", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void setTitle(int i) {
        Fragment fragmentel = new Fragment_Consulta();

        getFragmentManager().beginTransaction().replace(R.id.fragment_consulta,fragmentel).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).commit();
        alumno = VecAlumnos.getAlumno((int) id);





     /*   if (fragment != null) {
            if (i == 0) {
                Intent sendIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + alumno.getTelef()));
                sendIntent.putExtra(Intent.EXTRA_TEXT, "Hey, I'm using Agendex");
                startActivity(sendIntent);
            } else if (i == 1) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + alumno.getTelef()));
                startActivity(intent);
            } else {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/html");
                intent.setData(Uri.parse("mailto:"));
                intent.setType("message/rfc822");
                startActivity(Intent.createChooser(intent, "Selecciona la aplicaion"));
            }

        }*/
    }
}
