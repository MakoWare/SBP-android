package makowaredev.com.sbp.Adapters;

import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.view.ViewGroup;
import android.view.View;
import android.view.LayoutInflater;

import makowaredev.com.sbp.R;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private String[] mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView dayTextView;
        public TextView monthTextView;
        public TextView titleTextView;
        public TextView bodyTextView;
        public ViewHolder(View view) {
            super(view);
            dayTextView = (TextView) view.findViewById(R.id.dayTextView);
            monthTextView = (TextView) view.findViewById(R.id.monthTextView);
            titleTextView = (TextView) view.findViewById(R.id.titleTextView);
            bodyTextView = (TextView) view.findViewById(R.id.bodyTextView);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public NewsAdapter(String[] myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_news, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        if(position == 0) {
            holder.dayTextView.setText("13");
            holder.monthTextView.setText("Dec");
            holder.titleTextView.setText("Crazy New Boulders");
            holder.bodyTextView.setText("All New Boulders on the North Wall");
        } else if(position == 1) {
            holder.dayTextView.setText("7");
            holder.monthTextView.setText("Nov");
            holder.titleTextView.setText("Gym Closing for Maintenance");
            holder.bodyTextView.setText("The North Room and the Basement will be closed tody");
        } else if(position == 2){
            holder.dayTextView.setText("22");
            holder.monthTextView.setText("Sep");
            holder.titleTextView.setText("Climbing Competition");
            holder.bodyTextView.setText("NorthWest BoulderFest this Saturday!");
        } else {
            holder.dayTextView.setText("5");
            holder.monthTextView.setText("Sep");
            holder.titleTextView.setText("More Great Routes");
            holder.bodyTextView.setText("This Thursday the Roof will be reset");
        }

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.length;
    }
}
