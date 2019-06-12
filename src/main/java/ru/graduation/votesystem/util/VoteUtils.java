package ru.graduation.votesystem.util;

import ru.graduation.votesystem.model.Vote;
import ru.graduation.votesystem.to.VoteTo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class VoteUtils {
    private VoteUtils() {}

    public static List<VoteTo> asToList(List<Vote> votes) {
        System.out.println(votes);
        List<VoteTo> votesTo = new ArrayList<>();
        int allUsers = votes.size();

        Map<String, Long> voteResults = votes.stream()
                .collect(Collectors.groupingBy(v -> v.getRestaurant().getName(), Collectors.counting()));

        for (Map.Entry<String, Long> value : voteResults.entrySet())
        {
            votesTo.add(new VoteTo(null, null, value.getKey(), calculatePercentage(value.getValue(), allUsers)));
        }
        
        return votesTo;
    }

    private static Double calculatePercentage(double obtained, double total) {
        return obtained * 100 / total;
    }
}
