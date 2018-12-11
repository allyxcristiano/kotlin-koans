package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int {
        return when {
            this.year == other.year && this.month == other.month && this.dayOfMonth == other.dayOfMonth -> 0
            (this.year == other.year && this.month == other.month && this.dayOfMonth < other.dayOfMonth) || (this.year == other.year && this.month < other.month) || (this.year < other.year) -> -1
            else -> 1
        }
    }
}

operator fun MyDate.rangeTo(other: MyDate): DateRange {
    return DateRange(this, other)
}

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

class DateRange(override val start: MyDate, override val endInclusive: MyDate) : ClosedRange<MyDate>, Iterable<MyDate> {
    override fun iterator(): Iterator<MyDate> {
        return object : Iterator<MyDate> {
            override fun hasNext(): Boolean {
                return start < endInclusive
            }

            override fun next(): MyDate {
                return start.nextDay()
            }

        }
    }
}
