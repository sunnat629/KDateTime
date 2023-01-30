import kotlinx.datetime.*

object DateTimeFormatUtils {

    private val now by lazy { Clock.System.now() }
    val systemTone by lazy { TimeZone.currentSystemDefault() }

    fun Int.convertDoubleDigit(): String {
        return if (this < 10) String.format("%02d", this) else this.toString()
    }

    fun Long.convertDoubleDigit(): String {
        return if (this < 10) String.format("%02d", this) else this.toString()
    }

    fun Long.toLocalDateTime(): LocalDateTime {
        return this.toInstant().toLocalDateTime(systemTone)
    }

    fun Long.toInstant(): Instant {
        return Instant.fromEpochSeconds(this)
    }


    fun getTimerSecFormatString(millisUntilFinished: Long): String {
        return "${(millisUntilFinished / 1000).convertDoubleDigit()} seconds"
    }

    fun getRemainingTimeSec(givenTimeSec: Long?): Long {
        return givenTimeSec?.minus(Clock.System.now().toEpochSeconds()) ?: 0
    }

    fun isAlreadyDone(startTime: Long?, endTime: Long?): Boolean {
        if (startTime == null || endTime == null) return false
        val nowTime = Clock.System.now().epochSeconds
        return !isLive(startTime, endTime) && endTime > startTime && nowTime > endTime
    }

    fun isLive(startTime: Long?, endTime: Long?): Boolean {
        return if (startTime == 0L || startTime == null || endTime == null) false
        else startTime < endTime && Clock.System.now().epochSeconds in startTime..endTime
    }

//    fun getTimeFormat(context: Context, millisUntilFinished: Long): String {
//        val currentTime = Clock.System.now().toLocalDateTime(systemTz)
//        val givenTime = Instant.fromEpochSeconds(millisUntilFinished)
//            .toLocalDateTime(systemTz)
//
//        return if (givenTime.dayOfMonth == currentTime.dayOfMonth
//            && givenTime.monthNumber == currentTime.monthNumber
//        ) context.resources.getString(R.string.today) else {
//            "${givenTime.dayOfMonth.convertDoubleDigit()}.${givenTime.monthNumber.convertDoubleDigit()}"
//        }
//    }

    private fun getTimeFormat(millisUntilFinished: Long): String {
        val givenTime = Instant.fromEpochSeconds(millisUntilFinished)
            .toLocalDateTime(systemTone)
        return "${givenTime.dayOfMonth.convertDoubleDigit()}.${givenTime.monthNumber.convertDoubleDigit()}"
    }

    private fun getMonthFormat(month: Long): String {
        val givenTime =
            Instant.fromEpochSeconds(month).toLocalDateTime(systemTone)
        return "${givenTime.month.name.subSequence(0, 3)} ${givenTime.year}"
    }


    private val systemTimeZone by lazy { TimeZone.currentSystemDefault() }

    fun getLocalDates(givenTimeSec: Long): String {
        val dateTime = Instant.fromEpochSeconds(givenTimeSec).toLocalDateTime(systemTimeZone)
        return "${dateTime.dayOfMonth.convertDoubleDigit()}.${dateTime.monthNumber.convertDoubleDigit()}"
    }

    fun matchTimeDurationInPercentage(startTime: Long?, endTime: Long?): Int {
        return if (startTime == null || endTime == null) -1
        else {
            val totalDuration = endTime - startTime
            val currentProgress = Clock.System.now().epochSeconds - startTime
            val durationInPercentage = (currentProgress.toDouble() / totalDuration.toDouble()) * 100
            durationInPercentage.toInt()
        }
    }

    fun nowInLong(): Long = now.toEpochSeconds()

    fun getMonthRange(selectedMonth: Long) {
        val givenLocalDateTime = selectedMonth.toLocalDateTime()
        val dayOfTimeTo = if (givenLocalDateTime.month == now.toLocalDateTime(systemTimeZone).month) {
            givenLocalDateTime.dayOfMonth
        } else givenLocalDateTime.month.length(isLeapYear(givenLocalDateTime.year.toLong()))

        val hourOfTimeTo = if (givenLocalDateTime.month == now.toLocalDateTime(systemTimeZone).month) {
            givenLocalDateTime.hour
        } else 23

        val minuteOfTimeTo = if (givenLocalDateTime.month == now.toLocalDateTime(systemTimeZone).month) {
            givenLocalDateTime.minute
        } else 59

        val timeFrom = LocalDate(
            givenLocalDateTime.year,
            givenLocalDateTime.month,
            1
        ).atTime(0, 0)

        val timeTo = LocalDate(
            givenLocalDateTime.year,
            givenLocalDateTime.month,
            dayOfTimeTo
        ).atTime(hourOfTimeTo, minuteOfTimeTo)

    }
    fun getTimerFullFormatString(givenTimeSec: Long): String {
//        var diff = givenTimeSec.times(1000)
        var diff = givenTimeSec
        val secondsInMilli: Long = 1000
        val minutesInMilli = secondsInMilli * 60
        val hoursInMilli = minutesInMilli * 60
        val daysInMilli = hoursInMilli * 24

        val elapsedDays = diff / daysInMilli
        diff %= daysInMilli

        val elapsedHours = diff / hoursInMilli
        diff %= hoursInMilli

        val elapsedMinutes = diff / minutesInMilli
        diff %= minutesInMilli

        val elapsedSeconds = diff / secondsInMilli

        return "${elapsedDays.convertDoubleDigit()}d ${elapsedHours.convertDoubleDigit()}h " +
                "${elapsedMinutes.convertDoubleDigit()}m ${elapsedSeconds.convertDoubleDigit()}s"
    }
    fun yesterday(): Long {
        val yesterday = Clock.System.now().minus(1, DateTimeUnit.DAY, systemTimeZone).toEpochSeconds()
        val yesterdayLocalDateTime = Instant.fromEpochSeconds(yesterday).toLocalDateTime(systemTimeZone)
        return LocalDate(
            yesterdayLocalDateTime.year,
            yesterdayLocalDateTime.month,
            yesterdayLocalDateTime.dayOfMonth
        ).atTime(23, 59).toInstant(systemTimeZone).toEpochSeconds()
    }

    fun isLeapYear(prolepticYear: Long): Boolean {
        return prolepticYear and 3 == 0L && (prolepticYear % 100 != 0L || prolepticYear % 400 == 0L)
    }

    fun getMonth(timeStamp: Long): Month {
        return timeStamp.toLocalDateTime().month
    }

    fun Instant.toEpochSeconds(): Long {
        return this.toEpochMilliseconds().div(1000)
    }

    fun getTimeDuration(startTime: Long, endTime: Long): Int {
        return endTime.minus(startTime).div(60).toInt()
    }

    fun getNowInLong(): Long = Clock.System.now().epochSeconds

    fun getNowInInstant(): Instant = Clock.System.now()


    fun convertIntoDate(startTime: Long): String {
        val humanTime = startTime.toLocalDateTime()
        val dayOfMonth = humanTime.dayOfMonth.convertDoubleDigit()
        val monthNumber = humanTime.monthNumber.convertDoubleDigit()
        val hour = humanTime.hour.convertDoubleDigit()
        val minute = humanTime.minute.convertDoubleDigit()
        val hourMinute = "$hour:$minute"

        return "$dayOfMonth.$monthNumber $hourMinute"
    }

    fun timeStampToHumanTime(timeStamp: Long): String {
        if (timeStamp < 1) return ""
        val humanTime = timeStamp.toLocalDateTime()
        val hour = humanTime.hour.convertDoubleDigit()
        val minute = humanTime.minute.convertDoubleDigit()

        return "$hour:$minute"
    }

    fun getUtcOffsetMins(timeZone: TimeZone = systemTimeZone): Int {
        return timeZone.offsetAt(now).totalSeconds.div(60)
    }
    fun getGreetingContent(): String {
        val humanTime = now.epochSeconds.toLocalDateTime()
        return when (humanTime.hour) {
            in 0 until 5 -> "Good Evening"
            in 5 until 12 -> "Good Morning"
            in 12 until 17 -> "Good Afternoon"
            in 17 until 23 -> "Good Evening"
            else -> ""
        }
    }

    fun check(): Int {
        return DatePeriod(1).years
    }
}
