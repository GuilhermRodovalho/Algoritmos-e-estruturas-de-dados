# Percolation problem

This is the source code, wrote by me, for the first assignment of the Algorithms, part I course at Coursera.

This uses the implementation of Union Find, Weighted QuickUnion to design the percolation, once it is efficiently enough. 

I used also, the [algs4](https://algs4.cs.princeton.edu/home/) library available at to do the statistics, random number generations and output. 

The file PercolationStats.java is a Monte Carlo simulation of the Percolation problem, serving the mean, standard deviation, and a 95% confidence interval for the percolation threshold.

Percolation has one bug, that is when the system percolates, all the sites at the bottom line that are open will be considered full (even though they shouldn't), because I use a virtual node to represent the bottom and top line, so I can make the operation Percolates() in constant time. But to use it, I need to connect every site at the bottom line to the bottom site virtual. So it's like all bottom sites are already connected. To solve this bug, I could use another Weighted QuickUnion data structure, but without connecting the bottom line to a virtual bottom, so when the method isFull is called, it would check in this second Weighted QuickUnion if it connects to the top line virtual.