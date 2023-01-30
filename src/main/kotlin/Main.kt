import DateTimeFormatUtils.toEpochSeconds
import DateTimeFormatUtils.toInstant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import kotlinx.serialization.Serializable
import kotlin.time.Duration
import kotlin.time.Duration.Companion.days
import kotlin.time.Duration.Companion.hours
import kotlin.time.Duration.Companion.minutes
import kotlin.time.Duration.Companion.seconds
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
fun main() {

    val now = DateTimeFormatUtils.getNowInInstant()
    val timeIn = 1611423673L.toInstant()
    val diff: Duration = now - timeIn
    println("NOW: ${now.minus(1.hours)}")
    println("NOW: ${now.toLocalDateTime(TimeZone.UTC)}")
    println("Real time: ${diff.absoluteValue}")
    println(TimeAgo.getTimeAgo(now.epochSeconds))
    println(TimeAgo.getTimeAgo(now.minus(15.seconds).epochSeconds))
    println(TimeAgo.getTimeAgo(now.minus(1.minutes).epochSeconds))
    println(TimeAgo.getTimeAgo(now.minus(10.minutes).epochSeconds))
    println(TimeAgo.getTimeAgo(now.minus(16.minutes).epochSeconds))
    println(TimeAgo.getTimeAgo(now.minus(38.minutes).epochSeconds))
    println(TimeAgo.getTimeAgo(now.minus(50.minutes).epochSeconds))
    println(TimeAgo.getTimeAgo(now.minus(1.hours).epochSeconds))
    println(TimeAgo.getTimeAgo(now.minus(2.hours).epochSeconds))
    println(TimeAgo.getTimeAgo(now.minus(5.hours).epochSeconds))
    println(TimeAgo.getTimeAgo(now.minus(15.hours).epochSeconds))
    println(TimeAgo.getTimeAgo(now.minus(1.days).epochSeconds))
    println(TimeAgo.getTimeAgo(now.minus(5.days).epochSeconds))
    println(TimeAgo.getTimeAgo(now.minus(7.days).epochSeconds))
    println(TimeAgo.getTimeAgo(now.minus(10.days).epochSeconds))
    println(TimeAgo.getTimeAgo(now.minus(10.days).epochSeconds, true))
    println(TimeAgo.getTimeAgo(now.minus(150.days).epochSeconds))
    println(TimeAgo.getTimeAgo(now.minus(400.days).epochSeconds))


//    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
//    println("Program arguments: ${args.joinToString()}")

//    val resourcesDirectory = File("src/main/resources/dateTime.json").readText()
//
//    val list = Json.decodeFromString<List<CountryA>>(resourcesDirectory)
//    val listD = list.mapIndexed { index, countryA ->
//        countryA.copy(id = index)
//    }
//    println("${listD.size}")
//    println("*****")
//    println(Json.encodeToString<List<Country>>(COUNTRIES))
//    println("${COUNTRIES.size}: ${COUNTRIES.toString()}")

//    val aa = COUNTRIES.mapIndexed { index, country ->
//        val c = list.filter {it.countryCode == country.countryCode}
//        val countryTimeZone = c.map { Country.CountryTimeZone(timeZone = it.timeZone, gtmOffset = it.gtmOffset) }
//        country.copy(countryTimeZone = countryTimeZone, id = index)
//    }

//    val ccc = Json.encodeToString<List<Country>>(aa)
//    println("${aa.size}: ${aa}")

//    println(Json.encodeToString<List<Country>>(aa))
//    println(Json.encodeToString<List<CountryA>>(listD))
//    val plusUtcOffsetMins = DateTimeFormatUtils.getUtcOffsetMins(TimeZone.of("Asia/Dhaka"))
//    val TimeZoneOf = TimeZone.of("Asia/Dhaka")
//
//    val timeZoneIds = listD
//        .map { it.timeZone }
//        .sortedBy { it }
//        .map { it?.split("/")?.first() }
//        .distinct()
//
//    println(timeZoneIds)
//    println(listD
//        .map { it.timeZone }
//        .sortedBy { it }
//    )


}

@Serializable
data class CountryA(
    val id: Int? = null,
    val countryCode: String? = null,
    val name: String? = null,
    val timeZone: String? = null,
    val gtmOffset: String? = null,
)

@Serializable
data class Country(
    val id: Int? = null,
    val countryCode: String? = null,
    val name: String? = null,
    val dialCode: String? = null,
    val flag: String? = null,
    val currency: String? = null,
    val countryTimeZone: List<CountryTimeZone>? = null,
) {
    @Serializable
    data class CountryTimeZone(
        val timeZone: String? = null,
        val gtmOffset: String? = null,
    )
}

private val COUNTRIES = listOf(
    Country(
        id = 0,
        "AD",
        "Andorra",
        "+376",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/ad.svg",
        "EUR"
    ), Country(
        id = 0,
        "AE",
        "United Arab Emirates",
        "+971",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/ae.svg",
        "AED"
    ), Country(
        id = 0,
        "AF",
        "Afghanistan",
        "+93",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/af.svg",
        "AFN"
    ), Country(
        id = 0,
        "AG",
        "Antigua and Barbuda",
        "+1-268",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/ag.svg",
        "XCD"
    ), Country(
        id = 0,
        "AI",
        "Anguilla",
        "+1-264",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/ai.svg",
        "XCD"
    ), Country(
        id = 0,
        "AL",
        "Albania",
        "+355",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/al.svg",
        "ALL"
    ), Country(
        id = 0,
        "AM",
        "Armenia",
        "+374",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/am.svg",
        "AMD"
    ), Country(
        id = 0,
        "AN",
        "Netherlands Antilles",
        "+599",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/an.svg",
        "ANG"
    ), Country(
        id = 0,
        "AO",
        "Angola",
        "+244",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/ao.svg",
        "AOA"
    ), Country(
        id = 0,
        "AQ",
        "Antarctica",
        "+672",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/aq.svg",
        "USD"
    ), Country(
        id = 0,
        "AR",
        "Argentina",
        "+54",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/ar.svg",
        "ARS"
    ), Country(
        id = 0,
        "AS",
        "American Samoa",
        "+1-684",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/as.svg",
        "USD"
    ), Country(
        id = 0,
        "AT",
        "Austria",
        "+43",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/at.svg",
        "EUR"
    ), Country(
        id = 0,
        "AU",
        "Australia",
        "+61",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/au.svg",
        "AUD"
    ), Country(
        id = 0,
        "AW",
        "Aruba",
        "+297",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/aw.svg",
        "AWG"
    ), Country(
        id = 0,
        "AZ",
        "Azerbaijan",
        "+994",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/az.svg",
        "AZN"
    ), Country(
        id = 0,
        "BA",
        "Bosnia and Herzegovina",
        "+387",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/ba.svg",
        "BAM"
    ), Country(
        id = 0,
        "BB",
        "Barbados",
        "+1-246",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/bb.svg",
        "BBD"
    ), Country(
        id = 0,
        "BD",
        "Bangladesh",
        "+880",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/bd.svg",
        "BDT"
    ), Country(
        id = 0,
        "BE",
        "Belgium",
        "+32",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/be.svg",
        "EUR"
    ), Country(
        id = 0,
        "BF",
        "Burkina Faso",
        "+226",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/bf.svg",
        "XOF"
    ), Country(
        id = 0,
        "BG",
        "Bulgaria",
        "+359",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/bg.svg",
        "BGN"
    ), Country(
        id = 0,
        "BH",
        "Bahrain",
        "+973",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/bh.svg",
        "BHD"
    ), Country(
        id = 0,
        "BI",
        "Burundi",
        "+257",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/bi.svg",
        "BIF"
    ), Country(
        id = 0,
        "BJ",
        "Benin",
        "+229",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/bj.svg",
        "XOF"
    ), Country(
        id = 0,
        "BL",
        "Saint Barthelemy",
        "+590",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/bl.svg",
        "EUR"
    ), Country(
        id = 0,
        "BM",
        "Bermuda",
        "+1-441",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/bm.svg",
        "BMD"
    ), Country(
        id = 0,
        "BN",
        "Brunei",
        "+673",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/bn.svg",
        "BND"
    ), Country(
        id = 0,
        "BO",
        "Bolivia",
        "+591",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/bo.svg",
        "BOB"
    ), Country(
        id = 0,
        "BR",
        "Brazil",
        "+55",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/br.svg",
        "BRL"
    ), Country(
        id = 0,
        "BS",
        "Bahamas",
        "+1-242",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/bs.svg",
        "BSD"
    ), Country(
        id = 0,
        "BT",
        "Bhutan",
        "+975",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/bt.svg",
        "BTN"
    ), Country(
        id = 0,
        "BW",
        "Botswana",
        "+267",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/bw.svg",
        "BWP"
    ), Country(
        id = 0,
        "BY",
        "Belarus",
        "+375",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/by.svg",
        "BYR"
    ), Country(
        id = 0,
        "BZ",
        "Belize",
        "+501",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/bz.svg",
        "BZD"
    ), Country(
        id = 0,
        "CA",
        "Canada",
        "+1",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/ca.svg",
        "CAD"
    ), Country(
        id = 0,
        "CC",
        "Cocos Islands",
        "+61",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/cc.svg",
        "AUD"
    ), Country(
        id = 0,
        "CD",
        "Democratic Republic of the Congo",
        "+243",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/cd.svg",
        "CDF"
    ), Country(
        id = 0,
        "CF",
        "Central African Republic",
        "+236",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/cf.svg",
        "XAF"
    ), Country(
        id = 0,
        "CG",
        "Republic of the Congo",
        "+242",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/cg.svg",
        "XAF"
    ), Country(
        id = 0,
        "CH",
        "Switzerland",
        "+41",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/ch.svg",
        "CHF"
    ), Country(
        id = 0,
        "CI",
        "Ivory Coast",
        "+225",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/ci.svg",
        "XOF"
    ), Country(
        id = 0,
        "CK",
        "Cook Islands",
        "+682",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/ck.svg",
        "NZD"
    ), Country(
        id = 0,
        "CL",
        "Chile",
        "+56",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/cl.svg",
        "CLP"
    ), Country(
        id = 0,
        "CM",
        "Cameroon",
        "+237",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/cm.svg",
        "XAF"
    ), Country(
        id = 0,
        "CN",
        "China",
        "+86",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/cn.svg",
        "CNY"
    ), Country(
        id = 0,
        "CO",
        "Colombia",
        "+57",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/co.svg",
        "COP"
    ), Country(
        id = 0,
        "CR",
        "Costa Rica",
        "+506",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/cr.svg",
        "CRC"
    ), Country(
        id = 0, "CU", "Cuba", "+53", "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/cu.svg", "CUP"
    ), Country(
        id = 0,
        "CV",
        "Cape Verde",
        "+238",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/cv.svg",
        "CVE"
    ), Country(
        id = 0,
        "CW",
        "Curacao",
        "+599",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/cw.svg",
        "ANG"
    ), Country(
        id = 0,
        "CX",
        "Christmas Island",
        "+61",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/cx.svg",
        "AUD"
    ), Country(
        id = 0,
        "CY",
        "Cyprus",
        "+357",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/cy.svg",
        "EUR"
    ), Country(
        id = 0,
        "CZ",
        "Czech Republic",
        "+420",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/cz.svg",
        "CZK"
    ), Country(
        id = 0,
        "DE",
        "Germany",
        "+49",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/de.svg",
        "EUR"
    ), Country(
        id = 0,
        "DJ",
        "Djibouti",
        "+253",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/dj.svg",
        "DJF"
    ), Country(
        id = 0,
        "DK",
        "Denmark",
        "+45",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/dk.svg",
        "DKK"
    ), Country(
        id = 0,
        "DM",
        "Dominica",
        "+1-767",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/dm.svg",
        "XCD"
    ), Country(
        id = 0,
        "DO",
        "Dominican Republic",
        "+1-809, +1-829, +1-849",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/do.svg",
        "DOP"
    ), Country(
        id = 0,
        "DZ",
        "Algeria",
        "+213",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/dz.svg",
        "DZD"
    ), Country(
        id = 0,
        "EC",
        "Ecuador",
        "+593",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/ec.svg",
        "USD"
    ), Country(
        id = 0,
        "EE",
        "Estonia",
        "+372",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/ee.svg",
        "EUR"
    ), Country(
        id = 0,
        "EG",
        "Egypt",
        "+20",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/eg.svg",
        "EGP"
    ), Country(
        id = 0,
        "EH",
        "Western Sahara",
        "+212",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/eh.svg",
        "MAD"
    ), Country(
        id = 0,
        "ER",
        "Eritrea",
        "+291",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/er.svg",
        "ERN"
    ), Country(
        id = 0,
        "ES",
        "Spain",
        "+34",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/es.svg",
        "EUR"
    ), Country(
        id = 0,
        "ET",
        "Ethiopia",
        "+251",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/et.svg",
        "ETB"
    ), Country(
        id = 0,
        "FI",
        "Finland",
        "+358",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/fi.svg",
        "EUR"
    ), Country(
        id = 0,
        "FJ",
        "Fiji",
        "+679",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/fj.svg",
        "FJD"
    ), Country(
        id = 0,
        "FK",
        "Falkland Islands",
        "+500",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/fk.svg",
        "FKP"
    ), Country(
        id = 0,
        "FM",
        "Micronesia",
        "+691",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/fm.svg",
        "USD"
    ), Country(
        id = 0,
        "FO",
        "Faroe Islands",
        "+298",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/fo.svg",
        "DKK"
    ), Country(
        id = 0,
        "FR",
        "France",
        "+33",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/fr.svg",
        "EUR"
    ), Country(
        id = 0,
        "GA",
        "Gabon",
        "+241",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/ga.svg",
        "XAF"
    ), Country(
        id = 0,
        "GB",
        "United Kingdom",
        "+44",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/gb.svg",
        "GBP"
    ), Country(
        id = 0,
        "GD",
        "Grenada",
        "+1-473",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/gd.svg",
        "XCD"
    ), Country(
        id = 0,
        "GE",
        "Georgia",
        "+995",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/ge.svg",
        "GEL"
    ), Country(
        id = 0,
        "GG",
        "Guernsey",
        "+44-1481",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/gg.svg",
        "GGP"
    ), Country(
        id = 0,
        "GH",
        "Ghana",
        "+233",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/gh.svg",
        "GHS"
    ), Country(
        id = 0,
        "GI",
        "Gibraltar",
        "+350",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/gi.svg",
        "GIP"
    ), Country(
        id = 0,
        "GL",
        "Greenland",
        "+299",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/gl.svg",
        "DKK"
    ), Country(
        id = 0,
        "GM",
        "Gambia",
        "+220",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/gm.svg",
        "GMD"
    ), Country(
        id = 0,
        "GN",
        "Guinea",
        "+224",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/gn.svg",
        "GNF"
    ), Country(
        id = 0,
        "GQ",
        "Equatorial Guinea",
        "+240",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/gq.svg",
        "XAF"
    ), Country(
        id = 0,
        "GR",
        "Greece",
        "+30",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/gr.svg",
        "EUR"
    ), Country(
        id = 0,
        "GT",
        "Guatemala",
        "+502",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/gt.svg",
        "GTQ"
    ), Country(
        id = 0,
        "GU",
        "Guam",
        "+1-671",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/gu.svg",
        "USD"
    ), Country(
        id = 0,
        "GW",
        "Guinea-Bissau",
        "+245",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/gw.svg",
        "XOF"
    ), Country(
        id = 0,
        "GY",
        "Guyana",
        "+592",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/gy.svg",
        "GYD"
    ), Country(
        id = 0,
        "HK",
        "Hong Kong",
        "+852",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/hk.svg",
        "HKD"
    ), Country(
        id = 0,
        "HN",
        "Honduras",
        "+504",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/hn.svg",
        "HNL"
    ), Country(
        id = 0,
        "HR",
        "Croatia",
        "+385",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/hr.svg",
        "HRK"
    ), Country(
        id = 0,
        "HT",
        "Haiti",
        "+509",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/ht.svg",
        "HTG"
    ), Country(
        id = 0,
        "HU",
        "Hungary",
        "+36",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/hu.svg",
        "HUF"
    ), Country(
        id = 0,
        "ID",
        "Indonesia",
        "+62",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/id.svg",
        "IDR"
    ), Country(
        id = 0,
        "IE",
        "Ireland",
        "+353",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/ie.svg",
        "EUR"
    ), Country(
        id = 0,
        "IL",
        "Israel",
        "+972",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/il.svg",
        "ILS"
    ), Country(
        id = 0,
        "IM",
        "Isle of Man",
        "+44-1624",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/im.svg",
        "GBP"
    ), Country(
        id = 0,
        "IN",
        "India",
        "+91",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/in.svg",
        "INR"
    ), Country(
        id = 0,
        "IO",
        "British Indian Ocean Territory",
        "+246",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/io.svg",
        "USD"
    ), Country(
        id = 0,
        "IQ",
        "Iraq",
        "+964",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/iq.svg",
        "IQD"
    ), Country(
        id = 0, "IR", "Iran", "+98", "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/ir.svg", "IRR"
    ), Country(
        id = 0,
        "IS",
        "Iceland",
        "+354",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/is.svg",
        "ISK"
    ), Country(
        id = 0,
        "IT",
        "Italy",
        "+39",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/it.svg",
        "EUR"
    ), Country(
        id = 0,
        "JE",
        "Jersey",
        "+44-1534",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/je.svg",
        "JEP"
    ), Country(
        id = 0,
        "JM",
        "Jamaica",
        "+1-876",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/jm.svg",
        "JMD"
    ), Country(
        id = 0,
        "JO",
        "Jordan",
        "+962",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/jo.svg",
        "JOD"
    ), Country(
        id = 0,
        "JP",
        "Japan",
        "+81",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/jp.svg",
        "JPY"
    ), Country(
        id = 0,
        "KE",
        "Kenya",
        "+254",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/ke.svg",
        "KES"
    ), Country(
        id = 0,
        "KG",
        "Kyrgyzstan",
        "+996",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/kg.svg",
        "KGS"
    ), Country(
        id = 0,
        "KH",
        "Cambodia",
        "+855",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/kh.svg",
        "KHR"
    ), Country(
        id = 0,
        "KI",
        "Kiribati",
        "+686",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/ki.svg",
        "AUD"
    ), Country(
        id = 0,
        "KM",
        "Comoros",
        "+269",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/km.svg",
        "KMF"
    ), Country(
        id = 0,
        "KN",
        "Saint Kitts and Nevis",
        "+1-869",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/kn.svg",
        "XCD"
    ), Country(
        id = 0,
        "KP",
        "North Korea",
        "+850",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/kp.svg",
        "KPW"
    ), Country(
        id = 0,
        "KR",
        "South Korea",
        "+82",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/kr.svg",
        "KRW"
    ), Country(
        id = 0,
        "KW",
        "Kuwait",
        "+965",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/kw.svg",
        "KWD"
    ), Country(
        id = 0,
        "KY",
        "Cayman Islands",
        "+1-345",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/ky.svg",
        "KYD"
    ), Country(
        id = 0,
        "KZ",
        "Kazakhstan",
        "+7",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/kz.svg",
        "KZT"
    ), Country(
        id = 0,
        "LA",
        "Laos",
        "+856",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/la.svg",
        "LAK"
    ), Country(
        id = 0,
        "LB",
        "Lebanon",
        "+961",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/lb.svg",
        "LBP"
    ), Country(
        id = 0,
        "LC",
        "Saint Lucia",
        "+1-758",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/lc.svg",
        "XCD"
    ), Country(
        id = 0,
        "LI",
        "Liechtenstein",
        "+423",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/li.svg",
        "CHF"
    ), Country(
        id = 0,
        "LK",
        "Sri Lanka",
        "+94",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/lk.svg",
        "LKR"
    ), Country(
        id = 0,
        "LR",
        "Liberia",
        "+231",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/lr.svg",
        "LRD"
    ), Country(
        id = 0,
        "LS",
        "Lesotho",
        "+266",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/ls.svg",
        "LSL"
    ), Country(
        id = 0,
        "LT",
        "Lithuania",
        "+370",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/lt.svg",
        "LTL"
    ), Country(
        id = 0,
        "LU",
        "Luxembourg",
        "+352",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/lu.svg",
        "EUR"
    ), Country(
        id = 0,
        "LV",
        "Latvia",
        "+371",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/lv.svg",
        "LVL"
    ), Country(
        id = 0,
        "LY",
        "Libya",
        "+218",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/ly.svg",
        "LYD"
    ), Country(
        id = 0,
        "MA",
        "Morocco",
        "+212",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/ma.svg",
        "MAD"
    ), Country(
        id = 0,
        "MC",
        "Monaco",
        "+377",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/mc.svg",
        "EUR"
    ), Country(
        id = 0,
        "MD",
        "Moldova",
        "+373",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/md.svg",
        "MDL"
    ), Country(
        id = 0,
        "ME",
        "Montenegro",
        "+382",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/me.svg",
        "EUR"
    ), Country(
        id = 0,
        "MF",
        "Saint Martin",
        "+590",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/mf.svg",
        "EUR"
    ), Country(
        id = 0,
        "MG",
        "Madagascar",
        "+261",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/mg.svg",
        "MGA"
    ), Country(
        id = 0,
        "MH",
        "Marshall Islands",
        "+692",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/mh.svg",
        "USD"
    ), Country(
        id = 0,
        "MK",
        "Macedonia",
        "+389",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/mk.svg",
        "MKD"
    ), Country(
        id = 0,
        "ML",
        "Mali",
        "+223",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/ml.svg",
        "XOF"
    ), Country(
        id = 0,
        "MM",
        "Myanmar",
        "+95",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/mm.svg",
        "MMK"
    ), Country(
        id = 0,
        "MN",
        "Mongolia",
        "+976",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/mn.svg",
        "MNT"
    ), Country(
        id = 0,
        "MO",
        "Macao",
        "+853",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/mo.svg",
        "MOP"
    ), Country(
        id = 0,
        "MP",
        "Northern Mariana Islands",
        "+1-670",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/mp.svg",
        "USD"
    ), Country(
        id = 0,
        "MR",
        "Mauritania",
        "+222",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/mr.svg",
        "MRO"
    ), Country(
        id = 0,
        "MS",
        "Montserrat",
        "+1-664",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/ms.svg",
        "XCD"
    ), Country(
        id = 0,
        "MT",
        "Malta",
        "+356",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/mt.svg",
        "EUR"
    ), Country(
        id = 0,
        "MU",
        "Mauritius",
        "+230",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/mu.svg",
        "MUR"
    ), Country(
        id = 0,
        "MV",
        "Maldives",
        "+960",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/mv.svg",
        "MVR"
    ), Country(
        id = 0,
        "MW",
        "Malawi",
        "+265",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/mw.svg",
        "MWK"
    ), Country(
        id = 0,
        "MX",
        "Mexico",
        "+52",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/mx.svg",
        "MXN"
    ), Country(
        id = 0,
        "MY",
        "Malaysia",
        "+60",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/my.svg",
        "MYR"
    ), Country(
        id = 0,
        "MZ",
        "Mozambique",
        "+258",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/mz.svg",
        "MZN"
    ), Country(
        id = 0,
        "NA",
        "Namibia",
        "+264",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/na.svg",
        "NAD"
    ), Country(
        id = 0,
        "NC",
        "New Caledonia",
        "+687",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/nc.svg",
        "XPF"
    ), Country(
        id = 0,
        "NE",
        "Niger",
        "+227",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/ne.svg",
        "XOF"
    ), Country(
        id = 0,
        "NG",
        "Nigeria",
        "+234",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/ng.svg",
        "NGN"
    ), Country(
        id = 0,
        "NI",
        "Nicaragua",
        "+505",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/ni.svg",
        "NIO"
    ), Country(
        id = 0,
        "NL",
        "Netherlands",
        "+31",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/nl.svg",
        "EUR"
    ), Country(
        id = 0,
        "NO",
        "Norway",
        "+47",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/no.svg",
        "NOK"
    ), Country(
        id = 0,
        "NP",
        "Nepal",
        "+977",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/np.svg",
        "NPR"
    ), Country(
        id = 0,
        "NR",
        "Nauru",
        "+674",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/nr.svg",
        "AUD"
    ), Country(
        id = 0,
        "NU",
        "Niue",
        "+683",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/nu.svg",
        "NZD"
    ), Country(
        id = 0,
        "NZ",
        "New Zealand",
        "+64",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/nz.svg",
        "NZD"
    ), Country(
        id = 0,
        "OM",
        "Oman",
        "+968",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/om.svg",
        "OMR"
    ), Country(
        id = 0,
        "PA",
        "Panama",
        "+507",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/pa.svg",
        "PAB"
    ), Country(
        id = 0, "PE", "Peru", "+51", "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/pe.svg", "PEN"
    ), Country(
        id = 0,
        "PF",
        "French Polynesia",
        "+689",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/pf.svg",
        "XPF"
    ), Country(
        id = 0,
        "PG",
        "Papua New Guinea",
        "+675",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/pg.svg",
        "PGK"
    ), Country(
        id = 0,
        "PH",
        "Philippines",
        "+63",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/ph.svg",
        "PHP"
    ), Country(
        id = 0,
        "PK",
        "Pakistan",
        "+92",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/pk.svg",
        "PKR"
    ), Country(
        id = 0,
        "PL",
        "Poland",
        "+48",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/pl.svg",
        "PLN"
    ), Country(
        id = 0,
        "PM",
        "Saint Pierre and Miquelon",
        "+508",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/pm.svg",
        "EUR"
    ), Country(
        id = 0,
        "PN",
        "Pitcairn",
        "+64",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/pn.svg",
        "NZD"
    ), Country(
        id = 0,
        "PR",
        "Puerto Rico",
        "+1-787, +1-939",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/pr.svg",
        "USD"
    ), Country(
        id = 0,
        "PS",
        "Palestinian",
        "+970",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/ps.svg",
        "ILS"
    ), Country(
        id = 0,
        "PT",
        "Portugal",
        "+351",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/pt.svg",
        "EUR"
    ), Country(
        id = 0,
        "PW",
        "Palau",
        "+680",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/pw.svg",
        "USD"
    ), Country(
        id = 0,
        "PY",
        "Paraguay",
        "+595",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/py.svg",
        "PYG"
    ), Country(
        id = 0,
        "QA",
        "Qatar",
        "+974",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/qa.svg",
        "QAR"
    ), Country(
        id = 0,
        "RE",
        "Reunion",
        "+262",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/re.svg",
        "EUR"
    ), Country(
        id = 0,
        "RO",
        "Romania",
        "+40",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/ro.svg",
        "RON"
    ), Country(
        id = 0,
        "RS",
        "Serbia",
        "+381",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/rs.svg",
        "RSD"
    ), Country(
        id = 0,
        "RU",
        "Russia",
        "+7",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/ru.svg",
        "RUB"
    ), Country(
        id = 0,
        "RW",
        "Rwanda",
        "+250",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/rw.svg",
        "RWF"
    ), Country(
        id = 0,
        "SA",
        "Saudi Arabia",
        "+966",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/sa.svg",
        "SAR"
    ), Country(
        id = 0,
        "SB",
        "Solomon Islands",
        "+677",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/sb.svg",
        "SBD"
    ), Country(
        id = 0,
        "SC",
        "Seychelles",
        "+248",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/sc.svg",
        "SCR"
    ), Country(
        id = 0,
        "SD",
        "Sudan",
        "+249",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/sd.svg",
        "SDG"
    ), Country(
        id = 0,
        "SE",
        "Sweden",
        "+46",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/se.svg",
        "SEK"
    ), Country(
        id = 0,
        "SG",
        "Singapore",
        "+65",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/sg.svg",
        "SGD"
    ), Country(
        id = 0,
        "SH",
        "Saint Helena",
        "+290",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/sh.svg",
        "SHP"
    ), Country(
        id = 0,
        "SI",
        "Slovenia",
        "+386",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/si.svg",
        "EUR"
    ), Country(
        id = 0,
        "SJ",
        "Svalbard and Jan Mayen",
        "+47",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/sj.svg",
        "NOK"
    ), Country(
        id = 0,
        "SK",
        "Slovakia",
        "+421",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/sk.svg",
        "EUR"
    ), Country(
        id = 0,
        "SL",
        "Sierra Leone",
        "+232",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/sl.svg",
        "SLL"
    ), Country(
        id = 0,
        "SM",
        "San Marino",
        "+378",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/sm.svg",
        "EUR"
    ), Country(
        id = 0,
        "SN",
        "Senegal",
        "+221",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/sn.svg",
        "XOF"
    ), Country(
        id = 0,
        "SO",
        "Somalia",
        "+252",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/so.svg",
        "SOS"
    ), Country(
        id = 0,
        "SR",
        "Suriname",
        "+597",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/sr.svg",
        "SRD"
    ), Country(
        id = 0,
        "SS",
        "South Sudan",
        "+211",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/ss.svg",
        "SSP"
    ), Country(
        id = 0,
        "ST",
        "Sao Tome and Principe",
        "+239",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/st.svg",
        "STD"
    ), Country(
        id = 0,
        "SV",
        "El Salvador",
        "+503",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/sv.svg",
        "SVC"
    ), Country(
        id = 0,
        "SX",
        "Sint Maarten",
        "+1-721",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/sx.svg",
        "ANG"
    ), Country(
        id = 0,
        "SY",
        "Syria",
        "+963",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/sy.svg",
        "SYP"
    ), Country(
        id = 0,
        "SZ",
        "Swaziland",
        "+268",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/sz.svg",
        "SZL"
    ), Country(
        id = 0,
        "TC",
        "Turks and Caicos Islands",
        "+1-649",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/tc.svg",
        "USD"
    ), Country(
        id = 0,
        "TD",
        "Chad",
        "+235",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/td.svg",
        "XAF"
    ), Country(
        id = 0,
        "TG",
        "Togo",
        "+228",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/tg.svg",
        "XOF"
    ), Country(
        id = 0,
        "TH",
        "Thailand",
        "+66",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/th.svg",
        "THB"
    ), Country(
        id = 0,
        "TJ",
        "Tajikistan",
        "+992",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/tj.svg",
        "TJS"
    ), Country(
        id = 0,
        "TK",
        "Tokelau",
        "+690",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/tk.svg",
        "NZD"
    ), Country(
        id = 0,
        "TL",
        "East Timor",
        "+670",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/tl.svg",
        "USD"
    ), Country(
        id = 0,
        "TM",
        "Turkmenistan",
        "+993",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/tm.svg",
        "TMT"
    ), Country(
        id = 0,
        "TN",
        "Tunisia",
        "+216",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/tn.svg",
        "TND"
    ), Country(
        id = 0,
        "TO",
        "Tonga",
        "+676",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/to.svg",
        "TOP"
    ), Country(
        id = 0,
        "TR",
        "Turkey",
        "+90",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/tr.svg",
        "TRY"
    ), Country(
        id = 0,
        "TT",
        "Trinidad and Tobago",
        "+1-868",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/tt.svg",
        "TTD"
    ), Country(
        id = 0,
        "TV",
        "Tuvalu",
        "+688",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/tv.svg",
        "AUD"
    ), Country(
        id = 0,
        "TW",
        "Taiwan",
        "+886",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/tw.svg",
        "TWD"
    ), Country(
        id = 0,
        "TZ",
        "Tanzania",
        "+255",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/tz.svg",
        "TZS"
    ), Country(
        id = 0,
        "UA",
        "Ukraine",
        "+380",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/ua.svg",
        "UAH"
    ), Country(
        id = 0,
        "UG",
        "Uganda",
        "+256",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/ug.svg",
        "UGX"
    ), Country(
        id = 0,
        "US",
        "United States",
        "+1",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/us.svg",
        "USD"
    ), Country(
        id = 0,
        "UY",
        "Uruguay",
        "+598",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/uy.svg",
        "UYU"
    ), Country(
        id = 0,
        "UZ",
        "Uzbekistan",
        "+998",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/uz.svg",
        "UZS"
    ), Country(
        id = 0,
        "VA",
        "Vatican",
        "+379",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/va.svg",
        "EUR"
    ), Country(
        id = 0,
        "VC",
        "Saint Vincent and the Grenadines",
        "+1-784",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/vc.svg",
        "XCD"
    ), Country(
        id = 0,
        "VE",
        "Venezuela",
        "+58",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/ve.svg",
        "VEF"
    ), Country(
        id = 0,
        "VG",
        "British Virgin Islands",
        "+1-284",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/vg.svg",
        "USD"
    ), Country(
        id = 0,
        "VI",
        "U.S. Virgin Islands",
        "+1-340",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/vi.svg",
        "USD"
    ), Country(
        id = 0,
        "VN",
        "Vietnam",
        "+84",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/vn.svg",
        "VND"
    ), Country(
        id = 0,
        "VU",
        "Vanuatu",
        "+678",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/vu.svg",
        "VUV"
    ), Country(
        id = 0,
        "WF",
        "Wallis and Futuna",
        "+681",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/wf.svg",
        "XPF"
    ), Country(
        id = 0,
        "WS",
        "Samoa",
        "+685",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/ws.svg",
        "WST"
    ), Country(
        id = 0,
        "XK",
        "Kosovo",
        "+383",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/xk.svg",
        "EUR"
    ), Country(
        id = 0,
        "YE",
        "Yemen",
        "+967",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/ye.svg",
        "YER"
    ), Country(
        id = 0,
        "YT",
        "Mayotte",
        "+262",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/yt.svg",
        "EUR"
    ), Country(
        id = 0,
        "ZA",
        "South Africa",
        "+27",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/za.svg",
        "ZAR"
    ), Country(
        id = 0,
        "ZM",
        "Zambia",
        "+260",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/zm.svg",
        "ZMW"
    ), Country(
        id = 0,
        "ZW",
        "Zimbabwe",
        "+263",
        "https://github.com/sunnat629/CountriesDetails/blob/master/flags/svg/zw.svg",
        "USD"
    )
)

object TimeZoneCountries {
    internal enum class Africa {
        ABIDJAN, ACCRA, ADDIS_ABABA, ALGIERS, ASMARA, BAMAKO, BANGUI, BANJUL, BISSAU, BLANTYRE, BRAZZAVILLE, BUJUMBURA, CAIRO, CASABLANCA, CEUTA, CONAKRY, DAKAR, DAR_ES_SALAAM, DJIBOUTI, DOUALA, EL_AAIUN, FREETOWN, GABORONE, HARARE, JOHANNESBURG, JUBA, KAMPALA, KHARTOUM, KIGALI, KINSHASA, LAGOS, LIBREVILLE, LOME, LUANDA, LUBUMBASHI, LUSAKA, MALABO, MAPUTO, MASERU, MBABANE, MOGADISHU, MONROVIA, NAIROBI, NDJAMENA, NIAMEY, NOUAKCHOTT, OUAGADOUGOU, PORTO_NOVO, SAO_TOME, TRIPOLI, TUNIS, WINDHOEK
    }

    internal enum class America {
        ADAK, ANCHORAGE, ANGUILLA, ANTIGUA, ARAGUAINA, BUENOS_AIRES, CATAMARCA, CORDOBA, JUJUY, LA_RIOJA, MENDOZA, RIO_GALLEGOS, SALTA, SAN_JUAN, SAN_LUIS, TUCUMAN, USHUAIA, ARUBA, ASUNCION, ATIKOKAN, BAHIA, BAHIA_BANDERAS, BARBADOS, BELEM, BELIZE, BLANC_SABLON, BOA_VISTA, BOGOTA, BOISE, CAMBRIDGE_BAY, CAMPO_GRANDE, CANCUN, CARACAS, CAYENNE, CAYMAN, CHICAGO, CHIHUAHUA, CIUDAD_JUAREZ, COSTA_RICA, CRESTON, CUIABA, CURACAO, DANMARKSHAVN, DAWSON, DAWSON_CREEK, DENVER, DETROIT, DOMINICA, EDMONTON, EIRUNEPE, EL_SALVADOR, FORT_NELSON, FORTALEZA, GLACE_BAY, GOOSE_BAY, GRAND_TURK, GRENADA, GUADELOUPE, GUATEMALA, GUAYAQUIL, GUYANA, HALIFAX, HAVANA, HERMOSILLO, INDIANAPOLIS, KNOX, MARENGO, PETERSBURG, TELL_CITY, VEVAY, VINCENNES, WINAMAC, INUVIK, IQALUIT, JAMAICA, JUNEAU, LOUISVILLE, MONTICELLO, KRALENDIJK, LA_PAZ, LIMA, LOS_ANGELES, LOWER_PRINCES, MACEIO, MANAGUA, MANAUS, MARIGOT, MARTINIQUE, MATAMOROS, MAZATLAN, MENOMINEE, MERIDA, METLAKATLA, MEXICO_CITY, MIQUELON, MONCTON, MONTERREY, MONTEVIDEO, MONTSERRAT, NASSAU, NEW_YORK, NOME, NORONHA, BEULAH, CENTER, NEW_SALEM, NUUK, OJINAGA, PANAMA, PARAMARIBO, PHOENIX, PORT_AU_PRINCE, PORT_OF_SPAIN, PORTO_VELHO, PUERTO_RICO, PUNTA_ARENAS, RANKIN_INLET, RECIFE, REGINA, RESOLUTE, RIO_BRANCO, SANTAREM, SANTIAGO, SANTO_DOMINGO, SAO_PAULO, SCORESBYSUND, SITKA, ST_BARTHELEMY, ST_JOHNS, ST_KITTS, ST_LUCIA, ST_THOMAS, ST_VINCENT, SWIFT_CURRENT, TEGUCIGALPA, THULE, TIJUANA, TORONTO, TORTOLA, VANCOUVER, WHITEHORSE, WINNIPEG, YAKUTAT, YELLOWKNIFE,
    }

    internal enum class Antarctica {
        CASEY, DAVIS, DUMONTDURVILLE, MACQUARIE, MAWSON, MCMURDO, PALMER, ROTHERA, SYOWA, TROLL, VOSTOK,
    }

    internal enum class Arctic { LONGYEARBYEN }
    internal enum class Asia {
        ADEN, ALMATY, AMMAN, ANADYR, AQTAU, AQTOBE, ASHGABAT, ATYRAU, BAGHDAD, BAHRAIN, BAKU, BANGKOK, BARNAUL, BEIRUT, BISHKEK, BRUNEI, CHITA, CHOIBALSAN, COLOMBO, DAMASCUS, DHAKA, DILI, DUBAI, DUSHANBE, FAMAGUSTA, GAZA, HEBRON, HO_CHI_MINH, HONG_KONG, HOVD, IRKUTSK, JAKARTA, JAYAPURA, JERUSALEM, KABUL, KAMCHATKA, KARACHI, KATHMANDU, KHANDYGA, KOLKATA, KRASNOYARSK, KUALA_LUMPUR, KUCHING, KUWAIT, MACAU, MAGADAN, MAKASSAR, MANILA, MUSCAT, NICOSIA, NOVOKUZNETSK, NOVOSIBIRSK, OMSK, ORAL, PHNOM_PENH, PONTIANAK, PYONGYANG, QATAR, QOSTANAY, QYZYLORDA, RIYADH, SAKHALIN, SAMARKAND, SEOUL, SHANGHAI, SINGAPORE, SREDNEKOLYMSK, TAIPEI, TASHKENT, TBILISI, TEHRAN, THIMPHU, TOKYO, TOMSK, ULAANBAATAR, URUMQI, UST_NERA, VIENTIANE, VLADIVOSTOK, YAKUTSK, YANGON, YEKATERINBURG, YEREVAN,
    }

    internal enum class Atlantic { AZORES, BERMUDA, CANARY, CAPE_VERDE, FAROE, MADEIRA, REYKJAVIK, SOUTH_GEORGIA, ST_HELENA, STANLEY, }
    internal enum class Australia { ADELAIDE, BRISBANE, BROKEN_HILL, DARWIN, EUCLA, HOBART, LINDEMAN, LORD_HOWE, MELBOURNE, PERTH, SYDNEY, }
    internal enum class Europe { AMSTERDAM, ANDORRA, ASTRAKHAN, ATHENS, BELGRADE, BERLIN, BRATISLAVA, BRUSSELS, BUCHAREST, BUDAPEST, BUSINGEN, CHISINAU, COPENHAGEN, DUBLIN, GIBRALTAR, GUERNSEY, HELSINKI, ISLE_OF_MAN, ISTANBUL, JERSEY, KALININGRAD, KIROV, KYIV, LISBON, LJUBLJANA, LONDON, LUXEMBOURG, MADRID, MALTA, MARIEHAMN, MINSK, MONACO, MOSCOW, OSLO, PARIS, PODGORICA, PRAGUE, RIGA, ROME, SAMARA, SAN_MARINO, SARAJEVO, SARATOV, SIMFEROPOL, SKOPJE, SOFIA, STOCKHOLM, TALLINN, TIRANE, ULYANOVSK, VADUZ, VATICAN, VIENNA, VILNIUS, VOLGOGRAD, WARSAW, ZAGREB, ZURICH, }
    internal enum class Indian { ANTANANARIVO, CHAGOS, CHRISTMAS, COCOS, COMORO, KERGUELEN, MAHE, MALDIVES, MAURITIUS, MAYOTTE, REUNION }
    internal enum class Pacific { APIA, AUCKLAND, BOUGAINVILLE, CHATHAM, CHUUK, EASTER, EFATE, FAKAOFO, FIJI, FUNAFUTI, GALAPAGOS, GAMBIER, GUADALCANAL, GUAM, HONOLULU, KANTON, KIRITIMATI, KOSRAE, KWAJALEIN, MAJURO, MARQUESAS, MIDWAY, NAURU, NIUE, NORFOLK, NOUMEA, PAGO_PAGO, PALAU, PITCAIRN, POHNPEI, PORT_MORESBY, RAROTONGA, SAIPAN, TAHITI, TARAWA, TONGATAPU, WAKE, WALLIS }

}
