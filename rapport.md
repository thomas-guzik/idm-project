
# Rapport IDM

Sigrid Droogh
Thomas Guzik

# Pré-requis :

Python :
- python 3.6+
- pandas 1.1.4

Bash :
- bash 4.4 avec les commandes :
- - break
- - echo
- - eval
- - if
- - for
- - printf
- - read
- - while
- - [[ ]]
- - $()
- - $(( ))
- bsdmainutils 11.1 incluant les commandes :
- - column
- coreutils 8.28 incluant les commandes :
- - cat
- - cut
- - head
- - paste
- - tr
- - tail
- - wc
- grep 3.1
- mawk 1.3.3
- - awk


# Lancer le projet

Dans Eclipse : requiert les dépendances citées plus haut, sur le système.

*Ouvrir le projet dans Eclipse*

-> File : Open Projects from File System...

Il peut y avoir des erreurs au premier import. Elles partent en générant la grammaire Xtext du DSL : dans le projet `idm.qsv`, package `src.idm`, clic droit puis Run AS : Generate Xtext Artifacts sur le fichier Qsv.xtext

Lancer les tests dans Eclipse


Lancer les tests dans Docker :
`docker build -t test -f Dockerfile.test .`

Lancer un fichier Qsv avec Docker
`docker build -t idm -f Dockerfile .`
`docker run -t idm sh fichier.qsv`



# Grammaire

# Compilateur Python

# Compilateur Bash

# Interpreteur