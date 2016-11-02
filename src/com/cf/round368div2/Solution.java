package com.cf.round368div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.*;

public class Solution {

    public static void main(String args[]) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Problem problem = new Problem();
//        int testcase = Integer.parseInt(in.scanInput());
//        for (int i = 1; i <= testcase; i++)
//            problem.solve(i, in, out);
        problem.solve(1, in, out);
        out.close();
    }

}

class Problem {

    private boolean[][] bookMatrix;

    public void solve(int testcase, InputReader in, PrintWriter out) {
        int N = Integer.parseInt(in.scanInput());
        int M = Integer.parseInt(in.scanInput());
        int Q = Integer.parseInt(in.scanInput());
        bookMatrix = new boolean[N][M];
        List<Query> queries = new ArrayList<>(Q + 1);
        queries.add(new Query());
        for (int i = 1; i <= Q; i++) {
            int type = Integer.parseInt(in.scanInput());
            Query query = new Query();
            query.index = i;
            query.type = type;
            if (type <= 2) {
                query.i = Integer.parseInt(in.scanInput()) - 1;
                query.j = Integer.parseInt(in.scanInput()) - 1;
                queries.get(i - 1).child.add(query);
            }
            else if (type == 3) {
                query.i = Integer.parseInt(in.scanInput()) - 1;
                queries.get(i - 1).child.add(query);
            }
            else if (type == 4) {
                int k = Integer.parseInt(in.scanInput());
                queries.get(k).child.add(query);
            }
            queries.add(query);
        }
        calculate(queries.get(0), 0);
        for (int i = 1; i < queries.size(); i++)
            out.println(queries.get(i).ans);
    }

    private void calculate(Query query, int ans) {
        int count = 0;
        if (query.type == 1) {
            if (!bookMatrix[query.i][query.j]) {
                bookMatrix[query.i][query.j] = true;
                count = 1;
            }
        }
        else if (query.type == 2) {
            if (bookMatrix[query.i][query.j]) {
                bookMatrix[query.i][query.j] = false;
                count = -1;
            }
        }
        else if (query.type == 3) {
            for (int i = 0; i < bookMatrix[query.i].length; i++) {
                count += bookMatrix[query.i][i] ? -1 : 1;
                bookMatrix[query.i][i] = !bookMatrix[query.i][i];
            }
        }

        query.ans = ans + count;

        for (Query query1 : query.child)
            calculate(query1, ans + count);

        // Undo
        if (query.type == 1) {
            if (bookMatrix[query.i][query.j] && count > 0)
                bookMatrix[query.i][query.j] = false;
        }
        else if (query.type == 2) {
            if (!bookMatrix[query.i][query.j] && count < 0)
                bookMatrix[query.i][query.j] = true;
        }
        else if (query.type == 3) {
            for (int i = 0; i < bookMatrix[query.i].length; i++)
                bookMatrix[query.i][i] = !bookMatrix[query.i][i];
        }
    }

}

class Query {
    int index;
    int i;
    int j;
    int type;
    int ans;
    List<Query> child = new ArrayList<>();
}


class InputReader {

    private BufferedReader mReader;
    private StringTokenizer mTokenizer;

    public InputReader(InputStream stream) {
        mReader = new BufferedReader(new InputStreamReader(stream));
        mTokenizer = null;
    }

    public String scanInput() {
        while (mTokenizer == null || !mTokenizer.hasMoreTokens()) {
            try {
                mTokenizer = new StringTokenizer(mReader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return mTokenizer.nextToken();
    }

}