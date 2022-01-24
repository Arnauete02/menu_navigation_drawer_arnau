package com.example.recycler_view_arnau;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    ArrayList<Geographic> geographics = new ArrayList<>();
    private RecyclerView recyclerView;

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        initData();

        MyAdapter myAdapter = new MyAdapter(geographics, this);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3, RecyclerView.VERTICAL, false));

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,
                drawerLayout,
                toolbar,
                R.string.open,
                R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        onBackPressed();
        navigationView.setCheckedItem(R.id.nav_home);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_home:
                Toast.makeText(this, "Bike menu", Toast.LENGTH_SHORT).show();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private void initData(){
        Geographic geographic1 = new Geographic(
                "Baobab Tree",
                "https://www.nationalgeographic.com.es/medio/2022/01/05/waterfall-and-baobab-tree_3887ddc0_2000x1333.jpg",
                "\"Al llegar a este lugar en la frontera norte de Namibia, tuve la suerte de que las cascadas tuvieran agua. Buscando buenos ángulos para fotografiar el baobab con las cataratas que fluyen detrás de él, subí acantilados muy empinados mientras cargaba con mi equipo y mi trípode. Mis manos y rodillas ensangrentadas y la espera de tres horas por la mejor luz valieron la pena\"."
        );
        geographics.add(geographic1);
        Geographic geographic2 = new Geographic(
                "Los guardianes",
                "https://www.nationalgeographic.com.es/medio/2021/12/08/los-guardianes-del-lago_de8851ef_1152x769.jpg",
                "Después de seguir el clima espacial durante los días anteriores, sabía que era muy probable que las luces se vieran durante este otoño, así que fui a uno de mis lugares favoritos y preparé mi equipo con la esperanza de que aparecieran las auroras boreales…¡Y lo hicieron! Me quedé asombrado cuando bailaron por encima de mi cabeza y por fin pude capturar algunas imágenes con las que había soñado."
        );
        geographics.add(geographic2);
        Geographic geographic3 = new Geographic(
                "Higher prediction",
                "https://www.nationalgeographic.com.es/medio/2021/12/08/higher-prediction_f989f6d2_1152x847.jpg",
                "El norte de Noruega ofrece algunas de las vistas más bonitas y espectaculares que puedes encontrar en el norte de Europa. Algunas noches, llegan predicciones de fuertes auroras boreales que muchas veces desencadenan increíbles espectáculos de luces que se extienden por todo el cielo. Las bajas temperaturas forman hielos junto a la orilla del río y estas estructuras ayudan a crear la composición perfecta en las fotografías de la Aurora."
        );
        geographics.add(geographic3);
        Geographic geographic4 = new Geographic(
                "Santa´s Cabin",
                "https://www.nationalgeographic.com.es/medio/2021/12/08/santas-cabin_26d856a5_864x1080.jpg",
                "Sé que el viaje es a menudo más importante y memorable que los resultados, y después de tomar esta foto, puedo decir que fue un viaje para el recuerdo. No fue una caminata larga, pero cuando no tienes raquetas de nieve y te hundes medio metro con cada paso que das, la ruta parece cincuenta veces más larga. La próxima vez que vaya, llevaré sin duda mis esquís. Todo el camino estaba parcialmente nublado y sin señales de auroras boreales, pero finalmente conseguí capturar lo que buscaba. También logré conseguir algunas tomas bastante decentes de la Vía Láctea de invierno antes de que comenzara el espectáculo, lo que sin duda fue la guinda del pastel de la noche."
        );
        geographics.add(geographic4);
        Geographic geographic5 = new Geographic(
                "La catedral",
                "https://www.nationalgeographic.com.es/medio/2021/12/08/la-catedral-de-la-aurora_0818b67e_1393x1080.jpg",
                "Esta imagen es la representación perfecta de una de mis mejores noches viendo la aurora boreal en Noruega desde la isla de Senja. Las vistas eran impresionantes con paisajes nevados, montañas espectaculares, y una Aurora que bailaba y coloreaba todo de verde. Fue realmente una noche para recordar. Las condiciones eran perfectas; no hacía demasiado frío, y la aurora boreal apareció poco después de llegar, durando mucho tiempo. Volví a casa muy feliz y agradecida por esta increíble experiencia."
        );
        geographics.add(geographic5);
        Geographic geographic6 = new Geographic(
                "Road to Ruin",
                "https://www.nationalgeographic.com.es/medio/2021/10/12/road-to-ruin_d47d9693_1280x853.jpg",
                "Dividiendo el humedal en dos, esta carretera fue construida en la década de 1980 para proporcionar acceso a una playa. El humedal de marea es el hogar de más de un centenar de especies de aves entre las que pueden encontrarse desde águilas pescadoras a abejarucos, pasando por decenas de migratorios estacionales."
        );
        geographics.add(geographic6);
        Geographic geographic7 = new Geographic(
                "Luna Dunes",
                "https://www.nationalgeographic.com.es/medio/2021/09/15/luna-dunes_f0f15bdd_949x533.jpg",
                "Un luna creciente y humeante flota en una atmósfera azul océano sobre las tranquilas y brillantes dunas de arena. El fotógrafo caminó profundamente en las dunas y finalmente encontró el primer plano que había imaginado para esta toma. Una vez que todo estaba montado, levantó la vista y allí colgaba una astilla brillante de una luna creciente que delineaba su rostro oscuro pero visible."
        );
        geographics.add(geographic7);
        Geographic geographic8 = new Geographic(
                "Forest",
                "https://www.nationalgeographic.com.es/medio/2021/08/28/forest-of-reflection_5fb46941_1200x757.jpg",
                "Una hermosa escena con la que me encontré una tarde mientras exploraba un lugar para una sesión de fotos. Vi estas cortezas de papel en el agua creando reflejos impresionantes, con algo de luz dorada enfatizando los árboles. Vambié a mi lente gran angular y tomé algunas instantáneas antes de que la luz se desvaneciera."
        );
        geographics.add(geographic8);
        Geographic geographic9 = new Geographic(
                "The Surface",
                "https://www.nationalgeographic.com.es/medio/2021/08/28/beneath-the-surface_20bd6eda_1200x799.jpg",
                "Para algunos, las puestas de sol son un momento para la reflexión y la meditación. Para mí, combinar una puesta de sol ardiente con los prístinos jardines de coral del arrecife de Ningaloo bajo la superficie vítrea del océano trae un nuevo nivel de tranquilidad. Combinando dos mundos para crear un momento perfecto."
        );
        geographics.add(geographic9);
        Geographic geographic10 = new Geographic(
                "Stilted Reflections",
                "https://www.nationalgeographic.com.es/medio/2021/08/28/stilted-reflections_9e268ec2_1200x799.jpg",
                "Estaba en un lugar con vistas a estas cigueñas australianas -Himantopus leucocephalus- que se alimentaban en aguas poco profundas cuando el viento murió y la puesta de sol arrojó unos reflejos increíbles. Cambié a una lente de 100-400 mm y me alejé para capturar como pude a la mayor cantidad de estas hermosas aves \"caminando en las nubes\"."
        );
        geographics.add(geographic10);
        Geographic geographic11 = new Geographic(
                "Iceland Vortex",
                "https://www.nationalgeographic.com.es/medio/2021/07/01/iceland-vortex_751ed74d_1200x600.jpg",
                "Esta imagen presenta una panorámica de 250 grados de una Aurora Boreal sobre Islandia. El fotógrafo se encontró con este estuario que reflejaba el cielo a la perfección en una noche de invierno, y capturó primero el escenario. Luego tomó una foto de sí mismo en el hielo. Para el fotógrafo esta es una de las imágenes de auroras más increíbles que jamás haya capturado, y resume un viaje impresionante a Islandia en invierno."
        );
        geographics.add(geographic11);
        Geographic geographic12 = new Geographic(
                "Tree of Life",
                "https://www.nationalgeographic.com.es/medio/2021/06/05/tree-of-life_a13878f5_1200x799.jpg",
                "Suspendido en el tiempo; una sensación de espera impregna este valle donde nada parece haber sucedido durante mil años. La sombra de una antigua acacia se extiende como una mano ennegrecida a los delicados trazos del río Tsauchab; anhelo de la vida que una vez fue."
        );
        geographics.add(geographic12);
        Geographic geographic13 = new Geographic(
                "Another Planet",
                "https://www.nationalgeographic.com.es/medio/2021/05/31/another-planet_a0bb31f5_1200x799.jpg",
                "Lo que a primera vista parece ser lava que fluye por las laderas de estos volcanes islandeses es, de hecho, óxido de hierro depositado durante erupciones pasadas. A diferencia de Geldingadalir, un volcán a tan solo 20 minutos de Reikiavik que ha estado en erupción activa desde el 19 de marzo de 2021, la última erupción de la Reserva Natural de Fjallabak -en la fotografía- tuvo lugar en 1480. El clima en la reserva es árido y frío, y la temporada de crecimiento para la plantas se limita a unos dos meses al año, por lo que la vegetación escasa y las montañas bandeadas por los minerales proporcionan al paisaje gran parte de su color. El fotógrafo Fran Rubia quedó asombrado por su belleza, especialmente cuando vio el volcán por primera vez desde arriba. \"Cuando levanté el dron para un vuelo de reconocimiento me sorprendió la gran cantidad de óxido de hierro presente dentro de los volcanes\", cuenta. La fotografía que capturó más tarde ese día le hizo reflexionar sobre la importancia de preservar tales lugares. \"Debido a que la imagen parece estar fotografiada en otro mundo, en otro planeta, me pareció un lugar virgen, sin ninguna alteración humana, lo que la hizo aún más especial\"."
        );
        geographics.add(geographic13);
        Geographic geographic14 = new Geographic(
                "Electric Storm",
                "https://www.nationalgeographic.com.es/medio/2021/03/20/electric-storm-on-lavender_3f8ac6fc_1200x762.jpg",
                "Electric Storm on Lavender es una dramática fotografía que capta el momento en que un rayo cae sobre un campo de lavanda en flor con un árbol solitario en el centro, en un cielo nocturno. Tomada en la provincia de Guadalajara (España)"
        );
        geographics.add(geographic14);
        Geographic geographic15 = new Geographic(
                "Nature Silence",
                "https://www.nationalgeographic.com.es/medio/2021/02/26/nature-silence_0108e2c9_1200x1200.jpg",
                "Esta serie muestra las zonas secas del lago Urmia, donde no queda más que un terrible silencio."
        );
        geographics.add(geographic15);
    }
}