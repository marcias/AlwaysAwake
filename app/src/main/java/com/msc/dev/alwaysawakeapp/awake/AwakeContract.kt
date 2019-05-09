package com.msc.dev.alwaysawakeapp.awake

class AwakeContract {
    interface View {
        fun showImage(imageSource: String)
        fun showImageError()
    }

    interface Presenter {
        fun setView(view: View)
        fun setImageData(imageSource: String)
        fun errorLoadingUrl()
    }

}