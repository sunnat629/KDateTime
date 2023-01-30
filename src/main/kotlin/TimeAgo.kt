import DateTimeFormatUtils.systemTone
import DateTimeFormatUtils.toInstant
import kotlinx.datetime.toLocalDateTime
import kotlin.time.Duration

object TimeAgo {
    fun getTimeAgo(time: Long, includingTime: Boolean = false): String {
        val now = DateTimeFormatUtils.getNowInInstant()
        val timeIn = time.toInstant()

        val diff: Duration = now - timeIn
        val minute = timeIn.toLocalDateTime(systemTone).minute
        val hour = timeIn.toLocalDateTime(systemTone).hour
        val dayOfWeek = timeIn.toLocalDateTime(systemTone).dayOfWeek.name.subSequence(0, 3)
        val dayOfMonth = timeIn.toLocalDateTime(systemTone).dayOfMonth
        val month = timeIn.toLocalDateTime(systemTone).month.name.subSequence(0, 3)
        val monthNumber = timeIn.toLocalDateTime(systemTone).monthNumber
        val year = timeIn.toLocalDateTime(systemTone).year

        return if (diff.inWholeDays.toInt() == 0) {
            if (diff.inWholeHours.toInt() == 0) {
                if (diff.inWholeSeconds.toInt() < 2) "now"
                else if (diff.inWholeSeconds.toInt() in 2..59) "a few seconds ago"
                else if (diff.inWholeSeconds.toInt() in 60..119) "a minute ago"
                else if (diff.inWholeSeconds.toInt() in 120..599) "a few minutes ago"
                else if (diff.inWholeSeconds.toInt() in 600..1199) "10 minutes ago"
                else if (diff.inWholeSeconds.toInt() in 1200..1799) "20 minutes ago"
                else if (diff.inWholeSeconds.toInt() in 1800..2699) "30 minutes ago"
                else "45 minutes ago"
            } else if (diff.inWholeHours.toInt() == 1) "${diff.inWholeHours} hour ago"
            else "${diff.inWholeHours} hours ago"

        } else if (diff.inWholeDays.toInt() <= 7) {
            "$dayOfWeek $month $dayOfMonth".plus(if (includingTime) ", $hour:$minute" else "")
        } else {
            if(year == now.toLocalDateTime(systemTone).year)
            "$dayOfMonth $month".plus(if (includingTime) ", $hour:$minute" else "")
            else "$dayOfMonth-$monthNumber-$year".plus(if (includingTime) ", $hour:$minute" else "")
        }
    }
}