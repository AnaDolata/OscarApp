package com.example.oscarapp.apiMovie;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class RequestTask extends AsyncTask<String, Void, String> {
    private String obj;
    private Context myContext;
    private static final String IP = "10.0.0.2";
    private static final int port = 12345;

    public RequestTask(String obj, Context myContext) {
        this.obj = obj;
        this.myContext = myContext;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Toast.makeText(myContext, s, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected String doInBackground(String... strings) {
        String msg = "";
        try{
            Socket socket = new Socket(IP, port);
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());
            output.writeChars(strings[0]);
            output.flush();
            msg = input.readUTF();
            output.close();
            input.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return msg;
    }
}
