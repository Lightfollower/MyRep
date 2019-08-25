package Lesson_2;

public enum DayOfWeek {
    MONDAY (40),
    TUESDAY (32),
    WEDNESDAY (24),
    THURSDAY (16),
    FRIDAY (8),
    SATURDAY (0),
    SUNDAY (0);

    private int remainingHours;
    DayOfWeek(int remainingHours) {
        this.remainingHours = remainingHours;
    }

    public static void main(final String[] args) {
        System.out.println(getWorkingHours(DayOfWeek.MONDAY));
        System.out.println(getWorkingHours(DayOfWeek.TUESDAY));
        System.out.println(getWorkingHours(DayOfWeek.WEDNESDAY));
        System.out.println(getWorkingHours(DayOfWeek.THURSDAY));
        System.out.println(getWorkingHours(DayOfWeek.FRIDAY));
        System.out.println(getWorkingHours(DayOfWeek.SATURDAY));
        System.out.println(getWorkingHours(DayOfWeek.SUNDAY));
    }
    public static String getWorkingHours(DayOfWeek dayOfWeek){
        switch (dayOfWeek){
            case SATURDAY:
            case SUNDAY:
                return ("Идёт прогер домой- сегодня выходной");
        }
        return String.valueOf(dayOfWeek.remainingHours);
    }
}