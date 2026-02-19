import sys
import math

rl = sys.stdin.readline
wr = sys.stdout.write

S = int(rl().strip())

"""
(N**2 + N) <= 2S
"""

wr(str(math.floor((math.sqrt(1 + 8 * S) - 1) / 2)) + '\n')