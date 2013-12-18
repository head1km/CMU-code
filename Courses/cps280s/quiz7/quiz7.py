'''
Created on Nov 24, 2013

@author: head1km
'''
import re

def removeNull():
    someEmptyStuff = [None, [], [1,2,3], "Hello World", (), 90, ("A", "B", "C"), {"Moe" : 1897, "Shemp" : 1895, "Lary" : 1902}, None, "", (15, 62, 55, 18), "", "Python"]
    CleanedList = [x for x in someEmptyStuff if(x)]
    print CleanedList

def replace():
    GradeC_list = ["Name: Shemp    Grade: 79",
                   "Name: Curly    Grade: 75",
                   "Name: Larry    Grade: 72"]
    GradeC_list = [re.sub(r'7\d', "C", x) for x in GradeC_list]
    print GradeC_list

def tupe():
    names = (
"Moe Howard",
"Curly Howard",
"Larry Fine",
"Shemp Howard",
"Joe Besser",
"Curly Joe DeRita",
"Jabba Desilijic Tiure",
"Bria Tharen",
"Durga Besadii Tai",
"Hego Damask",
"Tyrion Lannister",
"Arya Stark",
"Sandor Clegane",
"Daenerys Targaryen",
"Tom Bombadil",
"Meriadoc Brandybuck",
"Pregrin Took",
"Leonard McCoy",
"Montgomery Scott",
"Wesley Crusher",
"Inigo Montoya",
"Tyrone Rugen",
"Han Solo",
"Carl Corey",
"Evelyn Flaumel",
"Vlad Taltos",
"Morrolan e'Drien",
"John Watson",
"Ebenezar McCoy",
"Molly Carpenter",
"Harry Dresden",
)
    SortedNames = list(names)
    SortedNames.sort(key=lambda x: x.split()[-1].lower()+x[0].lower(), reverse=True)
    print SortedNames
    
def main():
    mini = {"hey" : "ya"}
    print mini["hey"]
    print mini.get("hey")
if __name__ == '__main__':
    main()