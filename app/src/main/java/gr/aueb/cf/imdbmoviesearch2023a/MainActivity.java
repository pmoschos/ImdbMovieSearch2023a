package gr.aueb.cf.imdbmoviesearch2023a;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import gr.aueb.cf.imdbmoviesearch2023a.adapters.MovieAdapter;
import gr.aueb.cf.imdbmoviesearch2023a.models.Movie;

public class MainActivity extends AppCompatActivity {

    private EditText searchET;
    private Button searchBtn;
    private RecyclerView recyclerView;
    private ArrayList<Movie> movieArrayList;
    private TextView numberOfMovies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchET = findViewById(R.id.searchET);
        searchBtn = findViewById(R.id.searchBtn);
        recyclerView = findViewById(R.id.recyclerView);
        movieArrayList = new ArrayList<>();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        // linearLayoutManager.setStackFromEnd(true);
        // linearLayoutManager.setReverseLayout(true);
        recyclerView.setLayoutManager(linearLayoutManager);

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (searchET.getText().toString().trim().isEmpty()) {
                    searchET.setError("Please enter a movie name");
                } else {
                    RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
                    // TODO: set your key value (YOUR KEY VALUE) !
                    String url = "https://imdb-api.com/en/API/SearchMovie/k_e2h9g4au/" + searchET.getText().toString().trim();

                    JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            System.out.println("Response" + response.toString());
                            try {
                                movieArrayList.clear();
                                JSONArray jsonArray = response.getJSONArray("results");

                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject movieJsonObject = jsonArray.getJSONObject(i);
                                    Movie movie = new Movie();
                                    movie.setId(movieJsonObject.getString("id"));
                                    movie.setTitle(movieJsonObject.getString("title"));
                                    movie.setDescription(movieJsonObject.getString("description"));
                                    movie.setImage(movieJsonObject.getString("image"));
                                    movie.setResultType(movieJsonObject.getString("resultType"));
                                    movieArrayList.add(movie);
                                }
                                recyclerView.setAdapter(new MovieAdapter(movieArrayList));
                            } catch (JSONException e) {
                                throw new RuntimeException(e);
                            }

                        }
                    }, new Response.ErrorListener() {

                        @Override
                        public void onErrorResponse(VolleyError error) {
                            // TODO: Handle error

                        }
                    });

                    // Access the RequestQueue through your singleton class.
                    requestQueue.add(jsonObjectRequest);
                }
            }
        });
    }
}