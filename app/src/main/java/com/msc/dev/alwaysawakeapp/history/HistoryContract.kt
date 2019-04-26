package com.msc.dev.alwaysawakeapp.history

class HistoryContract {
    interface View {
        fun updateGallery()
        fun showError()
        fun showProgressBar()
        fun hidePogressBar()
        fun showEmptyGalleryMessage()
        fun hideEmptyGalleryMessage()
    }

    interface Presenter {
        fun setView(view: View)
        fun getGalleryContent()
    }
}