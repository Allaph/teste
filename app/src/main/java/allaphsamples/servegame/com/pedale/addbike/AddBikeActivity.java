package allaphsamples.servegame.com.pedale.addbike;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import allaphsamples.servegame.com.pedale.R;
import allaphsamples.servegame.com.pedale.showbikes.ShowBikesActivity;
import allaphsamples.servegame.com.pedale.showbikes.model.Bike;

/**
 * Created by Allaph on 03/12/2016.
 */
public class AddBikeActivity extends AppCompatActivity {

    private EditText mAddBikeName;
    private EditText mAddBikeDescription;
    private EditText mAddBikePrice;
    private EditText mAddBikeWeight;
    private EditText mAddBikeColor;
    private Bike mNewBike;
    private Button mBtnAddBike;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_bike_act);

        mAddBikeName        = (EditText) findViewById(R.id.add_bike_name);
        mAddBikeDescription = (EditText) findViewById(R.id.add_bike_description);
        mAddBikePrice       = (EditText) findViewById(R.id.add_bike_price);
        mAddBikeWeight      = (EditText) findViewById(R.id.add_bike_weight);
        mAddBikeColor       = (EditText) findViewById(R.id.add_bike_color);
        mBtnAddBike         = (Button) findViewById(R.id.btn_add_bike);

        String name         = mAddBikeName.getText().toString();
        String description  = mAddBikeDescription.getText().toString();
        String color        = mAddBikeColor.getText().toString();

        mNewBike = new Bike(name, 200f, 50, color, description);

        mBtnAddBike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddBikeActivity.this, ShowBikesActivity.class);

                Bundle bundle = new Bundle();
                bundle.putSerializable("NewBike", mNewBike);
                intent.putExtras(bundle);

                startActivity(intent);
            }
        });

    }
}
