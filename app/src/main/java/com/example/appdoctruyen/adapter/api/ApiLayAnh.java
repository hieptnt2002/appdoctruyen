package com.example.appdoctruyen.adapter.api;

import android.os.AsyncTask;

import com.example.appdoctruyen.adapter.interfaces.LayAnhVe;
import com.example.appdoctruyen.adapter.interfaces.LayTruyenVe;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class ApiLayAnh extends AsyncTask<Void,Void,Void> {
    String data;
    String idChap;
    LayAnhVe layAnhVe;

    public ApiLayAnh(LayAnhVe layAnhVe,String idChap) {
        this.layAnhVe = layAnhVe;
        this.idChap = idChap;
        this.layAnhVe.batDau();
    }

    @Override
    protected Void doInBackground(Void... voids) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
//                .url("https://api.jsonserve.com/KbA9c3")
//                .url("https://api.jsonserve.com/-zdDp_")
                .url("https://lamlong.000webhostapp.com/layAnh.php?idChap="+idChap)
                .build();
        data  = null;
        try {
            Response response = client.newCall(request).execute();
            ResponseBody body = response.body();
            data = body.string();

        } catch (IOException e) {
            data=null;

        }
        return null;
    }

    @Override
    protected void onPostExecute(Void unused) {
        if(data == null){
            this.layAnhVe.biLoi();

        }else {
            this.layAnhVe.ketThuc(data);
        }
    }
}
