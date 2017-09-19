/*
 PQ Kernel 1.0

 This code exhibits the algorithm the computes the PQ kernel in O(n log n) time.

 Original Authors
 Copyright (C) 2014  Radu Tudor Ionescu, Marius Popescu

 Java implementation
 Copyright (C) 2017  Butnaru Andrei-Madalin

 This program is free software: you can redistribute it and/or modify
 it under the terms of the GNU General Public License as published by
 the Free Software Foundation, either version 3 of the License, or any
 later version.

 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
public class PQKernelTest {
    public static void main(String[] args) {
        System.out.println("_________________________________________");
        System.out.println("Samples: \n");
        System.out.println("A = [1, 2, 4, 2, 1]");
        System.out.println("B = [3, 1, 3, 4, 1]");

        double A[] = {1, 2, 4, 2, 1};
        double B[] = {3, 1, 3, 4, 1};

        double r = PQKernel.pqk(A, B, 5);
        System.out.println("Kernel function :");
        System.out.println("k_PQ(A,B) = " + r);

        System.out.println("\nValidation test");
        System.out.println("PQ: " + pq_pair(A, B));
        System.out.println("PQ Kernel Proof: " + kernel_proof(A, B));
    }

    private static double pq_pair(double[] A, double[] B) {
        int P = 0, Q = 0;

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                if(1 <= j && i < j && j <= A.length) {
                    if((A[i] - A[j]) * (B[i] - B[j]) > 0)
                        P++;

                    if((A[i] - A[j]) * (B[i] - B[j]) < 0)
                        Q++;
                }
            }
        }

        return 2 * (P-Q);
    }

    private static double kernel_proof(double[] A, double[] B) {
        int[] X1 = new int[A.length * A.length];
        int[] X2 = new int[A.length * A.length];

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                X1[i * A.length + j] = Integer.compare((int)A[i], (int)A[j]);
                X2[i * A.length + j] = Integer.compare((int)B[i], (int)B[j]);
            }
        }

        int sum = 0;

        for (int i = 0; i < X1.length; i++) {
            sum += X1[i] * X2[i];
        }

        return sum;
    }
}
