package com.example.no_bisnes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity
{
    private ProgressBar pb;
    private Button bt1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pb = (ProgressBar)findViewById(R.id.pb) ;
        pb.setVisibility(View.INVISIBLE);
        bt1 = (Button)findViewById(R.id.bt1);

        bt1.setOnClickListener(new View.OnClickListener()
        {
        @Override
        public void onClick(View view)
        {
            new Task().execute();
        }
        }
        );
    }

    class Task extends AsyncTask<String, Void, String>
    {

        @Override
        protected void onPreExecute()
        {
           pb.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(String... strings)
        {
            for (int i = 1; i<= 10; i++)
            {
                try
                {
                    Thread.sleep(1000);
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }

            return null;
        }

        @Override
        protected void onPostExecute(String s)
        {
            pb.setVisibility(View.INVISIBLE);
            Intent i = new Intent(getBaseContext(), menu_act.class);
            startActivity(i);
        }
    }
}