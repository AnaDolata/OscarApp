package com.example.oscarapp.apiMovie;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class RequestTask extends AsyncTask<String, Void, Integer> {
    private String obj;
    private Context myContext;
    private static final String IP = "192.168.0.186";
    private static final int port = 12345;

    public RequestTask(Context myContext) {
        this.myContext = myContext;
    }

    @Override
    protected Integer doInBackground(String... strings) {
        int token = 0;
        try {
            Socket socket = new Socket(IP, port);
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());
            out.writeUTF(strings[0]);
            out.flush();
            token = in.readInt();
            out.close();
            in.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return token;
    }

    @Override
    protected void onPostExecute(Integer integer) {
        super.onPostExecute(integer);
        Toast.makeText(myContext, integer.toString(), Toast.LENGTH_SHORT).show();
    }
}
