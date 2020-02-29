 /*
Part A - Mystery Caches
*/

#include <stdlib.h>
#include <stdio.h>

#include "support/mystery-cache.h"

/*
 * NOTE: When using access_cache() you do not need to provide a "real" memory
 * addresses. You can use any convenient integer value as a memory address,
 * you should not be able to cause a segmentation fault by providing a memory
 * address out of your programs address space as the argument to access_cache.
 */

/*
   Returns the size (in B) of each block in the cache.
*/
int get_block_size(void) {
  /* YOUR CODE GOES HERE */
	/* Initialize variable to 0 then get the start of cache */
	int x = 0;
	int num1 = 0;

	access_cache(0);
	
	/* Loop through cache and increment size variable then return size */
	while(access_cache(x))
	{
		num1++;
		x++;
	}

  return num1;
}

/*
   Returns the size (in B) of the cache.
*/
int get_cache_size(int block_size) {
  /* YOUR CODE GOES HERE */
	/* Initialize variable and get access to first part of cache */
	int x = 0;
	int y = block_size;

	flush_cache();
	access_cache(0);

	/* Loop through cache and increment size counter by block_size per element */
	while(access_cache(0))
	{
		x = block_size;
		while(x <= y)
		{
			x += block_size;
			access_cache(x);
		}
		y += block_size;
	}
	
/* Return the size in bytes */
  return x;
}

/*
   Returns the associativity of the cache.
*/
int get_cache_assoc(int cache_size) {
  /* YOUR CODE GOES HERE */
	/* Initialize variables, one for cache, associativity, and check */
	int x = 0;
	int y = 1;
	int z = 0;
	
	flush_cache();
	access_cache(0);
	
	/* Loop through cache */
	while(access_cache(0))
	{
		x = cache_size;
		z = 0;
		while(x <= y)
		{
			/* If the check clears, increment x to the correct val and access the cache at the pos */
			x += cache_size;
			z++;
			access_cache(x);
		}
		y += cache_size;
	}
	
/* Return the associativity count (z) */
  return z;
}

int main(void) {
  int size;
  int assoc;
  int block_size;

  cache_init(0, 0);

  block_size = get_block_size();
  size = get_cache_size(block_size);
  assoc = get_cache_assoc(size);

  printf("Cache block size: %d bytes\n", block_size);
  printf("Cache size: %d bytes\n", size);
  printf("Cache associativity: %d\n", assoc);

  return EXIT_SUCCESS;
}
