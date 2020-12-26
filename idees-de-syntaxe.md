### Proposition 30/10
(sigrid)

Idée qu'on avait depuis le départ:

Chaque commande se fait dans le cadre d'un fichier CSV. C'est le "load"
auquel on fait référence dans l'énoncé du projet. On aurait donc quelque chose
comme:

```
load "myfile.csv" headers, delimiter ",", quotechar "'"
    [une commande]
    [une autre]
```

```
load "myfile.csv" noheaders, quotechar """, delimiter "\t"
    [une commande]
    [une autre]
```

On peut imaginer utiliser des valeurs par défaut
```
load "myfile.csv"
    [une commande]
    [une autre]
```

Variations de CSV à supporter:
- delimiter
- quotechar
- doublequote ?
- quoting ?
(https://docs.python.org/3/library/csv.html#csv-fmt-params)

Manière de PostgreSQL:

```
COPY items FROM ‘/Users/matt/Desktop/items.csv’ DELIMITER ‘,’ CSV HEADER;
```

Possible suite de l'idée:

On pourrait mettre un mot clé en avant, et des "paramètres" dessus qui
commencent par `:`. (pour essayer de pas copier le sql)
L'ordre des paramètres n'aurait pas d'importance.

Par exemple:

Afficher tout le csv
```
print
```

Afficher toutes les lignes, mais que les colonnes pays et ville
```
print
    :columns pays, ville
```

Afficher les lignes avec pays=Italie, toutes les colonnes
```
print
    :lines pays="Italie"
```

Afficher les lignes avec pays=Italie, seulement la colonne ville
```
print
    :lines pays="Italie"
    :columns ville
```

Dans le cas où on n'aurait pas mis de header au CSV, on pourrait signaler les
numéros de colonnes avec `#`.
```
print
    :lines #4 > 0
    :columns #5, #8
```

Pour calculer la somme de la colonne du nombre d'habitants et stocker dans la
variable `sommeHabitants`
```
compute $sommeHabitants
    :sum nb_habitants
```
```
compute $sommeHabitants
    :sumLines nb_habitants
```
^ sum lines of the column (returns int)

```
compute $sommeHabitantsEtChats
    :sumLines nb_habitants, nb_chats
```
^ sum lines of each column (returns line int, int)

```
compute $sommeHabitantsEtChatsParPays
    :sumColumns nb_habitants, nb_chats
```
^ sum for each line, values of these columns (returns column)

(On pourra imaginer n'importe quoi comme fonction au lieu de sum)

Pour afficher la valeur de la variable
```
echo $sommeHabitants
```

La distinction de `print` et `compute` permettrait de garder une séparation
entre `print` où on va regarder tout ce qui existe et afficher (éventuellement
avec des conditions) et `compute` où on va créer des nouvelles valeurs à partir
de ce qui existe déjà. Par contre ça devient super verbeux. On pourrait faire une
option `:print` à `compute` pour qu'il affiche (et `:store` serait aussi
optionnel).

Mettre à 0 le nombre d'habitants s'il est négatif
```
update
    :set 0
    :columns nb_habitants
    :lines nb_habitans < 0
```

Mettre la remarque à "suspect" quand on a un nombre d'habitant égal à 0
```
update
    :columns remarques
    :set "suspect"
    :lines nb_habitants < 0
```

Supprimer les colonnes remarque et maire
```
delete
    :columns remarques, maire
```

Supprimer les lignes dont le nombre d'habitants est inférieur à 10
```
delete
    :lines nb_habitants < 10
```
(je sais pas ce qu'on peut imaginer si on utilise à la fois `:lines` et
:`columns` pour `delete`)

Ajouter deux lignes
```
insert
    :lines ("Rome", "Italie", 230, "bla"), ("Pisa", "Italie", 458, "ok")
```

Ajouter une colonne
```
insert
    :columns meteo ("beau", "mauvais", "neige")
```

En cours de route, on peut dire de sauvegarder les modifications dans le
fichier csv original
```
save
    :csv
```

Ou dans un autre fichier
```
save
    :csv "autrefichier.csv"
```

Ou en json avec le même nom
```
save
    :json
```

Ou json avec un autre nom
```
save
    :json "something.json"
```
Ou les deux à la fois

```
save
    :csv
    :json "yes.json"
```

Il reste des trucs à ajouter, comme développer les conditions sur la sélection
des lignes, voir si on garde compute ou si on met ça quand même dans print, ou
d'autres choses.

```
print
    :lines pays="Italie" and nb_habitants < 0
```

