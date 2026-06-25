class Solution {
    List<List<Integer>> combinations = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> combination = new ArrayList<>();
        generateCombinations(1, n, k, combination);
        return combinations;
    }

    public void generateCombinations(int currentIndex, int n, int k, List<Integer> combination) {
        //Base case, add to answer when the list is full i.e. of size k
        if (combination.size() == k) {
            combinations.add(new ArrayList<>(combination));
            return;
        }

        //Base Case : If the currentIndex crosses the threshold, return
        if (currentIndex > n) return;

        //Select the current choice and add it to the combination
        combination.add(currentIndex);
        generateCombinations(currentIndex+1, n, k, combination);

        //Avoid the current choice and find the combinations
        combination.remove(combination.size()-1);
        generateCombinations(currentIndex+1, n, k, combination);







    }
}