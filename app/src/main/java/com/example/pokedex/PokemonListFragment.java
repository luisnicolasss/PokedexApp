package com.example.pokedex;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PokemonListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PokemonListFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public PokemonListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PokemonListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PokemonListFragment newInstance(String param1, String param2) {
        PokemonListFragment fragment = new PokemonListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pokemon_list, container, false);
        ListView pokemonListView = (ListView) view.findViewById(R.id.pokemon_listView);



        ArrayList<Pokemon> pokemonList = new ArrayList<>();

        Stats bulbasaurStats = new Stats("45", "49", "49", "65");
        Stats ivysaurStats = new Stats("60", "62", "63", "80");
        Stats venusaurStats = new Stats("80", "82", "83", "100");
        Stats charmanderStats = new Stats("39", "52", "43", "50");
        Stats charmeleontats = new Stats("58", "64", "58", "65");
        Stats charizardStats = new Stats("78", "84", "78", "85");
        Stats squirtleStats = new Stats("44", "48", "65", "64");
        Stats wartotleStats = new Stats("59", "63", "80", "80");
        Stats blastoiseStats = new Stats("79", "83", "100", "105");
        Stats pikachuStats = new Stats("35", "55", "40", "50");
        Stats raichuStats = new Stats("60", "85", "50", "85");

        pokemonList.add(new Pokemon("1", "Bulbasaur","https://static.wikia.nocookie.net/espokemon/images/4/43/Bulbasaur.png/revision/latest?cb=20170120032346",R.raw.bulbasaur, Pokemon.Type.PLANT, bulbasaurStats));
        pokemonList.add(new Pokemon("2", "Ivysaur","https://vignette1.wikia.nocookie.net/es.pokemon/images/3/3a/EP893_Ivysaur_de_Xana_(2).png/revision/latest?cb=20151002171614",R.raw.ivysaur, Pokemon.Type.PLANT, ivysaurStats));
        pokemonList.add(new Pokemon("3", "Venasaur","https://vignette3.wikia.nocookie.net/es.pokemon/images/6/67/EP428_Venusaur_de_Jeremy.png",R.raw.venasaur, Pokemon.Type.PLANT, venusaurStats));
        pokemonList.add(new Pokemon("4", "Charmander","https://archives.bulbagarden.net/media/upload/archive/7/73/20091223030246%21004Charmander.png",R.raw.charmander, Pokemon.Type.FIRE, charmanderStats));
        pokemonList.add(new Pokemon("5", "Charmeleon","https://vignette2.wikia.nocookie.net/es.pokemon/images/6/66/EP778_Charmeleon_de_Ash.png",R.raw.charmeleon, Pokemon.Type.FIRE, charmeleontats));
        pokemonList.add(new Pokemon("6", "Charizard", "https://vignette2.wikia.nocookie.net/es.pokemon/images/e/e7/SME02_Charizard_de_Alain.png/revision/latest?cb=20151026181408",R.raw.charizard, Pokemon.Type.FIRE, charizardStats));
        pokemonList.add(new Pokemon("7", "Squirtle","https://archives.bulbagarden.net/media/upload/archive/3/39/20100909015307%21007Squirtle.png",R.raw.squirtle, Pokemon.Type.WATER, squirtleStats));
        pokemonList.add(new Pokemon("8", "Wartortle","https://vignette1.wikia.nocookie.net/es.pokemon/images/c/c1/EP869_Wartortle_de_Benigno.png/revision/latest?cb=20150327182409",R.raw.wartotle, Pokemon.Type.WATER, wartotleStats));
        pokemonList.add(new Pokemon("9", "Blastoise","https://archives.bulbagarden.net/media/upload/archive/a/ae/20201129170504%21Gary_Blastoise.png",R.raw.blastoise, Pokemon.Type.WATER, blastoiseStats));
        pokemonList.add(new Pokemon("25", "Pikachu","https://archives.bulbagarden.net/media/upload/thumb/0/0d/025Pikachu.png/240px-025Pikachu.png",R.raw.pikachu, Pokemon.Type.ELECTRIC, pikachuStats));
        pokemonList.add(new Pokemon("26", "Raichu","https://static.wikia.nocookie.net/espokemon/images/3/34/Raichu.png/revision/latest?cb=20160815220038",R.raw.raichu, Pokemon.Type.ELECTRIC, raichuStats));

        final PokemonListAdapter adapter = new PokemonListAdapter(getActivity(), R.layout.pokemon_list_item, pokemonList);
        pokemonListView.setAdapter( adapter);

        pokemonListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Pokemon selectedPokemon = adapter.getItem(position);

                if(selectedPokemon != null) {
                    mListener.onPokemonSelected(selectedPokemon);
                }
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    public interface OnFragmentInteractionListener {
        void onPokemonSelected(Pokemon pokemon);
    }
}