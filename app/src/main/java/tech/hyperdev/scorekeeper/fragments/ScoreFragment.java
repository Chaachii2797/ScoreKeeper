package tech.hyperdev.scorekeeper.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import tech.hyperdev.scorekeeper.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScoreFragment extends Fragment{

    public ScoreFragment() {
        // Required empty public constructor
    }
    ImageButton btnAdd, btnSub;
    Spinner spinner;
    String name;
    int score;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        setRetainInstance(true);
        View view = inflater.inflate(R.layout.fragment_score, container, false);
        readBundle(getArguments());

        TextView teamName = (TextView) view.findViewById(R.id.tvTeamName);
        teamName.setText(name+"");

        btnAdd = (ImageButton) view.findViewById(R.id.btnPlus);
        btnSub = (ImageButton) view.findViewById(R.id.btnMinus);

        final TextView tvScore = (TextView) view.findViewById(R.id.textScore);
        score = Integer.parseInt(tvScore.getText().toString());
        tvScore.setText("");

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Add"+score,Toast.LENGTH_SHORT).show();
                ++score;
                tvScore.setText(" "+score);
            }
        });
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Minus"+score,Toast.LENGTH_SHORT).show();
                --score;
                tvScore.setText(" "+score);

            }
        });
//        btnSub.setOnClickListener(this);
//        btnAdd.setOnClickListener(this);

        return view;
    }

    public static ScoreFragment newInstance(String name){
        Bundle bundle = new Bundle();
        bundle.putString("name",name);

        ScoreFragment fragment = new ScoreFragment();
        fragment.setArguments(bundle);
        return fragment;
    }

    private void readBundle(Bundle bundle) {
        if (bundle != null) {
            name = bundle.getString("name");
        }
    }
//
//    @Override
//    public void onClick(View v) {
//        if(v==btnAdd){
//            score++;
//                if(score<0){
//                    score=0;
//                    tvScore.setText(""+score);
//            }
//        }
//    }
//    else if(v==btnMinus){
//        score--;
//            if(score<0) {
//                score = 0;
//                tvScore.setText("" + score);
//            }
//    }
}
