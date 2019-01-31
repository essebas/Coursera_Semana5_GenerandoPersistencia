package co.sebasdeveloper.servipet2;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.NetworkOnMainThreadException;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.Toast;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Address;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.InternetAddress;

import co.sebasdeveloper.servipet2.Mailer.SimpleMail;




public class ContactForm extends AppCompatActivity {

    private static final int MY_PERMISSIONS_REQUEST_INTERNET = 1;
    private Toolbar toolbar;
    private TextInputEditText txtInEditName;
    private TextInputEditText txtInEditMail;
    private TextInputEditText txtInEditMessage;
    private TextInputLayout txtInLayoutName;
    private TextInputLayout txtInLayoutMail;
    private TextInputLayout txtInLayoutMessage;
    private Button btnEnviar;

    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hideSoftKeyboard();
        setContentView(R.layout.activity_contact_form);
        toolbar = (Toolbar) findViewById(R.id.layout_actionBar);
        txtInEditName = (TextInputEditText) findViewById(R.id.edTxt_name);
        txtInEditMail = (TextInputEditText) findViewById(R.id.edTxt_mail);
        txtInEditMessage = (TextInputEditText) findViewById(R.id.edTxt_message);
        txtInLayoutName = (TextInputLayout) findViewById(R.id.txi_name);
        txtInLayoutMail = (TextInputLayout) findViewById(R.id.txi_mail);
        txtInLayoutMessage = (TextInputLayout) findViewById(R.id.txi_message);
        btnEnviar = (Button) findViewById(R.id.btn_send);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        check();

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean required1 = verificarTextFilds(txtInEditName, txtInLayoutName, getResources().getString(R.string.txi_error_name));
                boolean required2 = verificarTextFilds(txtInEditMail, txtInLayoutMail, getResources().getString(R.string.txi_error_mail));
                boolean required3 = verificarTextFilds(txtInEditMessage, txtInLayoutMessage, getResources().getString(R.string.txi_error_message));

                try {
                    if(!required1 & !required2 & !required3){
                        SimpleMail simpleMailTask = new SimpleMail(v);
                        String resultado = simpleMailTask.execute(txtInEditMail.getText().toString(), txtInEditName.getText().toString(),
                                txtInEditMessage.getText().toString()).get();
                        if (resultado.equals("successfull")){
                            txtInEditName.setText("");
                            txtInEditMail.setText("");
                            txtInEditMessage.setText("");
                            //finish();
                        }
                    }
                }catch (Exception ex){
                    ex.printStackTrace();
                }

            }
        });
    }

    public boolean verificarTextFilds(TextInputEditText view, TextInputLayout view2, String texto){
        if (view.getText().toString().isEmpty()){
            view2.setError(texto);
            view2.setErrorEnabled(true);
            return true;
        }else{
            if(view2.isErrorEnabled()){
                view2.setErrorEnabled(false);
            }
            return false;
        }
    }

    public void check(){
        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET);
        //Toast.makeText(this, "Permiso: " + permissionCheck, Toast.LENGTH_SHORT).show();
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED){
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.READ_CONTACTS)) {

                // Show an expanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

            } else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.INTERNET},
                        MY_PERMISSIONS_REQUEST_INTERNET);
            }
        }
    }

    public void hideSoftKeyboard() {
        if(getCurrentFocus()!=null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
    }

    public void showSoftKeyboard(View view) {
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        view.requestFocus();
        inputMethodManager.showSoftInput(view, 0);
    }

}
