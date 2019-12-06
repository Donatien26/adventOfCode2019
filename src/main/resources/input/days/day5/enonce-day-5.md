--- Jour 5: Ensoleillé avec risque d'astéroïdes ---

Vous commencez à transpirer alors que le navire se dirige vers Mercury. Les elfes vous suggèrent de faire fonctionner le climatiseur en mettant à niveau votre ordinateur de bord afin de prendre en charge le terminal de surveillance de l'environnement thermique.

Le terminal de surveillance de l'environnement thermique (TEST) commence par l'exécution d'un programme de diagnostic (votre entrée de puzzle). Le programme de diagnostic TEST s’exécutera sur votre ordinateur Intcode existant après quelques modifications:

Tout d'abord, vous devrez ajouter deux nouvelles instructions:

    Le code d'opération 3 prend un seul entier en entrée et l'enregistre à la position indiquée par son seul paramètre. Par exemple, l’instruction 3,50 prend une valeur d’entrée et la stocke à l’adresse 50.
    Le code d'opération 4 fournit la valeur de son seul paramètre. Par exemple, l'instruction 4,50 afficherait la valeur à l'adresse 50.

Les programmes qui utilisent ces instructions seront accompagnés d’une documentation qui explique ce qui doit être connecté à l’entrée et à la sortie. Le programme 3,0,4,0,99 émet ce qu’il reçoit en entrée, puis s’arrête.

Deuxièmement, vous devrez ajouter un support pour les modes de paramètres:

Chaque paramètre d'une instruction est traité en fonction de son mode de paramètre. À l'heure actuelle, votre ordinateur de bord comprend déjà le mode de paramètre 0, mode de position, qui interprète le paramètre comme une position. Si le paramètre est 50, sa valeur est la valeur stockée à l'adresse 50 en mémoire. Jusqu'à présent, tous les paramètres étaient en mode position.

Désormais, votre ordinateur de bord devra également gérer les paramètres en mode 1, mode immédiat. En mode immédiat, un paramètre est interprété comme une valeur - si le paramètre est 50, sa valeur est simplement 50.

Les modes de paramètre sont stockés dans la même valeur que le code d'opération de l'instruction. Le code d'opération est un nombre à deux chiffres basé uniquement sur les chiffres un et dix de la valeur. En d'autres termes, le code d'opération correspond aux deux chiffres les plus à droite de la première valeur d'une instruction. Les modes de paramètre sont des chiffres uniques, un par paramètre, lus de droite à gauche de l'opcode: le mode du premier paramètre est le chiffre des centaines, le mode du second paramètre est le chiffre des milliers, le mode du troisième paramètre est le mode des dix-milliers chiffre, et ainsi de suite. Tous les modes manquants sont 0.

Par exemple, considérons le programme 1002,4,3,4,33.

La première instruction, 1002,4,3,4, est une instruction de multiplication - les deux chiffres les plus à droite de la première valeur, 02, indiquent le code d'opération 2, la multiplication. Ensuite, en allant de droite à gauche, les modes de paramètre sont 0 (chiffres en centaines), 1 (chiffres en milliers) et 0 (chiffres en milliers, non présents et donc nuls):

ABCDE
 1002

DE - Opcode à deux chiffres, 02 == Opcode 2
 C - mode du 1er paramètre, 0 == mode position
 B - mode du 2e paramètre, 1 == mode immédiat
 A - mode du 3ème paramètre, 0 == mode position,
                                  omis en raison d'être un zéro non significatif

Cette instruction multiplie ses deux premiers paramètres. Le premier paramètre, 4 en mode position, fonctionne comme avant: sa valeur est la valeur stockée à l'adresse 4 (33). Le deuxième paramètre, 3 en mode immédiat, a simplement la valeur 3. Le résultat de cette opération, 33 * 3 = 99, est écrit conformément au troisième paramètre, 4 en mode position, qui fonctionne également comme auparavant. adresser 4.

Les paramètres écrits par une instruction ne seront jamais en mode immédiat.

Enfin, quelques notes:

    Il est important de se rappeler que le pointeur d'instruction doit augmenter du nombre de valeurs de l'instruction une fois l'instruction terminée. En raison des nouvelles instructions, ce montant n’est plus toujours 4.
    Les entiers peuvent être négatifs: 1101,100, -1,4,0 ​​est un programme valide (trouvez 100 + -1, enregistrez le résultat à la position 4).

Le programme de diagnostic TEST commence par demander à l'utilisateur l'identifiant du système à tester en exécutant une instruction d'entrée - fournissez-la 1, l'identifiant du climatiseur du navire.

Il effectuera ensuite une série de tests de diagnostic confirmant que diverses parties de l'ordinateur Intcode, telles que les modes de paramètre, fonctionnent correctement. Pour chaque test, une instruction de sortie sera exécutée indiquant la distance entre le résultat du test et la valeur attendue, où 0 signifie que le test a réussi. Des sorties non nulles signifient qu'une fonction ne fonctionne pas correctement. vérifiez les instructions qui ont été exécutées avant l'instruction de sortie pour voir laquelle a échoué.

Enfin, le programme émettra un code de diagnostic et s’arrêtera immédiatement. Cette sortie finale n'est pas une erreur. une sortie suivie immédiatement d'un arrêt signifie que le programme est terminé. Si toutes les sorties étaient nulles sauf le code de diagnostic, le programme de diagnostic a été exécuté avec succès.

Après avoir fourni 1 à la seule instruction d'entrée et passé tous les tests, quel code de diagnostic le programme produit-il?