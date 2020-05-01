iclass Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            if (!map.containsKey(groupSizes[i])) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(groupSizes[i], list);
            } else {
                map.get(groupSizes[i]).add(i);
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            int len = entry.getKey();
            List<Integer> list = entry.getValue();
            for (int i = 0; i < list.size(); i = i + len) {
                List<Integer> seg = list.subList(i, i + len);
                res.add(seg);
            }
        }
        return res;
    }
}
