/*
* Part B - Matrix Transposes
*	Eshan Parmar esp27
*/
/* 
 * trans.c - Natrix transpose B = A^T
 *
 * Each transpose function must have a prototype of the form:
 * void trans(int M, int N, int A[M][N], int B[N][M]);
 *
 * A transpose function is evaluated by counting the number of misses
 * on a 1 KiB direct mapped cache with a block size of 32 bytes.
 */ 
#include <stdio.h>
#include "support/cachelab.h"

int is_transpose(int M, int N, int A[M][N], int B[N][M]);

/* 
 * transpose_submit - This is the solution transpose function that you
 *     will be graded on for Part I of the assignment. Do not change
 *     the description string "Transpose submission", as the driver
 *     searches for that string to identify the transpose function to
 *     be graded. 
 */
char transpose_submit_desc[] = "Transpose submission";
void transpose_submit(int M, int N, int A[M][N], int B[N][M])
{
	int x;
	int y;
	int row;
	int col;
	int index = 0;
	int temp = 0;

	/* Iterates through if N = 32, N = 64, and then any other cases throughout */
	if (N == 32) 
	{
		/* A combination of nested for loops allows the program to iterate through each matrix. Different block values are use */
		/*	as the incrementers based on the size of the current matrix */
		for (col = 0; col < N; col += 8){ 
			for (row = 0; row < N; row += 8){ 
				for (x = row; x < row + 8; x ++){
					for (y = col; y < col + 8; y ++) 
					{
						if (x != y) 
						{
							B[y][x] = A[x][y];
						}
						 else
						{
							/* You are able to decrease the amount of misses by creating a temp variable and storing */
							/* a missed value in a temp rather than going back through */
							temp = A[x][y];
							index = x;
						}
					}
					if (row == col) 
					{
						/* Store the current temp into the indexed postion in B matrix, called when at a diagonal */
						B[index][index] = temp;
					}
				}				
			}
		}
	} 
	else if (N == 64) 
	{
		for (col = 0; col < N; col += 4){ 
			for (row = 0; row < N; row += 4){ 
				for (x = row; x < row + 4; x ++){ 
					for (y = col; y < col + 4; y ++) 
					{
						if (x != y) 
						{
							B[y][x] = A[x][y];
						}
						else
						{
							temp = A[x][y];
							index = x;
						}
					}
					/* Store the current temp into the indexed postion in B matrix, called when at a diagonal */
					if (row == col) 
					{
						B[index][index] = temp;
					}
				}	
			}
		}		
	} 
	else
	{
		for (col = 0; col < M; col += 16){
			for (row = 0; row < N; row += 16){ 
				for (x = row; (x < row + 16) && (x < N); x ++){ 
					for (y = col; (y < col + 16) && (y < M); y ++) 
					{
						if (x != y) 
						{
							
							B[y][x] = A[x][y];
						}
						else 
						{
							temp = A[x][y];
							index = x;
						}
					}
					if (row == col)
					{
						/* Store the current temp into the indexed postion in B matrix, called when at a diagonal */
						B[index][index] = temp;
					}
				}	
	 		}
		}
	}
}

/* 
 * You can define additional transpose functions below. We've defined
 * a simple one below to help you get started. 
 */ 

/* 
 * trans - A simple baseline transpose function, not optimized for the cache.
 */
char trans_desc[] = "Simple row-wise scan transpose";
void trans(int M, int N, int A[M][N], int B[N][M]) {
    int i, j, tmp;

    for (i = 0; i < M; i++) {
        for (j = 0; j < N; j++) {
            tmp = A[i][j];
            B[j][i] = tmp;
        }
    }

}

/*
 * registerFunctions - This function registers your transpose
 *     functions with the driver.  At runtime, the driver will
 *     evaluate each of the registered functions and summarize their
 *     performance. This is a handy way to experiment with different
 *     transpose strategies.
 */
void registerFunctions() {
    /* Register your solution function */
    registerTransFunction(transpose_submit, transpose_submit_desc);

    /* Register any additional transpose functions */
    registerTransFunction(trans, trans_desc);

}

/* 
 * is_transpose - This helper function checks if B is the transpose of
 *     A. You can check the correctness of your transpose by calling
 *     it before returning from the transpose function.
 */
int is_transpose(int M, int N, int A[M][N], int B[N][M]) {
    int i, j;

    for (i = 0; i < M; i++) {
        for (j = 0; j < N; ++j) {
            if (A[i][j] != B[j][i]) {
                return 0;
            }
        }
    }
    return 1;
}

