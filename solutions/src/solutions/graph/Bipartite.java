package solutions.graph;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * Given an undirected graph, return true if and only if it is bipartite.
 *
 * https://leetcode.com/problems/is-graph-bipartite/
 */
public class Bipartite {
	public static enum State {
		UNDISCOVERED,
		DISCOVERED,
		PROCESSED;
	}

	public static enum Color {
		UNCOLORED,
		WHITE,
		BLACK;
	}

	public boolean solve(int[][] graph) {
		State[] state = new State[graph.length];
		Color[] color = new Color[graph.length];

		Arrays.fill(state, State.UNDISCOVERED);
		Arrays.fill(color, Color.UNCOLORED);

		for (int i = 0; i < graph.length; i++) {
			if (state[i] == State.UNDISCOVERED) {
				color[i] = Color.WHITE;
				if (!bfs(graph, i, state, color)) {
					return false;
				}
			}
		}

		return true;
	}

	private boolean bfs(int[][] graph, int s, State[] state, Color[] color) {
		Queue<Integer> q = new ArrayDeque<>();
		q.add(s);

		while(!q.isEmpty()) {
			int u = q.remove();
			for (int v : graph[u]) {
				if (!processEdge(u, v, color)) {
					return false;
				}

				if (state[v] == State.UNDISCOVERED) {
					state[v] = State.DISCOVERED;
					q.add(v);
				}
			}
			state[u] = State.PROCESSED;
		}
		return true;
	}

	private boolean processEdge(int u, int v, Color[] color) {
		System.out.format("%d has color %s, %d has color %s\n", u, color[u], v, color[v]);

		if (color[u] == color[v]) {
			System.out.println(color[u] + " == " + color[v]);
			return false;
		}


		color[v] = color[u] == Color.WHITE ? Color.BLACK : Color.WHITE;
		return true;
	}
}
