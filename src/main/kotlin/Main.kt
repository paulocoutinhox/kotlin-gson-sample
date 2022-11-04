import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

interface Serializer {
    fun <T> decodeValue(data: String): T?
}

class JsonSerializer : Serializer {
    override fun <T> decodeValue(data: String): T? {
        try {
            val type = object : TypeToken<T>() {}.type
            val gson = Gson()
            return gson.fromJson<T>(data, type)
        } catch (e: Exception) {
            println("Error when parse: ${e.message}")
        }

        return null
    }
}

class Request<T>(val r: T)

inline fun <reified T> callSerializer(json: String): T? {
    val serializer = JsonSerializer()
    val decoded = serializer.decodeValue<Request<T>>(json)
    return decoded?.r
}

fun main() {
    val finalValue = callSerializer<Request<String>>("{\"r\": \"test\"}")
    println("Decoded data is: $finalValue")
}
