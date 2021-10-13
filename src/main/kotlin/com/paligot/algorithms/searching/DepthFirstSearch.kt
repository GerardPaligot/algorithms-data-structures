package com.paligot.algorithms.searching

import java.util.Stack
import kotlin.collections.HashSet

class DepthFirstSearch {
    /**
     * Time Complexity:     O(N)
     * Space Complexity:    O(H)
     */
    fun validPath(n: Int, edges: Array<IntArray>, start: Int, end: Int): Boolean {
        val graph = buildGraph(n, edges)
        val seen = HashSet<Int>().also {
            it.add(start)
        }
        return dfsValidPath(seen, 0, end, graph)
    }

    private fun dfsValidPath(seen: HashSet<Int>, cur: Int, end: Int, graph: Array<HashSet<Int>>): Boolean {
        if (cur == end) return true
        for (next in graph[cur])
            if (seen.add(next))
                if (dfsValidPath(seen, next, end, graph)) return true
        return false
    }

    /**
     * Time Complexity:     O(V + E) ~ O(size + TOTAL_ELEMENTS)
     * Space Complexity:    O(V + E) ~ O(size + TOTAL_ELEMENTS)
     */
    fun allPathsSourceTarget(edges: Array<IntArray>): List<List<Int>> {
        val res = mutableListOf<List<Int>>()
        val path = Stack<Int>().also {
            it.push(0)
        }
        dfsAllPaths(0, path, edges, res)
        return res
    }

    private fun dfsAllPaths(cur: Int, path: Stack<Int>, graph: Array<IntArray>, res: MutableList<List<Int>>) {
        if (cur == graph.size - 1) {
            res.add(path.toList())
            return
        }
        for (next in graph[cur]) {
            path.push(next)
            dfsAllPaths(next, path, graph, res)
            path.pop()
        }
    }

    private fun buildGraph(n: Int, edges: Array<IntArray>): Array<HashSet<Int>> {
        val graph = Array(n) { hashSetOf<Int>() }
        for ((a, b) in edges) {
            graph[a].add(b)
            graph[b].add(a)
        }
        return graph
    }
}