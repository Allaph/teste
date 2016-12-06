package allaphsamples.servegame.com.pedale.showbikes;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import allaphsamples.servegame.com.pedale.R;
import allaphsamples.servegame.com.pedale.addbike.AddBikeActivity;
import allaphsamples.servegame.com.pedale.showbikes.model.Bike;

/**
 * Created by Allaph on 03/12/2016.
 */
public class ShowBikesActivity extends AppCompatActivity {

    private RecyclerView mRecycler;
    private ShowBikesAdapter mAdapter;
    private List<Bike> mBikes;
    private FloatingActionButton mAddBike;

    private Intent intent = getIntent();
    Bundle bundle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_bikes_act);
        RecyclerView.LayoutManager layout = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        if (intent != null){
            bundle = intent.getExtras();
        }else{
            System.out.println("INTENT NULL");
        }


        mRecycler = (RecyclerView) findViewById(R.id.bikes_recycler_view);
        mRecycler.setNestedScrollingEnabled(false);
        mBikes = new ArrayList<>();
        mBikes.add(new Bike("Caloi", 200f, 4, "azul", "Descrição da minha bike1" ));
        mBikes.add(new Bike("Totem", 200f, 5,"azul", "Descrição da minha bike2" ));
        mBikes.add(new Bike("Tauors", 200f, 7,"azul", "Descrição da minha bike3" ));
        mBikes.add(new Bike("Shimano", 200f, 8, "azul", "Descrição da minha bike4" ));
        mBikes.add(new Bike("Bike", 200f, 10, "azul", "Descrição da minha bike4" ));
        mBikes.add(new Bike("Bike 5", 200f, 11, "azul", "Descrição da minha bike4" ));
        mBikes.add(new Bike("Bike 10", 200f, 20, "azul", "Descrição da minha bike4" ));

        if (bundle != null){
            Bike bike = (Bike) bundle.get("NewBike");
            mBikes.add(bike);
            mAdapter.notifyDataSetChanged();
        }else {
            System.out.println("OBJETO VAZIO");
        }

        mAdapter = new ShowBikesAdapter(mBikes, this);
        mAdapter.notifyDataSetChanged();

        mAddBike = (FloatingActionButton) findViewById(R.id.add_bike);

        mAddBike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShowBikesActivity.this, AddBikeActivity.class);
                startActivity(intent);
            }
        });

        mRecycler.setLayoutManager(layout);
        mRecycler.setAdapter(mAdapter);

    }
}
