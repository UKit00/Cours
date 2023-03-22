#include <iostream>
using namespace std;

void swapv(int n1, int n2)
{
    int tempvaleur(n1);
    cout << "in swapV-1 : n1= " << n1
            << " n2 = " << n2
            << endl;

    n1 = n2;
    n2=tempvaleur;

    cout << "in swapV-2: n1 = " << n1
         << " n2= " << n2
         <<endl;
}   //void swapv(int n1,int n2)

void swapR(int &n1, int &n2)
{
    int tempvaleur(n1);
    cout << "in swapV-1 :"<< "n1= " << n1
            << "n2 = " << n2
            << endl;

    n1 = n2;
    n2=tempvaleur;

    cout << "in swapV-2:"<< "n1= " << n1
         << "n2= " << n2
         <<endl;
}   //void swapv(int n1,int n2)

int main(int argc, char** argv)
{

    int val1=(5);
    int val2=(7);

    cout << "Programme test passage paramètres" << endl;
    cout << "in main:" << "val1= " << val1
            << " val2= "  << val2
            <<endl;
    swapv(val1, val2);
    cout << "after swap:"<< "val1= " << val1
            << "val2= " << val2
            << endl;
    swapR(val1, val2);
    cout << "after swapR:"<< "val1= " << val1
            << " val2= " << val2
            << endl;

    return 0;
}
