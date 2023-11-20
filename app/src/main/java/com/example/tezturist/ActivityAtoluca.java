package com.example.tezturist;
//clase para el carrusel, son tres en total
//clase que le da funcionalidad a los botones que cambian de fragmento

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import java.util.ArrayList;
import com.example.tezturist.R;

public class ActivityAtoluca extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atoluca);

        RecyclerView recyclerView = findViewById(R.id.recycler);
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("https://scontent.fjal2-1.fna.fbcdn.net/v/t39.30808-6/401694714_308024552215573_1226869390937196813_n.jpg?_nc_cat=100&ccb=1-7&_nc_sid=5f2048&_nc_eui2=AeGpOusvfqz2-ZO0h8V_pwkrxlsesJsAvK3GWx6wmwC8rRk8XHqGnbV15XZ9Sm8rGF_lj2a9YdGaGcaejk9a7p5E&_nc_ohc=4wws0IYIsBAAX9MWwq-&_nc_ht=scontent.fjal2-1.fna&oh=00_AfCrA6UTpScba3G-JujUgDAB0iPphRv3KDzMCC0I_0O-2A&oe=65597C30");
        arrayList.add("https://scontent.fjal2-1.fna.fbcdn.net/v/t39.30808-6/400854587_308632595488102_8428432291098856857_n.jpg?_nc_cat=108&ccb=1-7&_nc_sid=5f2048&_nc_eui2=AeGftF9FZWEYZibjk5ZrARCZ9g9a-h4jaRf2D1r6HiNpF2OodUHb8sm_GUZn8HE97K6AssYCUSDrqMKyA240triN&_nc_ohc=hRl0dcvEoiIAX-XEImg&_nc_ht=scontent.fjal2-1.fna&oh=00_AfBP7tyc4j_4DYncKGTiE3fsqVJXUhsMvSBpA9FD_XTnsQ&oe=65585506");
        arrayList.add("https://scontent.fjal2-1.fna.fbcdn.net/v/t39.30808-6/387084237_290730810611614_4894769293212880540_n.jpg?_nc_cat=111&ccb=1-7&_nc_sid=5f2048&_nc_eui2=AeHgMq95YW-elnmbGQypLWTcwGc3ps45tIvAZzemzjm0i-DwSF3y3balN3OD6S3-e7CWmaUoHJ6eO77sf34WgA9m&_nc_ohc=WLvNSNvj_0UAX-uQkGj&_nc_ht=scontent.fjal2-1.fna&oh=00_AfA652-kYMEr9cZhOTh58ZBGyIhNCCdh_KMrtiMU-vxbFQ&oe=6558E3FC");
        arrayList.add("https://scontent.fjal2-1.fna.fbcdn.net/v/t39.30808-6/391544695_290730677278294_4541204260320594069_n.jpg?_nc_cat=106&ccb=1-7&_nc_sid=5f2048&_nc_eui2=AeFAxwhM0E-i1ONbwBBxAWbRva28FYixATe9rbwViLEBN4Dn9JiThUWozyRFNpf2JicLLGbH1onCJkHpu34t5Vd7&_nc_ohc=YLF2RcVwYmoAX-pZ6Hc&_nc_ht=scontent.fjal2-1.fna&oh=00_AfAs63LGbHgDEkTyyYriR3MsSo_fYlX4MdaK9Lqh1Nt8tQ&oe=65590885");
        arrayList.add("https://scontent.fjal2-1.fna.fbcdn.net/v/t39.30808-6/242854245_4635598593200066_6470126732441173523_n.jpg?_nc_cat=107&ccb=1-7&_nc_sid=5f2048&_nc_eui2=AeF41nyuW2A4C8QWpCSupLNpsp0Ollq-qVCynQ6WWr6pUMzEpuKfPMURfo88uz1xoF79Mzt6HHTiPjtPQFY_FinC&_nc_ohc=rgaJP4ltpVUAX8nRcgB&_nc_ht=scontent.fjal2-1.fna&oh=00_AfBoUV7BRJCkdGftlnMCHp2tjFPf1GKdYih2AZRIckLxnA&oe=65586E5E");
        arrayList.add("https://scontent.fjal2-1.fna.fbcdn.net/v/t39.30808-6/242914350_4635600069866585_3861236131383818165_n.jpg?_nc_cat=108&ccb=1-7&_nc_sid=5f2048&_nc_eui2=AeFHFsYA_tU3zFxcL43C0YK4BJS5DuREC7AElLkO5EQLsCze8poHNjlwiX6E0scgcXOi34qyMEcyuHLCF2s0Kv57&_nc_ohc=wEsKKGovPswAX-u-u0X&_nc_ht=scontent.fjal2-1.fna&oh=00_AfCAT7V02PuQDlWZ_bBhW6SNHBZQfJLtNBVzYIe-oEGdBA&oe=65596606");


        arrayList.add("https://scontent.fjal2-1.fna.fbcdn.net/v/t39.30808-6/384581682_6956281044465131_1330455244416343941_n.jpg?_nc_cat=110&ccb=1-7&_nc_sid=5f2048&_nc_eui2=AeHPa9lT6vtBxPxJyoVwD2BcBlq7sUazH_4GWruxRrMf_uMHGqyTlojQQ1GaXiMMdEJwyMVTU77IhtrEQL0aLnTT&_nc_ohc=bCT5bF5KQVcAX-mH_AV&_nc_ht=scontent.fjal2-1.fna&oh=00_AfCGCcuaK5Ttu2Rluw7_4znkkLeOouo02Wlz-BCUYYBrqg&oe=65599926");
        arrayList.add("https://scontent.fjal2-1.fna.fbcdn.net/v/t39.30808-6/384529857_6956282221131680_7607991073715858704_n.jpg?_nc_cat=103&ccb=1-7&_nc_sid=5f2048&_nc_eui2=AeETg04OyZevDL2gBtx-AX9gx9xqTPPHHiTH3GpM88ceJC1XvEuAMEIRsxCLe8R--0SqDpiYGSs0cVI1iHgNXiD1&_nc_ohc=_RvrlOJJ2mIAX_NWBkO&_nc_ht=scontent.fjal2-1.fna&oh=00_AfA7px418yd7X1gzO6kuIiN_7gwxix09aFhjpkW9gT7IQw&oe=655969BE");
        arrayList.add("https://scontent.fjal2-1.fna.fbcdn.net/v/t39.30808-6/383979707_6956282734464962_3329701405378840484_n.jpg?_nc_cat=107&ccb=1-7&_nc_sid=5f2048&_nc_eui2=AeG78LmcEQUeP5kxBTjnwOYZQs_lx8oihDNCz-XHyiKEM-QSZUj2MGSjABPw2op4RxLJKO_cpZ4-Va4u6nxXVT6-&_nc_ohc=NNNtjcgwzqcAX841i9W&_nc_ht=scontent.fjal2-1.fna&oh=00_AfBdaPpJ8x3eu9lYv2uxJHILxZtDLfUiQQsUM-ndqiLD2A&oe=6559BDC6");
        arrayList.add("https://scontent.fjal2-1.fna.fbcdn.net/v/t39.30808-6/383965657_6956284467798122_3413444743425765527_n.jpg?_nc_cat=109&ccb=1-7&_nc_sid=5f2048&_nc_eui2=AeEn4MAjR-4xkFcxMHTQ_7DkFeyeZO2EJ6MV7J5k7YQno7QE3dfN1X5LF7zY5tFbOT_ZTROdtxbTbdq9ytHjv-wS&_nc_ohc=3C2Hf8wDIQYAX-wg1bD&_nc_oc=AQkxSoQIrx8SA8GUU8H3DLL_ew_A7vxaMWl1VshWofWsUpVBewU-BoEsDyOTMK2gvaO2aa9FRsjh4eqPqtabxudS&_nc_ht=scontent.fjal2-1.fna&oh=00_AfAm5npi9T6V_aZu70Gh9ri-xfM-GsstzPDNfnOGlWGw0w&oe=6559658C");
        arrayList.add("https://scontent.fjal2-1.fna.fbcdn.net/v/t39.30808-6/277750957_5266621493431103_7198053513427552681_n.jpg?_nc_cat=104&ccb=1-7&_nc_sid=5f2048&_nc_eui2=AeEHq6k3AGKAbzIOo0DK0VeHOV5oR5BkRx45XmhHkGRHHgR2N-zveQ3LPW2z3zLP0fAvBMbL3vMenfIP0qsD1uV9&_nc_ohc=iBfZa9-N0FMAX807drt&_nc_ht=scontent.fjal2-1.fna&oh=00_AfA8N09g85o6xNYM9AX-H4AGQJgyhQDZas4Gp13mjVTMGA&oe=655914E5");
        arrayList.add("https://scontent.fjal2-1.fna.fbcdn.net/v/t39.30808-6/276320107_5266618603431392_4001952240193280070_n.jpg?_nc_cat=107&ccb=1-7&_nc_sid=5f2048&_nc_eui2=AeEE5K--VsQPhPUmsknIBZ--nf2No8MXreed_Y2jwxet56cbRd7TYvaffhjWuJDTFWvzy5Ec-blFL8bo4X3luP2m&_nc_ohc=fVj54ETprS8AX-Kbc6y&_nc_ht=scontent.fjal2-1.fna&oh=00_AfAz9OesHBLkzLVJgBkww3uQKIW-lqrU6xtqYGF6eMk1jg&oe=65583522");


        ImageAdapter adapter = new ImageAdapter(ActivityAtoluca.this, arrayList);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new ImageAdapter.OnItemClickListener() {
            @Override
            public void onClick(ImageView imageView, String path) {
                startActivity(new Intent(ActivityAtoluca.this, ImageViewActivity.class).putExtra("image", path), ActivityOptions.makeSceneTransitionAnimation(ActivityAtoluca.this, imageView, "image").toBundle());



            }
        });
        // Configuración de los botones y sus manejadores de clics
        Button buttonActividades = findViewById(R.id.btnActividades);
        Button buttonEventos = findViewById(R.id.btnEventos);
        Button buttonHistoria = findViewById(R.id.btnHistoria);

        View.OnClickListener buttonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment;

                if (view.getId() == R.id.btnActividades) {
                    fragment = new FragmentActividades();
                } else if (view.getId() == R.id.btnEventos) {
                    fragment = new FragmentEventos();
                } else if (view.getId() == R.id.btnHistoria) {
                    fragment = new FragmentTres();
                } else {
                    fragment = new FragmentActividades(); // Fragmento predeterminado
                }

                // Reemplazar el fragmento en el FrameLayout(Contenedor de fragmentos para cambiar con los botones)
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainer, fragment)
                        .commit();
            }
        };

        buttonActividades.setOnClickListener(buttonClickListener);
        buttonEventos.setOnClickListener(buttonClickListener);
        buttonHistoria.setOnClickListener(buttonClickListener);
    }
}
