#include <iostream>

using namespace std;

int main()
{
    int i, n, nb, som, prod;
    float moy;

    cout << "Programme Somme-Produit-Moyenne" << endl;
    cout << "Entrer la valeur de N: ";
    cin >> n;

    som =0;
    prod = 1;
    i=0;
 /* while(i < n){
        cout << "Valeur " << i +1 << ":  ";
        cin >> nb;
        som += nb;
        prod *= nb;
        i++;
    };
*/
    do {
        cout << "Valeur " << i +1 << ":  ";
        cin >> nb;
        som += nb;
        prod *= nb;
        i++;
    } while(i < n);
 /*
    for(int i = 0; i < n; i++) {
        cout << "Valeur " << i +1 << ":  ";
        cin >> nb;
        som += nb;
        prod *= nb;
    }*/
    moy = (float)som / n;

    cout << "La somme = " << som << endl;
    cout << "Le produit = " << prod << endl;
    cout << "La moyenne = " << moy << endl;

    return 0;
    /*
        La structure de boucle la plus naturelle pour ce problème est la boucle for,
        car le nombre de valeurs à saisir est connu à l’avance et la boucle
        for est conçue pour itérer sur une séquence de valeurs avec une condition d’arrêt déterminée.
        Cependant, les boucles while et do-while peuvent également être utilisées pour résoudre ce problème en initialisant une variable de compteur
        et en utilisant une condition de sortie pour s’assurer que le nombre de valeurs saisies est correct.
    */

}
