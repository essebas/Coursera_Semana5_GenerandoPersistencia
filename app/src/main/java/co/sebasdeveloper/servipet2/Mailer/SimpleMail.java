package co.sebasdeveloper.servipet2.Mailer;


import android.os.AsyncTask;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;

import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Transport;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMultipart;

import co.sebasdeveloper.servipet2.R;


public class SimpleMail extends AsyncTask<String,Void,String> {

    private static final String SMTP_HOST_NAME = "smtp.gmail.com";
    private static final String SMTP_AUTH_USER = "exaple@gmail.com";// Put your email address
    private static final String SMTP_AUTH_PASS = "123"; // Put your email password

    private static Message message;

    private View view;

    public SimpleMail(View view) {
        this.view = view;
    }

    @Override
    protected String doInBackground(String... params) {
        String pTo = params[0];
        String pSubject = params[1];
        String pMsm = params[2];
        sendMail(pTo,pSubject,pMsm);
        return "successfull";
    }

    @Override
    protected void onPostExecute(String result) {
        if(result.equals("successfull")){
            Snackbar.make(view, view.getResources().getString(R.string.snack_mailSending), Snackbar.LENGTH_LONG)
                    .setAction(view.getResources().getString(R.string.snackBar_action), new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Log.i("SNACKBAR", "Click en SnackBar");
                        }
                    })
                    .setActionTextColor(view.getResources().getColor(R.color.colorAccent)).show();
            view.findViewById(R.id.edTxt_name);
            view.findViewById(R.id.edTxt_mail);
            view.findViewById(R.id.edTxt_message);
        }
    }

    private void sendMail(String to, String subject, String msm){
        String from = "example@gmail.com";

        final String username = SMTP_AUTH_USER;
        final String password = SMTP_AUTH_PASS;
        String host = SMTP_HOST_NAME;

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "587");


        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("¡" + subject + view.getResources().getString(R.string.mail_subject));
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent(msm, "text/html");
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            message.setContent(multipart);

            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try{
                        //Send Message
                        Transport.send(message);
                        Log.w("SimpleMail", "Sent Message Successfully...");
                    }catch (Exception ex){
                        ex.printStackTrace();
                    }
                }
            });
            thread.start();

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

}
