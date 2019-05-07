package com.example.myapplication4;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.io.IOException;
import java.lang.reflect.GenericSignatureFormatError;
import java.lang.reflect.Type;
import java.sql.Array;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public static Retrofit retrofit;
    public MyAPIService api;
    public TextView get4;
    public TextView patch;
    public TextView post3;
    public TextView delete2;
    public ImageView imageView;
    private String Url = "http://2ccf6ed2.ngrok.io/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        retrofit = new Retrofit.Builder()
                .baseUrl(Url + "app/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(MyAPIService.class);

        getProdcut(1);

        getProdcutList();
        getProdcutName();
        postMethod();
    }

    void getProdcut(int id) {
        get4 = (TextView)findViewById(R.id.textView4);
        Call<product> call = api.getProduct(id);

        call.enqueue(new Callback<product>() {
            @Override
            public void onResponse(Call<product> call, Response<product> response) {
                String result = response.body().getImage().get(0);

                get4.setText(result);
                imageView = (ImageView) findViewById(R.id.imageView);

                Picasso.get().load(Url+ result).into(imageView);


            }
            @Override
            public void onFailure(Call<product> call, Throwable t) {
                get4.setText(t.toString());
            }
        });
    }

    void getProdcutName() {
        delete2 = (TextView)findViewById(R.id.textView2);
        Call<ProductNameResponse> call = api.getProductName();

        call.enqueue(new Callback<ProductNameResponse>() {
            @Override
            public void onResponse(Call<ProductNameResponse> call, Response<ProductNameResponse> response) {
                try{
                    ProductNameResponse result = response.body();
                    if(result == null) throw new IOException("Result is null");

                    String str = "";
                    for (int i = 0; i < result.ProductName.size(); i++) {
                        str += "name: " + result.ProductName.get(i).name + " id: " + result.ProductName.get(i).Pid + "\n";
                    }
                    delete2.setText(str);

                }catch (IOException e){
                    delete2.setText(e.toString());
                }


            }
            @Override
            public void onFailure(Call<ProductNameResponse> call, Throwable t) {
                Log.e("U",t.toString());
                delete2.setText(t.toString());
            }
        });
    }

    void getProdcutList() {
        patch = (TextView)findViewById(R.id.textView);
        Call<ResponseBody> call = api.getProductList();

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try{
                    ResponseBody result = response.body();

                    patch.setText(result.string());

                }catch (IOException e){
                    patch.setText(e.toString());
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e("U",t.toString());
                patch.setText(t.toString());
            }
        });
    }


    void postMethod() {
        post3 = (TextView)findViewById(R.id.textView3);
        String feedback = "AAAAAAC";

        Call<feedback> call = api.feedback(2, 1,feedback);

        call.enqueue(new Callback<com.example.myapplication4.feedback>() {
            @Override
            public void onResponse(Call<com.example.myapplication4.feedback> call, Response<com.example.myapplication4.feedback> response) {

                 feedback fb = response.body();
                 if(fb != null){
                     System.out.println("feedback" + fb.getFeedback());
                     System.out.println(fb.getFeedback());
                 }


//                String result = response.body().toString();
//                String result1 = result.replaceAll("\\\\", "");
//                String result2 = result1.replaceAll(Matcher.quoteReplacement("$"), "");
//                String result3 = result2.substring(1, result2.length()-1);
//
//                post3.setText(result3);
            }

            @Override
            public void onFailure(Call<com.example.myapplication4.feedback> call, Throwable t) {
                Log.e("U", t.toString());
                post3.setText(t.toString());
            }
        });


    }

}
