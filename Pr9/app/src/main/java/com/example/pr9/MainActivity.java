package com.example.pr9;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.Buffer;

public class MainActivity extends AppCompatActivity
{
    EditText cont;
    EditText filename;
    TextView textView1;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView1  =findViewById(R.id.textview);
        Button add = findViewById(R.id.addbut);
        add.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                cont=findViewById(R.id.cont);
                String contval = cont.getText().toString();
                Toast.makeText(MainActivity.this,contval,Toast.LENGTH_LONG).show();

                textView1.setText(contval);
            }
        });
        filename=findViewById(R.id.name);
        cont=findViewById(R.id.cont);

        Button save = findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (filename.getText().toString().length() > 0)
                {
                    String strfilename=filename.getText().toString();
                    try(FileOutputStream outputStream = MainActivity.this.openFileOutput(strfilename, Context.MODE_APPEND))
                    {
                        outputStream.write(cont.getText().toString().getBytes());
                    } catch (FileNotFoundException e)
                    {
                        throw new RuntimeException(e);
                    } catch (IOException e)
                    {
                        throw new RuntimeException(e);
                    }
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Сначала укажите имя файла", Toast.LENGTH_LONG).show();
                }
            }
        });

        Button readbut = findViewById(R.id.read);
        readbut.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (filename.getText().toString().length()>0)
                {
                    String strfilename= filename.getText().toString();
                    try(FileInputStream fileInputStream = MainActivity.this.openFileInput(strfilename))
                    {
                        byte buffer[] = new byte[(fileInputStream.available())];
                        fileInputStream.read(buffer);
                        textView1.setText(new String(buffer));
                    } catch (FileNotFoundException e)
                    {
                        throw new RuntimeException(e);
                    } catch (IOException e)
                    {
                        throw new RuntimeException(e);
                    }
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Введите имя файла",Toast.LENGTH_LONG).show();
                }

            }
        });
        Button delete = findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (filename.getText().toString().length() > 0)
                {
                    String strfilename = filename.getText().toString();
                    AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                    alertDialog.setTitle("Предупреждение");
                    File dir = getFilesDir();
                    File file = new File(dir, strfilename);
                    if (file.exists())
                    {
                        alertDialog.setMessage("Вы уверенны, что хотите удлаить файл с названием" + strfilename + "?");
                        alertDialog.setPositiveButton("Da", new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialog, int which)
                            {

                                {
                                    Boolean filedeleted = file.delete();
                                    Toast.makeText(MainActivity.this, "Файл удалён", Toast.LENGTH_LONG).show();


                                }

                            }


                        });
                        alertDialog.setNegativeButton("Net", new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialog, int which)
                            {
                                dialog.dismiss();
                            }
                        });
                        AlertDialog alertDialog1 = alertDialog.create();
                        alertDialog1.show();
                    }
                    else
                    {
                        Toast.makeText(MainActivity.this, "Такого файла нет", Toast.LENGTH_LONG).show();
                    }


                }
                else
                {
                    Toast.makeText(MainActivity.this, "Поле с вводом имени файла пустое!", Toast.LENGTH_LONG).show();
                }
            }
        });

        if (savedInstanceState!=null)
            onRestoreInstanceState(savedInstanceState);

    }

    @Override
    protected void onSaveInstanceState(Bundle outstate)
    {
        super.onSaveInstanceState(outstate);
        outstate.putString("KEY",textView1.getText().toString());
    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState)
    {
        super.onRestoreInstanceState(savedInstanceState);
        String val = savedInstanceState.getString("KEY");
        textView1.setText(val);
    }

}