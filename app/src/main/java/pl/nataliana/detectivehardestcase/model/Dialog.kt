package pl.nataliana.detectivehardestcase.model

class Dialog// Constructor that is used to create an instance of the Dialog object
(// Store the id of the image
        private var mImageDrawable: Int, // Store the name of the person
        private var mName: String?, // Store the text
        private var mText: String?) {

    // Getters and setters
    fun getmImageDrawable(): Int {
        return mImageDrawable
    }

    fun setmImageDrawable(mImageDrawable: Int) {
        this.mImageDrawable = mImageDrawable
    }

    fun getmName(): String? {
        return mName
    }

    fun setmName(mName: String) {
        this.mName = mName
    }

    fun getmText(): String? {
        return mText
    }

    fun setmText(mText: String) {
        this.mText = mText
    }
}