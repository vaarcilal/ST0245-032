"""
    Authors: Vincent A. Arcila L.
    Date: 2019-03-23

    Program to convert strings from:

        This_is_a_[Beiju]_text
        asd[fgh[jkl

    to:

        BeijuThis_is_a__text
        jklfghasd
"""

import pyllist as ll


f = open("21pruebas.txt")

for i in f.readlines():
    i = i.strip("\n")
    i = i.strip("[")
    i = i.strip("]")
    state = "primera"
    primera = ll.dllist()
    segunda = ll.dllist()

    ultima = ""
    for s in i:
        if s == "[":
            if state == "segunda":
                segunda += primera
                primera = segunda
                segunda = ll.dllist()
                state = "segunda"
                ultima = s
                continue
            state = "segunda"
            ultima = s
            continue
        elif s == "]":
            if state == "segunda" and ultima == "[":
                segunda += primera
                primera = segunda
                segunda = ll.dllist()
            state = "primera"
            ultima = s
            continue

        if state == "primera":
            primera.append(s)
        if state == "segunda":
            segunda.append(s)

    if state == "segunda":
        segunda += primera
        primera = segunda
        segunda = ll.dllist()
    for i in primera:
        print(i,end="")
    print()
