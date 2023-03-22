/**
    Author : FEDA (corrected)
    Date : 2018/04/18
**/

#include <iostream>
#include <vector>
#include <ctime>
#include <cstdlib>
#include <cmath>
#include <conio.h> //GETCHE

using namespace std;

int main()
{
    float moyenne(vector<int>, int );

    vector<int>tentatives;
    double M,V,Ec;
    int nbAleatoire(0),nbMystere,S1=0,S2=0;
    int nbpropos_max(10),nbpropos(0), borne_max;
    char choix;

    srand(time(0));

    cout<<"                **********************************              "<<endl;
    cout<<"                **                              **              "<<endl;
    cout<<"                **           BIENVENUE          **              "<<endl;
    cout<<"                **                              **              "<<endl;
    cout<<"                **********************************              "<<endl<<endl;

    do  {//Boucle d'exécution générale
        system("cls");
        cout<<endl<<"Ce programme est un jeu dans lequel vous serez amene a deviner un nombre mystere"<<endl;
        do {
            cout<<"Saisissez la borne maximale : ";
            cin>>borne_max;
        }while(borne_max<0);

        nbAleatoire = rand() % borne_max+1;

        cout<<"Super!!! a vous de jouer!";
        cout<<"vous avez  "<<nbpropos_max<<" tentatives"<<endl;
        cout<<"Bonne chance"<<endl;
        do {
            cout<<"votre choix : ";
            cin>>nbMystere;
            tentatives.push_back(nbMystere);
            cout<<"il vous reste "<< nbpropos_max - tentatives.size()<<" tentatives"<<endl;
            if(nbMystere<nbAleatoire)
            {
                cout<<"plus petit!!!"<<endl;
            }
            else if(nbMystere>nbAleatoire)
            {
                cout<<"plus grand!!!"<<endl;
            }

        }while( nbpropos<nbpropos_max && nbMystere != nbAleatoire );
        S1 = moyenne(tentatives, 1);
        S2 = moyenne(tentatives, 2);
        nbpropos = tentatives.size();
         M = S1;//nbpropos;
         //V = S2/nbpropos - M*M;
         V = S2 - M*M;
         Ec = sqrt (V);
         //Appréciation
         if(nbMystere == nbAleatoire){
                if(nbpropos <4)
                {
                    cout<<" Super voyant"<<endl;
                }
                else if(nbpropos >3 && nbpropos < 7)
                 {
                    cout<<" Sage voyant"<<endl;
                 }
                else if(nbpropos >6 && nbpropos < 10)
                 {
                    cout<<" Apprentit voyant"<<endl;
                 }
                 else if(nbpropos >9)
                 {
                    cout<<" voyant pusillanime"<<endl;
                 }
         }else{
             cout<<endl<<"Vous avez perdu"<<endl;
         }   //if(nbMystere == nbAleatoire)

        for (unsigned int i=0 ; i< tentatives.size() ; i++)
        {
            cout<< i+1<< "eme tentative: "<<tentatives[i]<<endl;
        }
        cout<<"l'ecart type de vos tentatives est : "<< Ec<<endl;

        if(nbpropos>= nbpropos_max && nbMystere != nbAleatoire)
        {
            cout<<"Le nombre mystere etait : "<<nbAleatoire<<endl;
        }
        tentatives.clear();
        cout<<"Voulez vous continuer (O/N) ? :";
        choix = toupper(getche());
    }while(choix != 'N' );


    return 0;
}

float moyenne(vector<int> tabTenta,  int puissance) {
/*  Goal : compute average of  array values
*/
    long somme(0);
    unsigned int i, nb(tabTenta.size());
    float average;
    for(i=0; i<nb; i++){
        somme += pow(tabTenta[i], puissance);
    }
    average = float(somme)/nb;
    return average;
}
