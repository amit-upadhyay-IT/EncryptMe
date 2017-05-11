package com.amitupadhyay.encryptme;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.security.GeneralSecurityException;

public class MainActivity extends AppCompatActivity {

    TextView simpleMessage, encryptMessage, decryptMessage;

    private String encryptedMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        simpleMessage = (TextView) findViewById(R.id.simpleMessage);
        encryptMessage = (TextView) findViewById(R.id.encryptMessage);
        decryptMessage = (TextView) findViewById(R.id.decryptMessage);


        setSimpleMessage();
        doEncryption();
        doDecryptMessage();

    }

    private void setSimpleMessage()
    {
        simpleMessage.setText("Normal Message: AmitUpadhyay");
    }

    private void doEncryption()
    {
        String mykey = "password";
        String message = "AmitUpadhyay";

        try {
            encryptedMsg = AESCrypt.encrypt(mykey, message);
            encryptMessage.setText("Encrypted Message: "+encryptedMsg);
        }catch (GeneralSecurityException e){
            encryptMessage.setText("general security message");
            //handle error
        }
    }

    private void doDecryptMessage()
    {
        String mykey = "password";
        try {
            String messageAfterDecrypt = AESCrypt.decrypt(mykey, encryptedMsg);
            decryptMessage.setText("After Decrypt: "+messageAfterDecrypt);
        }catch (GeneralSecurityException e){
            //handle error - could be due to incorrect password or tampered encryptedMsg
            decryptMessage.setText("general security exception");
        }
    }
}
