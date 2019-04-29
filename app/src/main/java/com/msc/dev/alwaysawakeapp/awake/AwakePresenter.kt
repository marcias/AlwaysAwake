package com.msc.dev.alwaysawakeapp.awake

class AwakePresenter : AwakeContract.Presenter {
    private var view: AwakeContract.View? = null

    override fun setView(view: AwakeContract.View) {
        this.view = view
    }

    override fun setImageData(imageUri: String) {
        if(imageUri != null && imageUri.length > 0) {
            view?.showImage(imageUri)
        } else {
            view?.showImageError()
        }
    }

}