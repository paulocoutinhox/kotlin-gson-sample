import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

interface Serializer {
    fun <T> decodeValue(data: String): T?
}

class JsonSerializer : Serializer {
    override fun <T> decodeValue(data: String): T? {
        try {
            val type = object : TypeToken<Request<T>>() {}.type
            val gson = Gson()
            return gson.fromJson<Request<T>>(data, type).r
        } catch (e: Exception) {
            println("Error when parse: ${e.message}")
        }

        return null
    }
}

class Request<T>(val r: T)

inline fun <reified T> callSerializer(json: String): T? {
    val serializer = JsonSerializer()
    return serializer.decodeValue<T>(json)
}

fun main() {
    val result = callSerializer<String>("{\"r\": \"test\"}")
    println("Decoded data is: $result")
}
