package com.example.asynctask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnHanding;
    TextView txtInformation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnHanding = (Button) findViewById(R.id.buttonHandling);
        txtInformation = (TextView) findViewById(R.id.textViewInformation);

        btnHanding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Task().execute();
            }
        });
    }

    private class Task extends AsyncTask<Void, String, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            txtInformation.setText("Start" + "\n");
        }

        @Override
        protected String doInBackground(Void... voids) {
            for (int i = 1; i <= 5; i++){

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                publishProgress("Finish" + i + "\n");
            }

            return "Finish \n";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            txtInformation.append(s);
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            txtInformation.append(values[0]);
        }
    }
}
