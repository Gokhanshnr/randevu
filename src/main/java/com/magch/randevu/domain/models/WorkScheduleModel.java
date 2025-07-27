package com.magch.randevu.domain.models;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.List;


@Getter
@Setter
public class WorkScheduleModel {

    private Work monday;
    private Work tuesday;
    private Work wednesday;
    private Work thursday;
    private Work friday;
    private Work saturday;
    private Work sunday;

    @Getter
    @Setter
    public static class Work {
        private LocalTime startTime;
        private LocalTime endTime;
        private List<BreakTime> breakTimes;
        private boolean isClosed;
    }

    @Getter
    @Setter
    private static class BreakTime {
        private LocalTime startTime;
        private LocalTime endTime;
    }
}
