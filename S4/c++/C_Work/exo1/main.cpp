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
        La structure de boucle la plus naturelle pour ce probl�me est la boucle for,
        car le nombre de valeurs � saisir est connu � l�avance et la boucle
        for est con�ue pour it�rer sur une s�quence de valeurs avec une condition d�arr�t d�termin�e.
        Cependant, les boucles while et do-while peuvent �galement �tre utilis�es pour r�soudre ce probl�me en initialisant une variable de compteur
        et en utilisant une condition de sortie pour s�assurer que le nombre de valeurs saisies est correct.
    */

}
