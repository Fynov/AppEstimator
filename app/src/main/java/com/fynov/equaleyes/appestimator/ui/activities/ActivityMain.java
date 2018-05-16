package com.fynov.equaleyes.appestimator.ui.activities;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.fynov.equaleyes.appestimator.R;
import com.fynov.equaleyes.appestimator.data.ApplicationMy;
import com.fynov.equaleyes.appestimator.ui.adapters.AdapterAnswer;
import com.fynov.equaleyes.lib_data.Answer;
import com.fynov.equaleyes.lib_data.DataAll;
import com.fynov.equaleyes.lib_data.Question;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ActivityMain extends AppCompatActivity{
    ApplicationMy app;
    ActivityMain ac;

    //UI
    Button btnNext;
    Button btnBack;
    ProgressBar pbProgress;
    TextView tvQuestion;
    EditText etMail;

    //Recycler
    RecyclerView mRecyclerView;
    AdapterAnswer mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    //Variables
    int questionID = 0;
    int size;
    boolean finalScreen = false;

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
        etMail = findViewById(R.id.editMail);

        app.all = new DataAll();
        //LOAD MOCK DATA
        //TODO: ADD API CALL FOR DATA
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
                if (!finalScreen) {
                    if (questionID < size)
                        questionID++;

                    double tmp = (1.0f * questionID / size);
                    tmp = round(tmp, 2);
                    pbProgress.setProgress((int) (tmp * 100));

                    if (questionID < size) {
                        mAdapter = new AdapterAnswer(app.all.getQuestion(questionID), ac);
                        mRecyclerView.setAdapter(mAdapter);
                        tvQuestion.setText(app.all.getQuestion(questionID).getText());
                    } else {
                        mRecyclerView.setVisibility(View.GONE);
                        btnNext.setText("FINISH");
                        tvQuestion.setText("DONE \n Input E-Mail for results.");
                        etMail.setVisibility(View.VISIBLE);
                        if (app.all.getUserMail() != null)
                            etMail.setText(app.all.getUserMail());
                    }
                }else {
                    //TODO: API klic za rezultat
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

                //Resets
                mRecyclerView.setVisibility(View.VISIBLE);
                etMail.setVisibility(View.GONE);
                btnNext.setText("NEXT");
            }
        });

        etMail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                app.all.setUserMail(editable.toString());
            }
        });
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    public class getAPIquestions extends AsyncTask<String,String, List<Question> > {

        @Override
        protected void onCancelled() {
            super.onCancelled();
        }

        @Override
        protected List<Question> doInBackground(String... params) {
            HttpURLConnection connection = null;
            BufferedReader reader = null;

            try {
                URL url = new URL(params[0]);
                connection = (HttpURLConnection) url.openConnection();
                connection.connect();
                InputStream stream = connection.getInputStream();
                reader = new BufferedReader(new InputStreamReader(stream));
                StringBuffer buffer = new StringBuffer();
                String line = "";
                while ((line = reader.readLine()) != null) {
                    buffer.append(line);
                }

                String finalJson = buffer.toString();

                JSONObject parentObject = new JSONObject(finalJson);
                JSONArray parentArray = parentObject.getJSONArray("result");

                List<Question> questionList = new ArrayList<>();

                Gson gson = new Gson();
                for (int i = 0; i < parentArray.length(); i++) {
                    JSONObject finalObject = parentArray.getJSONObject(i);

                    Question quest = new Question();
                    quest.setId(finalObject.getInt("ID"));
                    quest.setText(finalObject.getString("Text"));

                    ArrayList<Answer> answerList = new ArrayList<>();
                    JSONArray answerArray = finalObject.getJSONArray("Answers");
                    for (int j = 0; j < answerArray.length(); j++) {
                        JSONObject finalAnswer = answerArray.getJSONObject(i);

                        Answer answerTMP = new Answer();
                        answerTMP.setId(finalAnswer.getInt("ID"));
                        answerTMP.setText(finalAnswer.getString("Text"));
                        answerTMP.setDetails(finalAnswer.getString("Details"));
                        answerTMP.setTime(finalAnswer.getInt("Time"));
                        answerTMP.setValue(finalAnswer.getInt("Value"));

                        answerList.add(answerTMP);
                    }
                    quest.setAnswers(answerList);

                    if (quest.getId() != 0)
                        questionList.add(quest);
                }
                return questionList;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    connection.disconnect();
                }
                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPostExecute(final List<Question> result) {
            super.onPostExecute(result);

            if (result != null) {

            }
        }
    }
}
