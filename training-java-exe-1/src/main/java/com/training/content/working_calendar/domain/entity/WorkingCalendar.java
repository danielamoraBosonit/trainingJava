package com.training.content.working_calendar.domain.entity;

import com.training.content.working_calendar.infrastructure.repository.jpa.entity.WorkingCalendarJpa;

import java.time.LocalDateTime;

public class WorkingCalendar {

    private int id;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int priority;
    private int employeeId;
    private int cityId;

    public WorkingCalendar(WorkingCalendarJpa workingCalendarJpa) {
        this.id = workingCalendarJpa.getId();
        this.startDate = workingCalendarJpa.getStartDate();
        this.endDate = workingCalendarJpa.getEndDate();
        this.priority = workingCalendarJpa.getPriority();
        this.employeeId = workingCalendarJpa.getEmployeeId();
        this.cityId = workingCalendarJpa.getCityId();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }
}
