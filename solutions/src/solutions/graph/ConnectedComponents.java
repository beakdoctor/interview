package solutions.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/**
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges
 * (each edge is a pair of nodes), write a function to find the number of
 * connected components in an undirected graph.
 *
 * https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph/
 */
public class ConnectedComponents {
	public static enum State {
		UNDISCOVERED,
		DISCOVERED,
		PROCESSED;
	}

	public int solve(int n, int[][] edges) {
		State[] state = new State[n];

		// Make the graph representation.
		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}
		for (int[] edge : edges) {
			// The edges are undirected so add both ways.
			graph.get(edge[0]).add(edge[1]);
			graph.get(edge[1]).add(edge[0]);
		}

		Arrays.fill(state, State.UNDISCOVERED);

		int components = 0;

		for (int i = 0; i < n; i++) {
			if (state[i] == State.UNDISCOVERED) {
				bfs(graph, i, state);
				components++;
			}
		}

		return components;
	}

	private void bfs(List<List<Integer>> graph, int s, State[] state) {
		Queue<Integer> q = new ArrayDeque<>();
		q.add(s);

		while(!q.isEmpty()) {
			int u = q.remove();
			for (int v : graph.get(u)) {
				if (state[v] == State.UNDISCOVERED) {
					state[v] = State.DISCOVERED;
					q.add(v);
				}
			}
			state[u] = State.PROCESSED;
		}
	}

}
