package com.totrail.totrail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
// import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.SharedPreferences;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;
import java.math.BigInteger;



public class loginActivity extends AppCompatActivity {

    EditText login_email;
    EditText login_password;
    Button login_button;
    Button reg_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login_email = findViewById(R.id.login_email);
        login_password = findViewById(R.id.login_password);
        login_button = findViewById(R.id.login_button);
        reg_button = findViewById(R.id.reg_button);
        checkNetworkConnection();

    }
    public boolean checkNetworkConnection() {
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        boolean isConnected = false;
        if (networkInfo == null && (isConnected = true)) {
            Context context = getApplicationContext();
            CharSequence text = "Вы не подключены к интернету!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }

        return isConnected;
    }

//    public class OAuth2Request extends SpringAndroidSpiceRequest<OAuth2Token> {
//        private final String user;
//        private final String pass;

//        public OAuth2Request(String user, String pass) {
//            super(OAuth2Token.class);
//
//            this.user = user;
//            this.pass = pass;
//        }

//        @Override
//        public OAuth2Token loadDataFromNetwork() throws RestClientException {
//            String client_id = "testid";
//            String client_secret = "testsecret";
//            HttpBasicAuthentication authHeader = new HttpBasicAuthentication(client_id, client_secret);
//            HttpHeaders requestHeaders = new HttpHeaders();
//            requestHeaders.setAuthorization(authHeader);
//            requestHeaders.setUserAgent("AndroidNotesApp/1.0");
//
//            MultiValueMap<String, String> data = new LinkedMultiValueMap<>();
//            data.add("grant_type", "password");
//            data.add("username", this.user);
//            data.add("password", this.pass);
//            HttpEntity<?> requestEntity = new HttpEntity<>(data, requestHeaders);
//
//            String url = "http://10.0.2.2:8000/oauth2/token/";
//
//            getRestTemplate().getMessageConverters().clear();
//            getRestTemplate().getMessageConverters().add(new FormHttpMessageConverter());
//            getRestTemplate().getMessageConverters().add(new MappingJacksonHttpMessageConverter());
//            return getRestTemplate().postForObject(url, requestEntity, OAuth2Token.class);
//        }




    }


