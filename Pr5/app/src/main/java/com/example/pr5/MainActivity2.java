package  com.example.pr5;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MainActivity2 extends AppCompatActivity
{

    //String[] namesJava = {"Elmar","Leonid","Gleb", "Ilya", "Fariz", "Rasid"};
    ArrayAdapter<String> namestoListview;
    ArrayList<String>selectednames = new ArrayList<String>();
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        ArrayList<String> names = new ArrayList<String >();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button addBut = findViewById(R.id.addbutton);
        String[] namesXML = getResources().getStringArray(R.array.names);
        Collections.addAll(names,namesXML);
        listView=(ListView) findViewById(R.id.listview1);
        namestoListview = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_multiple_choice,names);
        listView.setAdapter(namestoListview);

        Button delBut = findViewById(R.id.deleteButton);
        //TextView SelecredTextView= findViewById(R.id.textView2);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            SparseBooleanArray seleceted = listView.getCheckedItemPositions();
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                String selectedItem = namestoListview.getItem(position);
                if (listView.isItemChecked(position))
                {
                    selectednames.add(selectedItem);
                }
                //SelecredTextView.setText(selectedItem);
//                for (int i=0;i<namesXML.length;i++)
//                {
//                    if (seleceted.get(i))
//                    {
//                        selectedItem+=namesXML[i]+",";
//                        SelecredTextView.setText(selectedItem);
//                    }
//                }
            }
        });


        addBut.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                AddItem(v);
            }
        });

        delBut.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                deletefunc(v);
            }
        });
    }
    void AddItem(View v)
    {
        String vvod="";
        EditText editText= findViewById(R.id.editTextText2);
        vvod = editText.getText().toString();
        if (!vvod.isEmpty())
        {
            Toast.makeText(MainActivity2.this,vvod,Toast.LENGTH_LONG).show();
            namestoListview.add(vvod);
            namestoListview.notifyDataSetChanged();
            editText.setText("");
        }
        else
        {
            Toast.makeText(MainActivity2.this,"NO",Toast.LENGTH_LONG).show();
        }
    }
    void deletefunc(View v)
    {
        for (int i=0;i<selectednames.size();i++)
        {
            namestoListview.remove(selectednames.get(i));
        }
        listView.clearChoices();
        namestoListview.notifyDataSetChanged();
    }

}
