package com.msc.dev.alwaysawakeapp.awake

class AwakePresenter : AwakeContract.Presenter {
    private var view: AwakeContract.View? = null

    override fun setView(view: AwakeContract.View) {
        this.view = view
    }

    override fun setImageData(imageSource: String) {
        if(imageSource != null && !imageSource.isEmpty()) {
            view?.showImage(imageSource)
        } else {
            view?.showImageError()
        }
    }

    override fun errorLoadingUrl() {
        view?.showImageError()
    }

}