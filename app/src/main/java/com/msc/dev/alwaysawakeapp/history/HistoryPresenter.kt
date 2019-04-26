package com.msc.dev.alwaysawakeapp.history

class HistoryPresenter: HistoryContract.Presenter {
    var mView: HistoryContract.View? = null

    override fun setView(view: HistoryContract.View) {
        mView = view
    }

    override fun getGalleryContent() {
        //mView?.showProgressBar()
        mView?.showEmptyGalleryMessage()
        //chamada para model
    }

}