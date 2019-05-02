package com.msc.dev.alwaysawakeapp.awake

class AwakeContract {
    interface View {
        fun showImage(uriStr: String)
        fun showImageError()
    }

    interface Presenter {
        fun setView(view: View)
        fun setImageData(imageUri: String)
        fun errorLoadingUrl()
    }

}