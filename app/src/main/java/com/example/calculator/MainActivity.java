package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // declare variables for user input, button click, and result display
        EditText num1, num2, operator;
        Button calcu_button;
        TextView result;
        LinearLayout liMain;

        // initialize variables with views from the layout file
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        operator = findViewById(R.id.operator);
        calcu_button = findViewById(R.id.calcu_button);
        result = findViewById(R.id.result);
        liMain = findViewById(R.id.liMain);

        // perform arithmetic operation based on operator chosen by user
        calcu_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // get user input values as doubles and operator as a string
                double n1 = Double.parseDouble(num1.getText().toString());
                double n2 = Double.parseDouble(num2.getText().toString());
                String ope = operator.getText().toString();
                char op = ope.charAt(0);

                double ans = 0;
                switch (op){
                    // perform addition
                    case '+':{
                        result.setText(n1 + " + " + n2 + " = " + (n1+n2));
                        break;
                    }
                    // perform subtraction
                    case '-':{
                        result.setText(n1 + " - " + n2 + " = " + (n1-n2));
                        break;
                    }
                    // perform multiplication
                    case '*':{
                        result.setText(n1 + " * " + n2 + " = " + (n1*n2));
                        break;
                    }
                    // perform modulus
                    case '%':{
                        result.setText(n1 + " % " + n2 + " = " + (n1%n2));
                        break;
                    }
                    // perform exponentiation
                    case '^':{
                        result.setText(n1 + " ^ " + n2 + " = " + Math.pow(n1,n2));
                        break;
                    }
                    // perform division and check for division by zero
                    case '/':{
                        if (n2 != 0) {
                            ans = n1 / n2;
                            result.setText(n1 + " / " + n2 + " = " + ans);
                        } else {
                            result.setText("Error!! Cannot divide by zero");
                        }
                        break;
                    }
                    // default case if operator entered by user is not recognized
                    default:
                        result.setText("Error!! Please enter valid operator");
                }
            }
        });
    }
}
