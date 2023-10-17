package tdtu.edu.vn.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView simpleList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_1);

        simpleList = (ListView) findViewById(R.id.simpleListView);

        List<String> datas = new ArrayList<String>();
        // generator data
        for(int i=0;i<100;i++){
            datas.add(new String("item" + (i+1)));
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.layout_one_item_1,R.id.textView,datas);
        simpleList.setAdapter(adapter);


    }
}