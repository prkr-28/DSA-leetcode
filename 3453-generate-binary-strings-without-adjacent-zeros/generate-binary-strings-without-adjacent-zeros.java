class Solution {
    public List<String> validStrings(int n) {
        List<String> list = new ArrayList<>();
        soln(n, list, "", ' ');
        return list;
    }
    private static void soln(int n, List<String> list, String str, char lastChar) {
        if (n == 0) {
            list.add(str);
            return;
        }
        soln(n - 1, list, str + '1', '1');
        if (lastChar != '0') {
            soln(n - 1, list, str + '0', '0');
        }
    }
}