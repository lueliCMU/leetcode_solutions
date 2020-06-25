public int[][] kClosest(int[][] points, int K) {
    PriorityQueue<int[]> pq = new PriorityQueue<int[]>((i, j) -> {
        double dist1 = Math.sqrt(i[0] * i[0] + i[1] * i[1]);
        double dist2 = Math.sqrt(j[0] * j[0] + j[1] * j[1]);
        if (dist1 == dist2) {
            return 0;
        }
        return dist1 > dist2 ? -1 : 1;
    });
    for (int[] point : points) {
        if (pq.size() < K) {
            pq.add(point);
        } else {
            int[] p = pq.peek();
            double dist = Math.sqrt(p[0] * p[0] + p[1] * p[1]);
            double dist2 = Math.sqrt(point[0] * point[0] + point[1] * point[1]);
            if (dist > dist2) {
                pq.poll();
                pq.add(point);
            }
        }
    }
    int[][] res = new int[pq.size()][2];
    for (int i = 0; i < res.length; i++) {
        res[i] = pq.poll();
    }
    return res;
}