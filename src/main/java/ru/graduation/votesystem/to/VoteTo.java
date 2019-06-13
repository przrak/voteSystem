package ru.graduation.votesystem.to;

import java.util.Objects;

public class VoteTo extends NamedTo {

    private Long percentVotes;

    public VoteTo(Integer id, String restaurantName, Long percentVotes) {
        super(id, restaurantName);
        this.percentVotes = percentVotes;
    }

    public Long getPercentVotes() {
        return percentVotes;
    }

    public void setPercentVotes(Long percentVotes) {
        this.percentVotes = percentVotes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VoteTo voteTo = (VoteTo) o;
        return name.equals(voteTo.name) &&
                percentVotes.equals(voteTo.percentVotes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, percentVotes);
    }
}
