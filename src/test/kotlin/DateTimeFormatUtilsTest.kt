import kotlinx.datetime.DatePeriod
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.plus
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.io.File


@Serializable
data class Country(
    val countryCode: String? = null,
    val name: String? = null,
    val timeZone: String? = null,
    val gtmOffset: String? = null,
)

@DisplayName("A special test case")
class DateTimeFormatUtilsTest {

    private lateinit var timeZoneCountries: List<Country>

    @BeforeEach
    fun init(): Unit {
        val resourcesDirectory = File("src/main/resources/dateTime.json").readText()
        timeZoneCountries = Json.decodeFromString(resourcesDirectory)
    }

    @Test
    fun addition() {

        println(DateTimeFormatUtils.getNowInInstant())
        println(timeZoneCountries.first())

        println(DatePeriod(months = 1).months)
        println(DatePeriod(years = 1, months = 2).plus(DatePeriod(months = 1)))

        assertEquals(365, DateTimeFormatUtils.check())
    }

}