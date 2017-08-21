package pl.nataliana.detectivehardestcase;

public class Dialog {

    // Store the id of the face of the person speaking
    private int mImageDrawable;
    // Store the name of the person
    private String mName;
    // Store the text
    private String mText;

    // Constructor that is used to create an instance of the Dialog object
    public Dialog(int mImageDrawable, String mName, String mText)
    {
        this.mImageDrawable = mImageDrawable;
        this.mName = mName;
        this.mText = mText;
    }

    public int getmImageDrawable() {
        return mImageDrawable;
    }

    public void setmImageDrawable(int mImageDrawable) {
        this.mImageDrawable = mImageDrawable;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmText() {
        return mText;
    }

    public void setmText(String mText) {
        this.mText = mText;
    }
}