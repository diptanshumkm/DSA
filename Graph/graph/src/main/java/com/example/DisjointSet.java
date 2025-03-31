package com.example;
import java.util.ArrayList;

// This package implements Disjoint Set DS using Union Rank, Path compression

public class DisjointSet {
    
    ArrayList<Integer> parent;
    ArrayList<Integer> rank;
    int size;

    public DisjointSet(int size) {
        this.size = size;
        parent = new ArrayList<>(size+1);
        rank = new ArrayList<>(size+1);

        for (int i = 0; i <= size; i++) {
            parent.add(i);   // Each element is its own parent initially
            rank.add(0);     // Rank is initialized to 0
        }
    }

    public int findParent(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        parent.set(node, findParent(parent.get(node))); // Path compression
        return parent.get(node);
    }

    public void union(int u, int v) {
        int parentOfU = findParent(u);
        int parentOfV = findParent(v);

        if (parentOfU == parentOfV) return; // They are already in the same set

        int rankOfU = rank.get(parentOfU);
        int rankOfV = rank.get(parentOfV);

        if (rankOfU > rankOfV) {
            parent.set(parentOfV, parentOfU);
        } else if (rankOfU < rankOfV) {
            parent.set(parentOfU, parentOfV);
        } else {
            parent.set(parentOfV, parentOfU);
            rank.set(parentOfU, rankOfU + 1); // Fix: Increase rank of the correct parent
        }
    }

    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(7);

        ds.union(1, 2);
        ds.union(2, 3);
        ds.union(4, 5);
        ds.union(6, 7);
        ds.union(5, 6);
        ds.union(3, 7);

        // Check if 1 and 7 are in the same set
        if (ds.findParent(1) == ds.findParent(7)) {
            System.out.println("1 and 7 are in the same set.");
        } else {
            System.out.println("1 and 7 are in different sets.");
        }
    }
}
