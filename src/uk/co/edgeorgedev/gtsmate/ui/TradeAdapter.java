package uk.co.edgeorgedev.gtsmate.ui;

import uk.co.edgeorgedev.gtsmate.R;
import uk.co.edgeorgedev.gtsmate.gts.GTSTrade;
import uk.co.edgeorgedev.gtsmate.gts.GTSTradeList;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class TradeAdapter extends RecyclerView.Adapter<TradeAdapter.ViewHolder> {
    private GTSTradeList mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView mTrainerName, mTrainerRegion, mTradedPokeName, mRecievedPokeName, mTradeDate;
        public CardView mCardView;
        public ViewHolder(View mLayout) {
            super(mLayout);
            this.mTrainerName = (TextView) mLayout.findViewById(R.id.trader_name);
            this.mTrainerRegion = (TextView) mLayout.findViewById(R.id.trader_region);
            this.mTradedPokeName = (TextView) mLayout.findViewById(R.id.sent_pokemon_name);
            this.mRecievedPokeName = (TextView) mLayout.findViewById(R.id.recieved_pokemon_name);
            this.mTradeDate = (TextView) mLayout.findViewById(R.id.trade_date);
            this.mCardView = (CardView) mLayout.findViewById(R.id.card_view);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public TradeAdapter(GTSTradeList list) {
        mDataset = list;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public TradeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)	
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
    	GTSTrade trade = mDataset.getTradeList().get(position);
        holder.mTrainerName.setText(trade.getTradeSavedata().getTrainerName());
        holder.mRecievedPokeName.setText(trade.getTradePokemon().toString());
        holder.mTradedPokeName.setText(trade.getPostedPokemon().toString());
        holder.mTradeDate.setText(trade.getTradeDate());
        holder.mTrainerRegion.setText(trade.getTradeSavedata().getCountryCode());
        holder.mCardView.setCardElevation(10.0f);
    }

    @Override
    public int getItemCount() {
        return mDataset.getTradeList().size();
    }
}