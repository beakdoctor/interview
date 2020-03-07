package solutions.combinations;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.*;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible
 * letter combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * Note that 1 does not map to any letters.
 *
 * 2 -> abc
 * 3 -> def
 * 4 -> ghi
 * 5 -> jkl
 * 6 -> mno
 * 7 -> pqrs
 * 8 -> tuv
 * 9 -> wxyz
 */
public class LetterCombinations {
	private String[] mapping = new String[]{"", "", "abc", "def", "ghi", "jlk", "mno", "pqrs", "tuv", "wxyz"};

	public List<String> solve(String digits) {
		List<String> result = new ArrayList<>();

		if (digits.isEmpty())
			return result;

		backtrackDfs(result, parseDigitString(digits), new StringBuilder(), 0);
		return result;
	}

	private void backtrackDfs(List<String> result, List<Integer> digits, StringBuilder solution, int k) {
		if (k == digits.size()) {
			result.add(solution.toString());
		} else {
			int digit = digits.get(k);
			for (char c : mapping[digit].toCharArray()) {
				solution.append(c);
				backtrackDfs(result, digits, solution, k+1);
				solution.deleteCharAt(k);
			}
		}
	}

	public static List<Integer> parseDigitString(String digits) {
		return Stream.of(digits.split(""))
			.map(s -> Integer.parseInt(s))
			.collect(Collectors.toList());
	}
}
