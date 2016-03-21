package capstone_clive_odane_ashle.optical_proto1;

import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
public class MainActivity extends AppCompatActivity {
    Button NewImage,LoadImage,HelpButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NewImage=(Button)findViewById(R.id.button1) ;
        HelpButton=(Button)findViewById(R.id.button2) ;
        LoadImage=(Button)findViewById(R.id.button3) ;
    }
    public void goto_CameraMode(View View){
        Intent I = new Intent(this,CameraActivity.class);
        startActivity(I);
    }
    public void goto_MyImages(View View){
        Intent I= new Intent(Intent.ACTION_VIEW, Uri.parse("content://media/internal/images/media"));
        //startActivityForResult(I, REQUEST_IMAGE_CAPTURE);
        startActivity(I);
    }
    public void goto_Help(View View){
        Intent I = new Intent(this,HelpActivity.class); // Temporary
        startActivity(I);
    }
}
