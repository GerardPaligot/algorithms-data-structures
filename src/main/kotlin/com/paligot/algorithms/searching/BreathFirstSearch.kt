package com.paligot.algorithms.searching

class BreathFirstSearch {
    /**
     * Time Complexity:     O(V + E)
     * Space Complexity:    O(H)
     */
    fun validPath(n: Int, edges: Array<IntArray>, start: Int, end: Int): Boolean {
        val graph = buildGraph(edges, n)

        val queue = ArrayDeque<Int>().also {
            it.addLast(start)
        }

        val seen = HashSet<Int>().also {
            it.add(start)
        }

        while (!queue.isEmpty()) {
            val cur = queue.removeFirst()
            if (cur == end) return true
            for (adj in graph[cur]) {
                if (seen.add(adj)) {
                    queue.addLast(adj)
                }
            }
        }

        return false
    }

    private fun buildGraph(edges: Array<IntArray>, n: Int): Array<HashSet<Int>> {
        val list = Array(n) { hashSetOf<Int>() }
        for ((a, b) in edges) {
            list[a].add(b)
            list[b].add(a)
        }
        return list
    }
}