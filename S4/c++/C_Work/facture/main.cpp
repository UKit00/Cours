#include <iostream>
#include <string>
#include <vector>

using namespace std;

typedef struct {
    int code;
    double pUnit;
    string libelle;
} Article;

int main()
{
    int menu ();
    void ajouter(vector<Article> &stock);
    void lister (vector<Article> stock);
    vector<Article> stock;
    int choix(0);
    do {
            choix = menu ();
            switch (choix)
            {
            case 1:
                ajouter(stock);
                break;
            }

    } while(choix != 0);

    return 0;
}


int menu (){
    int choix(0);
    do{
        cout << "GEstion de stock" << endl;
        cout << "1 - Ajouter" << endl;
        cout << "2 - Supprimer" << endl;
        cout << "3 - Lister" << endl;
        cout << "4 - Facture" << endl;
        cout << "5 - Quitter" << endl;
        cout << "Entrez  votre choix: " << endl;
        cin >> choix;
    } while(choix < 0);
    return choix;
}

void ajouter(vector<Article> &stock) {

    Article unArt;
    do {
        cout << "Ajout d'article: " << endl;
        cout << "Code (0 pour terminer) : " << endl;
        cin >> unArt.code;
        if(unArt.code);
        {
            cout << "Libelle : " << endl;
            cin >> unArt.libelle;
            cout << "Prix Unitaire : " << endl;
            cin >> unArt.pUnit;
            stock.push_back(unArt);
        }
    }while(unArt.code > 0);
    declaratoin definition et appel

}

void lister (vector<Article> stock){
    Article unArt;
    for(unsigned int cpt = 0; cpt<stock.size(); cpt++)
    {
        unArt = stock[cpt];
        cout << unArt.code << "\t" << unArt.libelle << endl;
    }

}
