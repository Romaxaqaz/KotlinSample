package by.client.android.kotlin.images.api.search

/**
 * Created by PanteleevRV on 18.05.2018.
 *
 * @author PRV
 */
class SearchRequest {

    /**
     * A URL encoded search term. If omitted, all images are returned. This value may not exceed 100 characters.
     * Example: "yellow+flower"
     */
    var q: String = ""

    /**
     * Accepted values: cs, da, de, en, es, fr, id, it, hu, nl, no, pl, pt, ro, sk, fi, sv, tr, vi, th, bg, ru, el, ja, ko, zh
     * Default: "en"
     */
    var lang: String = ""

    /**
     * Filter results by image type.
     * Accepted values: "all", "photo", "illustration", "vector"
     * Default: "all
     */
    var image_type: ImageType = ImageType.ALL

    /**
     * Whether an image is wider than it is tall, or taller than it is wide.
     * Accepted values: "all", "horizontal", "vertical"
     * Default: "all"
     */
    var orientation: String = ""

    /**
     * Filter results by category.
     * Accepted values: fashion, nature, backgrounds, science, education, people, feelings, religion, health, places, animals,
     * industry, food, computer, sports, transportation, travel, buildings, business, music
     */
    var category: String = ""

    /**
     * Minimum image width.
     * Default: "0"
     */
    var min_width: Int = 0

    /**
     * 	Minimum image height.
     * Default: "0"
     */
    var min_height: Int = 0

    /**
     * Filter images by color properties. A comma separated list of values may be used to select multiple properties.
     * Accepted values: "grayscale", "transparent", "red", "orange", "yellow", "green", "turquoise", "blue", "lilac", "pink",
     * "white", "gray", "black", "brown"
     */
    var colors: String = ""

    /**
     * Select images that have received an Editor's Choice award.
     * Accepted values: "true", "false"
     * Default: "false"
     */
    var editors_choice: Boolean = false

    /**
     * A flag indicating that only images suitable for all ages should be returned.
     * Accepted values: "true", "false"
     * Default: "false"
     */
    var safesearch: Boolean = false

    /**
     * How the results should be ordered.
     * Accepted values: "popular", "latest"
     * Default: "popular"
     */
    var order: String = ""

    /**
     * Returned search results are paginated. Use this parameter to select the page number.
     * Default: 1
     */
    var page: Int = 0

    /**
     * Determine the number of results per page.
     * Accepted values: 3 - 200
     * Default: 20
     */
    var per_page: Int = 0

    /**
     * JSONP callback function name
     */
    var callback: String = ""

    /**
     * Indent JSON output. This option should not be used in production.
     * Accepted values: "true", "false"
     * Default: "false"
     */
    var pretty: Boolean = false

    fun setQ(q: String): SearchRequest {
        this.q = q
        return this
    }

    fun setlang(lang: String): SearchRequest {
        this.lang = lang
        return this
    }

    fun setImageType(imageType: ImageType): SearchRequest {
        this.image_type = imageType
        return this
    }

    fun setOrientation(orientation: String): SearchRequest {
        this.orientation = orientation
        return this
    }

    fun toHashMap(): HashMap<String, String> {
        val map: HashMap<String, String> = HashMap()
        map.put("q", q)
        map.put("lang", lang)
        map.put("image_type", image_type.toString())

        return map
    }
}