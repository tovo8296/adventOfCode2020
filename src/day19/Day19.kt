package day19

import java.util.*
import java.util.regex.Pattern


val input = """
3: 97 29 | 2 104
45: 97 10 | 2 73
114: 44 97 | 90 2
78: 2 95 | 97 32
7: 97 64 | 2 119
118: 97 81 | 2 58
64: 97 29 | 2 14
106: 53 121
4: 2 103 | 97 55
54: 2 53 | 97 44
58: 33 97 | 130 2
91: 104 97
102: 104 97 | 83 2
128: 2 59 | 97 3
79: 98 2 | 124 97
117: 2 65 | 97 92
1: 75 2 | 115 97
40: 2 96 | 97 119
8: 42
92: 102 97 | 57 2
93: 2 66 | 97 103
36: 2 104 | 97 32
108: 43 2 | 68 97
46: 44 2 | 90 97
31: 97 5 | 2 132
110: 14 2 | 90 97
61: 38 2 | 9 97
10: 63 2 | 34 97
32: 2 2 | 97 121
11: 42 31
103: 121 121
131: 75 97 | 60 2
74: 2 112 | 97 47
20: 93 2 | 69 97
53: 97 2 | 97 97
23: 125 121
9: 97 66 | 2 25
101: 83 97 | 95 2
35: 25 2 | 104 97
76: 97 55 | 2 104
125: 83 2 | 32 97
22: 59 97 | 76 2
127: 6 97 | 55 2
126: 97 119 | 2 17
113: 59 97 | 35 2
81: 46 2 | 72 97
104: 2 2 | 97 2
100: 25 2 | 95 97
95: 97 2
132: 97 27 | 2 45
107: 97 90 | 2 32
34: 98 97 | 50 2
33: 2 95 | 97 83
119: 32 97 | 66 2
90: 2 2 | 97 97
77: 126 2 | 22 97
6: 2 97
14: 97 2 | 2 121
94: 2 110 | 97 129
21: 56 97 | 105 2
65: 2 96 | 97 98
122: 2 71 | 97 86
87: 101 97 | 91 2
15: 107 97 | 120 2
120: 103 2 | 66 97
56: 128 2 | 20 97
129: 2 66 | 97 83
41: 97 48 | 2 122
13: 39 97 | 26 2
30: 97 88 | 2 54
84: 55 97 | 53 2
86: 84 2 | 59 97
96: 55 2 | 104 97
83: 97 121 | 2 97
50: 53 97 | 95 2
19: 2 70 | 97 78
121: 2 | 97
57: 53 2 | 83 97
37: 6 97 | 6 2
68: 97 53 | 2 83
112: 97 23 | 2 19
66: 2 97 | 2 2
49: 97 90 | 2 103
80: 2 97 | 97 97
85: 83 97 | 55 2
12: 2 35 | 97 51
116: 97 67 | 2 77
123: 4 2 | 85 97
82: 21 2 | 111 97
105: 30 97 | 87 2
72: 25 97 | 95 2
115: 104 2 | 29 97
63: 97 37 | 2 36
42: 24 2 | 82 97
0: 8 11
70: 2 80 | 97 25
5: 2 74 | 97 116
52: 16 97 | 94 2
62: 35 97 | 114 2
18: 123 2 | 61 97
25: 97 97
88: 83 97 | 66 2
124: 2 6 | 97 80
89: 114 97 | 100 2
44: 97 2 | 2 97
71: 49 97 | 106 2
38: 2 104 | 97 90
75: 53 2 | 104 97
98: 53 2 | 25 97
69: 97 95 | 2 95
73: 2 1 | 97 7
24: 41 97 | 109 2
48: 2 40 | 97 113
39: 103 2 | 104 97
67: 2 15 | 97 62
55: 2 2
47: 2 79 | 97 108
51: 6 2 | 95 97
17: 95 2 | 90 97
59: 53 97 | 66 2
28: 2 12 | 97 131
27: 2 52 | 97 28
29: 97 97 | 2 121
16: 4 2 | 127 97
109: 2 117 | 97 18
43: 104 97 | 6 2
99: 97 89 | 2 13
130: 83 121
111: 99 2 | 118 97
60: 97 44 | 2 25
26: 121 44

abbbbababababbaabbbbbbab
bababababaabbbaaaabaabaaaaabaabaaabbbbab
baaaabbbabbbbababbbbaabababaaababbaaaabbbbabbbbb
abbababaaabbabbaabaaaaaaaaaabaabaaabaabb
aabbaababaabbabbaaabaababaaaabab
baabaaaaabbabaabaaabaaabbaaabbabbaaabbbbbabbbaba
babaabaaabaabaababaabbab
bbbbbababbbaaaababaaaaabbaabaaba
bbaabaaaaaaabbabbababaabbabbaaaa
aabbababaaaabababbbbaabbaaabbaba
bbaaababbbbaababbbbabababbaaabaaaaababba
bbbbababaabbbabaabbaabbaaaaabbbabbbbbbbbbaaaabaabbbaaababbaaaaababbbabbabbabaaab
bbbabbbabbaaabaaabaababbbaabaabaaabbbbba
abbbbbabbaabbbbbbaaaabbbbaaaaabb
aabbababbabbababbbbbaaabaababbaabbaabbaa
bbbbbabaaabbaaaaabaaabbbabbaaaba
baaabbbbbaabbaaabbbaabaaaaaabbbbaabaaaab
bbabbbaaaabaabbaabbbabab
bbbbbabbbabbbababbabaabaabbbbaab
aaaabbabbbababbabbaabaaaaabbbaaaabbabbababbbaabbbbbbaaaa
bbaabbabbaaabbabababbbbbbbbbabbbaabaaaaaabbababbbbbaaaba
bbbaabbbaaabbaabbbbbbaaa
bbabbabbbababbbbababbbaa
baabbbabaabaaabaabbbbbbbaaabbaaaabbababa
aabbaabaabaabbbabbbbabaaabbabbbbabbabaabbbabbbaababbbbba
aaabababbbbaaabbbaaaaaabaaaaabaabaabababbbbabaaaabaaaaabbbbbbbba
babaaabaaabbbabaabaaabbbababbabbbabbabaaaaabbaba
aabbaaaabbbbbabbbbaaabbbaabaabbbbbaaabbbabaabbbbbbbababaabbaaabbabbaaaba
aaaabababbaabaaaaaaaaaba
babbbbaababaaaabbbabbbabaaababaaabababaaaaabbaababaaaaba
abbbabaababababbabbaaaab
babaabbbbabababaabaaaabbbababababbaaaabbaabbabba
bbabbababbbababbabbaaabb
bbabababbbbababbbbbbaaaa
bbaaababaaaababbbabbbaba
aabbbabababbababbababaaaababbaabbbabbaabaabbabbbbaaaaabb
bbbbbababbaabbababaabbbbababbbaabbbabbba
abbbbaabbbaaababaaababaaababbbbbbbaaaaaabbbaababaabababb
baaaaabbbaabaaabbbbbbaaaaabbaabaaabbaaaabbbbbbbbbbaaaaabbabbbababbabbbba
abaabbbaaabaabbbbaaabbababaabbab
abbbbababbbbaaababbbbbabbababbaaababbabaabbaabbb
babbababaabbbaaabaaabbabbbbaabaabaaaabbbabaabbaaabbbbbba
babbabaabaababbabbaabbbbbaabaaabbaabaabbbbaaabbaaabababb
babaaaaababbbaaabbabbabb
baabaaabbbbababbbabababbabbabaabbbaabababbbbbbabaabaaaab
aaaaabbbaababaababbbbababbbabbaaabbbabbbabbaaabbababaabbbaaabbaaaaaabbaa
bababaaaabbbbbbbababbbababbbbbaabaabbaab
baaabbbbaaaaabbabbababaaabbabbab
aaaaabbbaabbbaaabaaaaaabbabbbbbb
aababbaabbbabbaaabbbbabbaaaabbbb
aabbababbbbbbaabbaaaaaaaabbbbaabbbabaabb
bbbbbaabbbbbabaaabbbbbaa
babababaabaaaaaabbaaabbaaaaabbbaabbbbbababaaababbbabaaabbaabbabb
bababababbaaabbbababaabb
bbabaababbaaaaabbabbbaaabbbaaaababaaaaaaaabbbbab
bbabbbabbbbbabaabbbabaaa
aaabbbaabbaaaaabbbabbabababababbabbababb
aabbaaaabaabaabbbbbbaabaaaaabaaabaabbaab
aaaabbbabbbbaaababbabbab
abbaaaaabaabbbaaaaabbbbbbbababaabbbbaabbabbbababbaaaabaa
aaaabbbababababbbaaababaabbabbbabbabbbbb
baaaaaabbaababbbabbaabaa
aaaabbbaabaaabbbbaaaabbababaaabaaaabbaaabbababaa
bbaaaaabbabbaabbbabbbaba
aaaabbbababababbababbaababaabaabaaabbaab
baaaaaababaaabbabbabbaabaaaabbbb
bbbbaaabaaabaabaaabababaabbabaabbbbaaabb
aaabbababbbbaabbbbaababbaaababba
aabaabaaaaaababbbabbaaaabaaaaabaabbabaaabbabaaabaaabbbababaaabaa
aabaaabbabbabbbaaaabbbab
bbaaaaaabaabaaaababbaaaaaabaababbbbbbabbbabbbaaabbbabbbbbabbbaab
bbbbabaabbabbaaabaaaaaaabbbaaaabaaaabbababbaabbbbbabaabaaaabbbbaaaababaa
aaababaabaababbabbaabbbbbbbabaabaaaabaaabaaabbabaaaabaab
ababababbbbbbabaababbbabbbbaaabbabbababaaaabbbba
babbbbabbaabaababbabbbaabbbaabbbbaabbaab
aabaaababbbbaaabbabaabbaababaababbbabaab
aabaaabbbbaabbbbbbbaabbababbabaabbaaabaa
abbbbbbbaabbbaabbbabbbabbababbaabbababbb
aabababababaaaaabbbababbbaabbbba
aaaababbabaaaabbaabaabbaaaabaaaa
bbbbbabbababbaaaabbbbbabbaabaababbbbbaaa
aabbaaaababbbaaaaaaabbaa
aaaaaaabaabaaabbabbaaaaa
babaaababbaaabbabaabbbbbbaaaababbbaabaab
abbabbbaaaababbbababbbabaabaababbbababab
baabbbaabbabbbabaabbbaaabbaaaabbbbaaabaaabbaabbb
babaabaaaaababababbbbabbbabaabaaaabaaabaababababbbaabbbabbaaaaaababaaaab
aabaaabbaababbaaabbbbbaa
aaababaaaaaaabbabbbbbbba
ababbbabbabaabbabbabbbbababbaabbaabababb
baabaaabbaaaaaabababbaababaaabaaabbbbbbbbaabababbbbabbba
bbababbababbababbbaabbbbbbbababbabbaaabbbbbbaabbaababbba
ababbaaaaaabbbaaababbbaa
ababbaabababbaabbaabbaba
aaaaabbabbabbbabbbaaabbbababababaaababbabababbabaaabbbabbbaaaaba
aabaabaaabbbbabbababbaababaabaaabaababab
bbabbaaaaabbbabababababbababbbaaabbbaaaababbbabbbbbbbbabaababaaa
aabaaabbbbbbababaaabaaaaaababbaaabaaabaaaabaabaabababaabbbbaaaaabbbabaaa
aaabaabaabaabbbabbbbabba
aaabbbaabaabbbabbbababbb
bbbbbaababbbbaabbbabbaabbbbaaaaa
baaaabbbbbabbbababaaaaababbbabab
bbaaaaabbaabaabbaabbaaaaabaaabaaaaababbbabaababa
babaabbaabaaabbabaababbaababaaaa
abbbaababaaabbababbbbaabaaababbbbbbbbbab
abbbbbbbbbaaabbbaabbabaa
baababbabaaababaababbabababbbbabaababbbaaaabaabbabbaaabb
bbababaabbaabbbbbabaabaababbabba
bbbaabaaababababbaabaaba
aaabaaaaaaaaabaabbabaaabbbaabbab
aaaaabbaababbabababaabaabbbaaaaa
ababbabaaaaaaaaabaabbbaaaaaaaaabaaaaaaaababbaaaa
aabaabababbaababaababbabbaabbaabbbaaaabbababbabbbaaabbba
babaaaaababbaabbbbbbabaabaaababababbbabbaabbaaab
bbabbbabbbbaaaabaaaabbaaabbaabaabaaaabaa
baababbabbabbbaabaabbaab
babaabbbabaabbbaabaaabaaabaaabab
abaababbbababbbaaaaaabbababaaabbbaaabbbb
aaaababbaabaabbabbaaaaaa
baabbbbaabababababbbbaaababbaaaabbbbaaababaabbaaaaabbbbbaabbabbbbbaaaaaa
bbbbaaabbabbbaaaaabbbbba
aaabbbaaaabababaababbaabbbbabaaa
baabbbbbbaabaabbbababbaabbbabbabaabbbbab
baaababbaabaaabbbbbaaaaaaabbabbaaaaabaab
ababbabbabbbbbbbabababbaaaabababbaaabbaa
baaabbbababaabbbbaaaaabb
bbaabbbbababaabaaaaaaaba
aabbbabbbbabbbabbbbbabba
abbabbbbaabaaabaaabaabab
aaaaaaaaaaabaababbaaaabbaabbbaabbbbabbaabbabbabbababbbaabbaababbaaaaaaba
abaabbbbaabbbabbabbbbabaabbabbab
bbaabbabbbabbbbaabbbbaabababbbbaaaaaabbabbabbbbb
bababaaabaabbbbbbbaabbbaaaabbbab
abbbabaabaabaabbbaabbababbbababababbbabb
ababaabababababaababbbabbababaabbabbbaababababbb
baabbbbbabaabbbbabbbabab
ababbabbbabababbbbabbaaaaabbabbb
baabbabbbbaabaaabbabbaabbbabaabb
babababbbabaabbaabbbbbba
abaaaaabbbababaaaabaabbbaaaabaab
baaaaaabbabbababbaababbbbaabbabbaabbbbab
abbbabaabbaaababaabbbaabaababaabbababbabaababbba
bbabababaabbbbaaaabaabaaabaababbaabaaaaababbbbabbbaaaaabbabababaaabababababbaabb
aaababaaababababbbbbbababaabbabbabbbbabababbbaba
aabaabbbaaaaaabbbbbaababbabbbbba
bbabbbabbbaaabbbabaabbbababbababbbbaaabaaaaaabaabaaabaabaabbbbaaabbbabab
bbaabbbbbbaabbbbbaaababaaababbabbaaaabba
ababbbbbabbbbaabaabaabbaabaabbab
bbabbbaaaabbbaabbbababbaaaabbbba
baabbbbbababbabababbbaababbabbbaaaaaaaba
abbabbbaaabbbaaabbabaabababbabaaabbaaaaaaaaabaabbbabbbbb
aaabaaabbaabaabbbaababaabababbbbaabaaaab
baabbbaabaabaabbaababaabbbaaabba
abaaabbbbbbbabaababaabaaababbbbaaababbaaaabbbabaabaaaabababbbbbbabbaabab
abaaaabbaaaaaaabbbbbabaaababbabbabaaabaabbaabbba
bbaabbabbbbaabaabbaabbaa
abbbbababaabbbaabbbbbabaababbbaabbbbbaaa
babaaaaabbbbbbbbbbbbbababbbaabaabaaaaaabbbabaaabaabbabaa
bbaaababbabaabbabaabbbbbbababaabaabababbbabbbbba
baaaaaababbabaabaaaababaababbaabaaaaabab
aabaaaaabababaababaaababaaaabbabaabaaabaabbababbbaaabaaabaababaa
babababbababababaaababbb
aaabaaabbbababaaaabaabbabaaabbbabaaaabab
abbabbbaaaabbbaabbaaaabbbabbbabbabaabbaa
bbbbbabbabaaabaabbababaabaabbabbbabbaabbbbbbabbbabbaaaaa
bbbbbabaaabbbabaababbbbbabaabbbbbbaaaabbbbbaabbbabaaabab
bbabababbababaabababbbbbbbbaaabbabbaabbb
aaaaaabbbbbaababbbaaabaabbbaaaaa
aaababbabbabbbaababbabbaabbabaabaaabaababbbabbabbbbbbbbbaabaaaab
abbbbbbbbaaabababaaaaaabbbabbabb
babaabaabaaabababaabbabbbabaabaabbbaabaabbabbbaabbbabaaa
bbaabbabbbabaaabaaaaaabbbbabaaab
baaababbababbaaaabbbbbba
baaababbaaaabaaaaababbaabaabbbbbabaaaaababbaabaaaabbbbaaaaabaaaa
aabaabbbbababaaababbabaabaabbaaabbaaabbbbbbbbbbbabbababb
aabbbaaababaabbabaabaaaaaabaaabbbabbaaabbababbbbabaababb
baaabbabbaaaabaaaabaaababbbbabaaaaabaaba
ababbaabbaabbbabbabbababaaaabbbbaabbabba
abaabbbbbababaaabaababab
baabaaaaabaaabbbaabbaabbaaabbbbb
bbbbbbaaaaabbaababbabbabbbbbbbaa
abaaabaabaabbbbbbabababbbabbbaaaabaabbbaabbbabbbaabaaaaa
bababbaabaaabbababaababb
bbbabaabbababbaabbbabbaababbbbbbbbbbbbab
bbbbbbbbaabaabbaaaabaaabbbaaabbbbbabbbbb
abbabbbabbbbbaabbbaaabbbbaabbbaaabaabbbbbabbabbb
baaabaaababaaaaaaabbbabbbaabbaaababbbbbbbaaaabba
abaaabbaabaabbbabbaaabbbabaaabbbaababaaa
aaaaabbbaabaabbabaabbbbbbbaabbaa
aaaabbbaabbbbabaabbabaaaaaabaabb
aaabaaabaaabaaabbaabbaaababbbbabbabaaaab
aabaaabaaabababaabaaabaaababbaaa
bbbabbaabbabaababaaabbbabbbbaabb
bbaabbbbbaaabaaaaaaaabbaaaabbbbb
abbbabbaababbbbbbbbabaaa
bbbababbababbbabaabaabba
babbbaaababaabbbbbababababbbabaaabbbbaaa
abaaaaabbaaaaaabbabbabbb
ababaababbbbbabaaababbab
abbbabbbaaaaaaababbbaaaa
babaaaaabbaaabbbabbabbbbaabbaaaaabaabbabaaabbabb
babbaabbbbbbabaaabaaabbaabaabaaabababbba
ababbbbbaaabababbbbabbaaabaaaaaa
bbaaaabbbaabbbaababbbbbb
abaabbbaabbbbbbbaaabababbbbbababaaaabbaa
abaaabaaabbabbbbbabbababbabbbaabaaaaaabaaaaaabaabaababab
abaabaabbaaabbbbbbbbbabbaaabababbbaabaaaaaaaabab
aaabbbaabaabbbbbbabaabbabbbbaabb
bababaaabaabbbaabbaaabbababbbaabbbbabaababaabbaababaaaab
aaabaabaaababababbabbbbb
bbbababbaabbbaaaaabbbaabbababbba
baabbbaaabbabbbbbbbbabaaabbbbaabbababbbb
baabaaaaaaabababaaabbbab
babababbaabbbabaabbbbaaa
babaaababbaabbbbbababaaaabbbaababbaaabaa
aabbbabbbabbababaaaabababbbaabba
aabbbaaabbabaabbbbbbabbabbbbbbaaaababaaaabbbaaabbaabbabaabbbabaaababaaaa
ababaabaaaaababbbaaaaaba
bbabbbbaababaababbabbaabbbabbaaaaaaaaaababbbbbbabbabaaababbbbaaabbabbbbb
bbaabbabbaaabaaaaaabbbaabaababbbbaababbabababbababaabaaa
bbbbbaabbababaabbbabbaabbbababaabababbab
baaabbabaababbaaaaabbbaabbbbbaabbabbbaaaabbaaaabaabbbbaa
aababababababbaaabaaaaababbabaabaaaabbbaabaaabaaabbaababbbbabbbbbbbaaaaababbbbab
aaabababaabaaabbaabaaabbaaabbabbaabbaaab
baaabaaabbbbbbbbaaaaaaba
abbbabbbbbbbaababbbabaaa
babababbbbbbbabbaabaabbababbbbba
aaaaabbaaabbbaababaaabbbaabbbbab
bbbaaaaaabbabababaabbbaaaaaabbaaaababbbaaaaabababbabaaaaaaaaababbbbbbaabbbabaaab
aabaabbabababbbaabbaabbbbbabaabbbbabaabb
aaaaaaababbbabbbbababaaababababbaabbbaaabbbabbba
babbabaababbaabbbaabaaaabbaaaaababaaabaabaabbaab
abbbbbbbabbbbabbaabbbaaaabbbbbaa
bbaaaabbbaaabbbbbbbbabbb
aaababaababaabbbababbabbabaabbbabaabbaaabbbbbaaa
bbbababbbaabbaaabbabaaaababbbaaabbabbaba
abbabbbbbbbbbaabaabbaabaababbbaa
baababbabaaaaaaaaabbbbaa
baaabbabaabbbbbbaaaabbabbbbaaabb
bababbaabaabbaaabaabbabbabababbb
bbbbbababbbabbaabaababab
aaaabbababbabbbabbbbbbbbaaabbaab
bbababbaaababbaabbbbbbbbaaaaaababaaaaaba
ababbababaabbabbaaabaaaa
bbabbbaaaaaabbabaaaaaaabbbabaababbbbbbaababbbaba
aaaaabaaababbbaabbbbabba
ababbbbaaabbbbbbbaaaabbbbbaaabbbbbbbbbaa
babbaaaaabbbabbbaabbbababaaaaabaaaabaababababbab
baabaaabbabababbbbbaabbabbbbbbabbbbbbbaa
bbabbabaaaaababbaabaabaaaabbabbabbaaaaaa
aabbbababaabbabbbabaaabaabbaaababbbbaabb
aabbbaabaabaabaaaaaababbbbbababa
abaaaaaaabababbbaaabbaabaaabaabb
abbbbabbaaaaabbbababbabbbabbbaaaabaabbbbabaabbbabbbaaaba
aabbbaaaaaabbbaaaaaaabbbbababaabbbaababaaaabbaaaababaabb
aaababaaababbaaaabbbabaaabbababb
baaabbbabaaaaaababbbabbbbbbbababbbaabaabbabbabbababbbbabbbabaaab
bbabbabaaabbababbaabbbabaabbabab
abaabbbabbbbabaabbbaabba
babaabbbababaababaabbbbbaababbba
abaabbbbabbbabaabbababbb
baaabaaaaaaabaaabbbbbaabaaaabbbb
bbaaabaaababbaabbbaaababaaaabbbbabbaaabaaaaaababbabaaaaa
babbabaaaabbababaabbbaaaabaabbbbbbbaabab
bbabaabaaababaababaababb
aabbaaaabaabbbaabaaababaabbbbbabbbabbabaaaabaabb
baabbbabbaabaabbabaabaabbaabbbbbabababaa
abaabbbaabbaabbaaaabbbbababaaabb
bbbbaaabbbbbbabaaaaabaaabbbabbab
ababbbbaabbbabaabababbbabbababbaaaabaaabaaabaaaabbaaababaaaabbaabbbbaaaa
bbaabbababababbaaabbabbb
babaaababbaaaabbaabbbbab
bbabbbaabaabbabbaabbaaaaaabbbaabaaabbbab
abaabbbbabaaaabbaabbababaaaababaabaabbbabbaababbbbbaaaba
abbbbaabbbaaababbbabbbaaaaaaabaabababaaababbaabb
aabbbabbaaabaaabaabbabba
ababbabbababbaababbbbabaabbbaaab
ababbbbaabaaaaabaabbaaab
babbbaababababbaaaabaaabbaabaaaabbaabaaabbaaabbaaabaabababbaaaba
bbbbbbbbbaabbbababbaabba
aabbababbaabaaaaababbbaa
aabbbbbbababaabaaabaaabbbbabbabaaaaaababaaabbbba
aabaabbaaabaabaabbbaabaaaaaabbbb
abaaaabbbbbbaaabaaaaabaa
baaabbbbbabbabaaababbbaa
baaababaababaaababbaaabbabaabbba
ababaababbabbbabababbababbaababb
baaaaabbbaaababbbabaaaabbabbbababaaababbaaaababbbbaaababbaabababaababaab
baabaaaabaaababbbbabbbabababbabababbabba
aabbbabbababbabbaabbaaaaaabbbbaa
aaaaaaabbbbbaaaabbbabbabbaabababbbaaaaba
aabbbbbbaaaabbbabbbabaaa
aaaabaaaabbbbbbbbbaabbaa
baaaabbbabbbbabbbbbababa
ababaabaaabbaaaaabaabaabbbbbaabb
babaabbbbabbababbbbbabaaaabbaaabbbbaababaabbaaabbbabaabb
baabbbbbbbabbbbabaabbbba
aaababaaababaababbaaababbbababbaabbbbbabbbbaabbabbbbbbab
baaababbbbaabbbbbbaabaaabbbaabbb
baabaabbaaaaabbabaaabbababbaabbb
bbabaaaabbbababbaabbbababaaabbabbbaabbabaababbabbaaaabab
baabaaaabaaabbabbabbabaabbabbbababbbbbababaabaababbbaaaababaabab
abaaabbabaaabaabbbaaaabababbbbaabaaaabba
aaaaaabaaabaaabbaaabbaaaaabbbaabaabbaaaaaaababaa
bbbbabaaaababbaabaaabbaa
ababababbaaaaaaaaaaaaabb
aabbaabaaaabbaababaaaabaabaabbabaaaaabaabbbabbba
aaaababababbababababbbaa
abaaaaaababbbaabaaababbaababbaabbabbabababbbabbabbabbaab
bbabaabaabbbabaabaaabaaababaabbbabaaaabababbaabaaabbabaa
baabaaaabababaaabbbababa
aaaababaabbabaababaaabab
baaaaaaaaabbbabababbabba
abaababbbabbbaaaaaaaabbbbaaabababaababaaabbbbabaabbbaaaaabbaaaababbaaabb
ababbabbaabaabbbababbabaaabaabab
aaaaaaabbbabaaaababaabbaabbababa
bbbabaabbbbbabaaaaaaaaabbbbaabaabbabaaabaabbaaab
ababbabbaabaaabaababababaaaabbbb
aaabaaabaabaabaaaabaaabaaabaabab
abaaabbbaabbbbbbaaaaabaa
bbababababaabbbbbbbbbbbbababaaabaaabbaba
babbabaababababbabbbbbbbbaabbabbaaabbaab
aaabbbbabbbbbbbababaababbabbaaaaaaababbb
bbaaababbbaaabbbababbabbbbbbbbbbaabbabba
babaaabaaabbbabbaaaabbabbaaabaab
babaaaaaaabaabbbabaaabab
baaabbbbababbbbbbabbbaabbabaaaab
abababbbababbaaabbaaabababababaaaabaaabb
babaabbbababaabaabaabbbb
baabbaaaaaabbbaaaabababaaabbbaabbbbaabbababbbbab
bbababaaabaaaaabbabbbaaaaaababbb
bababbaababababbbbbbaabb
babbbaaababbbaaababababababbaaabbbaabaab
aaaabbbabbaaabbbbaabbbbbbbaabaaabaaabaab
baaaabbbababbaaaaabbbabbbabbbabbbabbbbab
bbabbbabaaaaabbbbabaabbbabbabbaa
abbbbaababaababbbaaabababbbbaabababaaaaabbabbbaaaaaabbaaabbbbaab
ababbbbabbabbbaaaabbbaaababaabaabaababbaaaaabbbbaaaabbbbbabaaaab
bababababaaababaababbabbabaabbaaaaabaabb
bbaaaabbabbabbbabbaabaaaaaaaabbbaaaabbababbabbabbabbbabaabbbaaabaabaaaab
bbaaabbbbaaaabbbbabaaaaaabbbaabb
babaabbaaaabbbaaaaabaaababbbabbaabbbbbabaaabbababbaaaababbbaaaaa
ababbabbbaabbbaabaaaabaa
aabaaabaaaaaaaaabbbbbaaa
baabaaabbabaabbbababbabbbababbab
abaaabbaaaaaabbabbaababa
babbabaabaaaabbbbababbab
aaabbbaaaabbbabbababbaaababababbabbbaabbabaababb
aabaaabaaabbbabaabbaaabb
abaaaabbbaaabbbaababbbbabaababab
bbababaabbbbaaabaabbbabbabbbaababbabaaab
abababbabbabbabbaabbabaabbaabbaa
abaaabbbababbbabbbaababa
ababbbabababbabaaaaabbbaabbababa
baababbabaababaabbaaaaaa
bbbbbaabaaababababaabaaa
babbaabbaabbbaaaabbbabbaabbabaaabbabbabaaaaaaaaababbbbaaaabaabab
aabababaababaabababbbaaabbaabaaabaaaabab
bbabaabababababbbabbbaba
aaababbbaabaabaabbaaaabbbbabaaabbbaababb
baaaabbbbababaabbabababaaabbbbbbaaabaaaa
abbbbabbaabbbabbabababaa
aabbbaaabbbababbbbaaaabaabbbaabb
ababbbabaababababaaaabab
bbaaabbabbabbbaaabbbaaaa
bbaabbbbabaaabbaabababbb
abbbaababbaabaaaaabbaaaaaaaaabaa
baabbabbabaaaaabaaabaaaa
aaabababababbbbabbbbbabaabababaa
aaaaabbbaabaaabbbbbabaabaaaabbaa
aaaaabbbababbbabbababbba
ababbbabababbaabbbaaaaabbbbbbbaa
bbbaaaabaababaabbaababbaabababaa
baaaaaabbbbaaaababbabbaa
baabbabbbbababaaabbabaababbbabbaabaaaaababababbb
abaaaaabbbbaaaababbabbaa
abbabaabbaabbbaaaabbaabbaabaabaaaaababbabaabbabababaabaabbbbbbbbbaaaaabbababbbba
aaabaaabbbbabaabbaababaaabbbbbabbaaaaaaaaababaaaaaababbabaaabbaa
aaaaaaabbaabbaaababbbaababaabaaababbbbaa
bababababbbbbabbaabababbbaaabaaaaaaaaaaaaabbbaaa
babababaaaaabaaabbaaabaa
abbbbabbbababbaababbbaabbababbbb
bbabbbabaabaaabaabbabbbbabbaaaaabbbabbba
aabbaaaabaaabaaaabbbbabaaaaaaaba
baabbbbbbaaabaabababaabaababaaaaaabbaaaabbbbaabbabbabbaa
bbaaaabbbbaaabbabaaabaab
bbbbbababaabbaaabbbbbaba
bbabbababaabbabbaaaababbbbbbbabaaaaaabaa
aaabababaabaabbbabbbabbaaaababaabbbabaaabbabbbbbabaaabab
bbbabbaababbababaaaaaaba
bbbbbababbabbaabbbbaaaba
aabaabbbbbabaaaabbaaababababababbabaaaab
baaabbbabbbababbabababaa
bbaaababbabaaaaaabababbb
bbabbaababbbabbaaaababbb
bbabbbbaabababbababaaaab
""".trimIndent()
//97: "a"
//2: "b"


val testInput = """
42: 9 14 | 10 1
9: 14 27 | 1 26
10: 23 14 | 28 1
11: 42 31
5: 1 14 | 15 1
19: 14 1 | 14 14
12: 24 14 | 19 1
16: 15 1 | 14 14
31: 14 17 | 1 13
6: 14 14 | 1 14
2: 1 24 | 14 4
0: 8 11
13: 14 3 | 1 12
15: 1 | 14
17: 14 2 | 1 7
23: 25 1 | 22 14
28: 16 1
4: 1 1
20: 14 14 | 1 15
3: 5 14 | 16 1
27: 1 6 | 14 18
21: 14 1 | 1 14
25: 1 1 | 1 14
22: 14 14
8: 42
26: 14 22 | 1 20
18: 15 15
7: 14 5 | 1 21
24: 14 1

abbbbbabbbaaaababbaabbbbabababbbabbbbbbabaaaa
bbabbbbaabaabba
babbbbaabbbbbabbbbbbaabaaabaaa
aaabbbbbbaaaabaababaabababbabaaabbababababaaa
bbbbbbbaaaabbbbaaabbabaaa
bbbababbbbaaaaaaaabbababaaababaabab
ababaaaaaabaaab
ababaaaaabbbaba
baabbaaaabbaaaababbaababb
abbbbabbbbaaaababbbbbbaaaababb
aaaaabbaabaaaaababaa
aaaabbaaaabbaaa
aaaabbaabbaaaaaaabbbabbbaaabbaabaaa
babaaabbbaaabaababbaabababaaab
aabbbbbaabbbaaaaaabbbbbababaaaaabbaaabba
""".trimIndent()
//14: "b"
//1: "a"

var rules: MutableMap<Int, Rule> = mutableMapOf()

fun main() {
    val source = input
    rules = mutableMapOf<Int, Rule>(
//             actual input
            Pair(97, Literal(97, 'a')),
            Pair(2, Literal(2, 'b'))

//            // test input
//            Pair(1, Literal(1, 'a')),
//            Pair(14, Literal(14, 'b'))
    )
    parseCombinationRules(source, rules)
    val messages = parseMessages(source)

    countValidMessages(messages) // part1 => 104
    countValidMessagesWithLoop(messages) // part2 => 314
}

fun countValidMessagesWithLoop(messages: List<String>) {
    val validCount = messages.count { matchesCompleteWithLoop(it) }
    println("Valid messages with loop: $validCount")
}

fun matchesCompleteWithLoop(message: String): Boolean {
    // 8: 42 | 42 8
    // 11: 42 31 | 42 11 31
    // Rule 0: 8 11

//    println("--- messsage: $message")

    val r42 = buildRegex(rules[42]!!)
    val matcher42 = Pattern.compile(r42).matcher(message)
    var ends42 = mutableListOf<Int>()
    var count42 = 0
    var previousEnd42 = 0
    while (matcher42.find()) {
        val start = matcher42.start()
        val end = matcher42.end()
        if (start != previousEnd42) {
            break
        }
        count42++
        previousEnd42 = end
        ends42.add(end)
    }
//    println("Match 42: $count42 times, ends: ${ends42.joinToString(",")} , message length: ${message.length}")
    if (count42 == 0) {
        return false
    }

    return ends42.any { end42 ->
        checkLoop31(message, end42, count42)
    }
}

private fun checkLoop31(message: String, end42: Int, count42: Int): Boolean {
    if (end42 == message.length) {
        return false
    }
    val r31 = buildRegex(rules[31]!!)
    val matcher31 = Pattern.compile(r31).matcher(message)
    var count31 = 0
    var end31 = end42
    while (matcher31.find(end31)) {
        val start = matcher31.start()
        if (start != end31) {
            break
        }
        count31++
        end31 = matcher31.end()
    }
//        println("Match 31: $count31 times, end at $end31, message length: ${message.length}")
    if (end31 != message.length) {
        return false
    }
    return count31 > 0 && (count42 > count31)
}

fun countValidMessages(messages: List<String>) {
    var validCount = 0
    messages.forEach { it ->
        if (matchesCompleteByRegex(it, rules.get(0)!!)) {
            validCount++
        }
    }
    println("Valid messages: $validCount")
}

fun matchesCompleteByRegex(message: String, rule: Rule): Boolean {
    val regexS = buildRegex(rule)
    val match = Regex(regexS).matchEntire(message)
    return match != null
}

fun buildRegex(rule: Rule): String {
    return when (rule) {
        is Literal -> "${rule.char}"
        is Combination -> {
            val exp1 = buildOptionRegex(rule.option1)
            if (rule.option2.isEmpty()) {
                "$exp1"
            } else {
                val exp2 = buildOptionRegex(rule.option2)
                "(?:$exp1)|(?:$exp2)"
            }
        }
    }
}

fun buildOptionRegex(option: List<Int>): String {
    return option.map { key ->
        val rule = rules[key]!!
        val ruleExp = buildRegex(rule)
        "(?:$ruleExp)"
    }.joinToString("")
}

fun parseMessages(source: String): List<String> {
    val lines = source.lines()
    val emptyLine = lines.indexOfFirst { it.trim().isEmpty() }
    return lines.subList(emptyLine + 1, lines.size)
}

fun parseCombinationRules(source: String, rules: MutableMap<Int, Rule>) {
    source.lines().forEach { line ->
        if (line.trim().isEmpty()) {
            return
        }
        val semicolon = line.indexOf(":")
        val key = Integer.parseInt(line.substring(0, semicolon).trim())
        val rest = line.substring(semicolon + 1).trim()
        val optionSep = rest.indexOf("|")
        val text1 = if (optionSep == -1) rest else rest.substring(0, optionSep).trim()
        val text2 = if (optionSep == -1) "" else rest.substring(optionSep + 1).trim()
        val option1 = parseOptions(text1)
        val option2 = parseOptions(text2)
        val rule = Combination(key, option1, option2)
        require(!rules.contains(key))
        rules.put(key, rule)
    }
    throw IllegalStateException("empty line not found")
}

fun parseOptions(text: String): List<Int> {
    val list = mutableListOf<Int>()
    val tokenizer = StringTokenizer(text, " ")
    while (tokenizer.hasMoreTokens()) {
        list.add(Integer.parseInt(tokenizer.nextToken()))
    }
    return list
}


sealed class Rule() {
    abstract val key: Int
}

data class Literal(override val key: Int, val char: Char) : Rule()

data class Combination(override val key: Int, val option1: List<Int>, val option2: List<Int>) : Rule()