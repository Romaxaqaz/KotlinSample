package by.client.android.kotlin.images.api.search

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by PanteleevRV on 18.05.2018.
 *
 * https://pixabay.com/api/docs/
 *
 * @author PRV
 */
data class SearchResponse(
        private val totalHits: Int,
        val hits: List<Hit>,
        private val total: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.createTypedArrayList(Hit),
            parcel.readInt())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(totalHits)
        parcel.writeTypedList(hits)
        parcel.writeInt(total)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SearchResponse> {
        override fun createFromParcel(parcel: Parcel): SearchResponse {
            return SearchResponse(parcel)
        }

        override fun newArray(size: Int): Array<SearchResponse?> {
            return arrayOfNulls(size)
        }
    }
}

data class Hit(
        val id: Int,
        val largeImageURL: String,
        val webformatHeight: Int,
        val webformatWidth: Int,
        val likes: Int,
        val imageWidth: Int,
        val user_id: Int,
        val views: Int,
        val comments: Int,
        val pageURL: String,
        val imageHeight: Int,
        val webformatURL: String,
        val type: String,
        val previewHeight: Int,
        val tags: String,
        val downloads: Int,
        val user: String,
        val favorites: Int,
        val imageSize: Int,
        val previewWidth: Int,
        val userImageURL: String,
        val previewURL: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readString(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readString(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readInt(),
            parcel.readString(),
            parcel.readString())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(largeImageURL)
        parcel.writeInt(webformatHeight)
        parcel.writeInt(webformatWidth)
        parcel.writeInt(likes)
        parcel.writeInt(imageWidth)
        parcel.writeInt(user_id)
        parcel.writeInt(views)
        parcel.writeInt(comments)
        parcel.writeString(pageURL)
        parcel.writeInt(imageHeight)
        parcel.writeString(webformatURL)
        parcel.writeString(type)
        parcel.writeInt(previewHeight)
        parcel.writeString(tags)
        parcel.writeInt(downloads)
        parcel.writeString(user)
        parcel.writeInt(favorites)
        parcel.writeInt(imageSize)
        parcel.writeInt(previewWidth)
        parcel.writeString(userImageURL)
        parcel.writeString(previewURL)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Hit> {
        override fun createFromParcel(parcel: Parcel): Hit {
            return Hit(parcel)
        }

        override fun newArray(size: Int): Array<Hit?> {
            return arrayOfNulls(size)
        }
    }
}