/*
    Name: calculatrice.cpp
    Goal: calcul et affichage arithmetique

*/


#include <iostream>
#include <iomanip> // formatage de l'affiche avec setioflags
#include <clocale> // Chaine de caractere accentuer

using namespace std;

int main()
{
    int nb1, nb2;
    float result;
    char operateur;

    setlocale(LC_CTYPE, "");
    cout << "Programme calculatrice arithmetique" << endl;
    cout << "Entrez le premiekr nombre : ";
    cin >> nb1;
    cout << "Entrez le deuxieme nombre : ";
    cin >> nb2;
    cout << "Precisez l'operateur: ";
    cin >> operateur;

    if(operateur == '+'){
        result = nb1 + nb2;
    }
    else if(operateur == '-'){
        result = nb1 - nb2;
    }
    else if(operateur == '/'){
        result = float(nb1) / nb2;
    }
    else if(operateur == '*'){
        result = nb1 * nb2;
    }

    cout << setiosflags(ios ::showpoint | ios ::fixed);
    cout << setprecision(2);

    cout <<  nb1 << " " << operateur << " " << nb2 << " = ";
    cout << result << endl;



    return 0;
}
