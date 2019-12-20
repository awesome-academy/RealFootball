package vn.sunasterisk.realfootball.utils

import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import vn.sunasterisk.realfootball.FootballApplication
import vn.sunasterisk.realfootball.R
import vn.sunasterisk.realfootball.constant.Constant
import vn.sunasterisk.realfootball.extension.formatDate
import vn.sunasterisk.realfootball.extension.getHour

object BindingUtil {
    @BindingAdapter("android:date")
    @JvmStatic
    fun bindDate(textView: TextView, date: String?) {
        date?.let {
            textView.text = it.formatDate()
        }
    }

    @BindingAdapter("android:hour")
    @JvmStatic
    fun bindHour(textView: TextView, hour: String?) {
        hour?.let {
            textView.text = it.getHour()
        }
    }

    @BindingAdapter("app:hideIfNext")
    @JvmStatic
    fun hideIfNext(view: View, type: String) {
        view.isVisible = type == Constant.TYPE_NEXT_MATCH
    }

    @BindingAdapter("android:url")
    @JvmStatic
    fun bindImageFromUrl(imageView: ImageView, imageUrl: String?) {
        imageUrl?.let {
            Glide.with(imageView.context)
                .load(it)
                .into(imageView)
        }
    }

    @BindingAdapter("android:format")
    @JvmStatic
    fun formatText(textView: TextView, string: String?) {
        string?.let {
            textView.text = string.format()
        }
    }

    @BindingAdapter("android:urlBound")
    @JvmStatic
    fun bindImageBound(imageView: ImageView, imageUrl: String?) {
        imageUrl?.let {
            var requestOptions = RequestOptions()
            requestOptions = requestOptions.transforms(
                CenterCrop(),
                RoundedCorners(
                    FootballApplication.applicationContext!!.resources.getDimensionPixelSize(
                        R.dimen.dp_8
                    )
                )
            )
            Glide.with(imageView.context)
                .applyDefaultRequestOptions(requestOptions)
                .load(it)
                .into(imageView)
        }
    }

    @BindingAdapter("android:embed")
    @JvmStatic
    fun embedHtml(webView: WebView, string: String?){
        string?.let {
            webView.apply {
                settings.javaScriptEnabled=true
                webChromeClient= WebChromeClient()
                loadData(string,"text/html","utf-8")
            }
        }
    }
}
