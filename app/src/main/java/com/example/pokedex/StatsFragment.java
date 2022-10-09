package com.example.pokedex;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StatsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StatsFragment extends Fragment {


   private static final String POKEMON_STATS = "pokemon_stats";

    private DetailFragment.OnFragmentInteractionListener mListener;



    public StatsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof DetailFragment.OnFragmentInteractionListener) {
            mListener = (DetailFragment.OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }


    public static StatsFragment newInstance(Stats pokemonStats) {
        StatsFragment fragment = new StatsFragment();
        Bundle args = new Bundle();
        args.putParcelable(POKEMON_STATS, pokemonStats);
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_stats, container, false);

        TextView hpTextView = (TextView) view.findViewById(R.id.fragment_stats_hp);
        TextView attackTextView = (TextView) view.findViewById(R.id.fragment_stats_attack);
        TextView defenseTextView = (TextView) view.findViewById(R.id.fragment_stats_defense);
        TextView speedTextView = (TextView) view.findViewById(R.id.fragment_stats_speed);

        if(getArguments() != null) {
            Stats pokemonStats = getArguments().getParcelable(POKEMON_STATS);

            hpTextView.setText(pokemonStats.getHp());
            attackTextView.setText(pokemonStats.getAttack());
            defenseTextView.setText(pokemonStats.getDefense());
            speedTextView.setText(pokemonStats.getSpeed());
        }

        return view;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}