package by.client.android.kotlin.images.api.search

/**
 * Created by PanteleevRV on 18.05.2018.
 *
 * @author PRV
 */
enum class ImageType {

    ALL,

    HORIZONTAL,

    VERTICAL;

    override fun toString(): String {
        return name.toLowerCase()
    }
}