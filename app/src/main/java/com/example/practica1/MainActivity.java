package com.example.practica1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.Student;

public class MainActivity extends AppCompatActivity {

  final Student[] students = new Student[]{
    new Student("Tahiri", "Duran", "Reparto Alma Rosa, Santo Domingo Este", "Ing. en Tecnologia de la Informacion y Comunicacion", "29/11/1996", "Femenino",  R.drawable.tahiri),
    new Student("Jesus", "Suriel", "El millon, Distrito Nacional", "Ing. Industrial", "22/02/1993", "Masculino",  R.drawable.jesus),
    new Student("Jose", "Matos", "Los Alcarrizos, Santo Domingo Norte", "Ing. en Redes", "22/02/1992", "Masculino",  R.drawable.jose),
    new Student("Karina", "Lopez", "Invivienda, Santo Domingo Este", "Lic. en Contabilidad", "22/02/1996", "Femenino",  R.drawable.karina),
    new Student("Edward", "Bernard", "Brisas del Norte, Santo Domingo Norte", "Ing. Electrico", "08/03/1997", "Masculino",  R.drawable.rafa)
  };


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    List<HashMap<String, String>> aList = new ArrayList<>();

    for (int i = 0; i < students.length; i++) {
      HashMap<String, String> hm = new HashMap<>();
      hm.put("listview_title", students[i].getName() + " "+ students[i].getLastName());
      hm.put("listview_image", Integer.toString(students[i].getProfileImg()));
      aList.add(hm);
    }

    String[] from = {"listview_image", "listview_title", "listview_discription"};
    int[] to = {R.id.listview_image, R.id.listview_item_title};

    SimpleAdapter simpleAdapter = new SimpleAdapter(getBaseContext(), aList, R.layout.list_layout, from, to);
    final ListView androidListView = (ListView) findViewById(R.id.list_view);
    androidListView.setAdapter(simpleAdapter);

    androidListView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Student student = students[position];
        Intent i = new Intent(MainActivity.this, DetailActivity.class);

        i.putExtra("name",student.getName());
        i.putExtra("lastName",student.getLastName());
        i.putExtra("career",student.getCareer());
        i.putExtra("birthDate",student.getBirthDate());
        i.putExtra("address",student.getAddress());
        i.putExtra("profileImg",student.getProfileImg());
        i.putExtra("gender",student.getGender());

        startActivity(i);
      }
    });
  }
}
