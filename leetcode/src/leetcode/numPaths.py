# -*- coding: utf-8 -*-
"""
Created on Thu Aug 30 14:21:50 2018


Problem statement:
    
    You want to walk from the origin (0, 0, 0) to the point (l, m, n) in three-dimensional space (the
    X-Y-Z space). Each step is along exactly one dimension.
    At each step, you are permitted to move an integer number of units along the chosen direction. At
    each step, one can choose the direction of travel but the number of units moved is as follows. You
    always move in the positive direction along the chosen direction so you never move backwards.
    At step k: - if k % 3 == 1 then move 1 unit along the chosen direction/dimension. - if k % 3 == 2
    then move 2 units along the chosen direction/dimension. - if k % 3 == 0 then move 3 units along
    the chosen direction/dimension.
    Naturally the first step is k = 1 (not k = 0).
    The only exception to the above rule is the last step, when one can move fewer than the number
    of units dictated above. For example, if it took 29 steps to get to (l, m, n-1) then we can move 1
    unit along the Z dimension even though this is the 30th step and one would have normally had
    to move 3 units.
    Implement a method numPaths that returns the number of unique paths from the origin to (l, m,
    n) where l, m and n are arguments to numPaths.

@author: Adam Dixon
"""

def numPaths(l, m, n):
    return helpFunc(l, m, n, 1)

def getK(k):
    if k % 3 == 0:
        return 3
    else:
        return k % 3
    
def caseOne(l,m,n):
    return l == 0 and ( (m == -1 and n == 0) or (m == 0 and n == -1) )
def caseTwo(l,m,n):
    return m == 0 and ( (l == -1 and n == 0) or (l == 0 and n == -1) )
def caseThree(l,m,n):
    return n == 0 and ( (l == -1 and m == 0) or (l == 0 and m == -1) )

def helpFunc(l, m, n, k):
    print(l)
    print(m)
    print(n)
    print(k)
    print("====")
    
    # l == 0 and m == 0 and n == 0
    if ( caseOne(l,m,n)  or caseTwo(l,m,n) or caseThree(l,m,n) or (l == 0 and m == 0 and n == 0)):
        return 1
    
    if l < 0 or m < 0 or n < 0:
        return 0
     
    return helpFunc(l - getK(k), m, n, k+1) + helpFunc(l, m - getK(k), n, k+1) + helpFunc(l, m, n - getK(k), k+1)
        
print(numPaths(4,4,4))

