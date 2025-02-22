public class MyDateWithEquals
{
    private int day, month, year;

    public MyDateWithEquals(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public boolean equals(Object obj) {
        if (obj instanceof MyDateWithEquals) {
            if ((this.getDay() == ((MyDateWithEquals) obj).getDay()) && (this.getMonth() == ((MyDateWithEquals) obj).getMonth()) && (this.getYear() == ((MyDateWithEquals) obj).getYear())) {
                return true;
            }
        }
        return false;
    }
}