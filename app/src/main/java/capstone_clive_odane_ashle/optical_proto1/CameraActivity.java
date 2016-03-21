package capstone_clive_odane_ashle.optical_proto1;

import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.ImageView;

public class CameraActivity extends AppCompatActivity {
    static final int REQUEST_IMAGE_CAPTURE= 1;
    String ReadText;
    Bitmap FinalImage;
    ImageView CapturedImage;
    Button Capture,OCR_READ;
    TessOCR ImageTranslator; // IMPLEMENTS OCR FUNCTIONALITY

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        CapturedImage=(ImageView)findViewById(R.id.imageView) ;
        OCR_READ=(Button)findViewById(R.id.button6);
        Capture=(Button)findViewById(R.id.button4) ;
        if (!hasCamera()){Capture.setEnabled(false);}
    }

    private boolean hasCamera(){
        return getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY);
    }

    public void LaunchCamera(View view){
        Intent I= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(I,REQUEST_IMAGE_CAPTURE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode== REQUEST_IMAGE_CAPTURE && resultCode==RESULT_OK){
            Bundle extras = data.getExtras();
            Bitmap Image = (Bitmap)extras.get("data");
            CapturedImage.setImageBitmap(Image);
            FinalImage= (Bitmap) Image;
        }
    }

    public void goto_OCRMode(View View){
    //Pass Image into OCR: Create OCR Using Tesseract API
       // ImageTranslator = new TessOCR(FinalImage);
       // ReadText= ImageTranslator.Process();

    // Pass Text into new Activity (Confirmation & Editting)
        Intent I = new Intent(this,TextConfirmationActivity.class);
        startActivity(I);
    }
}
