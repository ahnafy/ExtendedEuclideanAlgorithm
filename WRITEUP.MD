## TASK 1

* Q1: gcd(11069529223, 188351587) = x Answer: x = 105401

`` 
printValues(extendedEuclidean(BigInteger.valueOf(11069529223L), BigInteger.valueOf(188351587))); 
``

* Q2: 435985 * S + 288651 * T = 11 Answer: S = 7004, T = -10579 

``
printValues(extendedEuclidean(BigInteger.valueOf(435985), BigInteger.valueOf(288651))); 
``

* Q3: 300 * x ≡ 1 mod 104759 Answer: x = 21301 

``
printValues(extendedEuclidean(BigInteger.valueOf(104759), BigInteger.valueOf(300))); 
``

* Q4: 300 * x ≡ 1 mod 104003 Answer: x = 46108 

``
printValues(extendedEuclidean(BigInteger.valueOf(104003), BigInteger.valueOf(300)));
``

## TASK 2

* For the first part of the task we were asked to test our FermatPrimality method on a number we already know to be prime. We did this by going online and using a 512 bit length number generator
Our number was:

``
5083537116010106723688378720498755604459676251027147086083909175114718951456543300618492193767400943122345668194755922041177399476885135442140452526129161
``

* When running through our FermatPrimality Method, it returns to be true as well assuring us that our method is correct. We also wrote tests to check it again in the FermatPrimalityTest.java file which also  passed.
We then run our FermatPrimality Method on a 1024 bits number which was not a prime that we got from multiplying two primes:

``
15292635142798952685671545487211169665127673691353728491409464826040435192072032438666637583231590126991360729133268747769038629939926726113574604785635893524454127571364939683913369915662356501729222225792566114517935342304581429693471027865989402181055047482915477295920835006627284762492646284988758423231
``

This also got flagged as composite and in 1 candidate needed to be ran through out of our k value of 10. 

The test file also randomly generates primes and composites and tests if they are correct based on our method. We are also shown the number of candidates we had to be running through until we deduced it to be a prime or composite.

* We ran our MillerRabin methods and they seemed to have been giving optimal solutions. We also printed out print statements to showcase the counter for the number of candidates our alogorithm
passes through until it decides if it's prime or composite. Random automated tests have also been written out in the MillerRabinTest file which seem to be passing.

## Comparing the two primality tests

### Fermat Primality test: 

* Input number of k tests: 1 

    *It gave us a false positive for prime*

* Input number of k tests: 10 

    Number of candidates tried to determine composite: 2

* When we ran it with k tests: 100

    Number of candidates tried to determine composite: 6
    
### MillerRabinTest:

* Input number of k tests: 1 

    *It gave us a false positive for prime*

* Input number of k tests: 10 

    Number of candidates tried to determine composite: 1
    
* When we ran it with k tests: 100

    Number of candidates tried to determine composite: 1
    
### Conclusion about these comparisions:

MillerRabin test seems to be doing less candidate comparisions and giving the right answers and passing our test cases.
However, both of the test fails when the value of k is set to be too low like about 1.
    
## Finding Large Primes

We tried to find a prime by creating a random 512 bit BigInteger. We ran our Miller-Rabin test on this
see if it is prime. If not we incremented the random BigInteger by 1 and ran the test again. Unfortunately, we
were unable to locate a prime in the time we were testing. There is probably a better way to do this, but we are
already past the due date of the lab. Given enough time and computing power it should be possible to find a 512 and 1024 bit prime using this strategy. 