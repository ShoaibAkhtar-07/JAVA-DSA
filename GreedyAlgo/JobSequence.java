package GreedyAlgo;

import java.util.*;

public class JobSequence {

    static class Job {
        int id;
        int deadline;
        int profit;

        public Job(int i, int d, int p) {
            id = i;
            deadline = d;
            profit = p;
        }
    }

    public static void main(String[] args) {
        int[][] JobSequence = { { 4, 220 }, { 1, 10 }, { 1, 40 }, { 1, 30 } };

        ArrayList<Job> jobs = new ArrayList<>();
        for (int i = 0; i < JobSequence.length; i++) {
            jobs.add(new Job(i, JobSequence[i][0], JobSequence[i][1]));
        }

        Collections.sort(jobs, (a, b) -> b.profit - a.profit);

        ArrayList<Integer> ans = new ArrayList<>();
        int time = 0;
        for (int i = 0; i < jobs.size(); i++) {
            Job curr = jobs.get(i);
            if (curr.deadline > time) {
                ans.add(curr.id);
                time++;
            }
        }

        System.out.println("Max no.of Job : " + ans.size());
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
    }
}
