package com.techcrevices.retrofitexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ApiInterface apiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiInterface = ApiClient.getClient().create(ApiInterface.class);

    }

    public void postData(View view){

        Call<String> call = apiInterface.postdata("Hello World");
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Log.e("Resdata",response.body());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });


/*echo $json_data = file_get_contents('php://input');*/




    }

    public void postData2(View view){

        Call<DataModel> call = apiInterface.DATA_MODEL_CALL("Hello World","fdghj");
        call.enqueue(new Callback<DataModel>() {
            @Override
            public void onResponse(Call<DataModel> call, Response<DataModel> response) {
                Log.e("Resdata2",response.toString());
                Log.e("Resdataa2",response.body().toString());

                String s = response.body().getName();
                Toast.makeText(MainActivity.this,""+s,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<DataModel> call, Throwable t) {
                Log.e("ResdataError",t.toString());
            }
        });


        /*$data = $_POST['id'];
        $data2 = $_POST['name'];


        $res['id'] = $data;
        $res['name'] = "$data2";

        echo json_encode($res);*/
    }

    public void postData3(View view){

        DataModel dataModel = new DataModel("fefefs","SEFSEF");

        Call<DataModel> call = apiInterface.DATA_MODEL_CALL2(dataModel);
        call.enqueue(new Callback<DataModel>() {
            @Override
            public void onResponse(Call<DataModel> call, Response<DataModel> response) {
                Log.e("Resdata3",response.toString());
                Log.e("Resdataa3",response.body().toString());

                String s = response.body().getName();
                Toast.makeText(MainActivity.this,""+s,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<DataModel> call, Throwable t) {
                Log.e("ResdataError",t.toString());
            }
        });

/*        echo $json_data = file_get_contents('php://input');
 */

    }
}
