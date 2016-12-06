package allaphsamples.servegame.com.pedale.showbikes;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import allaphsamples.servegame.com.pedale.R;
import allaphsamples.servegame.com.pedale.showbikes.model.Bike;

/**
 * Created by Gabe on 03/12/2016.
 */
public class ShowBikesAdapter extends RecyclerView.Adapter<ShowBikesAdapter.ItemViewHolder> {

    private ItemViewHolder mViewHolder;
    private List<Bike> mBikes;
    private Context mContext;
    private Dialog mBikeDetailDialog;

    public ShowBikesAdapter(List<Bike> bikes, Context context){
        this.mBikes   = bikes;
        this.mContext = context;
    }


    @Override
    public ShowBikesAdapter.ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.show_bikes_item, parent, false);

        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ShowBikesAdapter.ItemViewHolder holder, int position) {
        mViewHolder = holder;

        mBikeDetailDialog = new Dialog(mContext, R.style.DialogTheme);
        mBikeDetailDialog.setContentView(R.layout.bike_detail_dialog);

        final Bike modelBike = mBikes.get(position);

        mViewHolder.mBikeName.setText(modelBike.getName());
        mViewHolder.mBikeDescription.setText(modelBike.getDescription());

        mViewHolder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bikeDetailDialogConfiguration(modelBike, mBikes);
                mBikeDetailDialog.show();
                notifyDataSetChanged();
            }
        });

    }

    public void bikeDetailDialogConfiguration(final Bike bike, final List<Bike> list){

        TextView bikeDetailName         = (TextView) mBikeDetailDialog.findViewById(R.id.bike_detail_name);
        TextView bikeDetailDescription  = (TextView) mBikeDetailDialog.findViewById(R.id.bike_detail_description);
        TextView bikeDetailWeight       = (TextView) mBikeDetailDialog.findViewById(R.id.bike_detail_weight);
        TextView bikeDetailPrice        = (TextView) mBikeDetailDialog.findViewById(R.id.bike_detail_price);
        TextView bikeDetailColor        = (TextView) mBikeDetailDialog.findViewById(R.id.bike_detail_color);
        TextView btnOk                  = (TextView) mBikeDetailDialog.findViewById(R.id.dismiss_detail_dialog);
        TextView btnDelete              = (TextView) mBikeDetailDialog.findViewById(R.id.logout_confirmation_confirm_Logout);

//        TODO CRIAR MÉTODO PARA FAZER ESSES FORMATED
        String formattedWeight = "" + bike.getWeight() + " Kg";
        String formattedPrice = "R$ " + bike.getPrice();

        bikeDetailName.setText(bike.getName());
        bikeDetailDescription.setText(bike.getDescription());
        bikeDetailWeight.setText(formattedWeight);
        bikeDetailPrice.setText(formattedPrice);
        bikeDetailColor.setText(bike.getColor());

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mBikeDetailDialog.dismiss();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list.remove(bike);
                mBikeDetailDialog.dismiss();
                notifyDataSetChanged();
            }
        });



    }

    @Override
    public int getItemCount() {
        return mBikes.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{

        private TextView mBikeName;
        private TextView mBikeDescription;
        private CardView mCardView;

        public ItemViewHolder(View v) {
            super(v);

            mBikeName        = (TextView) v.findViewById(R.id.text_bike_name);
            mBikeDescription = (TextView) v.findViewById(R.id.text_bike_description);
            mCardView        = (CardView) v.findViewById(R.id.card_view_clicker);

        }
    }
}
