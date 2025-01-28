package dev.buskopan;

import java.util.*;
import java.util.stream.Collectors;

public class AutocompleteWithNGrams {

    public static void main(String[] args) {

        List<String> corpus = Arrays.asList("casa amarela", "casa verde", "casa de campo", "cachorro preto", "cachorro de raça");

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite para autocompletar");
        String input = sc.nextLine();

        int n = 3;

        String suggest = autocomplete(input,corpus,n);
        System.out.println("Sugestão: " + suggest);
        main(args);

    }

    public static List<String> generateGrams(String text, int n) {
        List<String> grams = new ArrayList<>();

        for (int i = 0; i <= text.length() - n; i++) {
            grams.add(text.substring(i, i+n));
        }
        return grams;
    }

    public static double jaccardSimilarity(Set<String> setA, Set<String> setB) {
        Set<String> intersection = new HashSet<>(setA);
        intersection.retainAll(setB);
        Set<String> union = new HashSet<>(setA);
        union.addAll(setB);

        return (double) intersection.size() / union.size();
    }

    public static String autocomplete(String input, List<String> corpus, int n) {
        List<Set<String>> nGramsCorpus = corpus.stream()
                .map(text -> new HashSet<>(generateGrams(text,n)))
                .collect(Collectors.toList());

        Set<String> inputNGrams = new HashSet<>(generateGrams(input,n));

        double max = 0;
        String bestMatch = "";

        for (int i = 0; i < corpus.size(); i++) {
            double similarity = jaccardSimilarity(inputNGrams, nGramsCorpus.get(i));
            if (similarity > max) {
                max = similarity;
                bestMatch = corpus.get(i);
            }
        }

        return bestMatch;

    }

}
