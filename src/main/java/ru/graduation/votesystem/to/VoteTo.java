package ru.graduation.votesystem.to;

import java.time.LocalDate;
import java.util.Objects;

public class VoteTo extends NamedTo {

    private LocalDate date;

    private Double percentVotes;

    public VoteTo(Integer id, LocalDate date, String restaurantName, Double percentVotes) {
        super(id, restaurantName);
        this.date = date;
        this.percentVotes = percentVotes;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getPercentVotes() {
        return percentVotes;
    }

    public void setPercentVotes(Double percentVotes) {
        this.percentVotes = percentVotes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VoteTo voteTo = (VoteTo) o;
        return date.equals(voteTo.date) &&
                name.equals(voteTo.name) &&
                percentVotes.equals(voteTo.percentVotes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, name, percentVotes);
    }
}
