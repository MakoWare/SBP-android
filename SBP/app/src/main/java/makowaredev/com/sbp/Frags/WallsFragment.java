package makowaredev.com.sbp.Frags;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.maps.OnStreetViewPanoramaReadyCallback;
import com.google.android.gms.maps.StreetViewPanorama;
import com.google.android.gms.maps.StreetViewPanoramaFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.panorama.Panorama;

import makowaredev.com.sbp.R;

public class WallsFragment extends Fragment implements OnStreetViewPanoramaReadyCallback {

    private StreetViewPanorama panorama;
    private static final String SECTION_NUMBER = "sectionNumber";
    private WallsFragmentCallbacks mListener;

    public static WallsFragment newInstance(int sectionNumber) {
        WallsFragment fragment = new WallsFragment();
        Bundle args = new Bundle();
        args.putInt(SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public WallsFragment() {
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

        View view = inflater.inflate(R.layout.fragment_walls, container, false);
        return view;
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (WallsFragmentCallbacks) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onStreetViewPanoramaReady(StreetViewPanorama streetViewPanorama) {
        panorama.setPosition(new LatLng(-33.87365, 151.20689));
    }

    public interface WallsFragmentCallbacks {
        public void onWallInteraction(Uri uri);
    }

}
