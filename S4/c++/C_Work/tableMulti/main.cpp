#include <iostream>
#include <conio.h>
#include <iomanip>
#include <cstdlib>

using namespace std;

int main()
{
    int nb, deb, fin, cpt, result;
    char rep;

    do{
        system("COLOR 1F");
        system("CLS");
        cout << "Programme Table de multiplication" << endl;
        cout << "Entrez le nombre : ";
        cin >> nb;
        cout << "Entrez le debut : ";
        cin >> deb;
        cout << "Entrez la fin : ";
        cin >> fin;

        for(cpt = deb; cpt <= fin; cpt++){
            result = nb * cpt;
            cout << setw(5) << nb << "   x " << setw(5) <<cpt << " = " << setw(5) <<result << endl;
        }

        do {
            cout << "Voulez-vous reprendre (O/N)? :";
            rep = toupper(getche());
            cout << endl;
        } while(rep != 'O' && rep != 'N');

    }while(rep = 'O');
    cout << endl;

    cout << "Fin du Programme!" << endl;
    return 0;
}
