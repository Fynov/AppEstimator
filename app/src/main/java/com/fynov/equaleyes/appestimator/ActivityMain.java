package com.fynov.equaleyes.appestimator;

import android.app.VoiceInteractor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.fynov.equaleyes.lib_data.DataAll;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ActivityMain extends AppCompatActivity{
    ApplicationMy app;
    ActivityMain ac;
    RecyclerView mRecyclerView;
    AdapterAnswer mAdapter;
    Button btnNext;
    Button btnBack;
    ProgressBar pbProgress;
    TextView tvQuestion;
    int questionID = 0;
    int size;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ac = this;
        String URL="http://192.168.0.102:8000/estimateApi/?format=json";
        final ArrayList<String> list = new ArrayList<String>();

        RequestQueue requestQueue= Volley.newRequestQueue(this);
        JsonArrayRequest objectRequest = new JsonArrayRequest(
                Request.Method.GET,
                URL,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                       String test = response.toString();
                        int len = response.length();
                        for (int i=0;i<len;i++){
                            try {
                                list.add(response.get(i).toString());
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        String napaka = "napaka";

                    }
                }
        );
        requestQueue.add(objectRequest);

        //primer list[0]
        //{"vprasanje":"How big is your app?","odg":[{"odgovor1":"small","odgovor2":"medium","odgovor3":"large","odgovor4":"","odgovor5":"","odgovor6":"","odgovor7":"","odgovor8":"","odgovor9":"","odgovor10":"","platforma":"WEB"}]}

        app = (ApplicationMy) getApplication();
        mRecyclerView = (RecyclerView) findViewById(R.id.rvAnswers);
        btnNext = findViewById(R.id.btnNext);
        btnBack = findViewById(R.id.btnBack);
        pbProgress = findViewById(R.id.pbProgress);
        tvQuestion = findViewById(R.id.tvQuestion);

        app.all = new DataAll();
        app.all.Scenario();


        size = app.all.getQuestions().size();
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new AdapterAnswer(app.all.getQuestion(questionID), ac);
        tvQuestion.setText(app.all.getQuestion(questionID).getText());
        mRecyclerView.setAdapter(mAdapter);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (questionID<size)
                    questionID++;

                double tmp = (1.0f * questionID/size);
                tmp = round(tmp, 2);
                pbProgress.setProgress((int) (tmp*100));

                if (questionID < size){
                    mAdapter = new AdapterAnswer(app.all.getQuestion(questionID), ac);
                    mRecyclerView.setAdapter(mAdapter);
                    tvQuestion.setText(app.all.getQuestion(questionID).getText());
                }else {
                    mRecyclerView.setVisibility(View.INVISIBLE);
                    tvQuestion.setText("DONE");
                }
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (questionID>0)
                    questionID--;

                double tmp = (1.0f * questionID/size);
                tmp = round(tmp, 2);
                pbProgress.setProgress((int) (tmp*100));

                mAdapter = new AdapterAnswer(app.all.getQuestion(questionID), ac);
                mRecyclerView.setAdapter(mAdapter);
                tvQuestion.setText(app.all.getQuestion(questionID).getText());
                mRecyclerView.setVisibility(View.VISIBLE);
            }
        });

        /*
        Bundle bundle = new Bundle();
        bundle.putString("code", app.all.getQuestion(0).getText());
        Fragment fragment = new FragmentQuestion();
        fragment.setArguments(bundle);
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment, fragment);
        ft.commit();*/
    }
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
}
