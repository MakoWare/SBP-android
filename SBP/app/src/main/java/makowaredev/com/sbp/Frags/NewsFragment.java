package makowaredev.com.sbp.Frags;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android .support.v7.widget.RecyclerView;
import android .support.v7.widget.LinearLayoutManager;

import makowaredev.com.sbp.Adapters.NewsAdapter;
import makowaredev.com.sbp.R;
import makowaredev.com.sbp.Activities.Home_Activity;

public class NewsFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private static final String SECTION_NUMBER = "sectionNumber";
    private String[] data;
    private NewsFragmentCallbacks mListener;

    public static NewsFragment newInstance(int sectionNumber) {
        NewsFragment fragment = new NewsFragment();
        Bundle args = new Bundle();
        args.putInt(SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }
    public NewsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_news, container, false);
        this.data = new String[4];
        this.data[0] = "taco";
        this.data[1] = "loco";
        this.data[2] = "loco";
        this.data[3] = "loco";

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new NewsAdapter(this.data);
        mRecyclerView.setAdapter(mAdapter);

        return view;
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onNewsItemSelected(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((Home_Activity) activity).onSectionAttached(
                getArguments().getInt(SECTION_NUMBER));
        try {
            mListener = (NewsFragmentCallbacks) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement NewsFragment Callbacks");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface NewsFragmentCallbacks {
            public void onNewsItemSelected(Uri uri);
    }

}
