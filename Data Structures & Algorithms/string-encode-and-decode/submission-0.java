class Solution {

    public String encode(List<String> strs) {
        String encodedString = "";
        for (String str : strs) {
            encodedString += str.length() + "#" + str;
        }
        return encodedString;
    }

    public List<String> decode(String str) {
        List<String> decodedString = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = str.indexOf('#', i);
            int length = Integer.parseInt(str.substring(i, j));
            decodedString.add(str.substring(j + 1, j + 1 + length));
            i = j + 1 + length;
        }
        return decodedString;

    }
}
