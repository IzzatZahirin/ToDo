package sg.edu.rp.c346.id20042321.todo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText etElement;
    Button btnAdd;
    Button btnDelete;
    ListView lvToDo;

    ArrayList<String> alTodo;
    ArrayAdapter<String> aaTodo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
        setTitle ("Simple To Do");

        etElement = findViewById (R.id.editTextActivity);
        btnAdd = findViewById (R.id.buttonAddActivity);
        btnDelete = findViewById (R.id.buttonDeleteActivity);
        lvToDo = findViewById (R.id.listViewActivity);

        alTodo = new ArrayList<> ();
        aaTodo = new ArrayAdapter<> (this, android.R.layout.simple_list_item_1, alTodo);
        lvToDo.setAdapter (aaTodo);

        btnAdd.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                String newTodo = etElement.getText ().toString ();
                alTodo.add(newTodo);
                aaTodo.notifyDataSetChanged ();
                etElement.setText ("");
            }
        });

        btnDelete.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                alTodo.clear ();
                aaTodo.notifyDataSetChanged ();
            }
        });

    }
}