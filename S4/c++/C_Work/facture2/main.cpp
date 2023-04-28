/*
    Date: 31/03/2023 09:35
    Goal: Facturrurartioioiooioioiiooioioinoi
    Authors: KAKANOU Israel vs ChatGPT-3

*/
#include <iostream>
#include <string>
#include <vector>

using namespace std;

// Structure pour stocker les informations d'un article
struct Article {
    int id;
    string libelle;
    double prix_unitaire;
};

// Fonction pour rechercher un article à partir de son code
Article rechercher_article(vector<Article>& articles, int id) {
    for (auto& article : articles) {
        if (article.id == id) {
            return article;
        }
    }
    // Si l'article n'est pas trouvé, on retourne une structure vide
    return {};
}

// Fonction pour afficher la facture
void afficher_facture(vector<pair<Article, int>>& lignes_facture) {
    double total = 0.0;
    cout << "*** FACTURE ***" << endl;
    cout << "ARTICLE\tNBRE\tP-UNIT\tMONTANT" << endl;
    for (auto& ligne : lignes_facture) {
        auto article = ligne.first;
        int quantite = ligne.second;
        double montant = quantite * article.prix_unitaire;
        cout << article.libelle << "\t" << quantite << "\t"
             << article.prix_unitaire << "\t" << montant << endl;
        total += montant;
    }
    cout << "TOTAL\t\t\t" << total << endl;
}

int main() {
    // Initialisation de la liste des articles
    vector<Article> articles {
        { 25, "Centrifugeuse", 3700.00 },
        { 26, "Four à raclette 6P", 2952.50 },
        { 27, "Mixeur", 1500.00 },
        { 28, "Grille-pain", 1995.00 },
        // ...
    };

    // Saisie du nombre d'articles à facturer
    int nb_articles;

    cout << "PROGRAMME FACTURATION" << endl;

    cout << "Combien d articles a facturer ? ";
    cin >> nb_articles;

    vector<pair<Article, int>> lignes_facture; // Liste des articles à facturer

    // Saisie des codes et quantités d'articles à facturer
    for (int i = 0; i < nb_articles; i++) {
        int id;
        cout << "Code article ? ";
        cin >> id;
        auto article = rechercher_article(articles, id);
        while (article.id == 0) {
            cout << "** Article inexistant – redonnez le code : ";
            cin >> id;
            article = rechercher_article(articles, id);
        }
        int quantite;
        cout << "Quantite de " << article.libelle << " au prix unitaire de "
             << article.prix_unitaire << " ? ";
        cin >> quantite;
        lignes_facture.emplace_back(article, quantite);
    }

    // Affichage de la facture
    afficher_facture(lignes_facture);

    return 0;
}
