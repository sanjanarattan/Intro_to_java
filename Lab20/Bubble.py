import random
import time

def setValues(values):                          #Creates 10,000 random numbers
    L = len(values)
    for i in range(L):
        values[i] = random.randint(0, 4*L)

def doSort(values):                             #I have very little idea of whats going on here and will ask Prof during office hours
    for i in range(len(values)-1, 0, -1):
        for j in range(1, i-1):
            if values[j-1] > values[j]:
                tmp = values[j-1]
                values[j-1] = values[j]
                values[j] = tmp



Length = 10000                                  #intializes 10,000 0s in a list called values
values = [0] * Length                           #captures start and end tim after doSOrt is called
setValues(values)
start_time = time.time()
doSort(values)
end_time=time.time()
print(end_time - start_time)
print(values)


#MY PERSONAL NOTES:
#The method "randGen.nextInt(int n)" in java is used to generate a random integer between 0 (inclusive) and n (exclusive)
#in Prof.Haskell's code, n=4*L where L=10000
#def() is function method in python
#for i in range (value 1, iteration)
#start_time stores current time into variable-> you can either make 2 variables storing start and end time or call the function again in
#print and subtract by start time
#start time is defined after 10000 random number are generated
#[0] * Length" creates a list with L number of elements of 0. 
# The multiplication operator (*) is used to repeat the 
# list with all elements initialized to 0 (10,000 list of 0s which are later replaced)

    

