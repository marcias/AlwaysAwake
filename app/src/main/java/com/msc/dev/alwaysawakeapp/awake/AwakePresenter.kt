package com.msc.dev.alwaysawakeapp.awake

class AwakePresenter : AwakeContract.Presenter {
    private var view: AwakeContract.View? = null

    override fun setView(view: AwakeContract.View) {
        this.view = view
    }

    override fun setImageData(imageUri: String) {
        view?.showImage(imageUri)
    }

}