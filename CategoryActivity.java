package edu.purdue.sankara2.todolist;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CategoryActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "CategoryActivity";
    private EditText edit;
    private Button cancel;
    private Button add;
    private TextView titleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        //TODO: 1. Initialize all views using findViewById()
        //TODO: 2. Register OnClickListener for the two buttons
        titleView = (TextView)findViewById(R.id.category_title);
        edit = (EditText)findViewById(R.id.category_edittext);
        cancel = (Button)findViewById(R.id.cancel_btn);
        add = (Button)findViewById(R.id.add_btn);
        cancel.setOnClickListener(this);
        add.setOnClickListener(this);

        titleView.setText("Add New Category");

        }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //TODO: 3. When cancel button is clicked, go back to MainActivity
            case R.id.cancel_btn:
            onBackPressed();
            break;

            case R.id.add_btn:
                String newCategory = edit.getText().toString();
                if(newCategory.isEmpty())
                {
                    AlertDialog alertDialog = new AlertDialog.Builder(CategoryActivity.this).create();
                    alertDialog.setTitle("Alert");
                    alertDialog.setMessage("Category cannot be empty.");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();

                }
                else
                {
                    for(int i = 0; i < MainActivity.categories.size(); i++)
                    {
                        if(newCategory.equals(MainActivity.categories.get(i)))
                        {
                            AlertDialog alertDialog = new AlertDialog.Builder(CategoryActivity.this).create();
                            alertDialog.setTitle("Alert");
                            alertDialog.setMessage("Category exists.");
                            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                    new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.dismiss();
                                        }
                                    });
                            alertDialog.show();
                            return;
                        }
                    }
                    MainActivity.newCategories.add(newCategory);
                    onBackPressed();

                }
                break;

                /*
                TODO: 4. When add is clicked, you need to check the following conditions
                      (1) If category is empty, popup a dialog says 'Category cannot be empty'
                      (2) If category already exists, popup a dialog says 'Category exists'
                      (3) If a valid category is input, add it to MainActivity.newCategories and go back to MainActivity using onBackPressed()
                */

        }
    }
}
