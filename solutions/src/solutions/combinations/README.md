Whenever we're faced with a problem of returning all or some combinations
of the input space, we can think "backtracking algorithm".

Generally, when writing such an algorithm we need to consider a few things:

* How do we represent a single combination?
* What is a complete combination (or the end condition of the recursion)?
* How do we compute the "next steps"?

For example, when generating all subsets of size n, a single combination can be represented by a boolean array of size n, where each value represents if the corresponding element is included in the subset or not. A complete combination has considered whether or not to include each element, and to compute the next steps we simply choose "true" and then "false".

Other problems might have a longer list of "next steps" and in that case we iterate over them all, recursively calling backtrack for each candidate. It's important to "undo" any modification made do the current solution candidate before recursing again.
