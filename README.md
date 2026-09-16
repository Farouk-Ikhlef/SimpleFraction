# Compléments de programmation - TD 1

## Remarques préliminaires
* Avez vous lu sur persee, l'annonce "La notation et l'IA" ?
* Les commandes `git` sont à taper en ligne de commande dans un *shell bash*.
* Vous pouvez utiliser l'IDE de votre choix.
Sur le cartable numérique, [Eclipse](www.eclipse.org), [IntelliJ IDEA](http://www.jetbrains.com/idea/) et [Visual Studio Code](https://code.visualstudio.com/) sont installés.
* Vous répondrez aux questions directement dans ce fichier en complétant les emplacements correspondants.
Ajoutez ensuite ce fichier au dépôt `git`.

## Partie I (à faire durant le TD) : découverte de `git`
Dans cet exercice, vous créerez une classe `Fraction` représentant un nombre rationnel et une classe `Main` qui testera les méthodes de la classe `Fraction` **avec des assertions** (cf. [Utilisation d'assertions](https://koor.fr/Java/Tutorial/java_assert.wp)).
À chaque étape, consultez le statut des fichiers du projet (`git status`) ainsi que l'historique (`git log`).

1. Sur la forge, créez le dépôt (_repository_) `SimpleFraction`;
En terme de *commits*, quelle différence constatez-vous entre cocher une (ou plusieurs) des cases *Initialize this repository with* et n'en cocher aucune ?
    > Sans initialisation, le dépôt distant est vide (aucun commit). Avec une case cochée (ex. README), GitHub crée automatiquement un premier commit sur le dépôt distant. Cela peut causer un conflit lors du push d'un dépôt local, car les deux historiques n'ont pas d'ancêtre commun.

    *Pour la suite, ne cochez aucune de ces cases*.
1. Localement, configurez `git` avec votre nom (`user.name`) et votre email (`user.email`) (cf. [Personnalisation de Git](https://git-scm.com/book/fr/v2/Personnalisation-de-Git-Configuration-de-Git));
    ```bash
    # git config --global user.name "Omar El Farouk IKHLEF"
    # git config --global user.email "omarelfarouk.ikhlef@hotmail.com"
    ```
1. Initialisez le dépôt `git` local pour le projet (cf. [Démarrer un dépôt Git](https://git-scm.com/book/fr/v2/Les-bases-de-Git-D%C3%A9marrer-un-d%C3%A9p%C3%B4t-Git));
    ```bash
    # git init
    ```
1. Dans votre IDE, créez la classe `Fraction` (vide pour le moment) et la classe `Main` (avec un simple affichage) dans le projet (cf. [Méthode `main`](https://docs.oracle.com/javase/specs/jls/se19/html/jls-12.html#jls-12.1.4));
Vérifiez que le projet compile et s'exécute dans l'IDE;
Validez les changements (cf. [Enregistrer des modifications dans le dépôt](https://git-scm.com/book/fr/v2/Les-bases-de-Git-Enregistrer-des-modifications-dans-le-d%C3%A9p%C3%B4t));
    ```bash
    # git add src/
      git commit -m "Ajout des classes Fraction et Main"
    ```
1. Ajoutez la méthode `toString` à la classe `Fraction` (cf. [`Object.toString`](https://docs.oracle.com/en/java/javase/19/docs/api/java.base/java/lang/Object.html#toString())) qui retournera la chaîne `"Je suis une fraction."` et modifiez la classe `Main` en conséquence;
Validez les changements;
    ```Java
    // Code pour tester toString
    Fraction f = new Fraction();
    System.out.println(f.toString());
    assert f.toString().equals("Je suis une fraction.");
    ```
1. Publiez vos modifications sur le dépôt distant (cf. [Travailler avec des dépôts distants](https://git-scm.com/book/fr/v2/Les-bases-de-Git-Travailler-avec-des-d%C3%A9p%C3%B4ts-distants));
Vous utiliserez le protocole `https` pour cela;
Vérifiez avec le navigateur;
    ```bash
    # Commandes pour publier les modifications
    git remote add origin https://github.com/Farouk-Ikhlef/SimpleFraction.git
    git push -u origin master
    ```
1. Sur la forge, ajoutez un fichier de documentation `README.md`.
Quelle syntaxe est utilisée pour ce fichier ?
    > Markdown
1. Récupérez localement les modifications effectuées sur la forge.
    ```bash
    # git pull origin master
    ```
1. Ajoutez les répertoires et fichiers issus de la compilation aux fichiers ignorés par `git` (cf. [`.gitignore` pour Java](https://github.com/github/gitignore/blob/main/Java.gitignore));
    ```bash
    out/
    *.class
    ```
1. Retirez les fichiers de configuration de l'IDE du projet;
```bash
    # Retirer les fichiers de configuration de l'IDE
    # Le dossier .idea/ n'a jamais ete commit (reste "untracked" depuis le debut),
    # il n'y a donc rien a retirer avec une commande git.
```
    Ajoutez-les aux fichiers ignorés par `git`.
```bash
    # Copier ici les modifications de `.gitignore`
    echo ".idea/" >> .gitignore
```
1. Configurez l'accès par clé publique/clé privée à la forge (cf. [Connecting to GitHub with SSH](https://docs.github.com/en/authentication/connecting-to-github-with-ssh)).
    > Générer une paire de clés avec ssh-keygen -t ed25519, ce qui crée une clé privée (à garder secrète, jamais transmise) et une clé publique (.pub). Ajouter le contenu de la clé publique dans les paramètres SSH de son compte sur la forge (GitHub ou Persée). Ensuite, chaque connexion Git (clone, push, pull) via ssh est authentifiée automatiquement grâce à cette paire de clés, sans avoir besoin de saisir un mot de passe.

## Partie II (à faire durant le TD) : compléter la classe `Fraction`
Dans cet partie, vous compléterez les classes `Fraction` et `Main`.
Un exemple d'interface pour une telle classe est donné par la classe [`Fraction`](http://commons.apache.org/proper/commons-math/javadocs/api-3.6.1/org/apache/commons/math3/fraction/Fraction.html) de la bibliothèque [Apache Commons Math](http://commons.apache.org/math/).

Vous respecterez les consignes ci-dessous :
* chaque méthode de `Fraction` sera testée dans `Main` **avec des assertions** (cf. [Utilisation d'assertions](https://koor.fr/Java/Tutorial/java_assert.wp));
* à la fin de chaque question, consultez le statut des fichiers du projet (`git status`) ainsi que l'historique (`git log`) puis validez les changements.

1. Ajoutez les attributs représentants le numérateur et le dénominateur (nombres entiers).
    ```Java
    // Déclaration des attributs
    private int numerator;
    private int denominator;
    ```
1. Ajoutez les constructeurs (cf. [Constructor Declarations](https://docs.oracle.com/javase/specs/jls/se19/html/jls-8.html#jls-8.8)) suivants :
    * initialisation avec un numérateur et un dénominateur,
    * initialisation avec juste le numérateur (dénominateur égal à _1_),
    * initialisation sans argument (numérateur égal _0_ et dénominateur égal à _1_),
    ```Java
    // Assertions pour tester les constructeurs (avec toString)
    Fraction f1 = new Fraction(3, 4);
    Fraction f2 = new Fraction(5);
    Fraction f3 = new Fraction();
    assert f1.toString().equals("3/4");
    assert f2.toString().equals("5/1");
    assert f3.toString().equals("0/1");
    ```
1. Ajoutez les fractions constantes ZERO (0, 1) et UN (1, 1) (cf. [Constants in Java](https://www.baeldung.com/java-constants-good-practices)),
    ```Java
    // Déclaration des constantes
    public static final Fraction ZERO = new Fraction(0, 1);
    public static final Fraction UN = new Fraction(1, 1);
    ```
1. Ajoutez une méthode de consultation du numérateur et du dénominateur (par convention, en Java, une méthode retournant la valeur de l'attribut `anAttribute` est nommée `getAnAttribute`),
    ```Java
    // Définition des getters
    public int getNumerator() {
    return numerator;
    }

    public int getDenominator() {
    return denominator;
    }
    ```
1. Ajoutez une méthode de consultation de la valeur sous la forme d'un nombre en virgule flottante (méthode `doubleValue()`) (cf. [`java.lang.Number`](https://docs.oracle.com/en/java/javase/19/docs/api/java.base/java/lang/Number.html)),
   ```Java
    // Assertions pour tester la conversion
    assert Math.abs(f1.doubleValue() - 0.75) < 1e-8;
    ```
1. Ajoutez une méthode permettant l'addition de deux fractions (la méthode `add` prend en paramètre *une* fraction et *retourne* la somme de la fraction courante et du paramètre),
   ```Java
    // Assertions pour tester l'addition
    Fraction sum = new Fraction(1, 2).add(new Fraction(1, 3));
    assert sum.toString().equals("5/6");
    ```
1. Ajoutez le test d'égalité entre fractions (deux fractions sont égales si elles représentent la même fraction réduite) (cf. [`java.lang.Object.equals`](https://docs.oracle.com/en/java/javase/19/docs/api/java.base/java/lang/Object.html#equals(java.lang.Object))),
   ```Java
    // Assertions pour tester l'égalité
    Fraction a = new Fraction(2, 4);
    Fraction b = new Fraction(1, 2);
    assert a.equals(b);
    ```
1. Ajoutez la comparaison de fractions selon l'ordre naturel (cf. [`java.lang.Comparable`](https://docs.oracle.com/en/java/javase/19/docs/api/java.base/java/lang/Comparable.html)).
   ```Java
    // Assertions pour tester la comparaison
    Fraction small = new Fraction(1, 2);
    Fraction big = new Fraction(2, 3);
    assert small.compareTo(big) < 0;
    ```
1. Faites hériter votre classe `Fraction` de la classe [`java.lang.Number`](https://docs.oracle.com/en/java/javase/19/docs/api/java.base/java/lang/Number.html) et complétez les méthodes
   ```Java
    // Vérifiez avec le code ci-dessous
    Number aNumber = java.math.BigDecimal.ONE;
    Number anotherNumber = new Fraction(1, 2);
    assert java.lang.Math.abs(aNumber.doubleValue() + anotherNumber.doubleValue() - 1.5) < 1E-8;
    ```

## Partie III (à faire à la maison) : révisions et perfectionnement *shell* et *IDE*
### Maîtriser le *shell* de commandes
L'objectif de cet exercice est de vous faire réviser/découvrir les commandes de base du *shell* de votre machine.
Vous pouvez répondre en utilisant le shell de votre choix (*bash*, *Powershell*, …).
Pour répondre à ces questions, vous devez effectuer les recherches documentaires adéquates (livre, web, …).

1. Quel OS et quel shell de commande utilisez-vous ?
    > Windows 11 (Windows_NT), shell Git Bash (MINGW64)
1. Quelle commande permet d'obtenir de l'aide ?
Donnez un exemple.
    ```bash
    # --help
    ```
1. Donnez la ou les commandes shell permettant de
    1. afficher les fichiers d'un répertoire triés par taille (taille affichée lisiblement)
        ```bash
        # ls -lhS
        ```
    1. compter le nombre de ligne d'un fichier
        ```bash
        # wc -l Main.java
        ```
    1. afficher les lignes du fichier `Main.java` contenant la chaîne `uneVariable`
        ```bash
        # grep "uneVariable" Main.java

        ```
    1. afficher récursivement les fichiers `.java` contenant la chaîne `uneVariable`
        ```bash
        # grep -r --include="*.java" "uneVariable" .
        ```
    1. trouver les fichiers (pas les répertoires) nommés `README.md` dans une arborescence de répertoires
        ```bash
        # find . -type f -name "README.md"
        ```
    1. afficher les différences entre deux fichiers textes
        ```bash
        # diff fichier1.txt fichier2.txt
        ```
1. Expliquez en une ou deux phrases le rôle de ces commandes et dans quel contexte elles peuvent être utiles pour un développeur.
    * `ssh`
        > Permet de se connecter et d'exécuter des commandes sur une machine distante de façon sécurisée et chiffrée. Utile pour administrer un serveur, ou (comme on l'a fait) se connecter à un serveur Git distant (Persée) sans mot de passe grâce à une paire de clés.

    * `screen`/`tmux`
        > Permettent de créer des sessions de terminal persistantes, qui continuent de tourner même si on se déconnecte (ex: fermeture du SSH ou coupure réseau). Utile pour lancer une tâche longue sur un serveur distant et pouvoir la retrouver plus tard, ou pour gérer plusieurs terminaux dans une seule fenêtre.
    * `curl`/[HTTPie](https://httpie.org/)
        > Permettent d'envoyer des requêtes HTTP (GET, POST, etc.) directement en ligne de commande, sans navigateur. Très utile pour tester une API REST, télécharger un fichier depuis une URL, ou déboguer un service web.
    * [jq](https://stedolan.github.io/jq/)
        > Un outil en ligne de commande pour parser, filtrer et transformer du JSON directement dans le terminal. Utile par exemple pour extraire un champ précis de la réponse JSON renvoyée par une API, sans écrire de script complet.

### Découverte de votre *IDE*
Dans cet exercice, vous expliquerez en quelques phrases comment vous réalisez les actions ci-dessous dans votre IDE.
Vous pouvez choisir l'IDE/éditeur de texte de votre choix.
Pour réaliser cette exercice, vous devez bien évidemment vous reporter à la documentations de l'IDE ([IntelliJ IDEA](https://www.jetbrains.com/help/idea/discover-intellij-idea.html#developer-tools), [Visual Studio Code](https://code.visualstudio.com/docs), [Eclipse](https://help.eclipse.org/2020-09/index.jsp), …).

1. Quels IDE ou éditeurs de texte utilisez-vous pour le développement Java ?
    > IntelliJ IDEA

1. Comment vérifier/définir que l'encodage utilisé est UTF-8 ?
    > File > Settings > Editor > File Encodings, puis vérifier/choisir UTF-8 pour "Global Encoding" et "Project Encoding".

1. Comment choisir le JDK à utiliser dans un projet ?
    > File > Project Structure > Project, puis sélectionner le JDK voulu dans le menu déroulant "SDK" (ou via le bandeau "Setup SDK" qu'on a utilisé quand IntelliJ signalait "Project JDK is not defined").

1. Comment préciser la version Java des sources dans un projet ?
    > File > Project Structure > Project, champ "Language level" (ou dans Project Structure > Modules pour un module spécifique).

1. Comment ajouter une bibliothèque externe dans un projet ?
    > File > Project Structure > Libraries > "+", puis pointer vers le .jar de la bibliothèque (ou l'ajouter via Maven/Gradle si le projet en utilise).

1. Comment reformater un fichier source Java ?
    > Clic droit dans l'éditeur > Reformat Code (raccourci Ctrl+Alt+L).

1. Comment trouver la déclaration d'une variable ou méthode ?
    > Ctrl+clic sur le nom de la variable/méthode, ou Ctrl+B ("Go to Declaration").

1. Comment insérer un bloc de code prédéfini (snippet) ?
    > Taper l'abréviation du "live template" (ex: "psvm" pour public static void main, ou "sout" pour System.out.println) puis appuyer sur Tab.

1. Comment renommer une classe dans l'ensemble du projet ?
    > Clic droit sur la classe > Refactor > Rename (raccourci Maj+F6), ce qui met à jour automatiquement toutes les références dans le projet.

1. Comment exécuter le programme en lui passant un paramètre en ligne de commande ?
    > Run > Edit Configurations, puis remplir le champ "Program arguments" avec les paramètres voulus.

1. Comment déboguer le programme en visualisant le contenu d'une ou plusieurs variables ?
    > Poser un point d'arrêt (clic dans la marge à gauche d'une ligne), puis lancer avec "Debug" au lieu de "Run" (icône insecte). Les variables locales s'affichent alors dans le panneau "Variables" du débogueur.

1. Quels paramètres ou fonctionnalités vous semblent particulièrement importants/utiles pour le développement Java ?
    > Le débogueur intégré, le refactoring automatique (rename, extract method), la complétion de code et la navigation rapide (Ctrl+clic vers les déclarations) : ils font gagner beaucoup de temps et réduisent les erreurs par rapport à un simple éditeur de texte.
