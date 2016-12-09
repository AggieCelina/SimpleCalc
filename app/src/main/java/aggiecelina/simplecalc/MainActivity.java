package aggiecelina.simplecalc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText inputNb;
    Button buttonClear;
    Button buttonAdd;
    Button buttonSub;
    Button buttonMulti;
    Button buttonEq;
    TextView resultValue;
    float total = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // find the elements
        inputNb = (EditText) findViewById(R.id.inputNb);
        buttonClear = (Button) findViewById(R.id.buttonClear);
        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonSub = (Button) findViewById(R.id.buttonSub);
        buttonMulti = (Button) findViewById(R.id.buttonMulti);
        buttonEq = (Button) findViewById(R.id.buttonEq);
        resultValue = (TextView) findViewById(R.id.resultValue);

        // set a listener
        buttonClear.setOnClickListener(this);
        buttonAdd.setOnClickListener(this);
        buttonSub.setOnClickListener(this);
        buttonMulti.setOnClickListener(this);
        buttonEq.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {

        float input = 0;

        switch (view.getId()) {
            case R.id.buttonAdd:
                // check if the fields are empty (so the app does not crash)
                if (TextUtils.isEmpty(inputNb.getText().toString())) {
                    return;
                } else {
                    inputNb.setText(inputNb.getText() + "+");
                    inputNb.setSelection(inputNb.getText().length());
                    break;
                }

            case R.id.buttonClear:
                total = 0;
                input = 0;
                resultValue.setText("0.0");
                inputNb.setText("");
                break;

            case R.id.buttonEq:

                String inputString;
                inputString = inputNb.getText().toString();
                Pattern pattern = Pattern.compile(inputString, Pattern.CASE_INSENSITIVE);
                Matcher matcher = pattern.matcher("(\\d)[+-x](\\d)");
                resultValue.setText("something works");
                break;

            case R.id.buttonMulti:

                if (TextUtils.isEmpty(inputNb.getText().toString())) {
                    return;
                } else {
                    inputNb.setText(inputNb.getText() + "x");
                    inputNb.setSelection(inputNb.getText().length());
                    break;
                }

            case R.id.buttonSub:

                if (TextUtils.isEmpty(inputNb.getText().toString())) {
                    return;
                } else {
                    inputNb.setText(inputNb.getText() + "-");
                    inputNb.setSelection(inputNb.getText().length());
                    ;
                    break;
                }


            default:
                break;
        }


    }
}
