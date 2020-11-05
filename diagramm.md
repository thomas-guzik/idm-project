

 # Visualiser le diagramme avec markdown preview enhancer

https://atom.io/packages/markdown-preview-enhanced

Taper dans le terminal :
apm install markdown-preview-enhanced
Puis redémarrez atom

# Diagramme

```plantuml


@startuml

hide circle

class Bloc {}

class Statement {}

class Print extends Statement
class Delete extends Statement
class Insert extends Statement
class Modify extends Statement

class Value extends Expression
class Function extends Expression
class Area extends Expression

class Number extends Value
class String extends Value

class NameCol {
	name : string
}
class NumberLine {
	nb : int
}
class RangeLines {
	start : int
	end : int
}


class Header {
	fileName : string
	columnNamePresent : boolean
	encoding : string
  separator : string
}


class Sum extends Function
class Multiplication extends Function
class Concatenation extends Function

class NameCol extends Col
class RangeCol extends Col
class AllCol extends Col

class NumberLine extends Line
class RangeLines extends Line
class AllLines extends Line


Bloc *-- "*" Statement
Bloc *-- "1" Header

Statement *-- Expression

Area *-- "*" Region

Region *-- "*" Condition
Region *-- "1" Line
Region *-- "1" Col

@enduml


```


```plantuml


@startuml

hide circle

class Bloc {}

class Statement {}

class Print extends Statement
class Delete extends Statement
class Insert extends Statement
class Modify extends Statement

class Value extends Expression
class Function extends Expression
class Region extends Expression

class Number extends Value
class String extends Value
class Boolean extends Value

class RangeLine {
	start : int
	end : int
}

class RangeCol {
	start : string
	end : string
}

class Header {
	fileName : string
	columnNamePresent : boolean
	encoding : string
  separator : string
}


class Sum extends Function
class Multiplication extends Function
class Concatenation extends Function

class RangeCol extends Col
class AllCol extends Col

class RangeLine extends Line
class AllLines extends Line


Bloc *-- "*" Statement
Bloc *-- "1" Header

Region *-- "*" Condition
Region *-- "1" Line
Region *-- "1" Col

Function *-- "1 ou 2" Expression

Print *-- "*" Expression

Insert *-- "target\n1" Region
Insert *-- "*" Expression 

@enduml


```
