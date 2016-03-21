package capstone_clive_odane_ashle.optical_proto1;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;

import com.googlecode.tesseract.android.TessBaseAPI;

import java.io.File;

/**
 * Created by Clive on 17/03/2016.
 */
public class TessOCR {
    TessBaseAPI Tess;
    Bitmap Image;
    public TessOCR(Bitmap Image){
        this.Image=Image;
        Tess = new TessBaseAPI();
        String datapath= Environment.getExternalStorageDirectory().toString()+"/Android/data/" + "capstone_clive_odane_ashle.optical_proto1" +  "/";
        File tessdata = new
                File(datapath);
        if (!tessdata.exists() || !tessdata.isDirectory()) {throw new IllegalArgumentException("Data path must contain subfolder tessdata!");     }
        //FOR HELP SEE:--> http://stackoverflow.com/questions/16227364/tesseract-help-me-understand-datapath
        // Define Characterset as english + equation
        Tess.init(datapath,"eng+equ");
        Tess.setImage(this.Image);
    }// Constructor Stub

    public Bitmap getImage(){
        return this.Image;
    }

    public Bitmap enhance(Bitmap Image){
        ImageEnhancer ImageEnhancer = new ImageEnhancer(); // IMPLEMENTS IMAGE ENHANCEMENT FUNCTIONALITY
        return Image;
    }

    public String Process(){
        String ProcessedText=Tess.getUTF8Text();
        Tess.end(); // Kills OCR Process completely
        return ProcessedText;
    }


}
/*ToDo
* Implement Enhance Image Method
* Write function to read Multiple lines
* Ensure that Math Symbols are recognisable
* Write Function to detect Super Script and Subscript
*
* */